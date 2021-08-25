package com.bobocode.cs.generic_sorting;

import lombok.NonNull;

import java.util.Comparator;

public class InsertionSort<T> implements GenericSortingAlgorithm<T> {

    private final Comparator<T> comparator;

    public InsertionSort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public T[] sort(@NonNull T[] array) {
        for(int i = 1; i < array.length; i++) {
            T currentElem = array[i];
            for (int j = i - 1; j >= 0 && comparator.compare(currentElem, array[j]) == -1; j--) {
                array[j + 1] = array[j];
                array[j] = currentElem;
            }
        }
        return array;
    }
}
