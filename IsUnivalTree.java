/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;

/*
 *  GraphNode implementation
 */
class GraphNode {

    int data;
    ArrayList<GraphNode> children = new ArrayList<>();

    GraphNode(int data, ArrayList<GraphNode> children) {
        this.data = data;
        this.children = children;
    }
}

/**
 * A unival tree is a tree that has the same value in all nodes. Do not assume
 * that the tree is Binary.
 *
 * Part 1 - Check if the tree is unival
 *
 * Part 2 - Count the total number of sub-trees that are unival
 */
public class IsUnivalTree {

    /**
     * Part 1 Checks if tree is Unival
     *
     * @param root Root node
     * @return TRUE if tree is Unival
     */
    public Boolean isUnival(GraphNode root) {
        boolean isUV = true;
        if (root == null) {
            return isUV;
        }
        int data = root.data;
        if (root.children != null) {
            for (GraphNode child : root.children) {
                if (data == child.data) {
                    isUV &= isUnival(child);
                } else {
                    isUV = false;
                }
            }
        }
        return isUV;
    }

    public int countUnivalChildren(GraphNode root, int countUV) {
        if (root == null) {
            return countUV;
        }
        int data = root.data;
        if (root.children != null) {
            for (GraphNode child : root.children) {
                if (data == child.data) {
                    countUV++;
                }
                countUV = countUnivalChildren(child, countUV);
            }
        }
        return countUV;
    }

    public int countChildren(GraphNode root, int countChild) {
        if (root == null) {
            return countChild;
        }
        countChild++;
        if (root.children != null) {
            for (GraphNode child : root.children) {
                countChild = countChildren(child, countChild);
            }
        }
        return countChild;
    }

    /*
    
     */
    public void start() {

        // Children nodes
        GraphNode child1 = new GraphNode(1, null);
        GraphNode child2 = new GraphNode(1, null);
        GraphNode child4 = new GraphNode(1, null);
        GraphNode child5 = new GraphNode(1, null);

        ArrayList<GraphNode> childList1 = new ArrayList<>();
        childList1.add(child4);
        childList1.add(child5);

        // Child3 is parent to Child 4 and 5.
        GraphNode child3 = new GraphNode(1, childList1);

        ArrayList<GraphNode> childList2 = new ArrayList<>();
        childList2.add(child1);
        childList2.add(child2);
        childList2.add(child3);

        // Root is parent to Child 1, 2 and 3.
        GraphNode root = new GraphNode(1, childList2);

        // Diagrammatic Representation of the Tree
        /*
         *            R
         *        1   2   3
         *              4   5
         */
        System.out.println("Is Tree Unival : " + isUnival(root).toString().toUpperCase());
        System.out.println("Count Unival Children : " + countUnivalChildren(root, 0));
        System.out.println("Count Total Children  : " + countChildren(root, 0));
    }
}
