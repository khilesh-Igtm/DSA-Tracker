package BstFromPreorder;


// Most optimal solution
// Tc is O(n) and Sc is O(1)


// JAVA ONLY UPPER BOUND- RECURSIVE
// EXPLANATION-
// Every node has an upper bound.

// Left node is bounded by the parent node's value.
// Right node is bounded by the ancestor's bound.
// Using the example in the question:
// The nodes [5, 1, 7] are all bounded by 8.
// The node 1 is bounded by 5.

// 8 is the root node, but if you think deeper about it, it is bounded by Integer.MAX_VALUE.
//  i.e. imagine there is a root parent node Integer.MAX_VALUE with left node being 8.
// This also means that both 10 and 12 nodes, which are also right nodes, are also bounded
//  by Integer.MAX_VALUE.
// We use a recursive function together with an outer index variable i to traverse and 
// construct the tree. When we create a tree node, we increment i to process the next 
// element in the preorder array.
// We don't need to care about lower bound. When we construct the tree, we try to create 
// left node first. If the condition fails (i.e. current number is greater than the parent
//  node value), then we try to create the right node which automatically satisfies the 
// condition, hence no lower bound is needed

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

// EXPLANATON-
// "explanation- It is possible to do this because when we construct the " left
// child " the upper bound will be the node value itself and no lower bound will
// be needed!
// -no lower bound is required for "right child" because we have arrived at this
// point of creating the right child only because these elements failed to
// satisfy the left subtree conditions!
public class Approach3 {
    int i = 0;

    public static void main(String[] args) {

    }

    public TreeNode bstfrompreorder(int[] arr) {
        return helper(arr, Integer.MAX_VALUE);
    }

    // explanation in copy
    private TreeNode helper(int[] arr, int bound) {
        if (i == arr.length || arr[i] > bound)
            return null;
        TreeNode root = new TreeNode(arr[i++]);
        // in left part the max range will be the root value itself. so we don;t need to check the lower bound
        // if the value smaller than root value then it will be in left part else right
        root.left = helper(arr, root.val);
        // bound here is the max value , bcz we are moving in right part and it's max range will be int.max
        root.right = helper(arr, bound);
        return root;
    }
}
