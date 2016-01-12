/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author rominparekh
 */
public class QuickSort {

    public void quicksort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(arr, start, end);
        quicksort(arr, start, pivot - 1);
        quicksort(arr, pivot + 1, end);
    }

    public void start() {
        int[] arr = new int[]{1, 5, 3, 7, 2, 8, 4, 9, 6};
        quicksort(arr, 0, arr.length - 1);
        print(arr);
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                arr[i] += arr[pIndex];
                arr[pIndex] = arr[i] - arr[pIndex];
                arr[i] = arr[i] - arr[pIndex];
                pIndex += 1;
            }
        }
        arr[pIndex] += arr[end];
        arr[end] = arr[pIndex] - arr[end];
        arr[pIndex] = arr[pIndex] - arr[end];

        return pIndex;
    }

    private void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
