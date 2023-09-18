package google.TreesAndGraphs;

/*
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.



Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.


Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000
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
public class BinaryTreeMaximumPathSum {

    static int maxValue =Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        helper(root);
        return maxValue;
    }

    private static int helper(TreeNode root) {
        if(root==null)
            return 0;
        int left = Math.max(helper(root.left),0);
        int right = Math.max(helper(root.right),0);
        maxValue = Math.max(maxValue,left+right+ root.val);
        return Math.max(root.val+left, root.val+right);
    }

    public static void main(String[] args) {
        // Create the binary tree
//        Input: root = [1,2,3]
//        Output: 6
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Calculate and print the maximum path sum
        int maxSum = maxPathSum(root);
        System.out.println("Maximum Path Sum: " + maxSum);
    }
}
