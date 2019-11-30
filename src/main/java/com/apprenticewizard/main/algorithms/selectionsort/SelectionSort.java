package com.apprenticewizard.main.algorithms.selectionsort;

import com.apprenticewizard.main.algorithms.SortingAlgorithm;

public class SelectionSort implements SortingAlgorithm {

    @Override
    public void sort(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            int indexOfLowest = 0;
            int lowestValue = Integer.MAX_VALUE;
            for (int j =  i; j < elements.length; j++) {
                if(elements[j] < lowestValue) {
                    lowestValue = elements[j];
                    indexOfLowest = j;
                }
            }
            int temp = elements[indexOfLowest];
            elements[indexOfLowest] = elements[i];
            elements[i] = temp;
        }
    }
}
