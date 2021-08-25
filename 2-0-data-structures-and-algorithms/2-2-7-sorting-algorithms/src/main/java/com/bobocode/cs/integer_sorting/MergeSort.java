package com.bobocode.cs.integer_sorting;

import lombok.NonNull;

import java.util.Arrays;

/*
* 1. Merge sort works more quickly on large arrays than Insertion sort.
* 2. Merge sort uses more memory but fewer CPU resources, than Insertion sort. Memory is used to create new arrays
*   (divided and merged).
* 3. In the case of a partially sorted array, Merge sort works the same. In case of a partially sorted array,
*   Insertion sort has less number of nested iterations.
* */
public class MergeSort implements IntegerSortingAlgorithm {
    @Override
    public int[] sort(@NonNull int[] array) {
        if(array.length == 1) {
            return array;
        } else {
            int [] firstArr = Arrays.copyOfRange(array, 0, array.length/2);
            int [] secondArr = Arrays.copyOfRange(array, array.length/2, array.length);
            return mergeSortedArrays(sort(firstArr), sort(secondArr));
        }
    }

    private int [] mergeSortedArrays(int [] arr1, int [] arr2) {
        int [] mergedArray = new int[arr1.length + arr2.length];
        int arr1Index = 0, arr2Index = 0, mergedIndex = 0;
        while (arr1Index < arr1.length && arr2Index < arr2.length) {
            if(arr1[arr1Index] <= arr2[arr2Index]) {
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
