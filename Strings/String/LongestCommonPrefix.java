// import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        longcomm(strs);
    }

    private static String longcomm(String[] strs) {
        // One Approach with Tc as O(l + nlogn) and Sc as O(1)
        // Arrays.sort(strs);
        // String first = strs[0];
        // String last = strs[strs.length-1];
        // int c=0;
        // while(c<first.length()){
        //     if(first.charAt(c)==last.charAt(c)){
        //         c++;
        //     }else{
        //         break;
        //     }
        // }
        // return c==0?"":first.substring(0, c);


        // Another Approach Tc is O(l*n) here l is length of 1st string and n is number of string in an array.
        for(int i=0;i<strs[0].length();i++){
            char temp = strs[0].charAt(i);
            for(int j=0;j<strs.length;j++){
                // if it can't get further more then do this
                if(strs[j].length()==i || strs[j].charAt(i)!= temp){
                    return strs[0].substring(0,i);
                }
            }
        }
        // else we get whole array as the longest common prefix
        return strs[0];
    }
}
