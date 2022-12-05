package PalindromePartitioning;

public class Memoization {
    static Integer[][] dp;
    public static void main(String[] args) {
        String str = "ababbbabbababa";
        System.out.println(minPalPartion(str));
    }

    private static int minPalPartion(String str) {
        dp = new Integer[str.length()][str.length()];
        return solve(str, 0, str.length()-1);    
    }

    private static int solve(String str, int i, int j) {
        // Base case
        if(i>=j) return 0;
        if(dp[i][j] != null) return dp[i][j];
        // if the current string is palindrome then we don't need to break it into
        // further sub problem as we want to minimize the cuts
        if(isPalindrome(str,i,j)){
            dp[i][j] =0;
            return 0;
        }

        int min = Integer.MAX_VALUE;
        // trying different possible cuts between i and j
        for(int k =i;k<=j;k++){
            /*An Optimization: We will make the partition only if the string till the partition 
		(till Kth position) is a valid palindrome. Because the question states that all 
		partition must be a valid palindrome. If we dont check this, we will have to 
		perform recursion on the left subproblem too (solve(str, i, k)) and	we will waste 
		a lot of time on subproblems that is not required. Without this the code will give
		correct answer but TLE on big test cases. */
        if(isPalindrome(str,i,k)){
            int partitions = 1+solve(str, k+1, j);
            min = Math.min(min,partitions);
        }
        }
        // store answer in the memo table
        dp[i][j] = min;
        return dp[i][j];
    }
     static boolean isPalindrome(String str, int start, int end){
        while(start<end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
