package SuccessorPredecessor;
import java.util.ArrayList;

class TreeNode{
    int data;
    TreeNode left , right;
    TreeNode(int data){
        this.data =data;
    }
}
// Extreme brute force way
// Tc is O(n) and Sc is also O(n)

public class InorderSuccessorPredecessor {
    public static void main(String[] args) {
        
    }
    public static void inorder(TreeNode root , ArrayList<Integer>inorderArray){
        // doing the inorder bcz inorder is technically the sorted form 
        // bcz in BST all elements to left of root are smaller then it and right having greater ones.
        // And inorder is left, root , right. so we get sorted array.
        if(root ==null) return;
        inorder(root.left,inorderArray);
        inorderArray.add(root.data);
        inorder(root.right, inorderArray);
    }
    public static ArrayList<Integer> predecessorSuccessor(TreeNode root, int key){
        // to store the inorder traversal of the BST.
        ArrayList<Integer> inorderArray = new ArrayList<>();
        inorder(root,inorderArray);
        // intially we assume both as -1
        int predecessor =-1, successor = -1;
        for(int i=0;i<inorderArray.size();i++){
            if(inorderArray.get(i)==key){
                // if predecessor exist
                if(i-1 >=0){
                    predecessor = inorderArray.get(i-1);
                }
                // if successor exist
                if(i+1<inorderArray.size()){
                    successor = inorderArray.get(i+1);
                }
                break;
            }
        }
        // for storing the final answer
        ArrayList<Integer> sol = new ArrayList<>();
        sol.add(predecessor);
        sol.add(successor);
        return sol;
    }
    

}
