/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 * Question:
 *
 * Design a data structure that supports insert, delete, search and getRandom in
 * constant time Design a data structure that supports following operations in
 * Θ(1) time.
 *
 * insert(x): Inserts an item x to the data structure if not already present.
 *
 * remove(x): Removes an item x from the data structure if present.
 *
 * search(x): Searches an item x in the data structure.
 *
 * getRandom(): Returns a random element from current set of elements
 *
 * @author rominparekh
 */
public class MyDataStructure {

    HashMap<Integer, Integer> hash;
    ArrayList<Integer> arr;

    public MyDataStructure() {
        hash = new HashMap<>();
        arr = new ArrayList<>();
    }

    public boolean add(int num) {
        if (hash.get(num) != null) {
            return false;
        } else {
            int sizeOfArr = arr.size();
            arr.add(num);
            hash.put(num, sizeOfArr);
            System.out.println("key: " + num + "\tval: " + sizeOfArr);
            return true;
        }
    }

    public boolean remove(int num) {
        Integer idx = hash.get(num);
        if (idx == null) {
            return false;
        }

        hash.remove(num);
        int sizeOfArr = arr.size();

        if (sizeOfArr > 1) {
            // Swap element with last element so that remove from
            // arr[] can be done in O(1) time
            int lastElement = arr.get(sizeOfArr - 1);
            System.out.println("Before-idx: " + arr.get(idx) + "\t(sizeOfArr-1): " + arr.get(sizeOfArr-1));
            Collections.swap(arr, idx, sizeOfArr - 1);
            // Update in Hash table the position value of lastElement
            hash.put(lastElement, sizeOfArr - 1);
            System.out.println("After -idx: " + arr.get(idx) + "\t(sizeOfArr-1): " + arr.get(sizeOfArr-1));
        }
        // Cannot swap
        arr.remove((sizeOfArr - 1));

        return true;
    }
    
    public int getRandom() {
        int sizeOfArr= arr.size();
        Random rd = new Random();
        int randInt = rd.nextInt(sizeOfArr);
        int randVal = arr.get(randInt);
        remove(randVal);
        return randVal;
    }

    void start() {
        boolean t;
        t = add(100);
        t = add(101);
        t = add(102);
        t = add(103);
        t = add(104);
        t = remove(101);
        System.out.println(getRandom());
    }

}
