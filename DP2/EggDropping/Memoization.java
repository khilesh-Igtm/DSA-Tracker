package EggDropping;

import java.util.Arrays;

public class Memoization {

    static final int MAX = 1000;
 
    static int[][] memo = new int[MAX][MAX];
    public static void main(String[] args) {
        for (int i = 0; i < memo.length; i++)
        Arrays.fill(memo[i], -1);
    int n = 2, k = 36;
    System.out.print(solveEggDrop(n, k));
    }

    private static int solveEggDrop(int n, int k) {
        if(memo[n][k] != -1){
            return memo[n][k];
        }
        if(k==1 || k==0) return k;
        if(n==1) return k;

        int min = Integer.MAX_VALUE , x, res;
        for(x =1;x<=k;x++){
            res = Math.max(solveEggDrop(n-1,x-1),solveEggDrop(n, k-x));
            min = Math.min(res,min);
        }
        memo[n][k] = min+1;
        return min+1;
    }

    
}
