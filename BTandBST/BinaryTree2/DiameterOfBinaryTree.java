// Problem Statement: Find the Diameter of a Binary Tree. Diameter is the length of the
//  longest path between any 2 nodes in the tree and this path may or may not pass from
//  the root.

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        left = null;
        right =null;
    }
}


class DiameterOfBinaryTree{
    public static void main(String[] args) {
        
    }
    // Naive Approach using recursion

    // Approach : with Tc as O(n2) and Sc as O(1) with O(H) stack space.
// Traverse the tree recursively.
// At every node, calculate height of left and right subtrees.
// Calculate the diameter for every node using the above formula.
// Calculate the maximum of all diameters. This can be done simply using a variable passed by reference in the 
// recursive calls or a global static variable.

    public static int diameter(Node root){
       if(root==null) return 0;
    //    just find the height of left and right node , for every node. And finally check which node has max height
    
    int d1 = getHeight(root.left)+getHeight(root.right);
    //    considering evry node as root node
    // finding the diameter of all the left and right node
       int d2 = diameter(root.left);
       int d3 = diameter(root.right);
       return Math.max(d1,Math.max(d2,d3));

    }
    private static int getHeight(Node root) {
        if(root==null) return 0;
        return 1+ Math.max(getHeight(root.left),getHeight(root.right));
    }

    // Post Order Traversal Approach


    // Approach : 

// Yes, as in post-order traversal, we have to completely traverse the left and right subtree before visiting the
//  root node.So, the idea is to use post-order traversal and keep calculating the height of the left and right
//  subtrees. Once we have the heights at the current node, we can easily calculate both the diameter and height 
// of the current node.

// Start traversing the tree recursively and do work in Post Order.
// In the Post Order of every node , calculate diameter and height of the current node.
// If current diameter is maximum then update the variable used to store the maximum diameter.
// Return height of current node to the previous recursive call.

// Tc is O(n) and Sc is O(1)
int res =0;
// this is doing dfs , and instead of calling height multiple times ,we called it once
public int height(Node root){
    if(root==null) return 0;
    int leftheight = height(root.left);
    int rightheight = height(root.right);
    res = Math.max(res,leftheight+rightheight);
    return 1+Math.max(leftheight,rightheight);
}
public int diameterOfbinarytree(Node root){
    height(root);
    return res;
}

}