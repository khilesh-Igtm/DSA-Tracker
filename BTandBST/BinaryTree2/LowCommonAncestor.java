// Lowest common ancestor
// Lowest Common Ancestor(LCA): The lowest common ancestor is defined between two nodes
//  x and y as the lowest node in T that has both x and y as descendants (where we 
// allow a node to be a descendant of itself.

class LowCommonAncestor{
    public static void main(String[] args) {
        
    }


    // Intuition:
// The very first thing we can observe from the question is that we can find the LCA of 2 given nodes from 
// i) Left subtree or in
// ii)Right subtree, if not in both the subtrees then root will be the  LCA.

// Approach:

// If root is null or if root is x or if root is y then return root
// Made a recursion call for both
// i) Left subtree 
// ii)Right subtree
// Because we would find LCA in the left or right subtree only.
// If the left subtree recursive call gives a null value that means we haven’t found LCA in the left subtree, which means we found LCA on the right subtree. So we will return right.
// If the right subtree recursive call gives null value, that means we haven’t found LCA on the right subtree, which means we found LCA on the left subtree. So we will return left .
// If both left & right calls give values (not null)  that means the root is the LCA.


// Tc is O(n) and Sc is O(n)
public Node lowestcommonAncestor(Node root,Node p, Node q){
    // base case
    if(root == null || root ==p || root ==q){
        return root;
    }
    Node left = lowestcommonAncestor(root.left, p, q);
    Node right = lowestcommonAncestor(root.right, p, q);
    // result
    if(left == null) return right;
    if(right==null) return left;
    // //both left and right are not null, we found our result
    else return root;
}
}
