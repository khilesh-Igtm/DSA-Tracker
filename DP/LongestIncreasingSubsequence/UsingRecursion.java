package LongestIncreasingSubsequence;
class UsingRecursion{
    public static void main(String[] args) {
        int [] nums = {10,9,2,5,3,7,101,18};
        lengthOfLIS(nums);
    }

    // // TC = O(2^n)
// SC = O(n) recurrence stack space

    private static int lengthOfLIS(int[] nums) {
        // at starting index i.e 0 (bcz 0 based indexing) , the previous will be -1
        // as we don't have any previous for 1st element , that's why we take -1
        return getLIS(nums,-1,0);
    }

    private static int getLIS(int[] nums, int prev, int index) {
        // base case , if our index reaches end of array
        if(index == nums.length) return 0;
        int inc = Integer.MIN_VALUE;
        // this will be only for 0th index value bcz it's previous is -1.
        // and it is also greater than prev index value
        // and for that prev will be updated to index and index increment by 1
        // this is a method for taking 0th index
        if(prev == -1 || nums[index]>nums[prev]) inc = 1+ getLIS(nums, index, index+1);
        // if we don't take 0th index then start from index+1 and prev will be same -1.
        int ign = getLIS(nums, prev, index+1);
        // then finally return max from not take and take value .
        return Math.max(inc, ign);
    }
}