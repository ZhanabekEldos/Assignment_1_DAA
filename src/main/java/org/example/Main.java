package org.example;
public class Main {
    public static void main(String[] args) {
        int[] arr = {7, 6, 4, 5, 3, 1, 2};
        System.out.print("Before sort: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
        MergeSort.sort(arr);
        System.out.print("After sort:  ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}