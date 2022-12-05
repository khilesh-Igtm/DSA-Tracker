package PalindromePartitioning;

public class Recursion {
    public static void main(String[] args) {
        String str = "ababbbabbababa";
        System.out.println(minPalPartion(str, 0, str.length() - 1));
    }

    private static int minPalPartion(String str, int i, int j) {
        if(i>=j || isPalindrome(str ,i,j)) return 0;
        int ans = Integer.MAX_VALUE, count;
        for(int k =i;k<j;k++){
            // same as matrix chain multiplication
            count = minPalPartion(str, i, k) +
            minPalPartion(str, k+1, j) + 1;
            
            ans = Math.min(ans,count);
        }
        return ans;
    }

    private static boolean isPalindrome(String str, int i, int j) {
        while(i<j){
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
