public class NumOfDistinctSubString {
    public static void main(String[] args) {
        String s1 = "ababa";
        System.out.println("Total number of distinct substrings : " + 
        countDistinctSubstrings(s1));
    
        String s2 = "ccfdf";
        System.out.println("Total number of distinct substrings : " + 
        countDistinctSubstrings(s2));
    }

    private static int countDistinctSubstrings(String s) {
        Node root = new Node();
        int n = s.length();
        int count =0;

        for(int i=0;i<n;i++){
            Node node = root;

            for(int j=i;j<n;j++){
                if(!node.containsKey(s.charAt(j))){
                    node.put(s.charAt(j), new Node());
                    // counting the distict substring formed from the string
                    count++;
                }
                node = node.get(s.charAt(j));
            }
        }
        // one is added bcz we need to include empty space too.
        return count+1;
        
    }
}
class Node{
    Node[] links = new Node[26];

    boolean containsKey(char ch){
        return (links[ch-'a'] != null);
    }
    Node get(char ch){
        return links[ch - 'a'];
    }
    void put(char ch, Node node){
        links[ch - 'a'] = node;
    }

}

// Time Complexity: O(n2), because we have to go through the entire string for all 
// possible different starting points in order to generate all the substrings.

// Space Complexity: O(n2), because in the worst case, all the substrings can be 
// distinct and there will be a node for every substring. Number of substrings of 
// a string of length n is (n * (n + 1) / 2). Hence in the worst case, space 
// complexity will be O(n2).

