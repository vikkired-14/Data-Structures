package google;

import Trees.TreeNode;

import java.util.*;

/*
You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n. You are also given an integer startValue representing the value of the start node s, and a different integer destValue representing the value of the destination node t.

Find the shortest path starting from node s and ending at node t. Generate step-by-step directions of such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'. Each letter indicates a specific direction:

'L' means to go from a node to its left child node.
'R' means to go from a node to its right child node.
'U' means to go from a node to its parent node.
Return the step-by-step directions of the shortest path from node s to node t.



Example 1:


Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
Output: "UURL"
Explanation: The shortest path is: 3 → 1 → 5 → 2 → 6.
Example 2:


Input: root = [2,1], startValue = 2, destValue = 1
Output: "L"
Explanation: The shortest path is: 2 → 1.


Constraints:

The number of nodes in the tree is n.
2 <= n <= 105
1 <= Node.val <= n
All the values in the tree are unique.
1 <= startValue, destValue <= n
startValue != destValue
 */
public class StepByStepDirectionsFromABinaryTreeNodetoAnother {
    static List<String> pathList = new ArrayList<>();
    public static String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder sb = new StringBuilder();
        if(root==null)
            return null;
        TreeNode lca = findLca(root,startValue,destValue);
        findPathToLca(lca,startValue,new StringBuilder());
        findPathToLca(lca,destValue,new StringBuilder());
        for(int i=0;i<pathList.get(0).length();i++){
            sb.append("U");
        }
        sb.append(pathList.get(1));
        return sb.toString();

    }

    private static void findPathToLca(TreeNode lca, int value, StringBuilder sb) {
        if(lca == null)
            return;
        if(lca.val== value){
            pathList.add(sb.toString());
            return;
        }
        if(lca.left!=null)
            findPathToLca(lca.left,value,sb.append("L"));
        if(lca.right!=null)
            findPathToLca(lca.right,value,sb.append("R"));
        sb.deleteCharAt(sb.length()-1);
        return;
    }

    private static TreeNode findLca(TreeNode root, int startValue, int destValue) {
        if(root==null)
            return root;
        if(root.val== startValue || root.val== destValue)
            return  root;
        TreeNode left = findLca(root.left,startValue,destValue);
        TreeNode right = findLca(root.right,startValue,destValue);
        if(left!=null && right!=null)
            return root;
        return left!=null ? left: right;
    }

    public static void main(String[] args){
//        Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
//        Output: "UURL"

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);
        System.out.println(getDirections(root,3,6));

    }
}
