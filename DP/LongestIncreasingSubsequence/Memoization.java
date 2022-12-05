package LongestIncreasingSubsequence;

import java.util.Arrays;


// TC = O(n^2)
// SC = O(n^2) + O(n)

public class Memoization {
    public static void main(String[] args) {
        int [] nums = {10,9,2,5,3,7,101,18};
        lengthOfLIS(nums);
    }

    private static int lengthOfLIS(int[] nums) {
        // 2d array bcz for storing the prev too as prev is starting from -1
        // and our nums array is from 0 that's why we need 2d array
        int[][] dp = new int[nums.length][nums.length+1];
        // fill our row in dp with -1
        for(int[] row : dp) Arrays.fill(row, -1);
        return help(0,-1,nums,dp);
    }

    // prev+1 is done bcz we are doing coordinate change means prev will be stored at
    // 0th index and 0th index value will be stored at 1st index and so on. That is the reason
    // 2d array size is [n][n+1]. n for prev and n+1 for original

    private static int help(int i, int prev, int[] nums, int[][] dp) {
        // base case
        if(i == nums.length) return 0;

        // at every moment we are storing the value in dp to avoid
        // overlapping
        if(dp[i][prev+1] != -1) return dp[i][prev+1];
        // if we are not picking our 1st item then increase the index but prev will remain
        // same
        int notPick = help(i+1,prev,nums,dp);
        // this is when we pick the item considering at 0th index , which will be greater
        // prev bcz prev is -1 and hence pick value will be updated and hence we can find the
        // max from pick and notpick
        int pick = -1;
        if(prev == -1 || nums[i]>nums[prev]){
            pick = 1+ help(i+1, i, nums, dp);
        }
        return dp[i][prev+1] = Math.max(pick, notPick);
    }
}
