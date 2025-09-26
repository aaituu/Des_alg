package com.example.select;
import com.example.metrics.Metrics;
public class DeterministicSelect {

public static int select(int[] arr, int k) {
    return select(arr, k, new Metrics());
}

public static int select(int[] arr, int k, Metrics metrics) {
    if (arr == null || k < 0 || k >= arr.length)
        throw new IllegalArgumentException();
    return select(arr, 0, arr.length - 1, k, metrics);
}

private static int select(int[] arr, int left, int right, int k, Metrics metrics) {
    metrics.enterRecursion();
    try {
        while (true) {
            if (left == right) return arr[left];

            int pivotIndex = pivot(arr, left, right, metrics);
            pivotIndex = partition(arr, left, right, pivotIndex, metrics);

            if (k == pivotIndex) return arr[k];
            else if (k < pivotIndex) right = pivotIndex - 1;
            else left = pivotIndex + 1;
        }
    } finally {
        metrics.exitRecursion();
    }
}

private static int pivot(int[] arr, int left, int right, Metrics metrics) {
    if (right - left < 5) {
        insertionSort(arr, left, right, metrics);
        return left + (right-left)/2;
    }
    for (int i = left; i <= right; i += 5) {
        int subRight = Math.min(i + 4, right);
        insertionSort(arr, i, subRight, metrics);
        int median5 = i + (subRight - i) / 2;
        swap(arr, median5, left + (i-left)/5, metrics);
    }
    int mid = left + (int)Math.ceil((right-left)/5.0) / 2;
    return select(arr, left, left + (right-left)/5, mid, metrics);
}

private static int partition(int[] arr, int left, int right, int pivotIndex, Metrics metrics) {
    int pivot = arr[pivotIndex];
    swap(arr, pivotIndex, right, metrics);
    int storeIndex = left;
    for (int i = left; i < right; i++) {
        metrics.incComparisons();
        if (arr[i] < pivot) swap(arr, storeIndex++, i, metrics);
    }
    swap(arr, right, storeIndex, metrics);
    return storeIndex;
}

private static void insertionSort(int[] arr, int left, int right, Metrics metrics) {
    for (int i = left + 1; i <= right; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= left) {
            metrics.incComparisons();
            if (arr[j] <= key) break;
            arr[j+1] = arr[j];
            metrics.incSwaps();
            j--;
        }
        arr[j+1] = key;
        metrics.incSwaps();
    }
}

private static void swap(int[] arr, int i, int j, Metrics metrics) {
    if (i != j) {
        int tmp = arr[i]; 
        arr[i] = arr[j]; 
        arr[j] = tmp;
        metrics.incSwaps();
    }
}
}
