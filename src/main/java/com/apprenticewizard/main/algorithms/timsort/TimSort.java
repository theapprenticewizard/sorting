package com.apprenticewizard.main.algorithms.timsort;

import com.apprenticewizard.main.algorithms.SortingAlgorithm;

import java.util.Arrays;

public class TimSort implements SortingAlgorithm {
    @Override
    public void sort(int[] elements) {
        // cheating here by using Array.sort() - Tim Sort is the default sorting algorithm of the JVM!
        Arrays.sort(elements);
    }
}
