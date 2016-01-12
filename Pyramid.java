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
public class Pyramid {

    void makePyramid(char ch, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    void start() {
        makePyramid('#', 5);
        makePyramid('$', 5);
    }
}
