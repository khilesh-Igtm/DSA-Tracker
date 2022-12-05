package CompleteString;

class Node{
    Node []links = new Node[26];
    boolean flag = false;

    public Node(){}
    boolean containsKey(char ch){
        return (links[ch - 'a'] != null);
    }
    Node get(char ch){
        return links[ch - 'a'];
    }
    void put(char ch , Node node){
        links[ch - 'a'] = node;
    }
    void setEnd(){
        flag = true;
    }
    boolean isEnd(){
        return false;
    }
}

class Trie{
    private static Node root;

    Trie(){
        root = new Node();
    }

    public void insert(String word){
        Node node = root;
        for(int i =0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    boolean checkIfPrefixExists(String word){
        Node node = root;
        boolean flag = true;
        for(int i=0;i<word.length();i++){
            // we check whether the prefix of a word exist in trie or not by
            // check the flag value as if it is true at every instance of the word
            // means at every char reference then it's prefix is present
            if(node.containsKey(word.charAt(i))){
                // if the  node is present then get it and check it's flag is true or false
                // if that would be true then it's prefix exist
                node = node.get(word.charAt(i));
                flag = flag & node.isEnd();
            }
            else{
                return false;
            }
        }
        return flag;
    }
}

class Solution{
    public static String completeString(int n ,String[] a){
        Trie obj = new Trie();
        for(int i =0;i<n;i++){
            obj.insert(a[i]); 
        }
        String longest = "";
        for(int i=0;i<n;i++){
            // if we find the word whose prefix is all present in trie 
            // then
            if(obj.checkIfPrefixExists(a[i])){
                // check for the longest word and update the longest
                if(a[i].length()>longest.length()){
                    longest = a[i];
                }
                // if 2 or more words length is equal then compare them
                // lexiographically and update longest
                else if(a[i].length() == longest.length() && a[i].compareTo(longest)<0){
                    longest = a[i];
                }
            }
        }
        // if there is no word whose prefix is present then return None
        if(longest == "") return "None";
        return longest;
    }
}


public class Optimal {
    public static void main(String[] args) {
        Trie T = new Trie();
        T.insert("ni");
        T.insert("nin");
        T.insert("ninj");
        T.insert("ninja");
        T.insert("ninga");
        System.out.println(Solution.completeString(0, args));
    }
}
