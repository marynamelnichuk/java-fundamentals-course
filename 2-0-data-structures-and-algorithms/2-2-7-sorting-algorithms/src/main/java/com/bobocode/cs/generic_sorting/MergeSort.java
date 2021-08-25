package com.bobocode.cs.generic_sorting;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort <T> implements GenericSortingAlgorithm<T> {

    private final Comparator<T> comparator;

    public MergeSort(Comparator<T> comparator) {
        this.comparator = comparator;
    }
    @Override
    public T[] sort(@NonNull T[] array) {
        if(array.length == 1) {
            return array;
        } else {
            T [] firstArr = Arrays.copyOfRange(array, 0, array.length/2);
            T [] secondArr = Arrays.copyOfRange(array, array.length/2, array.length);
            return mergeSortedArrays(sort(firstArr), sort(secondArr));
        }
    }

    private T [] mergeSortedArrays(T [] arr1, T [] arr2) {
        T [] mergedArray = Arrays.copyOf(arr1, arr1.length + arr2.length);
        int arr1Index = 0, arr2Index = 0, mergedIndex = 0;
        while (arr1Index < arr1.length && arr2Index < arr2.length) {
            if(comparator.compare(arr1[arr1Index], arr2[arr2Index]) < 1) {
                mergedArray[mergedIndex++] = arr1[arr1Index++];
            } else {
                mergedArray[mergedIndex++] = arr2[arr2Index++];
            }
        }
        if(arr1Index < arr1.length) {
            System.arraycopy(arr1, arr1Index, mergedArray, mergedIndex, arr1.length - arr1Index);
        }
        if(arr2Index < arr2.length) {
            System.arraycopy(arr2, arr2Index, mergedArray, mergedIndex, arr2.length - arr2Index);
        }
        return mergedArray;
    }
}
