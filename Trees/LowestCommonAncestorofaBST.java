package Trees;

public class LowestCommonAncestorofaBST {
    public static TreeNode getCommonAncestor(TreeNode root,TreeNode p, TreeNode q){
        int pVal = p.val;
        int qVal = q.val;
        TreeNode node = root;
        while(node!=null){
            int parentVal = node.val;
            if(parentVal > pVal && parentVal > qVal)
                node = node.left;
            else if(parentVal < pVal && parentVal < qVal)
                node = node.right;
            else
                return node;
        }
        return  null;
    }

    public static  void main(String[] args){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        TreeNode right = root.left;
        TreeNode node = getCommonAncestor(root,root,right);
        System.out.println(node.val);
    }
}
