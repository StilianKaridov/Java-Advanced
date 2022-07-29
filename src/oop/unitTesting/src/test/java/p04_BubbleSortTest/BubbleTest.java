package oop.unitTesting.src.test.java.p04_BubbleSortTest;

import oop.unitTesting.src.main.java.p04_BubbleSortTest.Bubble;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BubbleTest {

    @Test
    public void test_BubbleSort() {
        int[] actual = new int[]{10, -1, -5, 2, 8, 4};
        int[] expected = new int[]{-5, -1, 2, 4, 8, 10};

        Bubble.sort(actual);
        assertArrayEquals(expected, actual);
    }
}