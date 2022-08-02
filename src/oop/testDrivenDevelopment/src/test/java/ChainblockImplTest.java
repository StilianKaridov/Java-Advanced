package oop.testDrivenDevelopment.src.test.java;

import oop.testDrivenDevelopment.src.main.java.ChainblockImpl;
import oop.testDrivenDevelopment.src.main.java.Transaction;
import oop.testDrivenDevelopment.src.main.java.TransactionImpl;
import oop.testDrivenDevelopment.src.main.java.TransactionStatus;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ChainblockImplTest {

    private ChainblockImpl chainblock;
    private List<Transaction> transactions;
    private static final int TRANSACTIONS_ADDED_COUNT = 10;
    private static final int INVALID_TRANSACTION = TRANSACTIONS_ADDED_COUNT + 1;

    private void addTransactionsToListAndChainblock(int count) {
        for (int i = 1; i <= count; i++) {
            Transaction transaction = new TransactionImpl(i, TransactionStatus.UNAUTHORIZED, "person_" + i, "receiver_" + i, 10.00 + i);
            this.chainblock.add(transaction);
            transactions.add(transaction);
        }
    }

    @Before
    public void setUp() {
        this.chainblock = new ChainblockImpl();
        this.transactions = new ArrayList<>();
        addTransactionsToListAndChainblock(TRANSACTIONS_ADDED_COUNT);
    }

    @Test
    public void test_Count_ShouldReturn_Zero_WhenCollection_IsEmpty() {
        int expected = 0;
        ChainblockImpl empty = new ChainblockImpl();

        int actual = empty.getCount();
        assertEquals(expected, actual);
    }

    @Test
    public void test_Count_ShouldReturnTrue_WhenCollection_HasTenElements() {
        int actual = chainblock.getCount();
        assertEquals(TRANSACTIONS_ADDED_COUNT, actual);
    }

    @Test
    public void test_TransactionContains_ShouldReturn_False() {
        boolean contains = chainblock.contains(new TransactionImpl(11, TransactionStatus.ABORTED, "me", "me", 10.00));
        assertFalse(contains);
    }

    @Test
    public void test_TransactionContains_ShouldReturn_True() {
        assertTrue(chainblock.contains(transactions.get(1)));
    }

    @Test
    public void test_Add_TransactionUnsuccessfully() {
        addTransactionsToListAndChainblock(1);
        int actualSize = chainblock.getCount();
        assertEquals(TRANSACTIONS_ADDED_COUNT, actualSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_ChangeTransactionStatus_NoSuchTransaction_ShouldThrow() {
        chainblock.changeTransactionStatus(INVALID_TRANSACTION, TransactionStatus.SUCCESSFUL);
    }

    @Test
    public void test_ChangeTransactionStatus_Successfully() {
        int idToChange = TRANSACTIONS_ADDED_COUNT - 1;
        TransactionStatus expected = TransactionStatus.SUCCESSFUL;
        chainblock.changeTransactionStatus(idToChange, expected);

        Transaction transaction = chainblock.getById(idToChange);

        assertEquals(expected, transaction.getStatus());
    }

    @Test
    public void test_GetById_Successfully() {
        int transactionId = 2;
        Transaction transaction = chainblock.getById(transactionId);

        assertEquals(transactionId, transaction.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetById_NoSuchTransaction_ShouldThrow() {
        chainblock.getById(INVALID_TRANSACTION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveTransactionById_NoSuchTransaction_ShouldThrow() {
        chainblock.removeTransactionById(INVALID_TRANSACTION);
    }

    @Test
    public void test_RemoveTransactionById_Successfully() {
        int validId = TRANSACTIONS_ADDED_COUNT - 1;

        Transaction transaction = chainblock.getById(validId);
        chainblock.removeTransactionById(validId);

        assertFalse(chainblock.contains(transaction.getId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetByTransactionStatus_NoSuchTransaction_ShouldThrow() {
        chainblock.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void test_GetByTransactionStatus_Successfully() {
        List<Transaction> expected = transactions
                .stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.UNAUTHORIZED))
                .sorted()
                .collect(Collectors.toList());

        Iterable<Transaction> iterable = chainblock.getByTransactionStatus(TransactionStatus.UNAUTHORIZED);

        List<Transaction> actual = new ArrayList<>();
        iterable.iterator().forEachRemaining(actual::add);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetAllSendersWithTransactionStatus_NoSuchTransactions_ShouldThrow() {
        chainblock.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void test_GetAllSendersWithTransactionStatus_Return_CollectionOfSenders() {
        List<String> expected = transactions
                .stream()
                .filter(p -> p.getStatus().equals(TransactionStatus.UNAUTHORIZED))
                .map(Transaction::getFrom)
                .sorted()
                .collect(Collectors.toList());

        Iterable<String> iterable = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED);

        List<String> actual = new ArrayList<>();
        iterable.iterator().forEachRemaining(actual::add);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetAllReceiversWithTransactionStatus_NoSuchTransactions_ShouldThrow() {
        chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void test_GetAllReceiversWithTransactionStatus_Return_CollectionOfSenders() {
        List<String> expected = transactions
                .stream()
                .filter(p -> p.getStatus().equals(TransactionStatus.UNAUTHORIZED))
                .map(Transaction::getTo)
                .sorted()
                .collect(Collectors.toList());

        Iterable<String> iterable = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.UNAUTHORIZED);

        List<String> actual = new ArrayList<>();
        iterable.iterator().forEachRemaining(actual::add);

        assertEquals(expected, actual);
    }

    @Test
    public void test_GetAllOrdered_AmountDescending_ThenById() {
        List<Transaction> expected = transactions
                .stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        Iterable<Transaction> iterable = chainblock.getAllOrderedByAmountDescendingThenById();

        List<Transaction> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetBySender_OrderedByAmountDescending_NoSuchSender_ShouldThrow() {
        chainblock.getBySenderOrderedByAmountDescending("invalid_sender");
    }

    @Test
    public void test_GetBySender_OrderedByAmountDescending() {
        String sender = "person_3";

        List<Transaction> expected = transactions
                .stream()
                .filter(t -> t.getFrom().equals(sender))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Iterable<Transaction> iterable = chainblock.getBySenderOrderedByAmountDescending(sender);

        List<Transaction> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetByReceiver_OrderedByAmountDescending_ThenById_NoSuchReceiver_ShouldThrow() {
        chainblock.getByReceiverOrderedByAmountThenById("invalid_receiver");
    }

    @Test
    public void test_GetByReceiver_OrderedByAmountDescending_ThenById() {
        String receiver = "receiver_4";

        List<Transaction> expected = transactions
                .stream()
                .filter(t -> t.getTo().equals(receiver))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        Iterable<Transaction> iterable = chainblock.getByReceiverOrderedByAmountThenById(receiver);

        List<Transaction> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        assertEquals(expected, actual);
    }

    @Test
    public void test_GetByTransactionStatus_AndMaximumAmount_ReturnsEmptyCollection() {
        assertEquals(new ArrayList<>(), chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.FAILED, 20.00));
    }

    @Test
    public void test_GetByTransactionStatus_AndMaximumAmount_Successfully() {
        TransactionStatus toFilter = TransactionStatus.UNAUTHORIZED;
        double maxAmount = 5;

        List<Transaction> expected = transactions
                .stream()
                .filter(t -> t.getStatus().equals(toFilter))
                .filter(t -> t.getAmount() <= maxAmount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Iterable<Transaction> iterable = chainblock.getByTransactionStatusAndMaximumAmount(toFilter, maxAmount);

        List<Transaction> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetBySender_AndMinimumAmount_NoSuchTransaction_ShouldThrow() {
        chainblock.getBySenderAndMinimumAmountDescending("invalid_person", 6);
    }

    @Test
    public void test_GetBySender_AndMinimumAmount_Descending() {
        String sender = "person_6";
        double minAmount = 4;

        List<Transaction> expected = transactions
                .stream()
                .filter(t -> t.getFrom().equals(sender))
                .filter(t -> t.getAmount() > minAmount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Iterable<Transaction> iterable = chainblock.getBySenderAndMinimumAmountDescending(sender, minAmount);

        List<Transaction> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetByReceiver_AndAmountRange_NoSuchTransaction_ShouldThrow() {
        chainblock.getByReceiverAndAmountRange("invalid_receiver", 20, 25);
    }

    @Test
    public void test_GetByReceiver_AndAmountRange_Successfully() {
        String receiver = "receiver_5";
        double low = 10;
        double high = 20;

        List<Transaction> expected = transactions
                .stream()
                .filter(t -> t.getTo().equals(receiver))
                .filter(t -> t.getAmount() >= low && t.getAmount() < high)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Iterable<Transaction> iterable = chainblock.getByReceiverAndAmountRange(receiver, low, high);

        List<Transaction> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        assertEquals(expected, actual);
    }

    @Test
    public void test_GetAllInAmountRange_NoSuchTransaction_ShouldReturn_EmptyCollection() {
        assertEquals(new ArrayList<>(), chainblock.getAllInAmountRange(40, 50));
    }

    @Test
    public void test_GetAllInAmountRange_Successfully() {
        double low = 5;
        double high = 15;

        List<Transaction> expected = transactions
                .stream()
                .filter(t -> t.getAmount() >= low && t.getAmount() <= high)
                .collect(Collectors.toList());

        Iterable<Transaction> iterable = chainblock.getAllInAmountRange(low, high);

        List<Transaction> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        assertEquals(expected, actual);
    }

    @Test
    public void test_Iterator_ShouldReturn_EmptyIterator() {
        ChainblockImpl empty = new ChainblockImpl();
        Iterator<Transaction> iterator = empty.iterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void test_Iterator_ReturnAllTransactions_Chainblock() {
        Iterator<Transaction> iterator = chainblock.iterator();

        int index = 0;
        while (iterator.hasNext()) {
            Transaction expected = iterator.next();
            Transaction actual = transactions.get(index++);
            assertEquals(expected, actual);
        }
    }
}