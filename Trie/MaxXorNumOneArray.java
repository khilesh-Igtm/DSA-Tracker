import java.util.HashMap;

// Maximum XOR of Two Numbers in an Array
// Given an integer array nums, return the maximum result of nums[i] XOR nums[j], 
// where 0 <= i <= j < n.

// created a node for trie class
class Node{
    HashMap<Integer,Node> children;
    Node(){
        this.children = new HashMap<>();
    }
}

class Trie{
    Node root;
    Trie(){
        this.root = new Node();
    }

    // for inserting elements to the trie
    public void insert(int[] A){
        for(int num : A){
            Node curr = this.root;
            // it's 32 bit integer that's why we use 31 here (0 based indexing)
            for(int i=31;i>=0;i--){
                int currBit = (num>>i) &1;
                if(!curr.children.containsKey(currBit)){
                    curr.children.put(currBit, new Node());
                }
                curr = curr.children.get(currBit);
            }
        }
    }
}

class Solution{
     public int findMaximumXOR(int[]nums){
        Trie trie = new Trie();
        trie.insert(nums);
        int max =0;
        for(int num : nums){
            Node curr = trie.root;
            int currSum =0;
            for(int i=31;i>=0;i--){
                // if A[i] is 0 , we need 1 and if A[i] is 1 , we need 0.
                // Thus , 1-A[i]
                int requiredBit = 1-((num>>i) &1);  
                // if we get the opposite bit in map then calculate the currsum
                if(curr.children.containsKey(requiredBit)){
                    currSum |= (1<<i); //set ith bit of curr result
                    curr = curr.children.get(requiredBit);
                }else{
                    // else take this only
                    curr = curr.children.get(1-requiredBit);
                }
            }
            max = Math.max(max, currSum);
        }
        return max;
     }
}

public class MaxXorNumOneArray {
    public static void main(String[] args) {
        
    }
}
