package LargestSumBSTInBt;

// APPROACH
// First we check if it's a valid BST. IF it is a valid BST , we take the max sum till now
//  max = Math.max(max,root.val + left.maxsum + right.maxsum); and move in upward direction
//  to look for another valid BST with greater sum .

// BST VALIDATION
// Node value must be greater than the largest value of left tree and must be smaller than
//  the smallest value of right tree

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
    }
}

// We create a class named as NodeValue which consists of 3 things :
class NodeValue {
    // maxValue , minValue for checking Validation of BST and maxsum of that valid
    // BST.
    public int maxValue, minValue, maxsum;

    NodeValue(int max, int min, int maxsum) {
        this.maxValue = max;
        this.minValue = min;
        this.maxsum = maxsum;
    }
}

public class OptimalApproach {
    int max = 0;

    public static void main(String[] args) {

    }

    public int maxSumBST(TreeNode root) {
        maxSumBSTHelper(root);
        return max;
    }

    private NodeValue maxSumBSTHelper(TreeNode root) {
        // an empty tree or bst of size 0;
        if (root == null) {
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        // get values from left and right subtree
        NodeValue left = maxSumBSTHelper(root.left);
        NodeValue right = maxSumBSTHelper(root.right);

        // check if it's valid bst
        // We just start doing post order traversal and if it's a valid BST we calculate
        // our maximum till now and compute maxValue on the left , minValue on the right
        // and total sum root.val + leftmaxsum + rightmaxsum

        if (left.maxValue < root.data && root.data < right.minValue) {
            // it is bst , calculate maxsum tillnow
            max = Math.max(max, root.data + left.maxsum + right.maxsum);
            return new NodeValue(Math.max(root.data, right.maxValue), Math.min(root.data, left.minValue),
                    root.data + left.maxsum + right.maxsum);

        }
        // otherwise return [INF,-INF] so that parent can't be a bst
        return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.maxsum, right.maxsum));
    }
}
