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
public class BinSearchCount {

    /* if x is present in arr[] then returns the count of occurrences of x, 
     otherwise returns -1. */
    int count(int arr[], int x, int n) {
        int i; // index of first occurrence of x in arr[0..n-1]
        int j; // index of last occurrence of x in arr[0..n-1]

        /* get the index of first occurrence of x */
        i = first(arr, 0, n - 1, x, n);

        /* If x doesn't exist in arr[] then return -1 */
        if (i == -1) {
            return i;
        }

        /* Else get the index of last occurrence of x. Note that we 
         are only looking in the subarray after first occurrence */
        j = last(arr, i, n - 1, x, n);

        /* return count */
        return j - i + 1;
    }

    /* if x is present in arr[] then returns the index of FIRST occurrence 
     of x in arr[0..n-1], otherwise returns -1 */
    int first(int arr[], int low, int high, int x, int n) {
        if (high >= low) {
            int mid = (low + high) / 2;  /*low + (high - low)/2;*/

            if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x) {
                return mid;
            } else if (x > arr[mid]) {
                return first(arr, (mid + 1), high, x, n);
            } else {
                return first(arr, low, (mid - 1), x, n);
            }
        }
        return -1;
    }

    /* if x is present in arr[] then returns the index of LAST occurrence 
     of x in arr[0..n-1], otherwise returns -1 */
    int last(int arr[], int low, int high, int x, int n) {
        if (high >= low) {
            int mid = (low + high) / 2;  /*low + (high - low)/2;*/

            if ((mid == n - 1 || x < arr[mid + 1]) && arr[mid] == x) {
                return mid;
            } else if (x < arr[mid]) {
                return last(arr, low, (mid - 1), x, n);
            } else {
                return last(arr, (mid + 1), high, x, n);
            }
        }
        return -1;
    }

    /* driver program to test above functions */
    public void start() {
        int arr[] = {1, 2, 2, 3, 3, 3, 3};
        int x = 3;  // Element to be counted in arr[]
        int n = arr.length;
        int c = count(arr, x, n);
        boolean searchFirst = true;
        int count = BSsearch(arr, x, n, !searchFirst) - BSsearch(arr, x, n, searchFirst) + 1;
        System.out.println(x + " occurs " + c + " times ");
        System.out.println(x + " occurs " + count + " times ");
    }

    int BSsearch(int arr[], int x, int n, boolean searchFirst) {
        int low = 0, high = n - 1, res = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                res = mid;
                if (searchFirst) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (x < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}
