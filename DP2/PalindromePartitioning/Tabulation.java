package PalindromePartitioning;

public class Tabulation {
    public static void main(String[] args) {
        String str = "ababbbabbababa";
        System.out.println(minPalPartion(str));
    }

    private static int minPalPartion(String str) {
        char [] s = str.toCharArray();
        boolean [][] isPalindrome = new boolean[str.length()][str.length()];
        int[] num = new int[str.length()];

        for(int i=0;i<str.length();i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<=i;j++){
                if(s[i]==s[j] && (j+1>=i || isPalindrome[j+1][i-1])){
                    isPalindrome[j][i] = true;
                    min = j ==0 ? 0: Math.min(min, num[j-1]+1);
                }
            }
            num[i] = min;
        }
        return num[str.length()-1];
    }
}
