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
public class AlternatingCharacters {

    void getCharCount(String line) {
        int lineLen = line.length();
        char prev = line.charAt(0);
        int count = 0;
        for (int i = 1; i < lineLen; i++) {
            char curr = line.charAt(i);
            if (prev == curr) {
                count++;
            }
            prev = curr;
        }
        System.out.println(count);
    }

    void start() {
        String[] arr = {"AAAA", "BBBBB", "ABABABAB", "BABABA", "AAABBB", "ABBABAB"};
        for (String s : arr) {
            getCharCount(s);
        }        
    }
}
