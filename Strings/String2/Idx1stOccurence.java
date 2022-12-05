class Idx1stOccurence{
    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        occurence(haystack,needle);
    }

    private static int occurence(String haystack, String needle) {

        // Most easiest way 
        //  return haystack.indexOf(needle);


        // 2nd Approach 

        // Steps:
        // 1) Check whether any character of haystack equals to 1st character of our needle. If not then there is no
        // need to check for other characters
        // 2) If yes then check for other characters from that index only
        // we have to traverse till haystack.length()-needle.length()+1 bcz let's take this string example
        // haystack has 9 length and needle has 3 . And we have to find needle in haystack and if we reached at
        // 6 index do we need to check for next bcz after 6th index there are only 7th and 8th index and we have 3 characters
        // in needle. SO that's why we check till 0-7 bcz after that it will not make a substring equals needle.
        // for(int i=0;i<haystack.length()-needle.length()+1;i++){
        //     // we check the 1st character of needle with every character of haystack until we find one.
        //     if(haystack.charAt(i)==needle.charAt(0)){
        //         // the moment we find , we need to check the substring of haystack from that index to needle.length()+i
        //         // to understand it better take this example and try on copy
        //         if(haystack.substring(i, needle.length()+i).equals(needle)){
        //             // finally return 1st index of occurence if present
        //             return i;
        //         }
        //     }
        // }
        // // else -1
        // return -1;


        // KMP Approach
        if(needle.isEmpty()) return 0;
        // make longest prefix suffix table
        int[] lps = makeLPS(needle);
        int i=0,j=0;
        while(i<haystack.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else if(j>0){
                j = lps[j-1];
            }else{
                i++;
            }
            if(j==needle.length()){
                return i-needle.length();
            }
        }
        return -1;
    }

    private static int[] makeLPS(String needle) {
        int[] lps = new int[needle.length()];
        int prevlps =0,i=1;
        while(i<needle.length()){
            if(needle.charAt(i)==needle.charAt(prevlps)){
                lps[i] = prevlps+1;
                prevlps++;
                i++;
            }else if(prevlps==0){
                lps[i]=0;
                i++;
            }else{
                prevlps = lps[prevlps-1];
            }
        }
        return lps;
    }
}