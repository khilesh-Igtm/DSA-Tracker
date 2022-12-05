package LongestPalindsubString;

public class UsingDP {
    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        System.out.println(longestPalSubstr(str));
    }

    private static String longestPalSubstr(String str) {

// Tc is O(n2) and Sc is also O(n2) 
// as we are using dp bottom up approach i.e tabulation table form


        // get length of input string
        int n = str.length();
        // table[i][j] will be false if substring is not palindrome else true
        boolean[][] table = new boolean[n][n];
        // all substrings of length 1 are palindrome
        int maxlength =1;
        for(int i=0;i<n;i++){
            table[i][i] = true;
        }
        // check for substring of length 2
        int start =0;
        for(int i=0;i<n-1;i++){
            // as length is 2 so both are one by other
            if(str.charAt(i)==str.charAt(i+1)){
                table[i][i+1]= true;
                start =i;
                maxlength = 2;
            }
        }
        // check for length greater than 2. k is the length of substring
        for(int k =3;k<=n;k++){
            // fix the starting index
            for(int i=0;i<n-k+1;i++){
                // get the ending index of substring from starting index i and length k
                int j = i+k-1;
                // checking for substring from ith index to jth index iff str.charAt(i+1) to str.charAt(j-1) is a palindrome
                if(table[i+1][j-1] && str.charAt(i)==str.charAt(j)){
                    table[i][j] = true;
                    // we want to update maxlength to k because k is the longest palidrome 
                    if(k>maxlength){
                        start = i;
                        maxlength = k;
                    }
                }
            }
        }
        return str.substring(start, start + maxlength);
        
       

    }

    
}
