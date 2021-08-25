package com.bobocode.cs.generic_sorting;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GenericSortingAlgorithmTest {

    @Test
    @Order(1)
    void testIntegerInsertionSort() {
        Integer [] arrayToSort = new Integer[]{5, 6, 3, 1, 8, 7, 2, 4, 9};
        GenericSortingAlgorithm<Integer> sortingAlgorithm = new InsertionSort<>(
                Comparator.comparingInt(Integer::intValue));
        Integer [] sortedArray = sortingAlgorithm.sort(arrayToSort);
        Arrays.sort(arrayToSort);
        assertThat(Arrays.equals(arrayToSort, sortedArray));
    }

    @Test
    @Order(2)
    void testStringInsertionSort() {
        String [] arrayToSort = new String[]{"12", "1", "12345", "123", "12345678", "1234", "123456"};
        GenericSortingAlgorithm<String> sortingAlgorithm = new InsertionSort<>(
                Comparator.comparingInt(String::length));
        String [] sortedArray = sortingAlgorithm.sort(arrayToSort);
        Arrays.sort(arrayToSort, Comparator.comparingInt(String::length));
        assertThat(Arrays.equals(arrayToSort, sortedArray));
    }

    @Test
    @Order(3)
    void testMergeSortNotEvenArrayLength() {
        String [] arrayToSort = new String[]{"12", "1", "12345", "123", "12345678", "1234", "123456"};
        GenericSortingAlgorithm<String> sortingAlgorithm = new MergeSort<>(
                Comparator.comparingInt(String::length));
        String [] sortedArray = sortingAlgorithm.sort(arrayToSort);
        Arrays.sort(arrayToSort, Comparator.comparingInt(String::length));
        assertThat(Arrays.equals(arrayToSort, sortedArray));
    }

    @Test
    @Order(4)
    void testMergeSortEvenArrayLength() {
        String [] arrayToSort = new String[]{"12", "1", "12345", "123", "12345678", "123456"};
        GenericSortingAlgorithm<String> sortingAlgorithm = new MergeSort<>(
                Comparator.comparingInt(String::length));
        String [] sortedArray = sortingAlgorithm.sort(arrayToSort);
        Arrays.sort(arrayToSort, Comparator.comparingInt(String::length));
        assertThat(Arrays.equals(arrayToSort, sortedArray));
    }

}
