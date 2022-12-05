import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class kthlargestInBST {
    public static void main(String[] args) {
        
    }
    // extreme brute force is using arraylist/list to store all the item 
    // as we are doing inorder traversal bcz we know it is sorted.
    // and we return n-k element
    // Tc is O(n) and Sc as O(n)
    public int kthSmallest(TreeNode root , int k){
        List<Integer> res = new ArrayList<>();
        solve(root,res);
        int n = res.size();
        // k from last means n-k from 1st
        return res.get(n-k);
    }
    private void solve(TreeNode root, List<Integer> res) {
        if(root == null) return;
        solve(root.left,res);
        res.add(root.val);
        solve(root.right, res);
    }

    // recursive way
    // To find Kth largest element in a Binary search tree, the simplest logic is to do 
    // reverse inorder traversal and while doing reverse inorder traversal simply keep a
    //  count of number of Nodes visited. When the count becomes equal to k, we stop the
    //  traversal and print the data. 
    // Tc is O(n) and Sc is O(h)
    int count =0;
    int ans =0;
    public void solve(TreeNode root , int k){
        if(root==null) return;
        // traverse right subtree
        solve(root.right,k);
        // traverse root node
        count++;
        if(count ==k){
            ans = root.val;
            return;
        }
        // traverse left subtree
        solve(root.left, k);
    }
    public int kthlargest(TreeNode root , int k){
        // inorder traverse gives a sorted array
        // we can also get reverse sorted array by revrsing inorder
        solve(root, k);
        return ans;
    }

   
}
