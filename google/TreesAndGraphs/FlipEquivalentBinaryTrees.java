package google.TreesAndGraphs;
/*
For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.

A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.

Given the roots of two binary trees root1 and root2, return true if the two trees are flip equivalent or false otherwise.



Example 1:

Flipped Trees Diagram
Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
Output: true
Explanation: We flipped at nodes with values 1, 3, and 5.
Example 2:

Input: root1 = [], root2 = []
Output: true
Example 3:

Input: root1 = [], root2 = [1]
Output: false


Constraints:

The number of nodes in each tree is in the range [0, 100].
Each tree will have unique node values in the range [0, 99].
 */

import Trees.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class FlipEquivalentBinaryTrees {
    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==root2)
            return true;
        if(root1==null || root2==null || root1.val!=root2.val)
            return false;
        return (flipEquiv(root1.left,root2.left)&& flipEquiv(root1.right,root2.right))||
                (flipEquiv(root1.left,root2.right)&& flipEquiv(root1.right,root2.left));
    }

    public static void main(String[] args) {
        TreeNode root1 = buildTree1();
        TreeNode root2 = buildTree2();

        boolean result1 = flipEquiv(root1, root2);
        System.out.println("Output 1: " + result1); // Output: true

        TreeNode root3 = null;
        TreeNode root4 = null;

        boolean result2 = flipEquiv(root3, root4);
        System.out.println("Output 2: " + result2); // Output: true

        TreeNode root5 = null;
        TreeNode root6 = new TreeNode(1);

        boolean result3 = flipEquiv(root5, root6);
        System.out.println("Output 3: " + result3); // Output: false
    }
    public static TreeNode buildTree1() {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(8);
        root1.right.left = new TreeNode(6);

        return root1;
    }

    public static TreeNode buildTree2() {
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(4);
        root2.left.right.left = new TreeNode(8);
        root2.left.right.right = new TreeNode(7);
        root2.right.left = new TreeNode(5);

        return root2;
    }
    }
