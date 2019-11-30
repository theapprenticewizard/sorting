package com.apprenticewizard.main.algorithms.cocktailshakersort;

import com.apprenticewizard.main.algorithms.SortingAlgorithm;

/**
 * A slightly more optimized variant of bubble sort it gets roughly
 * a 20% to 30% performance boost it's based on the optimized version of bubble sor.
 * where the last element could be ignored, we can double the elements that can
 * be ignored by scanning both ways. Despite the performance improvements, this
 * algorithms still operates in exponential time for worst and average cases. O(n^2)
 */
public class CocktailShakerSort implements SortingAlgorithm {

    // TODO: optimize this for fewer instructions so that the jitter has more efficient paths.

    @Override
    public void sort(int[] elements) {
        int window = 1;
        while(!(bubbleUp(elements, window) || sinkDown(elements, window))) {
            ++window;
        }
    }

    /**
     * "bubbles up" the array of elements if no elements were needed to swap then return true.
     * else return false.
     * @param elements the input
     * @param max the max index to be processed as we know the last index will have the highest value
     * @return true if the elements are already sorted, otherwise false
     */
    @SuppressWarnings("DuplicatedCode")
    private boolean bubbleUp(int[] elements, int max) {
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

    /**
     * "Sinks down" which is the inverse operation of bubbling up going highest (rightmost)
     * to lowest (left most)
     * @param elements the elements to sink down
     * @param min the minimum index to sink down to based on the window
     * @return whether or not sinking down has solved the problem
     */
    private boolean sinkDown(int[] elements, int min) {
        boolean sorted = true;
        for (int i = elements.length - min; i > 0; --i) {
            if(elements[i] < elements[i-1]) {
                int placeholder = elements[i];
                elements[i] = elements[i-1];
                elements[i-1] = placeholder;
                sorted = false;
            }
        }
        return sorted;
    }
}
