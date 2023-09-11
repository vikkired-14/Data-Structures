package Trees;

public class BinaryTreeMaximumPathSum {
    static int maxSum = Integer.MIN_VALUE;
    public static int getMaxPathSum(TreeNode root){
        if(root==null)
             return 0;
        getMaxSum(root);
        return  maxSum;
    }

    private static int getMaxSum(TreeNode root) {
        if(root==null)
             return 0;
        int leftMax = Math.max(getMaxSum(root.left),0);
        int rightMax = Math.max(getMaxSum(root.right),0);
        maxSum = Math.max(maxSum,leftMax+rightMax+ root.val);

        return Math.max(leftMax+ root.val,rightMax+ root.val);
    }

    public static void main(String[] args){
//        Input: root = [-10,9,20,null,null,15,7]
//        Output: 42
//        Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(getMaxPathSum(root));
    }
}
