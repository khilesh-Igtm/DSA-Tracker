package LongestPalindsubString;
public class LongPalindSubString {
    public static void main(String[] args) {
        String s = "bcdef";
        System.out.println(longestsubs(s));
    }

    private static String longestsubs(String s) {
        // Tc is O(n3) and Sc is O(1)
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                // this is what we call a window/substring
                // we choose j as last element bcz we want longest substring , so why not
                // start with i as start and j as end and check is this a substring. If yes
                // then return the anwer else check for lower then itself substring .
                String temp = s.substring(i, j + 1);
                if (temp.length() > 0 && isPalindrome(temp)) {
                    ans = temp;
                    break;
                }

            }

        }
        // if we have some substring then return else return 1st char of string
        return (ans.length() > 0) ? ans : s.charAt(0) + "";

    }

    private static boolean isPalindrome(String temp) {
        int i = 0;
        int j = temp.length() - 1;
        while (j > i) {
            if (temp.charAt(i) == temp.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }

        }
        return true;

    }
}
