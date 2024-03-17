package google;

import Trees.TreeNode;

import java.util.*;

/*
https://leetcode.com/problems/find-leaves-of-binary-tree/description/
Given the root of a binary tree, collect a tree's nodes as if you were doing this:

Collect all the leaf nodes.
Remove all the leaf nodes.
Repeat until the tree is empty.


Example 1:


Input: root = [1,2,3,4,5]
Output: [[4,5,3],[2],[1]]
Explanation:
[[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers since per each level it does not matter the order on which elements are returned.
Example 2:

Input: root = [1]
Output: [[1]]


Constraints:

The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100
solution link : https://www.youtube.com/watch?v=1ChX4Cpz0bU

 */
public class FindLeavesOfBinaryTree {
    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> findLeaves(TreeNode root) {
        helper(root);
        return result;
    }
    public static int helper(TreeNode root){
        if(root==null)
            return -1;
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        int currHeight = Math.max(leftHeight,rightHeight)+1;
        if(currHeight== result.size())
            result.add(new ArrayList<>());
        result.get(currHeight).add(root.val);
        return currHeight;
    }

    public static void main(String[] args){
       TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        findLeaves(root);
        for(List<Integer>list : result){
            System.out.println(list.toString());//[[4,5,3],[2],[1]]
        }
    }

}
/*

         List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return  res;
        getHeight(root,res);
        return res;
    }

   public  int getHeight(TreeNode root, List<List<Integer>> res){
        if(root==null)
            return  -1;
        int leftHeight = getHeight(root.left,res);
        int rightHeight = getHeight(root.right,res);
        int currHeight = Math.max(leftHeight,rightHeight)+1;
        if(currHeight== res.size())
            res.add(new ArrayList<>());
            System.out.println(currHeight + ":"+ root.val);
        res.get(currHeight).add(root.val);
        return currHeight;
    }
 */