package PostOrderTraversal;
// Approach: In postorder traversal, the tree is traversed in this way: left, right, root.

import java.util.ArrayList;
import java.util.Stack;


// Intuition: In postorder traversal, the tree is traversed in this way: left, right, root. We first visit the
//  left child, after returning from it we visit the right child, and after returning from both of them, we print
//  the value of the current node. The fundamental problem we face in this scenario is that there is no way that
//  we can move from a child to the parent using as our node points to only children and not to the parent. To
//  solve this problem, we use an explicit stack data structure. While traversing we can insert node values to
//  the stack in such a way that we always get the next node value at the top of the stack.

// Solution 1: Using two stacks

// Approach: 

// The algorithm approach can be stated as:

// We take two explicit stacks S1 and S2.
// We insert our node to S1(if it’s not pointing to NULL).
// We will set up a while loop to run till S1 is non-empty.
// In every iteration, we pop out the top of S1 and then push this popped node to S2. Moreover we will push the left child and right child of this popped node to S1.(If they are not pointing to NULL).
// Then we start the next iteration with the next node as top of S1.
// We stop the iteration when S1 becomes empty.
// At last we start popping at the top of S2 and print the node values, we will get the postorder traversal.

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
// Tc as O(n) and Sc as O(n)

public class Iterativeway {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        ArrayList < Integer > postOrder = new ArrayList < > ();
        postOrder = postOrderTrav(root);

        System.out.println("The postOrder Traversal is : ");
        for (int i = 0; i < postOrder.size(); i++) {
            System.out.print(postOrder.get(i) + " ");
        }
    }

    private static ArrayList<Integer> postOrderTrav(Node curr) {
        // this will store my final answer
        ArrayList<Integer> postOrder = new ArrayList<>();
        if(curr == null) return postOrder;
        // we are using 2 stacks to solve this problem
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        // intially add current node to our 1st stack
        s1.push(curr);
        while(!s1.isEmpty()){
            // till s1 is not empty update current to top of stack and pop from s1
            curr = s1.peek();
            s1.pop();
            // then push it to s2
            s2.push(curr);
            if(curr.left != null){
                s1.push(curr.left);
            }
            if(curr.right != null){
                s1.push(curr.right);
            }
        }
        while(!s2.isEmpty()){
            postOrder.add(s2.peek().data);
            s2.pop();
            
        }
        return postOrder;
        
    }

   
}
