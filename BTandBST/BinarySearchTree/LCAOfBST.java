
// Are you sure the solution is O(logN) - what about a BST which has no left sub tree and only right sub tree(See the tree below) - Would the time complexity in that case still be O(logN) - In those cases the time complexity would be O(N).

// Time complexity of a balanced BST - O(logN)
// Time complexity of an unbalanced BST - O(N)


class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val){
        this.val = val;
    }
}

// Tc is O(H) , H is Height of tree and Sc is O(1)
public class LCAOfBST {
    public static void main(String[] args) {
        
    }
    public TreeNode lca(TreeNode root, TreeNode p , TreeNode q){
        if(root == null) return null;
        // 1st one is that if both p & q are smaller than the root then call the left subtree
        if(p.val < root.val && q.val < root.val){
            return lca(root.left,p,q);
        }
        // 2nd if both p & q are greter than the root then call the right subtree
        else if(p.val > root.val && q.val > root.val){
            return lca(root.right,p,q);
        }
        // 3rd is that we get our answer that is root :)
        else{
            return root;
        }
    }
}
