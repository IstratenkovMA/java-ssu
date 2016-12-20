package com.mikhail_istratenkov;

import com.mikhail_istratenkov.task1.BubbleSorter;
import com.mikhail_istratenkov.task1.Sorter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Task1Test {

    @Test
    public void bubbleSort() {
        Sorter sorter = new BubbleSorter();
        int[] actualArray = new int[] { 10, 0, -1, 100 };
        sorter.sort(actualArray);
        int[] expectedArray = new int[] { -1, 0, 10, 100};
        assertArrayEquals(expectedArray, actualArray);
    }
}
