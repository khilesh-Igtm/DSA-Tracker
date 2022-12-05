package CloneAGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
    public int val;
    public List<Node> neighbors;
    public Node(){
        val =0;
        neighbors = new ArrayList<>();
    }
    public Node (int _val){
        val = _val;
        neighbors = new ArrayList<>();
    }
    public Node (int _val, ArrayList<Node> _neighbors){
        val = _val;
        neighbors = _neighbors;
    }
}

// Time Complexity: O(N + M)
// Space Complexity: O(N)


class UsingBFS{
    public static void main(String[] args) {
        
    }
    public Node cloneGraph(Node node){
        if(node==null){
            return null;
        }
        // // An HashMap to keep track of all the
        // nodes which have already been created
        HashMap<Node,Node> visited = new HashMap<>();
        // create a newnode and node value from original graph
        Node newNode = new Node(node.val);
         //Put the node into the HashMap
        visited.put(node,newNode);
        // Queue used for the BFS.
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
           // Take the the front element from the queue.
            Node cur = queue.poll();
             // Get corresponding Cloned Graph Node
            List<Node> newneighbors = visited.get(cur).neighbors;
            for(Node n : cur.neighbors){
                
                    // Get the corresponding cloned node
                    // If the node is not cloned then we will
                    // simply get a null
                if(!visited.containsKey(n)){
                     // If not then create a new Node and
                        // put into the HashMap
                    visited.put(n, new Node(n.val));
                    queue.offer(n);
                }
                // add the 'cloneNodeG' to neighbour
                    // arraylist of the cloneNodeG
                newneighbors.add(visited.get(n));
            }
        }
        return newNode;
    }
   
       
    
}