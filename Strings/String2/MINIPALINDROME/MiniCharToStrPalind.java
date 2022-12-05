package MINIPALINDROME;
// Minimum characters needed to be inserted in the beginning to make it palindromic

// Brute Force
// The idea is pretty simple, as we can add only at the front, thus, we need to work on the prefix of the string.
// We need to find the largest prefix that is a palindrome. For example, in case of “abbac”, the largest prefix that is a palindrome is “abba”, now all you need to do is add the reverse of left out suffix i.e. “ca” at the front to make it a palindrome.
// This can be done in the following way:-
// Until the string becomes a palindrome:
// Remove the last character from the string.
// Once the string becomes a palindrome or empty:
// Subtract the current length of string with the actual length of the string and return the function.
// In the case of “xxaxxxr” of length 7:
// As, “xxaxxxr” is not a palindrome, remove the last character, the new string will be “xxaxxx”
// As, “xxaxxx” is not a palindrome either, remove the last character, the new string will be “xxaxx”. 
// Now, as, “xxaxx” is a palindrome:
// Answer = actual length - current length
// Answer = 7 - 5 i.e. 2.

public class MiniCharToStrPalind {
    public static void main(String[] args) {
        String str = "abcd";
        mincharpalind(str);
    }

    // Time complexity is O(n2) and Space complexity is O(1)
    private static int mincharpalind(String str) {
        int count =0;
        while(str.length()>0){
            // if current string is palindrome break the loop
            if(isPalindrome(str)){
                break;
            }
            // otherwise remove the last char and go to next iteration
            else{
                count++;
                str = str.substring(0, str.length()-1);
            }
        }
        return count;
    }

    // function for checking a string is palindrome or not
    private static boolean isPalindrome(String str) {
        int l = str.length();
        int i =0;
        int j = l-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}
