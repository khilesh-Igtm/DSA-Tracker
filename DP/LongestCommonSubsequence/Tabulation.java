package LongestCommonSubsequence;

public class Tabulation {
    public static void main(String[] args) {
        String s1= "acd";
        String s2= "ced";
                                       
        System.out.println("The Length of Longest Common Subsequence is "+lcs(s1,s2));
    }

    // Time Complexity: O(N*M)

    // Reason: There are two nested loops
    
    // Space Complexity: O(N*M)
    
    // Reason: We are using an external array of size ‘N*M)’. Stack Space is eliminated.

    private static int lcs(String s1, String s2) {
       int[][]dp = new int [s1.length()+1][s2.length()+1];
       for(int i =1;i<=s1.length();i++){
        for(int j =1;j<=s2.length();j++){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                dp[i][j] = 1+dp[i-1][j-1];
            }else{
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
       }
       return dp[s1.length()][s2.length()];
    }
}
