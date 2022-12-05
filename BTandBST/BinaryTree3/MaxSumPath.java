// Problem Statement: Write a program to find the maximum sum path in a binary tree.
//  A path in a binary tree is a sequence of nodes where every adjacent pair of nodes 
// are connected by an edge. A node can only appear in the sequence at most once. A path
//  need not pass from the root. We need to find the path with the maximum sum in the
//  binary tree.

// To summarize:
// Initialize a maxi variable to store our final answer.
// Do a simple tree traversal. At each node, find  recursively its leftMaxPath and its rightMaxPath.
// Calculate the maxPath through the node as val + (leftMaxPath + rightMaxPath) and update maxi accordingly.
// Return the maxPath when node is not the curving point as val + max(leftMaxPath, rightMaxPath).

// Tc is O(n) and Sc is O(n)

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class MaxSumPath {
    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        int answer = maxPathSum(root);
        System.out.println("The Max Path Sum for this tree is " + answer);

    }

    static int res = Integer.MIN_VALUE;

    private static int maxPathSum(Node root) {
        // this variable will be used to store the answer after each possible path and
        // hence will finally store the max path sum

        if (root == null)
            return res;
        dfs(root);
        return res;
    }

    private static int dfs(Node root) {
        // base case
        if (root == null)
            return 0;
        // at any node we want to find the left and right side of max sum
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        // we are finding the max with 0 as we do not want to include any subtree with
        // negative contribution.
        // left here is storing the max possible contribution of the left subtree
        // right here is storing the max possible contribution of the right subtree
        // if either of left and right have a positive contribtuion(value),the larger
        // will finally be taken
        // but first we will have to assume that the subtree with root node as root(the
        // variable in this function) will have the largest sum path, so we will include
        // this in our res if it has a value larger than previous res
        res = Math.max(res, root.val + left + right);
        // so we simply return the sum of the root val and the larger between left and
        // rigth subtree sum
        return root.val + Math.max(left, right);
    }
}