package PowerSet;

import java.util.ArrayList;
import java.util.Collections;

public class UsingBit {
    public static void main(String[] args) {
        String s="abc";
	ArrayList<String>ans = AllPossibleStrings(s);
	//printint all the subsequence.
	System.out.println("All possible subsequences are ");
	for (String it : ans) {
		System.out.print( it+" ");
	}
    }

    private static ArrayList<String> AllPossibleStrings(String s) {
        int n = s.length();
        ArrayList<String> ans = new ArrayList<>();

        // 2^n is similar tp 1<<n so we can use this instead
        // we are doing bit index representation of a string . ex = "abc"
        // 3 characters so 2^3 can be written as 1<<3. so it will have 
        // all the subsequence of a string
        for(int num =0;num<(1<<n);num++){
            // for substring
            String sub = "";
            for(int i=0;i<n;i++){
                // check if the ith bit is set or not
                // here we are doing left shift of every i. i.e is 2^1 , 2^2, 2^3
                if((num & (1<<i))!=0){
                    // if this condition happens then it is set bit
                    sub += s.charAt(i);
                }
                // else not a set bit
            }
            if(sub.length()>0){
                ans.add(sub);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}

// Time Complexity: O(2^n * n)
// Reason: O(2^n) for the outer for loop and O(n) for the inner for loop.
// Space Complexity: O(1)
