package RodCutting;

// Time complexity = O(2 ^ N)
// Space complexity = O(N)

public class Recursion {
    public static void main(String[] args) {
        
    }
    public static int cutRod(int[]price,int n){
        // base condition
        if(n<=0) return 0;

        // intialize maxCost with minimum value
        int maxCost = Integer.MIN_VALUE;

        // recursively cut the rod , obtain different configuration
        // and compare cost obtained from each with maxCost.
        for(int i =0;i<n;i++){
            maxCost = Math.max(maxCost,price[i]+cutRod(price, n-i-1));
        }
        return maxCost;
    }
}
