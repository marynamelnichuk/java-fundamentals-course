package com.bobocode.cs.integer_sorting;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IntegerSortingAlgorithmTest {

    @Test
    @Order(1)
    void testInsertionSort() {
        int [] arrayToSort = new int[]{5, 6, 3, 1, 8, 7, 2, 4, 9};
        IntegerSortingAlgorithm sortingAlgorithm = new InsertionSort();
        int [] sortedArray = sortingAlgorithm.sort(arrayToSort);
        Arrays.sort(arrayToSort);
        assertThat(Arrays.equals(arrayToSort, sortedArray));
    }

    @Test
    @Order(2)
    void testMergeSortNotEvenArrayLength() {
        int [] arrayToSort = new int[]{5, 6, 3, 1, 8, 7, 2, 4, 9};
        IntegerSortingAlgorithm sortingAlgorithm = new MergeSort();
        int [] sortedArray = sortingAlgorithm.sort(arrayToSort);
        assertThat(Arrays.equals(arrayToSort, sortedArray));
    }

    @Test
    @Order(3)
    void testMergeSortEvenArrayLength() {
        int [] arrayToSort = new int[]{5, 6, 3, 1, 8, 7, 2, 4, 10, 9};
        IntegerSortingAlgorithm sortingAlgorithm = new MergeSort();
        int [] sortedArray = sortingAlgorithm.sort(arrayToSort);
        assertThat(Arrays.equals(arrayToSort, sortedArray));
    }

}
