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
public class BouncyNumbers {

    public void start() {
        int cases = 1;
        while ((cases--) > 0) {
            float n = 1;
            float m = 2;
            float fratio = n/m;
            long noOfBouncy = 0, noTotal = 0;
            float ratio = 0.0f;
            while (ratio <= fratio) {
                if (!isIncreasing(noTotal) && !isDecreasing(noTotal)) {
                    noOfBouncy++;
                }
                noTotal++;
                ratio = (noOfBouncy / noTotal);
            }
            System.out.println(noTotal);
        }
    }

    public boolean isIncreasing(float ii) {
        boolean isIncreasing = true;
        String iStr = String.valueOf(ii);
        iStr = iStr.substring(0, iStr.lastIndexOf("."));
        //System.out.println(iStr);
        if(iStr.length() < 3) {
            return isIncreasing;
        }
        int prev = Character.getNumericValue(iStr.charAt(0));
        int next;
        for (int i = 1; i < iStr.length(); i++) {
            next = Character.getNumericValue(iStr.charAt(i));
            if ((prev <= next) && isIncreasing) {
                // Okay increasing.
            } else {
                isIncreasing = false;
            }
            prev = next;
        }
        return isIncreasing;
    }

    public boolean isDecreasing(float ii) {
        boolean isDecreasing = true;
        String iStr = String.valueOf(ii);
        iStr = iStr.substring(0, iStr.lastIndexOf("."));
        if(iStr.length()<3) {
            return isDecreasing;
        }
        int prev = Character.getNumericValue(iStr.charAt(0));
        int next;
        for (int i = 1; i < iStr.length(); i++) {
            next = Character.getNumericValue(iStr.charAt(i));
            if ((next <= prev) && isDecreasing) {
                // Okay decreasing.
            } else {
                isDecreasing = false;
            }
            prev = next;
        }
        return isDecreasing;
    }
}
