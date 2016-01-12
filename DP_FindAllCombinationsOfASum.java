/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Arrays;

/**
 *
 * @author rominparekh
 */
public class DP_FindAllCombinationsOfASum {

    /**
     * Question. (a) Given a target sum, populate all subsets, whose sum is
     * equal to the target sum, from an int array.
     *
     * (b) Find subsets upto a given size that reach the target sum.
     *
     * @param target Target Sum
     * @param numArr Int array containing all numbers
     * @param sumStack Int array containing subset of numbers that add to target
     * @param startIdx Index position of numArr
     * @param stackIdx Index position of sumStack
     * @param isLength True if subsets need to be of fixed size
     * @param length Length of subset size
     */
    public void getSubsets(int target, int[] numArr, int[] sumStack, int startIdx, int stackIdx, boolean isLength, int length) {

        if (isLength && stackIdx == length && target == 0) {
            printArray(Arrays.copyOf(sumStack, stackIdx));
            return;
        } 
        if (!isLength && target == 0) {
            printArray(Arrays.copyOf(sumStack, stackIdx));
            return;
        }

        while (startIdx < numArr.length) {
            sumStack[stackIdx] = numArr[startIdx];
            getSubsets(target - numArr[startIdx], numArr, sumStack, startIdx + 1, stackIdx + 1, isLength, length);
            startIdx++;
        }
    }

    public void printArray(int[] sumStack) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i : sumStack) {
            sb.append(" ").append(i);
        }
        sb.append(" ]");
        System.out.println(sb.toString());
    }

    public void start() {
        int[] numArr = {-1, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15};
        int target = 15;
        // Get all subsets from numArr that add to 15
        getSubsets(target, numArr, new int[numArr.length + 1], 0, 0, false, -1);

        int length = 3;
        System.out.println("\nSubset size = " + length + "\n");

        // Get all subsets of size 3 from numArr that add to 15
        getSubsets(target, numArr, new int[numArr.length + 1], 0, 0, true, length);
    }
}
