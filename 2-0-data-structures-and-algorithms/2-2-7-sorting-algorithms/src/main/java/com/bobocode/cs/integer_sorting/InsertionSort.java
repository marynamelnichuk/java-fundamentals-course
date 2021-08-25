package com.bobocode.cs.integer_sorting;

import lombok.NonNull;

public class InsertionSort implements IntegerSortingAlgorithm {
    @Override
    public int[] sort(@NonNull int[] array) {
        for(int i = 1; i < array.length; i++) {
            int currentElem = array[i];
            for (int j = i - 1; j >= 0 && currentElem < array[j]; j--) {
                array[j + 1] = array[j];
                array[j] = currentElem;
            }
        }
        return array;
    }
}
