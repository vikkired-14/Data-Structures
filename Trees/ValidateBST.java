package Trees;

public class ValidateBST {
    public static boolean isValidBST(TreeNode root){
        if(root == null)
            return true;
        return validateBST(root,null,null);
    }

    private static boolean validateBST(TreeNode root,Integer low,Integer high) {
        if(root==null)
            return true;
        if((low!=null && low >= root.val) || (high!= null&& high<= root.val))
            return false;
        return validateBST(root.left, low,root.val) && validateBST(root.right, root.val,high);
    }

    public static void main(String[] args){
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);
        System.out.println(isValidBST(node));
    }
}
