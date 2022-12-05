import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Tc is O(V+E)
// Sc is O(V)

public class BFSTraversal {
    public static void main(String[] args) {
        // my adjacency list or we can say all the neighbour of the node
        // will be stored in this
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);


        ArrayList < Integer > ans = bfsOfGraph(5, adj);
        printAns(ans);
    }

    private static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // for storing my final answer
        ArrayList<Integer> bfs = new ArrayList<>();
        // for checking whether the particular node is visited or not
        boolean []vis = new boolean[V];
        // it's a bfs traversal so queue is required as we do level order travering
        Queue<Integer> q = new LinkedList<>();
        // add my 1st/starting node to queue and mark it as visited
        q.add(0);
        vis[0] = true;
        // until q is not empty
        while(!q.isEmpty()){
            // take the front node from the queue
            Integer node = q.poll();
            // and add it to my final answer list 
            bfs.add(node);
             // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            // and find the neighbour of this node ,one at a time is checked
            for(Integer it : adj.get(node)){
                // if it is not visited then only move inside
                if(vis[it]==false){
                    // mark it as visited and add it to queue
                    vis[it]=true;
                    q.add(it);
                }
            }
        }
        // return my answer
        return bfs;
    }
    // for printing my answer
    static void printAns(ArrayList < Integer > ans) {
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
