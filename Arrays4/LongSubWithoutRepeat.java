import java.util.HashMap;
// import java.util.HashSet;
// import java.util.Set;

class LongSubWithoutRepeat {
    public static void main(String[] args) {
        String s = "abcbcacab";
        System.out.println(s.length());
        System.out.println(solve(s));
    }

    private static int solve(String str) {
        // if(str.length()==0) return 0;
        // if(str.length()==1) return 1;

        // int maxans = Integer.MIN_VALUE;
        // for (int i = 0; i < str.length(); i++) // outer loop for traversing the
        // string
        // {
        // Set < Character > se = new HashSet < > ();
        // for (int j = i; j < str.length(); j++) // nested loop for getting different
        // // string starting with str[i]
        // {
        // if (se.contains(str.charAt(j))) // if element if found so mark it as ans
        // // and break from the loop
        // {
        // maxans = Math.max(maxans, j - i);
        // break;
        // }
        // se.add(str.charAt(j));
        // maxans = Math.max(maxans, j - i+1);
        // }
        // }
        // return maxans;

        // if(str.length()==0)
        // return 0;
        // int maxans = Integer.MIN_VALUE;
        // Set < Character > set = new HashSet < > ();
        // int l = 0;
        // for (int r = 0; r < str.length(); r++) // outer loop for traversing the
        // string
        // {
        // if (set.contains(str.charAt(r))) //if duplicate element is found
        // {
        // while (l < r && set.contains(str.charAt(r))) {
        // set.remove(str.charAt(l));
        // l++;
        // }
        // }
        // set.add(str.charAt(r));
        // maxans = Math.max(maxans, r - l + 1);
        // }
        // return maxans;

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int n = str.length();
        int len = 0;
        while (right < n) {
            if (map.containsKey(str.charAt(right))) {
                left = Math.max(map.get(str.charAt(right)) + 1, left);
            }
            map.put(str.charAt(right), right);
            len = Math.max(len, right - left + 1);
            right++;

        }
        return len;

    }

}