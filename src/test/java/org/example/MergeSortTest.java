package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MergeSortTest {
    @Test
    void testMergeSortBasic() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 5, 5, 6, 9}, arr);
    }
    @Test
    void testEmptyArray() {
        int[] arr = {};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }
    @Test
    void testSingleElement() {
        int[] arr = {42};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }
    @Test
    void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }
    @Test
    void testReverseOrder() {
        int[] arr = {9, 8, 7, 6, 5};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{5, 6, 7, 8, 9}, arr);
    }
}
