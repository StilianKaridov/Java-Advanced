package oop.unitTesting.src.test.java.p05_CustomLinkedList;

import oop.unitTesting.src.main.java.p05_CustomLinkedList.CustomLinkedList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    private CustomLinkedList<Integer> customLinkedList;
    private static final Integer EXPECTED_INVALID_INDEX = -1;
    private static final Integer EXPECTED_VALID_INDEX = 2;


    @Before
    public void setUp() {
        this.customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(1);
        customLinkedList.add(2);
        customLinkedList.add(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_GetElement_OnGivenInvalidIndex_ShouldThrow() {
        customLinkedList.get(3);
    }

    @Test
    public void test_GetElement_Successfully() {
        Integer expectedNumber = 2;
        Integer actual = customLinkedList.get(1);

        assertEquals(expectedNumber, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_SetElement_OnGivenInvalidIndex_ShouldThrow() {
        customLinkedList.set(-1, 4);
    }

    @Test
    public void test_SetElement_Successfully() {
        customLinkedList.set(2, 4);

        Integer expectedValue = 4;
        Integer actualValue = customLinkedList.get(2);

        assertEquals(expectedValue, actualValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_RemoveAt_InvalidIndex_ShouldThrow() {
        customLinkedList.removeAt(3);
    }

    @Test
    public void test_RemoveAt_Successfully() {
        Integer actualRemoved = customLinkedList.removeAt(1);

        assertEquals(EXPECTED_VALID_INDEX, actualRemoved);
    }

    @Test
    public void test_Remove_ElementNotFound() {
        Integer actualIndex = customLinkedList.remove(4);

        assertEquals(EXPECTED_INVALID_INDEX, actualIndex);
    }

    @Test
    public void test_Remove_Successfully() {
        Integer actualIndex = customLinkedList.remove(3);

        assertEquals(EXPECTED_VALID_INDEX, actualIndex);
    }

    @Test
    public void test_IndexOf_ElementNotFound() {
        Integer actualIndex = customLinkedList.indexOf(4);

        assertEquals(EXPECTED_INVALID_INDEX, actualIndex);
    }

    @Test
    public void test_IndexOf_Successfully() {
        Integer actualIndex = customLinkedList.indexOf(3);

        assertEquals(EXPECTED_VALID_INDEX, actualIndex);
    }

    @Test
    public void test_Contains_Unsuccessfully() {
        assertFalse(customLinkedList.contains(4));
    }

    @Test
    public void test_Contains_Successfully() {
        assertTrue(customLinkedList.contains(3));
    }

    @Test
    public void test_RemoveListNode() {
        customLinkedList.remove(1);
        customLinkedList.remove(2);
        customLinkedList.remove(3);
    }
}