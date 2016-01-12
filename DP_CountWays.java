/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.HashMap;

/**
 *
 * @author rominparekh
 */
public class DP_CountWays {

    private static int counter = 0;
    // Time - O(3^N)
    // Each call makes three different calls
    public int countWays(int noOfSteps) {
        if (noOfSteps < 0) {
            return 0;
        } else if (noOfSteps == 0) {
            return 1;
        } else {
            return countWays(noOfSteps - 1) + countWays(noOfSteps - 2) + countWays(noOfSteps - 3);
        }
    }

    // Memoization needs to be done 
    public int countWaysDP(int noOfSteps, HashMap<Integer,Integer> map) {
        if (noOfSteps < 0) {
            return 0;
        } else if (noOfSteps == 0) {
            return 1;
        } else if (map.containsKey(noOfSteps)) {
            return map.get(noOfSteps);
        } else {
            map.put(noOfSteps, countWaysDP(noOfSteps - 1, map)
                    + countWaysDP(noOfSteps - 2, map)
                    + countWaysDP(noOfSteps - 3, map));
            return map.get(noOfSteps);
        }
    }

    public void start() {
        int noOfSteps = 3;
        HashMap<Integer,Integer> map = new HashMap<>();
        System.out.println("Number of Ways: " + countWays(noOfSteps));
        System.out.println("Number of Ways: " + countWaysDP(noOfSteps, map));
    }
}
