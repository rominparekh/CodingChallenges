/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    public static class TrieNode {

        char c;
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isLeaf;

        public TrieNode() {
        }

        public TrieNode(char c) {
            this.c = c;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }
            children = t.children;
            if (i == word.length() - 1) {
                t.isLeaf = true;
            }
        }
    }

    public boolean search(String word) {
        TrieNode t = searchNode(word);
        if (t != null && t.isLeaf) {
            return true;
        } else {
            return false;
        }
    }

    public boolean startsWith(String prefix) {
        if (searchNode(prefix) == null) {
            return false;
        } else {
            return true;
        }
    }

    private TrieNode searchNode(String str) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }

        return t;
    }

    void start() {
        Trie t = new Trie();
        t.insert("get");
        t.insert("hi");
        t.insert("hello");
        t.insert("computer");
        t.insert("communication");
        t.insert("communist");
        System.out.println(t.startsWith("com"));
    }

}
