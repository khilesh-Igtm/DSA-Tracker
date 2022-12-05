// A symmetrical binary tree is a tree that forms a mirror of itself around the center. In other words, every node in the left subtree will have a mirror image in the right subtree.'
// We can ignore the root node as it is lying on the mirror line.

// Approach

// We take two variables root1 and root2 initially both pointing to the root.
// Then we use any tree traversal to traverse the nodes. We will simultaneously change root1 and root2 in this traversal function.
// For the base case, if both are pointing to NULL, we return true, whereas if only one points to NULL and other to a node, we return false.
// If both points to a node, we first compare their value, if it is the same we check for the lower levels of the tree.
// We recursively call the function to check the root1’s left child with root2’s right child; then we again recursively check the root1’s right child with root2’s left child.
// When all three conditions ( node values of left and right and two recursive calls) return true, we return true from our function else we return false.

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

// Tc is O(n) and Sc is O(n)
public class SymmetricBT {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right = new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        boolean res;
        res = isSymmetric(root);
        if (res)
            System.out.println("The tree is symmetrical");
        else
            System.out.println("The tree is NOT symmetrical");
    }

    private static boolean isSymmetric(Node root) {
        if (root == null)
            return true;
            // we are not considreing the root node , bcz it will be present in both part
            // so only left and right of root
        return isSymmetricUtil(root.left, root.right);
    }

    private static boolean isSymmetricUtil(Node root1, Node root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }
        // we know a mirror image is totally opposite , means left part is right in mirror and vice-versa.
        // so here we are check the data on every node from left and right part.
        // and whenever we are checking left part and it's mirror part will be right and vice-versa.
        // if their data is same return true
        return (root1.data == root2.data) && isSymmetricUtil(root1.left, root2.right)
                && isSymmetricUtil(root1.right, root2.left);
    }
}
