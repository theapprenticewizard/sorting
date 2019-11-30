package com.apprenticewizard.main.utils;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayUtils {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    private ArrayUtils() {}

    /**
     * makes a defensive copy of an array
     */
    public static int[] copy(int[] elements) {
        return Arrays.copyOf(elements, elements.length);
    }

    /**
     * prints an array directly to System.out
     */
    public static void print(int[] elements) {
        System.out.println(Arrays.toString(elements));
    }

    /**
     * determines if an array is already sorted
     * TODO: sorted guarantee is broken
     */
    public static boolean isSorted(int[] elements) {
        int cursor = elements.length > 0 ? elements[0] : 0;
        for (int i = 1; i < elements.length; i++) {
            if(cursor > elements[i])
                return false;
            cursor = elements[i];
        }
        return true;
    }

    public static void shuffle(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            int randomIndex = RANDOM.nextInt(elements.length);
            int placeholder = elements[i];
            elements[i] = elements[randomIndex];
            elements[randomIndex] = placeholder;
        }
    }
}
