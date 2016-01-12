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
public class OddManOut {

    int getOddManOut(int[] array) {
        int val = 0;
        for (int i = 0; i < array.length; i++) {
            val ^= array[i];
        }
        return val;
    }
    
    void start() {
        int arr[] = {1,8,6,1,8,7,6};
        System.out.println(getOddManOut(arr));
    }
}
