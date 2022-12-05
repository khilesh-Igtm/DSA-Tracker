package LongestPalindsubString;

public class ExpandFromCentre {
    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(longestpalindrome(s));
    }

    private static int longestpalindrome(String s) {
        if(s== null || s.length()<1) return s.length();
        int start = 0, end=0;
        for(int i=0;i<s.length();i++){
            // from len1 and len2 one will be for even length and one for odd length
            int len1 = expandAroundCenter(s,i,i);
            int len2 = expandAroundCenter(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len > end-start){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return end-start+1;
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left , R = right;
        while(L >=0 && R <s.length() && s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }
}
