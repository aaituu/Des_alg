package com.example.sort;

import java.util.Arrays;

public class MergeSort {

    private static final int CUTOFF = 10; // small-n cutoff for insertion sort

    public static void sort(int[] array) {
        int[] aux = new int[array.length]; // reusable buffer
        sort(array, aux, 0, array.length - 1);
    }

    private static void sort(int[] array, int[] aux, int low, int high) {
        if (high - low + 1 <= CUTOFF) {
            insertionSort(array, low, high);
            return;
        }
        int mid = low + (high - low) / 2;
        sort(array, aux, low, mid);
        sort(array, aux, mid + 1, high);
        merge(array, aux, low, mid, high);
    }

    private static void merge(int[] array, int[] aux, int low, int mid, int high) {
        System.arraycopy(array, low, aux, low, high - low + 1);
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) array[k] = aux[j++];
            else if (j > high) array[k] = aux[i++];
            else if (aux[i] <= aux[j]) array[k] = aux[i++];
            else array[k] = aux[j++];
        }
    }

    private static void insertionSort(int[] array, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= low && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
