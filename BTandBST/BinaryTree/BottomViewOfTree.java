import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

// Intuition:  We can mark straight lines like in the image below and mark them with +ve and -ve indexes.
//  The Last node of every line will be my Bottom view.

// Approach: 

// First we have to make a queue of pair which have nodes and their respective +ve and -ve indexes.
// Then we need a map data structure to store the lines and the nodes. This map will store the data in the form of sorted orders of keys(Lines).
// Here we will follow the level order traversal.
// Traverse through the nodes starting with root,0 and store them to the queue.
// Until the queue is not empty, store the node  and line no. in 2 separate variables .
// Then store the line and the node->val to the map, if there will be any node value present that corresponds to a line in the map , it will be replaced by the new node value and by this we will get the last node of each line.
// Store the node->left and node->right along with their line nos. to the queue.
// Then print the node->val from the map


class Node{
    int data;
    Node left , right;
    int hd;
    Node(int data){
        this.data = data;
        this.hd = Integer.MAX_VALUE;
        this.left = null;
        this.right = null;
    }
}


class BottomViewOfTree{
    public static void main(String[] args) {
        
    }
    public static ArrayList<Integer> bottomview(Node root){
        // this will have my final answer
        ArrayList<Integer> ans = new ArrayList<>();
        // base case
        if(root==null) return ans;
        // created a map for storing the horizontal distance of a particular node from the root and that nodes data. So 
        // key , value pair is horizontal distance , nodes data
        // we use TreeMap bcz it will arrange the key in sorted order
        Map<Integer,Integer> map = new TreeMap<>();
        // here we have to do level order traversal bcz using recursive or iterative approach we might get
        // some wrong answer that's why and for using level order traversal we use Queue.
        // Basically queue will have pair of horizontal distance and the nodes data
        Queue<Node> q = new LinkedList<Node>();
        // hd is horizontal distance , this will tell how far my node is from root node
        // to get -1 , -2 ,+1,+2 distance of node
        // root has horizontal distance of 0 and is added to queue
        root.hd =0;
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.remove();
            int hd = temp.hd;
            map.put(hd,temp.data);
            if(temp.left != null){
                // if we are adding from left side then we need left horizontal distance
                temp.left.hd = hd-1;
                q.add(temp.left);
            }
            if(temp.right != null){
                // we need right hd
                temp.right.hd = hd+1;
                q.add(temp.right);
            }

        }
        // here we are traversing through the map
        for(Map.Entry<Integer,Integer>entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        // bcz it was a treemap we can say that it will be sorted order
        return ans;
    }
    
}