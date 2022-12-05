public class Tabulation {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4, 3 };
        int N = arr.length-1;
 
        // Function call
        System.out.println(
            "Minimum number of multiplications is "
            + MatrixChainOrder(arr, N));
    }

    private static int MatrixChainOrder(int[] arr, int N) {
        int[][] dp = new int[N][N];
         /* 
	        State: dp[i, j] = Minimum number of scalar
	        multiplications needed to compute the
	        matrix A[i]A[i+1]...A[j] = A[i..j] where
	        dimension of A[i] is arr[i-1] x arr[i] 
	    */

	    // The cost of multiplying one matrix is 0
        for(int i=1;i<N;i++){
             // Make dp[i][i] 0
            dp[i][i] =0;
        }
         // Run a loop from length 2 to n - 1 
        for(int l = 2;l<N;l++){
            for(int i=1;i<N-l+1;i++){
                int j = i+l-1;
                // intialize dp[i][j] with max value
                dp[i][j] = Integer.MAX_VALUE;
                for(int k =i;k<=j-1;k++){
                    int temp = dp[i][k] + dp[k + 1][j]  + arr[i - 1] * arr[k] * arr[j];
	                
	                // If temporary answer 'temp' is less than actual aswer then update actual ans i.e dp[i][j]
	                dp[i][j] = Math.min(dp[i][j], temp);
                }
            }
        }
        return dp[1][N - 1];
    }
}
