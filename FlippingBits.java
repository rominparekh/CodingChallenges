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
public class FlippingBits {

    void getFlippingBits(long x) {
        String ans = "";
        String s = Long.toBinaryString(x);
        //System.out.println("Binary string: " + s);
        for (int i = 0, j = s.length() - 1; i < 32; i++) {
            ans += (j >= 0 && s.charAt(j) == '1') ? "0" : "1";
            j--;
        }
        //System.out.println("Ans string: " + ans);
        String anss = new StringBuilder(ans).reverse().toString();
        //System.out.println("Anss string: " + anss);
        String bin = anss;
        long number = 0;
        int dig;
        for (int i = 0; i < bin.length(); i++) {
            dig = bin.charAt(i) - '0';
            number = 2 * number + dig;
        }
        System.out.println(Long.toString(number));
    }

    void getFlippingBits2(long num) {
        //System.out.println("num:" + num);
        //System.out.println("~num:" + ~num);
        System.out.println("mask: " + (long) 0xffffffffL);
        long flipped = ~num & 0xffffffffL;
        System.out.println("flipped: "+flipped);
    }

    void start() {
        getFlippingBits(2147483647);
        getFlippingBits2(2147483647);
        //getFlippingBits(0);
        //getFlippingBits2(0);
        //getFlippingBits(1);
        //getFlippingBits2(1);
    }

}
