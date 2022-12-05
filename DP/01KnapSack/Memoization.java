import java.util.Arrays;

// Time Complexity: O(N*W)
// Space Complexity: O(N*W) + O(N)
class Memoization {
    public static void main(String[] args) {
        int wt[] = { 1, 2, 4, 5 };
        int val[] = { 5, 4, 8, 6 };
        int W = 5;

        int n = wt.length;

        System.out.println("The Maximum value of items, thief can steal is " +
                knapsack(wt, val, n, W));
    }

    private static int knapsack(int[] wt, int[] val, int n, int w) {
        int[][] dp = new int[n][w + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return knapsackUtil(wt, val, n - 1, w, dp);
    }

    private static int knapsackUtil(int[] wt, int[] val, int ind, int W, int[][] dp) {
        // base case 
        if (ind == 0) {
            // if last element fits in my bag , i will take it bcz it'a a top down approach
            if (wt[0] <= W)
                return val[0];
            else
                return 0;
        }
        // at every moment we are storing the value in dp , so to avoid recalculating overlapping
        // subarrays
        if (dp[ind][W] != -1) {
            return dp[ind][W];
        }

        // we are starting from end that's why ind-1 , we don't take the weight value
        // remains same but index decreases
        int notTaken = 0 + knapsackUtil(wt, val, ind - 1, W, dp);
        // but in case we take then check whether the taking value is smaller than our bag
        // capacity if yes then taken it and decrease the index and weight
        int taken = Integer.MIN_VALUE;
        if (wt[ind] <= W) {
            taken = val[ind] + knapsackUtil(wt, val, ind - 1, W - wt[ind], dp);
        }
        // finally find the max of take and not take
        return dp[ind][W] = Math.max(notTaken, taken);
    }
}