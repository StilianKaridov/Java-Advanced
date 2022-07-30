package oop.unitTesting.src.test.java.p03_IteratorTest;

import oop.unitTesting.src.main.java.p03_IteratorTest.ListIterator;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;


public class ListIteratorTest {

    private ListIterator listIterator;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.listIterator = new ListIterator("1", "2");
    }

    @SuppressWarnings("all")
    @Test(expected = OperationNotSupportedException.class)
    public void test_Constructor_WithNullElement_ShouldThrow() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void test_Constructor_SuccessfullyCreate() throws OperationNotSupportedException {
        new ListIterator("1", "2", "3");
    }

    @Test
    public void test_hasNext_Successfully() {
        while (listIterator.hasNext()) {
            listIterator.move();
        }
    }

    @Test
    public void test_Move_Successfully() {
        while (listIterator.hasNext()) {
            listIterator.move();
        }
        listIterator.move();
    }

    @Test(expected = IllegalStateException.class)
    public void test_Print_ZeroSize_ShouldThrow() throws OperationNotSupportedException {
        new ListIterator().print();
    }

    @Test
    public void test_Print_Successfully() {
        listIterator.print();
    }
}