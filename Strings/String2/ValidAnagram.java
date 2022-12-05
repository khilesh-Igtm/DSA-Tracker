// import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        anagram(s,t);
    }

    private static boolean anagram(String s, String t) {
        // Brute force way with Tc as O(nlogn) and Sc as O(n).
        // char[] arr = s.toCharArray();
        // char[] arr1 = t.toCharArray();
        // Arrays.sort(arr);
        // Arrays.sort(arr1);
        // if(Arrays.equals(arr,arr1)) return true;
        // return false;

        // Using Extra space with Tc as O(n) and Sc as O(n)
        if(s.length() != t.length()) return false;
        int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            // we have to subtract a from the i index character of the given string
            // and increment and decrement it's counter in both the string if at the end
            // our count array is full of 0 then we can say , both strings are anagarm means
            // having same characters.
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for(int i:count){
            if(i!=0){
                return false;
            }
        }
        return true;


    }
}
