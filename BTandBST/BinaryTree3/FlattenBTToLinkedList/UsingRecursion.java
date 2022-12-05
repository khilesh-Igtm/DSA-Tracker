package FlattenBTToLinkedList;

// Taking 1,2,3 as an example of a tree 2 in left , 3 in right and 1 as root.
// At starting node 1, what we finally want is that node 1’s right child should point to its current left child (node 2). 
// Now If we set it like this in our preorder traversal there will be no way to reach node 3.
// We need to modify our traversal technique. If we somehow start at node 3 (last node of the
// linked list), we need not traverse its right child as it is NULL, therefore we can 
// straightaway set its right child to its left child( which is again NULL) and set its
//  left child to NULL. Now we need to get to the second last node of the linked list 
// (node 2) and set the right child to node 3. After that, we need to move to the third 
// last node i.e node 1.

// Approach
// If we observe, we are moving in a reverse postorder way : i.e  right, left, root. 
// We take a reference variable (say prev) to store the previous node( initialized to NULL).
// Whenever we visit a node, we set the right child to the prev and left child to NULL. 
// Next we assign this current node to prev.
// We perform the above two operations on all the nodes in the traversal.

// Tc is O(n) and Sc is also O(n)


class Node {
    int data;
    Node  left, right;
    Node(int data)
    {
        this.data=data;
        left=null;
        right=null;
    }
  }



public class UsingRecursion {
    static Node prev = null;
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

    private static void flatten(Node root) {
        if(root==null) return;
        // reverse post order
        // check for right node
        flatten(root.right);
        flatten(root.left);
        // update the right and left and prev
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
