package com.apprenticewizard.main.algorithms.insertionsort;

import com.apprenticewizard.main.algorithms.SortingAlgorithm;


/**
 * This is the constant space implementation of insertion sort.
 * However providing a version of insertion sort using a list would take more
 * space but would be faster.
 */
public class InsertionSort implements SortingAlgorithm {

    @Override
    public void sort(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            for (int j = i; j > 0; j--) {
                if(elements[j-1] < elements[j]) break;
                swap(elements, j);
            }
        }
    }

    /**
     * swaps an element with the preceding element
     */
    private void swap(int[] elements, int j) {
        int temp = elements[j];
        elements[j] = elements[j-1];
        elements[j-1] = temp;
    }
}