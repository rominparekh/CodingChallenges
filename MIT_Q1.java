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
public class MIT_Q1 {

    protected String getReverse(String x) {
        return new StringBuilder(x).reverse().toString();
    }
    
    protected String proc(String x) {
        if (x == null || x.length() < 1) {
            return "";
        }
        return getReverse(x);
    }
    
    protected String procFinal(String rev) {
        String[] str = rev.split(" ");
        String fin = "";
        for (String x : str) {
            fin += proc(x) + " ";
        }
        return fin.trim();
    }

    protected void start() {
        String s = "The quick brown fox jumps over the lazy dog";
        System.out.println("Input: " + s);
        String rev = getReverse(s);
        System.out.println("Output: " + rev);
        System.out.println("Final: " + procFinal(rev));
    }
}
