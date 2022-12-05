import java.util.ArrayList;
import java.util.List;

public class Tabulation {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordbreak(s,wordDict));

    }

    private static boolean wordbreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        // dp[0] is true bcz an empty string can always be segmented
        dp[0] = true;
        for(int i =0;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    
        
    }
}
