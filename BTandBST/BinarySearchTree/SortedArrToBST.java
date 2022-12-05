// Given an integer array nums where the elements are sorted in ascending order, 
// convert it to a height-balanced binary search tree.

public class SortedArrToBST {
    public static void main(String[] args) {
        
    }
    // Tc is O(n) and Sc is O(1)
    public Node sortedarrtoBST(int[]nums){
        return CreateBST(nums,0,nums.length-1);
    }
    private Node CreateBST(int[]nums,int l,int r){
        // base case
        if(l>r) return null;
        // so basically in this question we have to convert sorted array to height balanced tree
		// so if we directly create tree in given sorted order it will become linked list
		// so we have to take middle element as head value such it will  become height balanced tree 
        int mid = (l+(r-l)/2);
        // created a root 
        Node root = new Node(nums[mid]);
         // assign the value for left of subtree that is l to mid -1 for given array
        root.left = CreateBST(nums, l, mid-1);
        // assign the value for right go subtree that is mid+1 to r for given array
        root.right = CreateBST(nums, mid+1, r);
        return root;

    }
}
