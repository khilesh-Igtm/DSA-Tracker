// we created a trie of member as links and flag
class Node{
    Node links[] = new Node[26];
    boolean flag = false;
    public Node(){}

    // we have written an industry standard code, so we need to use this function
    // when needed instead of calculating like this in logical part
    
    // containskey will return true if there already exist a char of the word in the
    // trie else return false
    boolean containsKey(char ch){
        return (links[ch-'a'] != null);
    }

    // this is for searching of a word , char by char in a trie
    Node get(char ch){
        return links[ch-'a'];
    }
    // this is for inserting a word , char by char in a trie 
    void put(char ch, Node node){
        links[ch-'a'] = node;
    }

    // this is for, when the word end then we need to know that word is end in trie
    // so for that after the last char of word , we update flag of reference of last
    // char as true . so it will tell end of word
    void setEnd(){
        flag = true;
    }
    // this tell end of the word if flag is true
    boolean isEnd(){
        return flag;
    }
}

class Trie{
    private static Node root;
    // Initialize your data structure here
    Trie(){
        root = new Node();
    }

    // Insert a word into the trie

    public void insert(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            // if our trie doesn't consist of the char then put it into it
            // and also create a reference node/trie too
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            // if already exist then get it
            node = node.get(word.charAt(i));
        }
        // set end in the last , if the word is completed
        node.setEnd();
    }

    // return if the word is in the trie
    public boolean search(String word){
        // starting from the root
        Node node = root;
        for(int i=0;i<word.length();i++){
            // if the node doesn't contain  the char of the word then return false
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            // else get the char and move for the next char
            node = node.get(word.charAt(i));
        }
        // finally at the end of the char if it is true then return true else
        // false 
        if(node.isEnd()) return true;
        return false;
    }

    // return if there is any word in the trie that starts with the given prefix
    public boolean startsWith(String prefix){
        Node node = root;
        for(int i=0;i<prefix.length();i++){
            // if the node doesn't have the char then retrun false
            if(!node.containsKey(prefix.charAt(i))){
                return false;
            }
            // else get the char from the node
            node = node.get(prefix.charAt(i));
        }
        // and return true if we get all the prefix in the trie
        return true;
    }
}

class ImplementTrie1 {
    public static void main(String[] args) {
        int n = 5;
        int type[] = { 1, 1, 2, 3, 2 };
        String value[] = { "hello", "help", "help", "hel", "hel" };
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            if (type[i] == 1) {
                trie.insert(value[i]);
            } else if (type[i] == 2) {
                if (trie.search(value[i])) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            } else {
                if (trie.startsWith(value[i])) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
        }
    }
}