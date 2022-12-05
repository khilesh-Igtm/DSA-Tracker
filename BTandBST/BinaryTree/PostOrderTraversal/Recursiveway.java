package PostOrderTraversal;


// // The algorithm approach can be stated as:

// We first recursively visit the left child and go on left till we find a node pointing to NULL.
// Then we return to its parent.
// Then we recursively visit the right child.
// After we have returned from the right child as well, only then will we print the  current node value.


import java.util.ArrayList;

class Node{
    int data;
    Node left , right;
    Node(int data){
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

        ArrayList<Integer> postOrder = new ArrayList<>();
        postOrderTrav(root,postOrder);
        System.out.println("The postOrder Traversal is : ");
        for(int i=0;i<postOrder.size();i++){
            System.out.println(postOrder.get(i)+" ");
        }
    }
    private static void postOrderTrav(Node curr, ArrayList<Integer> postOrder) {
        if(curr == null) return;
        postOrderTrav(curr.left, postOrder);
        postOrderTrav(curr.right, postOrder);
        postOrder.add(curr.data);
    }
}
