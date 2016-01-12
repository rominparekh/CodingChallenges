/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.PriorityQueue;

/**
 *
 * @author rominparekh
 */
public class CreateBST {

    private static int counter = 0;
    private static TreeNode root;

    public void add(int... items) {
        for (int item : items) {
            add(item);
        }
    }

    public void add(TreeNode rootNode, int item) {
        if (item < rootNode.item) {
            if (rootNode.left == null) {
                rootNode.left = new TreeNode(null, item, null);
            } else {
                add(rootNode.left, item);
            }
        } else if (item > rootNode.item) {
            if (rootNode.right == null) {
                rootNode.right = new TreeNode(null, item, null);
            } else {
                add(rootNode.right, item);
            }
        }
    }

    public void add(int item) {
        if (root == null) {
            root = new TreeNode(null, item, null);
        } else {
            add(root, item);
        }
    }

    public int countNodesBST(TreeNode r) {
        int count = 0;
        if (r != null) {
            count = 1 + countNodesBST(r.left) + countNodesBST(r.right);
        }
        return count;
    }

    public String printTreeInOrder(TreeNode r) {
        if (r == null) {
            return "";
        }
        return printTreeInOrder(r.left) + r.item + "," + printTreeInOrder(r.right);
    }

    public String printTreePreOrder(TreeNode r) {
        if (r == null) {
            return "";
        }
        return r.item + "," + printTreeInOrder(r.left) + printTreeInOrder(r.right);
    }

    public String printTreePostOrder(TreeNode r) {
        if (r == null) {
            return "";
        }
        return printTreeInOrder(r.left) + printTreeInOrder(r.right) + r.item + ",";
    }

    //Gets Least Common Ancestor of nodes a and b
    public TreeNode getLCA(TreeNode r, TreeNode a, TreeNode b) {
        if (a.item == r.item || b.item == r.item) {
            return r;
        }

        if (a.item > r.item && b.item > r.item) {
            return getLCA(r.right, a, b);
        }
        if (a.item < r.item && b.item < r.item) {
            return getLCA(r.left, a, b);
        }
        return r;
    }

    public int getHopCount(TreeNode a, TreeNode b) {
        TreeNode r = root;
        if (r == null || a == null || b == null) {
            return -1;
        }
        int maxCount = countNodesBST(r);

        TreeNode LCA = getLCA(r, a, b);
        TreeNode tempLCA = LCA;
        //System.out.println("LCA.item:" + tempLCA.item);
        int hopA = 0, hopB = 0;
        while (tempLCA != null && tempLCA.item != a.item && hopA <= maxCount) {
            //System.out.println("tempLCA-A.item:" + tempLCA.item);
            if (tempLCA.item < a.item) {
                tempLCA = tempLCA.left;
            } else {
                tempLCA = tempLCA.right;
            }
            hopA++;
        }
        tempLCA = LCA;
        while (tempLCA != null && tempLCA.item != b.item && hopB <= maxCount) {
            //System.out.println("tempLCA-B.item:" + tempLCA.item);
            if (tempLCA.item < b.item) {
                tempLCA = tempLCA.left;
            } else {
                tempLCA = tempLCA.right;
            }
            hopB++;
        }
        return hopA + hopB - 1;
    }

    public void printBSTinDFS() {
        PriorityQueue<TreeNode> nodesQ = new PriorityQueue<>();
        TreeNode r = root;
        int nodesCurrLevel = 0, nodesNextLevel = 0;
        nodesQ.add(r);
        nodesCurrLevel++;
        while (nodesQ.size() > 0) {
            System.out.println("nodesQ size:" + nodesQ.size());
            TreeNode currNode = nodesQ.poll();
            nodesCurrLevel--;
            if (currNode != null) {
                System.out.print(currNode.item + " ");
                nodesQ.add(currNode.left);
                nodesQ.add(currNode.right);
                nodesNextLevel += 2;
            }
            System.out.println();
            if (nodesCurrLevel == 0) {
                nodesCurrLevel = nodesNextLevel;
                nodesNextLevel = 0;
            }
        }
    }

    public TreeNode findKthLargestItem(TreeNode rootNode, int k) {
        if (rootNode == null) {
            return null;
        }
        //System.out.println("~~~ " + rootNode.item);
        //Instead of Left to Right, we will traverse in Right to Left fashion because largest element 
        //are present of Right side of Root Node.
        TreeNode node = findKthLargestItem(rootNode.right, k);
        //System.out.println("+++ " +node.item);
        //If counter is not equal to K, then only increment the counter. 
        //Once counter is equal to K, it means we have found the desired largest element and no need to increment further, 
        //Take the back up of the current node as it might be the Kth largest element we are looking for.  
        if (counter != k) {
            counter++;
            node = rootNode;
            //System.out.println("+++ " + node.item);
        }

        //This is the place where actual check is going to happen between counter and K, 
        //If counter matched K, it means we found the node and no need to find further so simply return the found node.
        if (counter == k) {
            return node;
        } else {
            return findKthLargestItem(rootNode.left, k);
        }
    }

    public void start() {
        int[] arr = {4, 2, 6, 1, 3, 5, 7};
        this.add(arr);
        int N = countNodesBST(root);
        System.out.println("Number of Nodes in BST: " + N);
        System.out.println("In-order Traversal : " + printTreeInOrder(root));
        System.out.println("Pre-order Traversal : " + printTreePreOrder(root));
        System.out.println("Post-order Traversal : " + printTreePostOrder(root));
        TreeNode xx = findKthLargestItem(root, 4);
        System.out.println("K Largest:" + xx.item);
        //TreeNode a = new TreeNode(null, 4, null);
        //TreeNode b = new TreeNode(null, 2, null);
        //System.out.println("Hop Count from " + a.item + " to " + b.item + "" + ": " + getHopCount(a, b));
        //printBSTinDFS();
        System.out.println(toString(root));

    }

    public String toString(TreeNode r) {
        if (r != null) {
            return "[" + toString(r.left) + "," + r.item + "," + toString(r.right) + "]";
        }
        return "null";
    }
}

class TreeNode {

    TreeNode left;
    int item;
    TreeNode right;

    TreeNode(TreeNode left, int item, TreeNode right) {
        this.left = left;
        this.right = right;
        this.item = item;
    }
}
