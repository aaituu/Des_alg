package com.example.select;

public class DeterministicSelect {

    public static int select(int[] arr, int k) {
        if (arr == null || k < 0 || k >= arr.length)
            throw new IllegalArgumentException();
        return select(arr, 0, arr.length - 1, k);
    }

    private static int select(int[] arr, int left, int right, int k) {
        while (true) {
            if (left == right) return arr[left];

            int pivotIndex = pivot(arr, left, right);
            pivotIndex = partition(arr, left, right, pivotIndex);

            if (k == pivotIndex) return arr[k];
            else if (k < pivotIndex) right = pivotIndex - 1;
            else left = pivotIndex + 1;
        }
    }

    private static int pivot(int[] arr, int left, int right) {
        if (right - left < 5) {
            insertionSort(arr, left, right);
            return left + (right-left)/2;
        }
        for (int i = left; i <= right; i += 5) {
            int subRight = Math.min(i + 4, right);
            insertionSort(arr, i, subRight);
            int median5 = i + (subRight - i) / 2;
            swap(arr, median5, left + (i-left)/5);
        }
        int mid = left + (int)Math.ceil((right-left)/5.0) / 2;
        return select(arr, left, left + (right-left)/5, mid);
    }

    private static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivot) swap(arr, storeIndex++, i);
        }
        swap(arr, right, storeIndex);
        return storeIndex;
    }

    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
    }
}
