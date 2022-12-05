// Problem Statement: Check whether the given Binary Tree is a Balanced Binary Tree or not.
//  A binary tree is balanced if, for all nodes in the tree, the difference between left
// and right subtree height is not more than 1.

class BalancedBinaryTree{
    public static void main(String[] args) {
        
    }
    // Naive Approach
//     // Intuition + Approach: 
// For a Balanced Binary Tree, Check left subtree height and right subtree height for every node present in the tree. Hence, traverse the tree recursively and calculate the height of left and right subtree from every node, and whenever the condition of Balanced tree violates, simply return false.
// Condition for Balanced Binary Tree
// For all Nodes , Absolute( Left Subtree Height – Right Subtree Height ) <= 1

// Tc is O(n2) and Sc is O(1)
public boolean isBalanced(Node root){
    // base case
    if(root == null) return true;
    // check the left node of current node until left is not null and then find height
    int leftHeight = findH(root.left);
    // similarly for right
    int rightHeight = findH(root.right);
    // then check for condition , bcz a balanced binary tree will have abs diff of left-right <=1
    if(Math.abs(leftHeight - rightHeight)>1) return false;
    // // recursivley call this function for all left node and check the height from that node and check whther it is balanced or not
    boolean left = isBalanced(root.left);
    boolean right = isBalanced(root.right);
    return left && right;
}

private int findH(Node root) {
    if(root==null) return 0;
    // get the height of left and riight node 
    int left = findH(root.left);
    int right = findH(root.right);
    // chevk max of left and right and add 1 bcz we want ti include that node also
    return 1+ Math.max(left,right);
}


// Optimised Approach using Postorder traversal
// Approach : 
// Start traversing the tree recursively and do work in Post Order.
// For each call, caculate the height of the root node, and return it to previous calls.  
// Simultaneously, in the Post Order of every node , Check for condition of balance as information of left and right subtree height is available.
// If it is balanced , simply return height of current node and if not then return -1.
// Whenever the subtree result is -1 , simply keep on returning -1.

// Tc is O(n) and Sc is O(1)

public boolean isbalance(Node root){
    // doing this bcz we have to return the boolean value
    return dfsheight(root) != -1;
}
public static int dfsheight(Node root){
    if(root==null) return 0;
    // dfs for finding the left deepst node and get the height till top 
    int leftheight = dfsheight(root.left);
    // base case
    if(leftheight == -1) return -1;
    // similarly for right
    int righheight = dfsheight(root.right);
    // base case
    if(righheight == -1) return -1;
    // check for balanced condition
    if(Math.abs(leftheight - righheight)>1) return -1;
    // return final answer 
    return Math.max(leftheight, righheight)+1;
}
}