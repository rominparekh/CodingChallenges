/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author rominparekh
 */
public class DP_FindAllSubsets {

    private static HashMap<Integer, ArrayList<String>> subsets = new HashMap<>();

    public void getSubsets(int[] arr) {
        ArrayList<String> subs;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                subs = new ArrayList<>();
                subs.add("{}");
            } else {
                subs = subsets.get(i - 1);
                ArrayList<String> newSubs = new ArrayList<>();
                for (String sub : subs) {
                    newSubs.add(sub);
                    newSubs.add(makeSub(sub, arr[i]));
                }
                subs = newSubs;
            }
            subsets.put(i, subs);
        }
    }

    public String makeSub(String i, int j) {
        String newI = i.replace("{", "").replace("}", "").trim();
        String res = new String().concat("{");
        res += newI.isEmpty() ? "" : newI + ",";
        return res.concat(j + "}");
    }

    public void start() {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        getSubsets(arr);
        printSubsets();
    }

    public void printSubsets() {
        for (int i : subsets.keySet()) {
            ArrayList<String> subs = subsets.get(i);
            for (String sub : subs) {
                System.out.print(sub + ",");
            }
            System.out.println();
        }
    }
}
