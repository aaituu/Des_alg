package com.example.sort;

public class QuickSort {

    public static void sort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private static void quicksort(int[] arr, int low, int high) {
        while (low < high) {
            int pivotIndex = partition(arr, low, high);
            // recurse on smaller part first
            if (pivotIndex - low < high - pivotIndex) {
                quicksort(arr, low, pivotIndex - 1);
                low = pivotIndex + 1; // loop on larger part
            } else {
                quicksort(arr, pivotIndex + 1, high);
                high = pivotIndex - 1; // loop on larger part
            }
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivotIndex = low + (int)(Math.random() * (high - low + 1));
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, high);
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                swap(arr, i++, j);
            }
        }
        swap(arr, i, high);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
