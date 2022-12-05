import java.util.ArrayList;
import java.util.List;

// Problem Statement: Given a Binary Tree, find the Right/Left view of it. The right view of a Binary Tree is a
//  set of nodes visible when the tree is viewed from the right side. The left view of a Binary Tree is a set of
// nodes visible when the tree is viewed from the left side.

// Approach: 

// Create an vector data structure inside both the left and the right side view function
// Call for the recursive _left and recursive_right function respectively with the (root,level,vector). Here level will be initially passed as 0.
// Return the vector.
// Now in the recursive_left function
// If vector size is equal to the level then push_back its node value to the vector data structure.
// Otherwise call recursive_left for (node->left,level+1,vector)
// Call recursive_left for (node->right,level+1,vector)
// Now in the recursive_right function
// If vector size is equal to the level then push_back its node value to the vector data structure.
// Otherwise call recursive_right for (node->right,level+1,vector)
// Call recursive_right for (node->left,level+1,vector)

class Node{
    int data;
    Node left , right;
Node(int data){
this.data = data;
this.left = null;
this.right = null;
}
}

class LeftViewOfTree{
    public static void main(String[] args) {
        
    }
    // Tc as O(n) and Sc as O(H)
    public static List<Integer> leftSideView(Node root){
        List<Integer> result = new ArrayList<Integer>();
        leftView(root,result,0);
        return result;
    }
    private static void leftView(Node root, List<Integer> result, int i) {
        if(root == null) return;
        if(i== result.size()){
            result.add(root.data);
        }
        leftView(root.left, result, i+1);
        leftView(root.right, result, i+1);
    }
    
}