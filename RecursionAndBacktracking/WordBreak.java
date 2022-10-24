import java.util.Arrays;
import java.util.List;

// Word Break Problem: Given a string and a dictionary of words, determine if the string can be segmented into
//  a space-separated sequence of one or more dictionary words.
public class WordBreak {
    public static void main(String[] args) {
        // List of strings to represent a dictionary
        List<String> dict = Arrays.asList("god", "is", "now", "no",
                "where", "here");
                // god is now no where here

        // input string
        String word = "godisnowherenowhere";

       wordBreak(dict, word, "");
    }

    private static void wordBreak(List<String> dict, String word, String out) {
        // if the end of the string is reached ,
        // print the out
        if(word.length()==0){
            System.out.println(out);
            return;
        }
        for(int i=1;i<=word.length();i++){
            // consider all prefixes of the current string
            String prefix = word.substring(0, i);
            // if the prefix is present in the dictionary , add it to the out string and recur
            // for the remaining string
            if(dict.contains(prefix)){
                wordBreak(dict, word.substring(i), out+" "+prefix);
            }
        }
    }

}