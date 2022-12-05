// // BINARY SEARCH TREE (BST) is a node-based binary tree data structure which has the properties:

// The left subtree of a node contains only nodes with keys lesser than the node’s key.
// The right subtree of a node contains only nodes with keys greater than the node’s key.
// The left and right subtree each must also be a binary search tree.

class Node{
    int val;
    Node left,right;
    Node(int val){
        this.val = val;
    }
}

public class SearchInBST {
    public static void main(String[] args) {
        
    }
    // Recursive Method Tc is O(n) and Sc is O(n)
    public Node searchBST(Node root, int val){
        // Base Cases: root is null or val is present at root
        if(root==null || root.val == val) return root;
        // Value is smaller than root's val then search in left
        if(root.val>val) return searchBST(root.left, val);
     // Value is greater than root's val then search in right
        return searchBST(root.right, val);
    }

    // Iterative Method Tc is O(n) and Sc is O(1)
    public Node search(Node root,int val){
        // if tree is empty
        if(root==null) return null;
        // //Tree is not empty and root value is not equals to val
        while(root != null && root.val != val){
            //terminatory condition if val smaller than root value then search in left side 
            root = val <root.val ? root.left : root.right;
        }
        return root;
    }
}
