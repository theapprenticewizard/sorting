package com.apprenticewizard.main.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayUtilsTest {

    @Test
    void isSorted() {
        int[] elements = { 2, 3, 1, 5, 3 };
        assertFalse(ArrayUtils.isSorted(elements));
    }

    @Test
    void isSorted_no_elements() {
        int[] elements = new int[0];
        assertTrue(ArrayUtils.isSorted(elements));
    }

    @Test
    void isSorted_elements_near_sorted() {
        int[] elements = { 1, 2, 1, 3, 4};
        assertFalse(ArrayUtils.isSorted(elements));
    }

    @Test
    void isSorted_sorted_elements() {
        int[] elements = { 1, 2, 3, 4, 5};
        assertTrue(ArrayUtils.isSorted(elements));
    }
}