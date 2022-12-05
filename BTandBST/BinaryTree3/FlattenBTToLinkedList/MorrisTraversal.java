package FlattenBTToLinkedList;

// At a node(say cur) if there exists a left child, we will find the rightmost node in the left subtree(say prev).

// We will set prev’s right child to cur’s right child,
// We will then set cur’s right child to it’s left child.
// We will then move cur to the next node by assigning cur it to its right child
// We will stop the execution when cur points to NULL.


// Tc is O(n) and Sc is O(1)
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
    Node prev = null;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right = new Node(5);
        root.right.right = new Node(6);
        root.right.right.left = new Node(7);
        flatten(root);
        while (root.right != null) {
            System.out.print(root.data + "->");
            root = root.right;
        }
        System.out.print(root.data);

    }

    // what we are doing is moving all left node to right of root node
    // by makiing a connection between last node of root's left to root's right
    private static void flatten(Node root) {
        Node curr = root;
        while(curr != null){
            if(curr.left != null){
                Node pre = curr.left;
                while(pre.right != null){
                    pre = pre.right;
                }
                pre.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
