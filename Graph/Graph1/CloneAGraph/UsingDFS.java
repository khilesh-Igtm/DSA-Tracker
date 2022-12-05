package CloneAGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//   Time Complexity: O(N + M)
// Space Complexity: O(N)



class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        // basically this neighbors arraylist is created to store all the adjcent
        // nodes connected to particular node
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class UsingDFS {
    public static void main(String[] args) {
        
    }
    public Node cloneGraph(Node node){
        // if the actual node is empty there is nothing to copy , so return null
        if(node==null) return null;
        // intially we  create a new Node, with same value as the root node(given node)
        Node copy = new Node(node.val);
        // in this questiion we will create an array of Node(not boolean) bcz i have to add all the adjacent nodes of a
        // particular vertex , whether it's visited or not, so in the Node[] intially null is stored, if that node is visited
        // we will store the respective node at the index, and can retreive that easily.
        Node[] visited = new Node[101];
        // intially store null at all places
        Arrays.fill(visited,null);
        // make a dfs call for traversing all vertices of root node
        dfs(node,copy,visited);
        // in the end return the copy node
        return copy;
    }
    private void dfs(Node node, Node copy, Node[] visited) {
        // store the starting/current node at it's val index which will tell us that this node is now visited
        visited[copy.val] = copy;
        // now traverse for the adjacent nodes of root node
        for(Node n : node.neighbors){
            // check whether that node is visited or not
            // if not there must be null
            if(visited[n.val]==null){
                // visited[n.val]==null means , the node is not visited earlier
                // so now if it is not visited create a new node of node value
                Node newNode = new Node(n.val);
                // add this node as the neighbor of the prev copied node
                copy.neighbors.add(newNode);
                // make dfs call for this unvisited node to discover whether it's adjacent nodes are explored or not
                dfs(n,newNode,visited);
            }else{
                // if that node is already visited , retrive that node from visited array and add it as the adjcaent node of prev
                // copied node.  THIS IS THE POINT WHY WE USED NODE[] INSTEAD OF BOOLEAN[] ARRAY
                copy.neighbors.add(visited[n.val]);

            }
        }
    }
}
