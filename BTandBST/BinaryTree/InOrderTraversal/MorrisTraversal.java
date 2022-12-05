package InOrderTraversal;

import java.util.ArrayList;
import java.util.List;

// Tc is O(n) and Sc is O(1)

// 1. Initialize current as root 
// 2. While current is not NULL
// If the current does not have left child
//    a) Print current’s data
//    b) Go to the right, i.e., current = current->right
// Else
//    a) Find rightmost node in current left subtree OR
//            node whose right child == current.
//       If we found right child == current
//           a) Update the right child as NULL of that node whose right child is current
//           b) Print current’s data
//           c) Go to the right, i.e. current = current->right
//       Else
//           a) Make current as the right child of that rightmost 
//              node we found; and 
//           b) Go to this left child, i.e., current = current->left

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}


public class MorrisTraversal {
    Node root;
    public static void main(String[] args) {
        MorrisTraversal tree = new MorrisTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println(tree.inorderTraversal(tree.root));
    }
    public List<Integer> inorderTraversal(Node root){
        // this will store my final answer
       List<Integer> result = new ArrayList<>();
    //    created a new node that is pointing to root
        Node current = root;
        Node previous;
        while(current != null){
            if(current.left == null){
                // add to my answer
                result.add(current.data);
                // move to next right node
                current = current.right;
            }else{
                // has a left subtree
                previous = current.left;
                while(previous.right != null){
                    // find rightmost
                    previous = previous.right;
                }
                // put current after the previous node
                previous.right = current;
                // store current node
                Node temp = current;
                // move current to the top of the new tree
                current = current.left;
                // original current left be null, avoid infinite loops
                temp.left = null;

            }
        }
        return result;
    }

}
