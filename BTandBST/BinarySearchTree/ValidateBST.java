class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

// Basically what I am doing is recursively iterating over the tree while
// defining interval <minVal, maxVal> for each node which value must fit in.
// Tc is O(n) and Sc is O(1). Explanation is in the copy
public class ValidateBST {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null)
            return true;
        if (root.val >= maxValue || root.val <= minValue)
            return false;
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }

}
