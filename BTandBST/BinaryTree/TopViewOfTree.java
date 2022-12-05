import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

// Intuition:  We can mark straight lines like in the image below and mark them with +ve and -ve indexes.
//  The first node of every line will be my top view.

// Approach: 

// First we have to make a queue of pair which have nodes and their respective +ve and -ve indexes or we can say the horizontal distance
// Then we need a map data structure to store the lines and the nodes. This map will store the data in the form of sorted orders of keys(Lines).
// Here we will follow the level order traversal.
// Traverse through the nodes starting with root,0 and store them to the queue.
// Until the queue is not empty, store the node  and line no. in 2 separate variable .
// Then check if that line is present in the map or not
// If not present then store the line and the node->val to the map
// Otherwise store the node->left and node->right along with there line nos. to the queue.
// Then print the node->val from the map

// pair class for making the pair for node and it's respective hd in map.
class Pair{
    int hd;
    Node node;
    public Pair(int hd, Node node){
        this.node = node;
        this.hd = hd;
    }
}



public class TopViewOfTree {
    public static void main(String[] args) {
        
    }
    public static ArrayList<Integer> topView(Node root){
        // this will have my final answer
        ArrayList<Integer> ans = new ArrayList<>();
        // base case
        if(root == null) return ans;
         // created a map for storing the horizontal distance of a particular node from the root and that nodes data. So 
        // key , value pair is horizontal distance , nodes data
        // we use TreeMap bcz it will arrange the key in sorted order
        Map<Integer,Integer> map = new TreeMap<>();
       // here we have to do level order traversal bcz using recursive or iterative approach we might get
        // some wrong answer that's why and for using level order traversal we use Queue.
        // Basically queue will have pair of horizontal distance and the nodes data
        Queue<Pair> q = new ArrayDeque<>();
         // hd is horizontal distance , this will tell how far my node is from root node
        // to get -1 , -2 ,+1,+2 distance of node
        // root has horizontal distance of 0 and is added to queue
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            Pair cur = q.poll();
            // this will help in checking if we already get the horizontal distance of a particular node
            // then don't need to check this bcz we already got some hd previously and that would be our top view
            // bcz we are traversing from top. 
            if(!map.containsKey(cur.hd)){
                map.put(cur.hd,cur.node.data);
            }
            // then we are doing level order traversal , and adding to queue ,if left is not null then take horiontal distance from
            // left side that would be -ve 
            if(cur.node.left != null){
                q.add(new Pair(cur.hd-1,cur.node.left));
            }
            // hd will be positive  on right side
            if(cur.node.right != null){
                q.add(new Pair(cur.hd+1,cur.node.right));
            }
        }
        // for traversing through the map and getting the value
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
