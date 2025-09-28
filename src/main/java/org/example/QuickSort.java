package org.example;

import java.util.Random;

public class QuickSort {
    private static final Random rand = new Random();
    public static void sort(int[] array) {
        if (array == null || array.length <= 1) return;
        quickSort(array, 0, array.length - 1);
    }
    private static void quickSort(int[] array, int left, int right) {
        while (left < right) {
            int pivotIndex = partition(array, left, right);
            if (pivotIndex - left < right - pivotIndex) {
                quickSort(array, left, pivotIndex - 1);
                left = pivotIndex + 1;
            } else {
                quickSort(array, pivotIndex + 1, right);
                right = pivotIndex - 1;
            }
        }
    }
    private static int partition(int[] array, int left, int right) {
        int pivotIndex = left + rand.nextInt(right - left + 1);
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, right);
        int i = left;
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, right);
        return i;
    }
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
