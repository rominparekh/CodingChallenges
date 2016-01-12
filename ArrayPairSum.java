/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This method obtains all pairs from an Array that add to a sum N
 *
 * @author rominparekh
 */
public class ArrayPairSum {

    void printSumPairs(int[] input, int k) {
        if (false) {
            Map<Integer, Integer> pairs = new HashMap();
            for (int i = 0; i < input.length; i++) {
                if (pairs.containsKey(input[i])) {
                    System.out.println(input[i] + ", " + pairs.get(input[i]));
                } else {
                    pairs.put(k - input[i], input[i]);
                }
            }
        } 
        // Method 2
        
        else {
            Set<Integer> pairs = new HashSet<>();
            for (int i : input) {
                if (pairs.contains(k - i)) {
                    System.out.println("" + (k - i) + ", " + i);
                } else {
                    pairs.add(i);
                }
            }
        }
    }

    void start() {
        int arr[] = {2, 5, 7, 3, 5, 1, 8, 9, 1};
        printSumPairs(arr, 10);
    }
}
