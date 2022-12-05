
// Tc is O(n) and Sc is O(1)

// created a trie with it's member as countendwith , countprefix and char node
class Node{
    Node [] links = new Node[26];
    int cntEndWith =0;
    int cntPrefix =0;

    public Node(){}
    // checking the character
    boolean containsKey(char ch){
        return (links[ch - 'a'] != null);
    }
    // for getting the character
    Node get(char ch){
        return links[ch - 'a'];
    }
    // for inserting the character
    void put(char ch , Node node){
        links[ch - 'a'] = node;
    }
    // for increasing the end as there could be 2 same words with same character
    void increaseEnd(){
        cntEndWith++;
    }
    // increasing the prefix if many words having same starting char
    void increasePrefix(){
        cntPrefix++;
    }
    // for deleteing the end , if we want to erase the word from trie
    void deleteEnd(){
        cntEndWith--;
    }
    // then while erasing word we need to reduce the perfix too
    void reducePrefix(){
        cntPrefix--;
    }
    // for getting the end of the word 
    int getEnd(){
        return cntEndWith;
    }
    // for getting the prefix of the word in trie
    int getPrefix(){
        return cntPrefix;
    }
}


public class ImplementTrie2 {
    private Node root;
    ImplementTrie2(){
        root = new Node();
    }
    // simple insert method to insert char of words in the trie
    public void insert(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
            // after inserting the char in trie , increase the prefix and also
            // increase the end too if same words are there
            node.increasePrefix();
        }
        node.increaseEnd();
    }

    // for checking the number of words that are equal to each other
    public int countWordsEqualTo(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }
            else{
                return 0;
            }
        }
        return node.getEnd();
    }

    // for counting the number of words having same prefix
    public int countWordsStartingWith(String word){
        Node node = root; 
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }else{
                return 0;
            }
        }
        return node.getPrefix();
    }

    // for deleting the particular word from the trie , char by char
    public void erase(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
                node.reducePrefix();
            }else{
                return;
            }
        }
        node.deleteEnd();
    }




    public static void main(String[] args) {
        ImplementTrie2 T = new ImplementTrie2();
        T.insert("apple");
        T.insert("apple");
        T.insert("apps");
        T.insert("apps");
        String word1 = "apps";
        System.out.println("Count words Equal to "+ word1+T.countWordsEqualTo(word1));
        String word2 = "abc";
        System.out.println("Count words Equal to "+ word2+T.countWordsEqualTo(word2));
        String word3 = "ap";
        System.out.println("Count words Equal to "+ word3+T.countWordsStartingWith(word3));
        String word4 = "appl";
        System.out.println("Count words Equal to "+ word4+T.countWordsStartingWith(word4));
        T.erase(word1);
        System.out.println("Count words equal to "+word1+T.countWordsEqualTo(word1));

    }
}
