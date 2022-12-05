import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Memoization {
    // in memoization , we need to avoid overlapping subproblems , so for that we need extra storage
    // to check whether it is visited or not
    static Boolean[] dp;
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordbreak(s,wordDict));
    }
    private static boolean wordbreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        return wordbreak(0,s, new HashSet<>(wordDict));
    }
    private static boolean wordbreak(int p, String s, Set<String>dict) {
        int n = s.length();
        if(p==n){
            return true;
        }
        // if the subproblem is already been computed then no need to recompute instead , return the
        // already computed value
        if(dp[p]!= null) return dp[p];
        // check for the word in the dict using recursion by considering everry substring as a word
        for(int i = p+1;i<=n;i++){
            if(dict.contains(s.substring(p,i))&& wordbreak(i,s,dict)){
                return dp[p] = true;
            }
        }
        return dp[p] = false;
       
    }
}
