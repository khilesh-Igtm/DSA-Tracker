package LongestIncreasingSubsequence;

public class SpaceOptimise {
    public static void main(String[] args) {
        int [] nums = {10,9,2,5,3,7,101,18};
       System.out.println( lengthOfLIS(nums));
    }

    private static int lengthOfLIS(int[] nums) {
        int amax = 1;
        int[] dp = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int max =0;
            for(int j =0;j<i;j++){
                if(nums[j]<nums[i]) max = Math.max(max,dp[j]);
            }
            dp[i] = max +1;
            amax = Math.max(amax, dp[i]);
        }
        return amax;
    }
}
