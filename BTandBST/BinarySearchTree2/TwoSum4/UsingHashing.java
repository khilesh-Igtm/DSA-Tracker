package TwoSum4;

import java.util.HashSet;

class TreeNode{
    int data;
    TreeNode left, right;
    TreeNode(int data){
        this.data = data;
    }
}

// (TC : O(N) 
// SC : O(N) 

public class UsingHashing {
    public static void main(String[] args) {
        
    }
    public boolean findTarget(TreeNode root,int k){
        HashSet<Integer> set = new HashSet<>();
        return dfs(root,set,k);
    }
    private boolean dfs(TreeNode root, HashSet<Integer> set, int k) {
        if(root== null)return false;
        if(set.contains(k-root.data)) return true;
        set.add(root.data);
        return dfs(root.left,set,k) || dfs(root.right,set,k);
    }
}
