/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Arrays;

/**
 * Take a 2D array as input and print it in a Spiral form
 *
 * @author rominparekh
 */
public class SpiralArray {

    int[] getSpiralArray(int[][] arr) {
        int rows = arr.length, cols = 0;
        if (rows > 0) {
            cols = arr[0].length;
        }
        if (rows > 0 && cols > 0) {
            //System.out.println("r:" + rows + " c:" + cols);
            int res[] = new int[rows * cols];
            int t = 0, b = rows - 1, l = 0, r = cols - 1, dir = 0, k = 0;
            while (t <= b && l <= r) {
                if (dir == 0) {
                    // Move L to R
                    for (int i = l; i <= r; i++) {
                        //System.out.println(arr[t][i]);
                        res[k] = arr[t][i];
                        k++;
                    }
                    t++;
                } else if (dir == 1) {
                    // Move T to B
                    for (int i = t; i <= b; i++) {
                        //System.out.println(arr[i][r]);
                        res[k] = arr[i][r];
                        k++;
                    }
                    r--;
                } else if (dir == 2) {
                    // Move R to L
                    for (int i = r; i >= l; i--) {
                        //System.out.println(arr[b][i]);
                        res[k] = arr[b][i];
                        k++;
                    }
                    b--;
                } else if (dir == 3) {
                    // Move B to T
                    for (int i = b; i >= t; i--) {
                        //System.out.println(arr[i][l]);
                        res[k] = arr[i][l];
                        k++;
                    }
                    l++;
                }
                dir = (dir + 1) % 4;
            }
            return res;
        }
        return null;
    }

    void start() {
        int arr[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.toString(getSpiralArray(arr)));
    }
}
