package BstFromPreorder;

class TreeNode{
    int val;
    TreeNode left , right;
    TreeNode(int val){
        this.val = val;
    }
}
// JAVA ITERATIVE APPROACH -

public class IterativeApproach {
    public static void main(String[] args) {
        
    }
    public TreeNode bstfrompreorder(int[]preorder){
        if(preorder == null) return null;
        int size = preorder.length;
        if(size==0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=1;i<size;i++){
            generateBST(preorder[i],root);
        }
        return root;
    }
    private void generateBST(int target, TreeNode tree) {
        TreeNode root = tree;
        TreeNode node = new TreeNode(target);
        while(root != null){
            if(target <root.val){
                if(root.left == null){
                    root.left = node;
                    break;
                }else{
                    root = root.left;
                }
            }else{
                if(root.right == null){
                    root.right = node;
                    break;
                }else{
                    root= root.right;
                }
            }
        }
    }
}
