package LargestSumBSTInBt;

// Brute force way

// We can make every node of the binary tree as the root node BST and check whether it is a BST or not. 

// The algorithm will be-

// We will start from the root of the binary tree and do the inorder traversal using recursion.
// For the current node ‘ROOT', we will do the following-
// If it is the root of a valid BST, we return its size.
// Else, we will find the largest BST in left and right subtrees.

// As for every node of the binary tree, we are checking whether it is a BST or not in O(N) time. So, the total time complexity will be O(N^2).
// As the maximum height of the binary tree can be ‘N’, the space complexity of the recursion stack will be O(N).


class TreeNode{
    int val;
    TreeNode left , right;
    TreeNode(int val){
        this.val = val;
    }
}

public class LargestBSTInBT {
    int maxsum =0;
    public static void main(String[] args) {
        
    }
    public int maxSumBSTBrute(TreeNode root){
        // base case
        if(root==null) return 0;
        // this is for checking wether our tree is bst or not
        if(isValidBST(root)){
            maxsum = Math.max(maxsum,sumTree(root));
        }
        // then check for it's left and right tree , are they bst or not
        maxSumBSTBrute(root.left);
        maxSumBSTBrute(root.right);
        // return maxsum from the bst if present
        return maxsum;
    }
    // helper function for validating the bst tree
    private boolean isValidBST(TreeNode root) {
        // we are considering the range from mini to max of particular node
        return isValidBSTUtil(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean isValidBSTUtil(TreeNode root, long minRange, long maxRange) {
        // base case
        if(root==null) return true;
        // edge case as left part of bst is always smaller than root and right is greater
        if(root.val <=minRange || root.val>=maxRange) return false;
        // else we recursively check for the left and right part of root separately.
        return isValidBSTUtil(root.left, minRange, root.val) && isValidBSTUtil(root.right, root.val, maxRange);

    }
    public int sumTree(TreeNode root){
        if(root==null) return 0;
        // for calculating the max sum of valid bst
        return root.val + sumTree(root.left)+sumTree(root.right);
    }
}
