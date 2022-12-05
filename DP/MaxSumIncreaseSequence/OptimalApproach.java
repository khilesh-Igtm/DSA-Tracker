package MaxSumIncreaseSequence;

// Tc is O(n2) and Sc is O(n)

public class OptimalApproach {
    public static void main(String[] args) {
        int[] nums = { 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11 };
 
        System.out.println("The maximum sum of the increasing subsequence is " +
                        MSIS(nums));
    }

    private static int MSIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = nums[i];
        }
        for(int i=1;i<n;i++){
            for(int j =0;j<i;j++){
                if(nums[i]>=nums[j]){
                    dp[i] = Math.max(dp[j]+nums[i],dp[i]);
                }
            }
        }
        int maximum =0;
        for(int i=0;i<n;i++){
            maximum = Math.max(maximum,dp[i]);
        }
        return maximum;
    }
}
