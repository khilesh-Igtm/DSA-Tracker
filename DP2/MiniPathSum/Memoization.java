import java.util.Arrays;
// Time Complexity: O(N*M)
// Space Complexity: O((M-1)+(N-1)) + O(N*M)
class Memoization{
    public static void main(String[] args) {
        int matrix[][] = {{5,9,6},{11,5,2}};
                            
  int n = matrix.length;
  int m = matrix[0].length;
  
  System.out.println(minSumPath(n,m,matrix));
    }

    private static int minSumPath(int n, int m, int[][] matrix) {
        int[][] dp = new int[n][m];
        for(int row[]:dp) Arrays.fill(row,-1);
        return minsumpathutil(n-1,m-1,matrix,dp);
    }

    private static int minsumpathutil(int i, int j, int[][] matrix, int[][] dp) {
        if(i==0 && j==0) return matrix[0][0];
        if(i<0 || j<0) return (int)Math.pow(10,9);
        if(dp[i][j] != -1) return dp[i][j];
        int up = matrix[i][j]+minsumpathutil(i-1, j, matrix, dp);
        int left = matrix[i][j]+minsumpathutil(i, j-1, matrix, dp);
        return dp[i][j] = Math.max(up, left);
    }
}