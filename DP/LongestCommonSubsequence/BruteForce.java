package LongestCommonSubsequence;

public class BruteForce {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        longestCommonsubsequence(text1,text2);
    }

    private static int longestCommonsubsequence(String text1, String text2) {
        return longestCommonsubsequence(text1, text2,0,0);
    }

    private static int longestCommonsubsequence(String text1, String text2, int i, int j) {
        if(i == text1.length() || j == text2.length()) return 0;
        if(text1.charAt(i)==text2.charAt(j)){
            return 1 + longestCommonsubsequence(text1, text2, i+1, j+1); 
        }
        else{
            return Math.max(longestCommonsubsequence(text1, text2,i+1,j), longestCommonsubsequence(text1, text2,i,j+1));
        }
    }
}
