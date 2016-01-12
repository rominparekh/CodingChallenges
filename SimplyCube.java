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
public class SimplyCube {

    boolean isInteger(double x) {
        return Math.ceil(x) == (int) x;
    }

    void getIntegerPairs(int m, int n) {
        if (m > 0 && n > 0) {
            int numOfPairs = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    double x = Math.pow(i, 1.0 / 3.0);
                    double y = Math.pow(j, 1.0 / 3.0);
                    if (isInteger(x) && isInteger(y))  {
                        numOfPairs++;
                    }
                }
            }
            System.out.println(numOfPairs);
        }
    }

    void start() {
        getIntegerPairs(1, 1);
        getIntegerPairs(1, 8);
    }

}
