package TwoSum4;

import java.util.ArrayList;

// In this approach, we use the property of the inorder traversal of BST. The inorder
//  traversal of a BST always traverses the nodes of BST in the increasing order of their
//  values. Thus, we do the inorder traversal of the given tree and we store all the 
// values of the nodes in an array. This will give us an array in increasing order. 
// Now we can use the two-pointer technique on this sorted list for determining if two
//  elements exist in the list which sums up to the target value ‘K’.



class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

// (TC : O(N) for finding inorder + O(N) for using 2 pointer approach
// SC : O(N) for storing inorder in array/list)

public class BruteForce {
    public static void main(String[] args) {

    }
    public static boolean pairSumBST(TreeNode root,int k){
        // vector to store the inorder traversal of the bst.
        ArrayList<Integer> nums = new ArrayList<>();
        inorder(root,nums);
        // iterating over the nums list using 2 pointer
        int i=0,j=nums.size()-1;
        // Iterate till 'i' is less than 'j'
        while(i<j){
            if(nums.get(i)+nums.get(j)==k) return true;
            // if the sum of elements at index 'i' and 'j' is less than target 'k'
            if(nums.get(i)+nums.get(j)<k){
                // increment the left pointer 'i'
                i = i+1;
            }
            // If the sum of elements at index 'i' and 'j' is greater than target 'k'.
			else {

				// Decrement the right pointer 'j'.
				j = j - 1;
			}

        }
        return false;
    }
    private static void inorder(TreeNode root, ArrayList<Integer> nums) {
        if(root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    
}
