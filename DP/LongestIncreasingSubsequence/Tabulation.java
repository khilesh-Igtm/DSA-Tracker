package LongestIncreasingSubsequence;

// TC = O(n^2)
// SC = O(n^2)

// This just remove the extra stack space


public class Tabulation {
    public static void main(String[] args) {
        int [] nums = {10,9,2,5,3,7,101,18};
        lengthOfLIS(nums);
    }

    private static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        // we are starting from last index and prev will be 2nd last
        // i will iterate till it is equals to 0 and prev will iterate till
        // it becomes equal to -1 bcz it is prev of i , so when i becomes 0
        // it should be -1.
        for(int i = n-1;i>=0;i--){
            for(int prev = i-1;prev>=-1;prev--){
                int notPick = dp[i+1][prev+1];
                int pick = -1;
                if(prev == -1 || nums[i]>nums[prev]){
                    pick = 1 + dp[i+1][i+1];
                }
                dp[i][prev+1] = Math.max(notPick, pick);
            }
        }
        return dp[0][0];
    }
}
