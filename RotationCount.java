/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 * https://www.youtube.com/watch?v=4qjprDkJrjY&list=PL2_aWCzGMAwLPEZrZIcNEq9ukGWPfLT4A&index=3
 *
 * @author rominparekh
 */
public class RotationCount {

    int getRC(int arr[]) {
        int n = arr.length;
        if (n > 0) {
            int low = 0, high = n - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                //Case2: Mid is the lowest point
                //Element before and after Mid are greater than or equal to Mid 
                int next = (mid + 1) % n;
                int prev = (mid + n - 1) % n;
                //Case1: No circularity
                if (arr[low] <= arr[high]) {
                    return low;
                } //Case2
                else if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
                    return mid;
                } //Case3: Split the array 
                else if (arr[mid] <= arr[high]) {
                    high = mid - 1;
                } //Case4
                else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    void start() {
        int arr[] = {8, 9, 10, 1, 2, 3, 4, 5, 6, 7};
        System.out.println("No of rotations :" + getRC(arr));
    }
}
