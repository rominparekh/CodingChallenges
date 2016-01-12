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
public class BSearchCircularArray {

    int getElementIndex(int[] arr, int x) {
        int n = arr.length;
        if (n > 0) {
            int low = 0, high = n - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == x) {
                    return mid;
                } else if (arr[mid] < arr[high]) {
                    if (x > arr[mid] && x <= arr[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                } else if (arr[mid] > arr[low]) {
                    if (x < arr[mid] && x >= arr[low]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    System.out.println("Error");
                    return -1;
                }
            }
        }
        return -1;
    }

    void start() {
        int arr[] = {12, 16, 18, 21, 3, 6, 8, 9};
        int x = 21;
        System.out.println(x + " is at loc :" + getElementIndex(arr, x));
    }
}
