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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GenRandomArray {

    private final Random rand;

    public GenRandomArray() {
        rand = new Random();
    }

    public GenRandomArray(int seed) {
        rand = new Random(seed);
    }

    public int[] generateSorted(final int length, final int minVal, final int maxVal) {
        List<Integer> data = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            int rndNum = getRandomVal(minVal, maxVal);
            int insertionPoint = Collections.binarySearch(data, rndNum);
            data.add(insertionPoint > -1 ? insertionPoint : -insertionPoint - 1, rndNum);
        }

        return data.stream().mapToInt(i -> i).toArray();
    }

    private int getRandomVal(int min, int max) {
        return min + rand.nextInt(max - min + 1);
    }
}
