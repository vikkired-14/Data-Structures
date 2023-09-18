package google.TreesAndGraphs;

import Trees.TreeNode;

/*
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.



Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1


Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
 */
public class DiameterOfBinaryTree {
    static int max =0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return max;
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if(root==null)
            return 0;
        int leftMax = helper(root.left);
        int rightMax = helper(root.right);
        max = Math.max(max,leftMax+rightMax);
        return Math.max(leftMax,rightMax)+1;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();

        // Create a binary tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        int diameter1 = solution.diameterOfBinaryTree(root1);
        System.out.println("Diameter of Binary Tree 1: " + diameter1); // Output: 3

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        max =0;
        int diameter2 = solution.diameterOfBinaryTree(root2);
        System.out.println("Diameter of Binary Tree 2: " + diameter2); // Output: 1
    }
}

