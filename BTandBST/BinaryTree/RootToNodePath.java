import java.util.ArrayList;

// Tc is O(n) and Sc is O(n)

// Problem Statement: Print Root to Node Path In A Binary Tree. Write a program to print path from root to a given node in a binary tree.

// Intuition: 

// First of all, we need to find the node V in our tree for which we need to find the path. We can use any depth-first traversal technique (preorder, inorder, postorder) in order to find the required node.

// Approach: 

// We will use an external list to store our path. This list will be passed by reference to our recursive function. Moreover, we can set the return value of our function as boolean, this will help us to know whether node V was found in a subtree or not.

// The algorithm steps can be stated as follows:

// We pass the function with our root node, the path list and node V.
// For the base case, if root is pointing to NULL, we return false as clearly node V can’t be found.
// Now we first push the node to our path list.
// Then we check whether the current node is the target node or not, if it is then no further execution is needed and we return to the parent function.
// If not, then we recursively call its left and right child to find the target node V. If any one of them returns true, it means we have found node V at lower levels and return true from the current function.
// If the value is not found at the current node and neither in any of the recursive calls, it means that the value is not present in the current sub-tree, therefore we pop out the current node from the path list and return false.

class Node{
    int data;
    Node left , right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class RootToNodePath {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        root.right = new Node(3);

        ArrayList < Integer > arr = new ArrayList < > ();

      getPath(root, arr, 7);

        System.out.print("The path is ");
        for (int it: arr) {
            System.out.print(it + " ");
        }

    }

    private static boolean getPath(Node root, ArrayList<Integer> arr, int x) {
        // if root is null , there is no path
        if(root == null) return false;
        //push the node's value in arr
        arr.add(root.data);
        // if it is the required node return true
        if(root.data==x) return true;
        // else check whether the required node lies in the left subtree or right subtree
        // of the current node
        if(getPath(root.left, arr, x) || getPath(root.right, arr, x)){
            return true;
        }
        // required node does not lie either in the left or right subtree of the current node. Thus, remove current node's value
        // from 'arr' and then return false
        arr.remove(arr.size()-1);
        return false;
    }
}
