/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Arrays;

/**
 * http://stackoverflow.com/questions/5958169/how-to-merge-two-sorted-arrays-into-a-sorted-array
 * Complexity - O(n)
 *
 * @author rominparekh
 */
public class MergeSort {

    int[] merge(int arr[], int brr[]) {
        if (arr.length < 1) {
            return brr;
        }
        if (brr.length < 1) {
            return arr;
        }
        int answer[] = new int[arr.length + brr.length];
        int i = 0, j = 0, k = 0;
        while (i < arr.length && j < brr.length) {
            if (arr[i] <= brr[j]) {
                answer[k] = arr[i];
                i++;
                k++;
            } else {
                answer[k] = brr[j];
                j++;
                k++;
            }

            //Using ternary operators
            //To further compact the code 
            //answer[k++] = arr[i] <= brr[j] ? arr[i++] : brr[j++];
        }
        while (i < arr.length) {
            answer[k] = arr[i];
            i++;
            k++;
        }
        while (j < brr.length) {
            answer[k] = brr[j];
            j++;
            k++;
        }
        return answer;

    }

    // This entire method can be further optimized using ternary operations
    int[] merge2(int[] a, int[] b) {
        int[] answer = new int[a.length + b.length];
        int i = a.length - 1, j = b.length - 1, k = answer.length;
        while (k > 0) {
            answer[--k] = (j < 0 || (i >= 0 && a[i] >= b[j])) ? a[i--] : b[j--];
        }
        return answer;
    }

    public void start() {
        //int arr[] = {1, 3, 5, 7, 9};
        //int brr[] = {0, 2, 4, 6, 8};
        int axx[] = new GenRandomArray(0).generateSorted(90000, 0, 900000);
        int bxx[] = new GenRandomArray(0).generateSorted(90000, 0, 900000);
        long start = System.nanoTime();
        int answer[] = merge(axx, bxx);
        long stop = System.nanoTime();
        System.out.println("Merge1 method :" + (stop - start) / 1000 + " ms");
        //System.out.println(Arrays.toString(answer));
        start = System.nanoTime();
        answer = merge2(axx, bxx);
        stop = System.nanoTime();
        System.out.println("Merge2 method :" + (stop - start) / 1000 + " ms");
        //System.out.println(Arrays.toString(answer));
    }
}
