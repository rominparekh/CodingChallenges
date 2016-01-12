/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rominparekh
 */
public class GetPrimes {

    public static List<Integer> generatePrimes(int upperLimit) {

        if (upperLimit < 0) {
            throw new IllegalArgumentException("Negative size");
        }

        // at first all are numbers (0<=i<=n) not composite
        boolean[] isComposite = new boolean[upperLimit + 1];
        for (int i = 2; i * i <= upperLimit; i++) {
            if (!isComposite[i]) {
                for (int j = 2 * i; j <= upperLimit; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        List<Integer> primeList = new ArrayList<>();

        // make a list of all non-composite numbers(prime numbers)
        int arrLength = isComposite.length;
        for (int index = 2; index < arrLength; index++) {
            if (!isComposite[index]) {
                primeList.add(index);
            }
        }
        return primeList;
    }

    void printList(List<Integer> arr) {
        System.out.println("Printing");
        for (int i : arr) {
            System.out.println(i);
        }
    }

    void start() {
        List<Integer> arr = generatePrimes(10);
        printList(arr);
        arr = generatePrimes(100);
        printList(arr);
    }
}
