import java.util.ArrayList;
import java.util.Arrays;

// Problem Statement: You are given two arrays of non-negative integers say ‘arr1’
//  and ‘arr2’ of sizes N and M respectively. Find the maximum value of
//  ( ‘A’ xor ‘B’ ) where ‘A’ and ‘B’ are any elements from ‘arr1’ and ‘arr2’
//  respectively and ‘xor’ represents the bitwise xor operation. Maximum XOR of Two
//  Numbers in an Array.

// here we are creating a trie and production level code
class Node {
    Node[] links = new Node[2];

    public Node() {
    }

    boolean containsKey(int ind) {
        return (links[ind] != null);
    }

    Node get(int ind) {
        return links[ind];
    }

    void put(int ind, Node node) {
        links[ind] = node;
    }
}

class Trie {
    private static Node root;

    // initialise your ds here
    Trie() {
        root = new Node();
    }

    // insert a word into the trie
    public void insert(int num) {
        Node node = root;
        // out num is integer type that's why 32 bit is required here
        for (int i = 31; i >= 0; i--) {
            // getting the bit of that num i.e 31 at starting
            int bit = (num >> i) & 1;
            // check does node/trie contain this bit or not if not then put it
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
                // put the bit and create a new trie or reference for this trie
            }
            // after creating a new node move to this and update this a new node
            node = node.get(bit);
        }
    }

    public int getMax(int num) {
        Node node = root;
        // now i need a max num , so i intialize maxNum as 0 and started array from 31
        // bcz if left most bit is set(1) then it will have max 
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            // i get the bit of the num 
            int bit = (num >> i) & 1;
            // then i check does our node/trie contains the opposite of our
            // current bit if yes then do OR with maxNum and update maxNum
            if (node.containsKey(1 - bit)) {
                maxNum = maxNum | (1 << i);
                // and get the 1-bit to node
                node = node.get(1 - bit);
            } else {
                // if it doesn't contain the opposite bit then no need to do anything
                // it will give is 0 zero answer
                node = node.get(bit);
            }
        }
        // finally return max answer
        return maxNum;
    }
}

public class MaxXorNumTwoArray {
    public static void main(String[] args) {
        int n = 2, m = 3;
        ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(new Integer[] { 6, 8 }));
        ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(new Integer[] { 7, 8, 2 }));
        MaxXorNumTwoArray obj = new MaxXorNumTwoArray();
        System.out.println(obj.maxXor(n, m, arr1, arr2));
    }

    public int maxXor(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            // insert the arr1 item to the trie
            trie.insert(arr1.get(i));
        }
        int maxi = 0;
        for (int i = 0; i < m; i++) {
            // then find max from the second arr and update the maxi
            maxi = Math.max(maxi, trie.getMax(arr2.get(i)));
        }
        // return maxi 
        return maxi;
    }
}

// Time Complexity: O(N*32) + O(M*32)
// Reason: For inserting all the elements of arr1 into the trie take O(N*32) [32 Bit]
//  and O(M*32) for finding the maxXOR for every element of arr2.
// Space Complexity: O(N*32)
// Reason: Since we are inserting all the elements of arr1 into trie where every 
// element is of size 32 bit but the space complexity will be less than O(N*32) 
// because they might have overlapped.
