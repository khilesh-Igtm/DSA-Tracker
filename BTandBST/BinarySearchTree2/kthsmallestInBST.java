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

public class kthsmallestInBST {
    public static void main(String[] args) {
        
    }
    // extreme brute force is using arraylist/list to store all the item 
    // as we are doing inorder traversal bcz we know it is sorted.
    // and we return k-1 element
    // Tc is O(n) and Sc as O(n)
    public int kthSmallest(TreeNode root , int k){
        List<Integer> res = new ArrayList<>();
        solve(root,res);
        return res.get(k-1);
    }
    private void solve(TreeNode root, List<Integer> res) {
        if(root == null) return;
        solve(root.left,res);
        res.add(root.val);
        solve(root.right, res);
    }

    // Optimised one with Tc as O(n) and Sc as O(1)
    int i =1;
    int ans =0;
    public int kthsmallest(TreeNode root , int k){
        inorder(root,k);
        return ans;
    }
    public void inorder(TreeNode root , int k){
        if(root == null) return;
        inorder(root.left, k);
        if(i==k){
            ans = root.val;
        }
        i++;
        inorder(root.right,k);
    }
}
