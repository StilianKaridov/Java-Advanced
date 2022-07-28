package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.database = new Database(1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Constructor_ZeroElements() throws OperationNotSupportedException {
        this.database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Constructor_MoreThan_SixteenElements() throws OperationNotSupportedException {
        this.database = new Database(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Add_NullElement() throws OperationNotSupportedException {
        Integer nullable = null;
        this.database.add(nullable);
    }

    //getElements() is being tested too
    @Test
    public void test_Add_NextElement() throws OperationNotSupportedException {
        Database expectedDatabase = new Database(1, 2);

        this.database.add(2);

        Integer[] expectedArray = expectedDatabase.getElements();
        Integer[] currentArray = database.getElements();

        assertArrayEquals(expectedArray, currentArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_Remove_IndexBelowZero() throws OperationNotSupportedException {
        this.database.remove();
        this.database.remove();
    }

    @Test
    public void test_Remove_ReduceElementsCount_WhenRemoving() throws OperationNotSupportedException {
        int expectedCount = 0;
        this.database.remove();

        assertEquals(expectedCount, database.getElements().length);
    }

}