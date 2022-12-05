// The idea is to use Reverse Morris Traversal which is based on Threaded Binary Trees.
//  Threaded binary trees use the NULL pointers to store the successor and predecessor
//  information which helps us to utilize the wasted memory by those NULL pointers.
// The special thing about Morris traversal is that we can do Inorder traversal without 
// using stack or recursion which saves us memory consumed by stack or recursion call stack.
// Reverse Morris traversal is just the reverse of Morris traversal which is majorly used 
// to do Reverse Inorder traversal with constant O(1) extra memory consumed as it does 
// not uses any Stack or Recursion.
// To find Kth largest element in a Binary search tree, the simplest logic is to do 
//reverse inorder traversal and while doing reverse inorder traversal simply keep a count
//  of number of Nodes visited. When the count becomes equal to k, we stop the traversal 
// and print the data. 

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}
// Tc is O(n) and Sc is O(1)
public class KthlargestMorris {
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(10);
        System.out.println("Finding K-th largest Node in BST : " +
                KthLargestUsingMorrisTraversal(root, 2));
    }

    private static Node KthLargestUsingMorrisTraversal(Node root, int k) {
        Node curr = root;
        Node Klargest = null;
        // count variable to keep count of visited nodes
        int count = 0;
        while (curr != null) {
            // if right child is null
            if (curr.right == null) {
                // first increment count and check if count =k
                if (++count == k) {
                    Klargest = curr;
                }
                // otherwise move to left child
                curr = curr.left;
            } else {
                // find inorder successor of current node
                Node succ = curr.right;
                while (succ.left != null && succ.left != curr) {
                    succ = succ.left;
                }
                if (succ.left == null) {
                    // set left child of successor to the current node
                    succ.left = curr;
                    // move current to its right
                    curr = curr.right;
                }
                // restoring the tree back to original binary search tree removing threaded
                // links
                else {
                    succ.left = null;
                    if (++count == k) {
                        Klargest = curr;
                    }
                    // move current to its left child
                    curr = curr.left;
                }
            }
        }
        return Klargest;
    }
}
