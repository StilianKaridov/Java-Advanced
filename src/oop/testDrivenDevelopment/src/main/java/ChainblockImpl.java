import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {

    private Map<Integer, Transaction> transactions;

    public ChainblockImpl() {
        this.transactions = new HashMap<>();
    }

    public int getCount() {
        return transactions.size();
    }

    public void add(Transaction transaction) {
        this.transactions.putIfAbsent(transaction.getId(), transaction);
    }

    public boolean contains(Transaction transaction) {
        return contains(transaction.getId());
    }

    public boolean contains(int id) {
        return transactions.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (!contains(id)) {
            throw new IllegalArgumentException();
        }

        transactions.get(id).setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        if (!contains(id)) {
            throw new IllegalArgumentException();
        }

        transactions.remove(id);
    }

    public Transaction getById(int id) {
        if (!contains(id)) {
            throw new IllegalArgumentException();
        }

        return transactions.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> iterable = transactions
                .values()
                .stream()
                .filter(t -> t.getStatus().equals(status))
                .sorted()
                .collect(Collectors.toList());

        if (iterable.size() == 0) {
            throw new IllegalArgumentException();
        }

        return iterable;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<String> iterable = transactions
                .values()
                .stream()
                .filter(t -> t.getStatus().equals(status))
                .map(Transaction::getFrom)
                .sorted()
                .collect(Collectors.toList());

        if (iterable.size() == 0) {
            throw new IllegalArgumentException();
        }

        return iterable;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<String> iterable = transactions
                .values()
                .stream()
                .filter(p -> p.getStatus().equals(status))
                .map(Transaction::getTo)
                .sorted()
                .collect(Collectors.toList());

        if (iterable.size() == 0) {
            throw new IllegalArgumentException();
        }

        return iterable;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return transactions
                .values()
                .stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> senders = transactions
                .values()
                .stream()
                .filter(t -> t.getFrom().equals(sender))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (senders.size() == 0) {
            throw new IllegalArgumentException();
        }

        return senders;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> receivers = transactions
                .values()
                .stream()
                .filter(t -> t.getTo().equals(receiver))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        if (receivers.size() == 0) {
            throw new IllegalArgumentException();
        }

        return receivers;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return transactions
                .values()
                .stream()
                .filter(t -> t.getStatus().equals(status))
                .filter(t -> t.getAmount() <= amount)
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> ordered = transactions
                .values()
                .stream()
                .filter(t -> t.getFrom().equals(sender))
                .filter(t -> t.getAmount() > amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (ordered.size() == 0) {
            throw new IllegalArgumentException();
        }

        return ordered;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> ordered = transactions
                .values()
                .stream()
                .filter(t -> t.getTo().equals(receiver))
                .filter(t -> t.getAmount() >= lo && t.getAmount() < hi)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (ordered.size() == 0) {
            throw new IllegalArgumentException();
        }

        return ordered;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return transactions
                .values()
                .stream()
                .filter(t -> t.getAmount() >= lo && t.getAmount() <= hi)
                .collect(Collectors.toList());
    }

    public Iterator<Transaction> iterator() {
        return transactions.values().iterator();
    }
}
