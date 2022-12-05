package MINIPALINDROME;

public class KMPmethod {
    public static void main(String[] args) {
        String str = "abcd";
        mincharpalind(str);
    }

    private static int mincharpalind(String str) {
        String revstr = reverse(str);
        // concatenate string with $ and reverse string
        String concat = str + "$" + revstr;
        // get LPS array of this concatenated string
        // longest prefix suffix is something where starting of string(Prefix) is same as
        // ending of string(suffix)
        int[] lps = calculatelps(concat);
        return (str.length() - lps[lps.length-1]);

    }
    // function for calculating lps array
    public static int[] calculatelps(String str){
        int n = str.length();
        int[] lps = new int[n];
        int len =0;
        // as , lps[0] is always 0
        lps[0] =0;
        // the loop calculate lps[i] for i=1 to n-1;
        int i=1;
        while(i<n){
            // we get new prefix and suffix , so increase length of current
            // lps by 1 and go to next iteration.
            if(str.charAt(i)==str.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                // don't increment i here
                if(len !=0){
                    len = lps[len-1];
                }else{
                    // there isn't any lps ends with pattern[i],sp set lps[i]=0
                    // and go to next iteration.
                    lps[i] =0;
                    i++;
                }
            }
        }
        return lps;
    }
     // Function for reverse a string
     public static String reverse(String s) {

        int n = s.length();
        StringBuffer sb = new StringBuffer(s);
        for (int i = n - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return sb.toString();

    }
    
}
