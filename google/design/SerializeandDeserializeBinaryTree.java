package google.design;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.



Example 1:


Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
 */
public class SerializeandDeserializeBinaryTree {
 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public String serialize(TreeNode root) {
        String ans = serializeHelper(root,new StringBuilder());
        System.out.println(ans);
        return ans;
    }

    public String serializeHelper(TreeNode root, StringBuilder ans){
        if(root==null)
            ans.append("null,");
        else{
            ans.append(root.val+",");
            serializeHelper(root.left,ans);
            serializeHelper(root.right,ans);
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        return deserializeHelper(new LinkedList<String>(Arrays.asList(dataArray)));
    }

    public TreeNode deserializeHelper(List<String> dataList){
        if("null".equals(dataList.get(0))){
            dataList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = deserializeHelper(dataList);
        root.right = deserializeHelper(dataList);
        return root;
    }
}
