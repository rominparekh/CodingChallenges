/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.HashMap;

/**
 * Time - O(mn) Space - O(mn)
 *
 * @author rominparekh
 */
public class LargestCommonSequence {

    private static int[][] C;
    private static HashMap<Integer, String> hC = new HashMap<>();

    public static void start() {
        int n = 5, m = 6;

        int[] X = new int[n + 1];
        int[] Y = new int[m + 1];

        System.out.print("X: ");
        for (int i = 1; i <= n; i++) {
            X[i] = (int) (n * Math.random());
            System.out.print(X[i] + " ");
        }
        System.out.print("\nY: ");
        for (int i = 1; i <= m; i++) {
            Y[i] = (int) (m * Math.random());
            System.out.print(Y[i] + " ");
        }
        System.out.println();
        C = new int[n + 1][m + 1];
        getLCS(X, Y, n, m);
    }

    public static void getLCS(int[] X, int[] Y, int n, int m) {
        hC.put(0, "");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    C[i][j] = 0;
                } else {
                    // If you want longest increasing sequence
                    //if (X[i] == Y[j] && ((X[i] > X[i - 1]) || (Y[i] > Y[i - 1]))) {
                    if (X[i] == Y[j]) {
                        C[i][j] = C[i - 1][j - 1] + 1;
                        hC.put(C[i][j], (hC.get(C[i - 1][j - 1]) + " " + X[i]));
                    } else {
                        if (C[i][j - 1] > C[i - 1][j]) {
                            C[i][j] = C[i][j - 1];
                            hC.put(C[i][j], hC.get(C[i][j - 1]));
                        } else {
                            C[i][j] = C[i - 1][j];
                            hC.put(C[i][j], hC.get(C[i - 1][j]));
                        }
                    }
                }
            }
        }
        /*
         for (int a : hC.keySet()) {
         System.out.println(a + "\t" + hC.get(a));
         }
         */
        System.out.println("Len: " + C[n][m] + "=\t" + hC.get(C[n][m]).trim());
    }
}
