/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 * @author rominparekh
 */
public class MaxProfit {
    public int getMaxProfit(int[] arr) {
        if(arr.length < 2) {
            return Integer.MIN_VALUE;
        } 
        int min_price = arr[0];
        int max_profit = arr[1] - arr[0];
        int curr_profit = 0;
        
        for(int i = 1; i < arr.length; i++) {
            curr_profit = arr[i] - min_price;
            max_profit = (max_profit < curr_profit) ? curr_profit : max_profit;
            min_price = (min_price < arr[i]) ? min_price : arr[i];
        }
        return max_profit;
    }
    public void start() {
        int[] arr = new int[] {10, 4, 5, 6, 2, 1};
        System.out.println("Max Profit: "+getMaxProfit(arr));
        arr = new int[] {5, 4, 3, 2, 1};
        System.out.println("Max Profit: "+getMaxProfit(arr));
    }
}
