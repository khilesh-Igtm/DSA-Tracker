package PowerSet;

public class Recursion {
    public static void main(String[] args) {
        String s = "abc";
	String f = "";
	System.out.println("All possible subsequences are: ");
	solve(0, s, f);
    }

    private static void solve(int i, String s, String f) {
        if(i == s.length()){
            System.out.println(f+" ");
            return;
        }
        // picking 
        // f = f+s.charAt(i);
        solve(i+1, s, f+s.charAt(i));
        // popping out while backtracking 
        // f.pop_back();
        solve(i+1, s, f);
    }
}

// Time Complexity: O(2^n)
// Space Complexity: O(n), recursion stack.