package LongestCommonSubsequence;

// Time Complexity: O(N*M)

// Reason: There are N*M states therefore at max ‘N*M’ new problems will be solved.

// Space Complexity: O(N*M) + O(N+M)

// Reason: We are using an auxiliary recursion stack space(O(N+M)) (see the recursive
//  tree, in the worst case, we will go till N+M calls at a time) and a 2D array ( O(N*M)).


import java.util.Arrays;

public class Memoization {
    public static void main(String[] args) {
        String s1= "acd";
        String s2= "ced";
        System.out.println("The Length of Longest Common Subsequence is "+lcs(s1,s2));
    }

    private static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        // 2d is required bcz we have 2 stings and for 2 string s we have 2 indexs
        // so for managing these two index we need 2d array 
        int [][] dp = new int[n][m];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return lcsUtil(s1,s2,n-1,m-1,dp);
    }

    private static int lcsUtil(String s1, String s2, int ind1, int ind2, int[][] dp) {
        // base case
        if(ind1<0 || ind2<0) return 0;
        // we are storing values at every moment in dp
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        // if character matches then check for the next characters in both the string
        // recursively and also add 1 to it bcz it will be the part of my final answer
        if(s1.charAt(ind1)==s2.charAt(ind2)){
            return dp[ind1][ind2] = 1 + lcsUtil(s1, s2, ind1-1, ind2-1, dp);
        }
        // else decrease 1 index from 1 string at a time and check for that in current index
        // in next string and find the max from both
        // it is not take condition
        else
            return dp[ind1][ind2] = 0 + Math.max(lcsUtil(s1, s2, ind1, ind2-1, dp), lcsUtil(s1, s2, ind1-1, ind2, dp));

        
    }
}
