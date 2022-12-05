package EditDistance;

// Time Complexity: O(N*M)
// Space Complexity: O(N*M)
public class Tabulation {
    public static void main(String[] args) {
        String s1 = "horse";
  String s2 = "ros";

  System.out.println("The minimum number of operations required is: "+
  editDistance(s1,s2));
    }

    private static int editDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i =0;i<=n;i++){
            dp[i][0] = i;
        }
        for(int j =0;j<=m;j++){
            dp[0][j] = j;
        }
        for(int i=1;i<n+1;i++){
            for(int j =1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 0 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[n][m];
    }
}
