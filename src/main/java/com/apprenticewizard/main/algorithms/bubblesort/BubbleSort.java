package com.apprenticewizard.main.algorithms.bubblesort;

import com.apprenticewizard.main.algorithms.SortingAlgorithm;

/**
 * With a worst and average case of O(n^2) this is a very slow algorithm.
 * It's best case is O(n) if all of the elements are already in order.
 * Typically O(n log n) algorithms (merge sort, quick sort, tim sort)
 * are more popular due to their ability to sort nearly sorted elements.
 * */
public class BubbleSort implements SortingAlgorithm {

    /**
     * While the array is not sorted bubble up the elements in ascending order.
     * after each bubble the N highest element is guaranteed to be the Nth right most
     * element.  This means we don't have to sort until the nth element which is the
     * max index.
     */
    public void sort(int[] elements) {
        int max = 1;
        while(!bubble(elements, max))
            ++max;
    }

    /**
     * "bubbles up" the array of elements if no elements were needed to swap then return true.
     * else return false.
     * @param elements the input
     * @param max the max index to be processed as we know the last index will have the highest value
     * @return true if the elements are already sorted, otherwise false
     */
    @SuppressWarnings("DuplicatedCode")
    private boolean bubble(int[] elements, int max) {
        boolean sorted = true;
        for (int i = 0; i < elements.length - max; i++) {
            if(elements[i] > elements[i+1]) {
                int placeholder = elements[i];
                elements[i] = elements[i+1];
                elements[i+1] = placeholder;
                sorted = false;
            }
        }
        return sorted;
    }
}