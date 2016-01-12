/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;

/**
 *
 * @author rominparekh
 */
public class GetMissingNum {

    void getMissingNumbers(ArrayList<Integer> arr, int N, int k) {
        //arr - ArrayList of N - k integers
        //N - upper limit of numbers - 1 to N
        //k - No. of missing numbers
        //First increase the length of the ArrayList to fit length N.
        //for (int i = N - k; i < N; i++) {
        //    arr.add(N);
        //}

        for (int i = 0; i < N - k; i++) {
            if (arr.get(arr.get(i) - 1) != arr.get(i)) {
                int t = arr.get(arr.get(i) - 1);
                arr.set(arr.get(arr.get(i) - 1), arr.get(i));
                arr.set(i, t);
            }
        }

        for (int i = 0; i < N; i++) {
            if (arr.get(i) - 1 != i) {
                System.out.println(i + 1);
            }
        }
    }
    
    void getMissingNumbersArr(int arr[], int N, int k) {
        for(int i=0; i< N-k; i++) {
            if(arr[arr[i]-1] != arr[i]) {
                //Swap numbers
                int t = arr[arr[i]-1];
                arr[arr[arr[i]-1]] = arr[i];
                arr[i] = t;
            }
        }
        
        for(int i = 0; i < N; i++) {
            if((arr[i]-1) != i) {
                System.out.println(i+1);
            }
        }
    }

    void start() {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(1);
        arr.add(1);
        arr.add(6);
        //arr.add(7);
        //arr.add(8);
        //arr.add(9);
        int arr1[] = {1,2,3,1,1,6};
        getMissingNumbers(arr, 6, 2);
        System.out.println("With Array\n");
        getMissingNumbersArr(arr1, 6, 2);
    }
}
