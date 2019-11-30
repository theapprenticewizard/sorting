package com.apprenticewizard.main.algorithms.monkeysort;

import com.apprenticewizard.main.algorithms.SortingAlgorithm;

import static com.apprenticewizard.main.utils.ArrayUtils.isSorted;
import static com.apprenticewizard.main.utils.ArrayUtils.shuffle;

/**
 * A "joke" or "fake" sorting algorithm also known as "bogosort" (short for bogus)
 * it just randomizes a list until it's fully sorted. It's best, worst and average case is
 * O((n + 1)!) which with very few elements could take a long amount of time.
 */
public class MonkeySort implements SortingAlgorithm {

    @Override
    public void sort(int[] elements) {
        while(!isSorted(elements)) {
            shuffle(elements);
        }
    }
}
