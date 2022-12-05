package SuccessorPredecessor;

import java.util.ArrayList;

// Tc is O(n) and Sc is O(1)
// for worst case when the tree is skewed means only in one direction
class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class OptimalApproach {
    public static void main(String[] args) {
        inorderSuccessorPredecessor(null, 0);
    }
    private static ArrayList<Integer> inorderSuccessorPredecessor(TreeNode<Integer> root , int key){
       int predecessor = -1;
       int successor = -1;
    //    reach to the key
    // if our root data is not  equal to key then only move inside this
    while(root.data != key){
        // if our key is greater than root data than it's predecessor is  in right part
        if(key>root.data){
            predecessor = root.data;
            root = root.right;
        }
        // if key < root.data then successor is in left of root
        else{
            successor = root.data;
            root = root.left;
        }
    }
    // but in case our root is equal to key then our successor will be it's next element
    TreeNode<Integer> rightsubtree = root.right;
    while(rightsubtree != null){
        successor = rightsubtree.data;
        rightsubtree = rightsubtree.left;
    }

    // if root is equal to key then it's predecessor will be it;s previous element
    TreeNode<Integer> leftsubtree = root.left;
    while(leftsubtree != null){
        predecessor = leftsubtree.data;
        leftsubtree = leftsubtree.right;
    }
    ArrayList < Integer > sol = new ArrayList < Integer > ();
    sol.add(predecessor);
    sol.add(successor);
    return sol;
    
    }
}
