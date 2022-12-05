package EditDistance;

import java.util.Arrays;
// Time Complexity: O(N*M)
// Space Complexity: O(N*M) + O(N+M)



public class Memoization {
    public static void main(String[] args) {
        String s1 = "horse";
  String s2 = "ros";

  System.out.println("The minimum number of operations required is: "+
  editDistance(s1,s2));
    }

    private static int editDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for(int row[]:dp){
            Arrays.fill(row, -1);
        }
        return editDIstance(s1,s2,n-1,m-1,dp);
    }

    private static int editDIstance(String s1, String s2, int i, int j, int[][] dp) {
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = 0 + editDIstance(s1, s2, i-1, j-1, dp);
        }
        // minimum of 3 choices
        else return dp[i][j] = 1 + Math.min(editDIstance(s1, s2, i-1, j-1, dp),Math.min(editDIstance(s1, s2, i-1, j, dp),editDIstance(s1, s2, i, j-1, dp)) );
       
    }
}
