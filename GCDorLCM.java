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
public class GCDorLCM {

    long getGCD(long a, long b) {
        return (a % b == 0) ? b : getGCD(b, a % b);
    }

    long getLCM(long a, long b) {
        return a * (b / getGCD(a, b));
    }

    void start() {
        long numArr[] = {6, 4, 2, 8, 10};
        long GCDresult = numArr[0], LCMresult = numArr[0];
        for (int i = 1; i < numArr.length; i++) {
            GCDresult = getGCD(GCDresult, numArr[i]);
            LCMresult = getLCM(LCMresult, numArr[i]);
        }
        System.out.println("GCD :" + GCDresult);
        System.out.println("LCM :" + LCMresult);
    }
}
