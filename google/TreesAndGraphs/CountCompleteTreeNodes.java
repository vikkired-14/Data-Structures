package google.TreesAndGraphs;

import Trees.TreeNode;
import java.util.*;

/*
Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.



Example 1:


Input: root = [1,2,3,4,5,6]
Output: 6
Example 2:

Input: root = []
Output: 0
Example 3:

Input: root = [1]
Output: 1


Constraints:

The number of nodes in the tree is in the range [0, 5 * 104].
0 <= Node.val <= 5 * 104
The tree is guaranteed to be complete.
 */
public class CountCompleteTreeNodes {
    public static int countNodes(TreeNode root) {

        if(root==null)
            return 0;
        int height = getHeight(root);
        int left =0,right =(int) Math.pow(2,height)-1;
        while(left<=right){
            int pivot = left + (right-left)/2;
             if(isExisting(root,pivot,height)){
                 left = pivot+1;
             }else {
                 right = pivot-1;
             }
        }
       return (int)Math.pow(2,height)-1 + left;
    }

    private static boolean isExisting(TreeNode root, int pivot, int height) {
        int left =0, right = (int)Math.pow(2,height)-1;
        for(int i=0;i<height;i++){
            int mid = left + (right-left)/2;
            if(pivot<=mid){
                root = root.left;
                right = mid;
            }else{
                root = root.right;
                left = mid+1;
            }
        }
        return root!=null;
    }

    private static int getHeight(TreeNode root) {
        int h=0;
        while(root.left!=null){
            h++;
            root = root.left;
        }
        return h;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(countNodes(root));//6
        System.out.println(countNodes2(root));//6
    }


    //Approch 2
    public static int countNodes2(TreeNode root) {
        if(root==null)
            return 0;
        TreeNode leftNode = root;
        TreeNode rightNode = root;
        int left =0;
        int right =0;
        while(leftNode!=null){
            left++;
            leftNode = leftNode.left;
        }

        while(rightNode!=null){
            right++;
            rightNode = rightNode.right;
        }
        if(left==right)
            return (int)Math.pow(2,left)-1;
        return 1+countNodes2(root.left) + countNodes2(root.right);
    }
}
