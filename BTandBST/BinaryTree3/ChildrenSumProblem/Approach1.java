package ChildrenSumProblem;

// Problem stat : For every node of a tree , the value of that node is equal to the sum of the value of all its children nodes
// (left child and the right child).
// we can only increment the value of root and children but can' decrement the value.

// Using DFS


// Approach
// Let ‘parentVal’ be the value at the parent’s node and ‘childVal’ be the sum of the values of children nodes. Now there arise three cases :
// If ‘parentVal’ = ‘childVal’, then we have to do nothing.
// If ‘parentVal’ < ‘childVal’, then we can simply increase ‘parentVal’ by diff = ‘childVal’ - ‘parentVal’.
// If ‘parentVal’ > ‘childVal’, then we can’t decrease the value in a node, so this case is a bit tricky. To handle this case, we need to increase ‘childVal’ i.e increase the sum of children nodes and for that increase the values in the child nodes.
// To handle the last case, what we can do is traverse recursively either the left child or the right child,  as when incrementing a child’s value, it will violate its children sum property so we have to recursively update the values in the subtree also. If one child is ‘NULL’, then we can recursively update the second child.

// Tc is O(n) and Sc is O(n)

class BinaryTreeNode <Integer> {
    int data;
    BinaryTreeNode < Integer > left;
    BinaryTreeNode < Integer > right;

public BinaryTreeNode(int data) {
        this.data = data;
    }
}


public class Approach1 {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(40);
        root.left = new BinaryTreeNode<>(10);
        root.left.left = new BinaryTreeNode<>(2);
        root.left.right = new BinaryTreeNode<>(5);
        root.right = new BinaryTreeNode<>(20);
        root.right.left = new BinaryTreeNode<>(30);
        root.right.right = new BinaryTreeNode<>(40);
        change(root);
    }

    private static void change(BinaryTreeNode<Integer> root) {
        // base case
        if(root==null || (root.left==null && root.right==null)) return;
        // traverse subtrees
        change(root.left);
        change(root.right);
        // child sum
        int childval =0;
        // finding the children sum 
        if(root.left != null){
            childval += root.left.data;
        }
        if (root.right != null) {
            childval += root.right.data;
        }
        // find the differnce
        int diff = childval - root.data;

        // if childval > parentval update the root.data
        if(diff>0) root.data += diff;
        // else try to increment the children data
        else increment(root,-diff);
    }

    private static void increment(BinaryTreeNode<Integer> root, int diff) {
        if(root.right != null){
            root.right.data += diff;
            increment(root.right, diff);
        }else if(root.left != null){
            root.left.data += diff;
            increment(root.left, diff);
        }
    }
}
