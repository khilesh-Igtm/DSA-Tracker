import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into
//  a space-separated sequence of one or more dictionary words. Means can words be formed to string


public class Recursion {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordbreak(s,wordDict));

    }

    private static boolean wordbreak(String s, List<String> wordDict) {
        return wordbreak(0,s, new HashSet<>(wordDict));
    }

    // whenever using recursion think in terms of indexes, here p acts as index.
    private static boolean wordbreak(int p, String s, Set<String>dict) {
        int n = s.length(); // n stores the length of the string
        if(p==n) return true;
        // taking every substring to match the word in dict and if matches return true.
        for(int i = p+1;i<=n;i++){
            if(dict.contains(s.substring(p,i))&& wordbreak(i,s,dict)){
                return true;
            }
        }
        // else return false
        return false;
    }
}
