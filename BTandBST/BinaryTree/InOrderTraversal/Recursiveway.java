package InOrderTraversal;

import java.util.ArrayList;

class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Recursiveway {
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

        ArrayList < Integer > inOrder = new ArrayList < > ();
        inOrderTrav(root, inOrder);

        System.out.println("The inOrder Traversal is : ");
        for (int i = 0; i < inOrder.size(); i++) {
            System.out.print(inOrder.get(i) + " ");
        }
    }
    static void inOrderTrav(Node curr, ArrayList < Integer > inOrder) {
        // base case
        if (curr == null)
            return;

            // get the left node
        inOrderTrav(curr.left, inOrder);
        // add this data to inorder and after that add root data
        inOrder.add(curr.data);
        // then finally right node data
        inOrderTrav(curr.right, inOrder);
    }
}
