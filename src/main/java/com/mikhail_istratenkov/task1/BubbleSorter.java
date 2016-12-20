package com.mikhail_istratenkov.task1;

public class BubbleSorter implements Sorter {

    public void sort(int[] arrayToSort) {
        int size = arrayToSort.length;
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < (size - i); j++) {
                if (arrayToSort[j - 1] > arrayToSort[j]) {
                    int temp = arrayToSort[j - 1];
                    arrayToSort[j - 1] = arrayToSort[j];
                    arrayToSort[j] = temp;
                }
            }
        }
    }
}
