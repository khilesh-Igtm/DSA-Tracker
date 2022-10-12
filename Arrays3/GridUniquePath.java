// import java.util.Arrays;

class GridUniquePath {
    
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(uniquepath(m, n));
    }

    private static int uniquepath(int m, int n) {
        // if(i==(n-1) && j==(m-1)) return 1;
        // if(i>=n || j>=m) return 0;
        // else return uniquepath(i+1,j,m,n) + uniquepath(i, j+1,m,n );
   

        // Combinatorics Solution 
        // nCr 
        int N = n+m-2;
        int r = m-1;
        double result = 1;
        for(int i=1;i<=r;i++){
            result = result * (N-r+i)/i;
        }
        return (int) result;
 
   
//    Memoization technique of DP
   
        // int[][] dp = new int[m][n];
    // for(int[] row : dp){
    //     Arrays.fill(row, -1);
    // }
    // int num=countpath(0,0,m,n,dp);
    //     if(m==1&&n==1)
    //         return num;
    //     return dp[0][0];
      
    // }

    // private static int countpath(int i , int j ,int n, int m, int[][] dp) {
    
    //     if(i==(n-1)&&j==(m-1)) return 1;
    //     if(i>=n||j>=m) return 0;
    //     if(dp[i][j]!=-1) return dp[i][j];

    //     else return dp[i][j]=countpath(i+1,j,n,m,dp)+countpath(i,j+1,n,m,dp);
    
    }
}