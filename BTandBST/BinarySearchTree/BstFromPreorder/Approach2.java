package BstFromPreorder;

// JAVA-LOWER AND UPPER BOUND RECURSIVE

class TreeNode{
    int val;
    TreeNode left , right;
    TreeNode(int val){
        this.val = val;
    }
}
// Tc is O(n) and Sc is O(n)

public class Approach2 {
    int nodeIndex;
    public static void main(String[] args) {
        
    }
    public TreeNode bstFromPreorder(int[]preorder){
        if(preorder == null){
            return null;
        }
        // index value for iteration 
        nodeIndex =0;
        return bsthelper(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private TreeNode bsthelper(int[] preorder, int start, int end) {
        // intially start is Mini value of integer and end is max value of integer.
        if(nodeIndex == preorder.length || preorder[nodeIndex]<start || preorder[nodeIndex]>end ){
            return null;
        }
        // through val we will get the root  
        int val = preorder[nodeIndex++];
        TreeNode node = new TreeNode(val);
        // get the left part of root , as my left part will lie from int.mini to upper node value
        node.left = bsthelper(preorder, start, val);
        // get the right part of the root , as my right part will lie from upper node value to int.max
        node.right = bsthelper(preorder, val, end);
        return node;

        
    }
}
