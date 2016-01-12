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
public class DP_Fibonacci {
    private static final ArrayList fib = new ArrayList<>();
    
    public int getFib(int n) {
        int f = 0;
        for(int i = 0; i<n; i++) {
            if(i < 2) f = 1;
            // For computing F(n) we need F(n-1) and F(n-2).
            // So this program is constant in space {O(1)} and linear in time {O(n)}
            else f = (int) fib.get(i-1) + (int) fib.get(i-2);
            //System.out.println("Adding i:"+i+" f:"+f);
            fib.add(i, f);
        }
        return f;
    }
    
    public void start() {
        int[] n = {2, 6, 15, 20, 35, 40};
        for(int i : n) 
            System.out.println(getFib(i));
    }
}
