package InOrderTraversal;

import java.util.ArrayList;
import java.util.Stack;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class InorderTraversal {
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

        ArrayList<Integer> inOrder;
        inOrder = inOrderTrav(root);

        System.out.println("The inOrder Traversal is : ");
        for (int i = 0; i < inOrder.size(); i++) {
            System.out.print(inOrder.get(i) + " ");
        }
    }

    // Using stack with Tc as O(n) and Sc as O(n)
    private static ArrayList<Integer> inOrderTrav(Node curr) {
        // Approach:

        // The algorithm approach can be stated as:

        // We first take an explicit stack data structure and set an infinite loop.
        // In every iteration we check whether our current node is pointing to NULL or
        // not.
        // If it is not pointing to null, we simply push the current value to the stack
        // and move the current node to its left child.
        // If it is pointing to NULL, we first check whether the stack is empty or not.
        // If the stack is empty, it means that we have traversed the tree and we break
        // out of the loop.
        // If the stack is not empty, we pop the top value of the stack, print it and
        // move the current node to its right child.

        // Stack is a Last-In-First-Out (LIFO) data structure, therefore when we
        // encounter a node, we simply push it to
        // the stack and try to find nodes on its left. When the current node points to
        // NULL, it means that there is
        // nothing left to traverse and we should move to the parent. This parent is
        // always placed at the top of the stack.
        // If the stack is empty, then we had already traversed the whole tree and
        // should stop the execution.

        ArrayList<Integer> inOrder = new ArrayList<>();
        // create a stack
        Stack<Node> s = new Stack<>();
        // iterate through this loop until it is true
        while (true) {
            // if the node is not null then add it to stack and check for it's left node if present or not
            // and update current node with left node
            if (curr != null) {
                s.push(curr);
                curr = curr.left;
            } 
            // if our current is null , then check if our stack also becomes null then break
            else {
                if (s.isEmpty())
                    break;

                // if our stack is not null then take top element from stack and put in inorder
                // and remove it from stack and check for right node
                curr = s.peek();
                inOrder.add(curr.data);
                s.pop();
                curr = curr.right;
            }
        }
        // return final answer
        return inOrder;
    }

}
