package CompleteString;

/*
    Time Complexity : O(Sum(A[i])*max(A[i])*log(N))
    Space Complexity : O(Sum(A[i]))

    where 'Sum(A[i])' is the sum of length of all words 'A[i]',
    'max(A[i])' is the maximum length of string in array 'A'.
    and 'N' is the size of array 'A'.
 */

import java.util.HashMap;

public class BruteForce {
    public static void main(String[] args) {
        
    }
    public static String completeString(int n , String[]a){
        // my final answer
        String ans = "";
        HashMap<String,Integer> mp = new HashMap<>();
        // storing all strings in hashmap
        for(int i=0;i<n;i++){
            mp.put(a[i],1);
        }
        for(int i=0;i<n;i++){
            String pre = "";
            boolean flag = true;
            // traversing over all prefixes of the string 'a[i]'
            for(int j =0;j<a[i].length();j++){
                pre += a[i].charAt(j);
                // if current prefix is not present in map, this string is invalid.
                if(mp.containsKey(pre));
                else{
                    flag = false;
                    break;
                }
            }
            // current string is a valid string
            if(flag){
                // if current string is longer than ans, we update it
                if(ans.length()<a[i].length()){
                    ans = a[i];
                }
                // if current string is of same length as 'ans', but lexicographically 
                // smaller , we update it.
                else if(ans.length() == a[i].length() && ans.compareTo(a[i])>0){
                    ans = a[i];
                }
            }
        }
        // if there is no valid answer, we return "None"
        if(ans.length()==0){
            ans = "None";
        }
        // return final result
        return ans;
    }
}
