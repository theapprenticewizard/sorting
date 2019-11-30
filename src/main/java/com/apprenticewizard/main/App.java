package com.apprenticewizard.main;

import com.apprenticewizard.main.algorithms.SortingAlgorithm;
import com.apprenticewizard.main.algorithms.bubblesort.BubbleSort;
import com.apprenticewizard.main.algorithms.cocktailshakersort.CocktailShakerSort;
import com.apprenticewizard.main.algorithms.insertionsort.InsertionSort;
import com.apprenticewizard.main.algorithms.selectionsort.SelectionSort;
import com.apprenticewizard.main.utils.ArrayUtils;

import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class App {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    private static final int UPPER_BOUND = 1000;
    private static final int NUMBER_OF_ELEMENTS = 50000;

    private static SortingAlgorithm[] ALGORITHMS = new SortingAlgorithm[]
            {
                    new InsertionSort(),
                    new SelectionSort(),
//                    new TimSort(),
//                    new MonkeySort(),
                    new BubbleSort(),
                    new CocktailShakerSort()
            };

    public static void main(String[] args) {
        int[] elements = randomInts();
        System.out.println("=== before sorting === ");
        ArrayUtils.print(elements);
        Instant start = Instant.now();
        Arrays.stream(ALGORITHMS).forEach(a -> benchmark(elements, a));
        sort(elements, new BubbleSort());
        Instant end = Instant.now();
        System.out.printf("=== time to complete %dms ===%n", msBetween(start, end));
    }

    private static void benchmark(int[] elements, SortingAlgorithm algorithm) {
        // make defensive copy
        int[] cp = ArrayUtils.copy(elements);
        String algorithmName = className(algorithm);
        System.out.printf("=== running %s ====%n", algorithmName);
        Instant start = Instant.now();
        algorithm.sort(cp);
        Instant end = Instant.now();
        if(!ArrayUtils.isSorted(cp))
            throw new IllegalStateException("algorithm " + algorithmName + " did not sort!");
        printArray(cp);
        System.out.printf("=== %s took %dms ===%n%n", algorithmName, msBetween(start, end));
    }

    private static String className(Object obj) {
        return obj.getClass().getSimpleName();
    }

    private static long msBetween(Instant start, Instant end) {
        return end.toEpochMilli() - start.toEpochMilli();
    }

    private static void sort(int[] elements, SortingAlgorithm algorithm) {
        algorithm.sort(elements);
    }

    private static void printArray(int[] ints) {
        System.out.println(Arrays.toString(ints));
    }

    private static int[] randomInts() {
        int[] randomElements = new int[NUMBER_OF_ELEMENTS];
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            randomElements[i] = RANDOM.nextInt(UPPER_BOUND);
        }
        return randomElements;
    }
}
