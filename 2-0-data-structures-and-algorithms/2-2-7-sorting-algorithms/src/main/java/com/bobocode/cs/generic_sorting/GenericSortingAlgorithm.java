package com.bobocode.cs.generic_sorting;

import lombok.NonNull;

public interface GenericSortingAlgorithm<T> {
    T[] sort(@NonNull T [] array);
}
