package UndirectedGraph;
import java.util.ArrayList;

// Time Complexity: O(N+E)
// Sc is O(N)

public class DetectDFSCycle {
    public static void main(String[] args) {
        int V = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // edge 0---1
        adj.get(0).add(1);
        adj.get(1).add(0);

        // edge 1---2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // adge 2--3
        adj.get(2).add(3);
        adj.get(3).add(2);

        // adge 3--4
        adj.get(3).add(4);
        adj.get(4).add(3);

        // adge 1--4
        adj.get(1).add(4);
        adj.get(4).add(1);

        Solution obj = new Solution();
        boolean ans = obj.isCycle(V, adj);
        if (ans == true) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle Detected");

        }

    }
}

class Solution {
    public boolean checkForCycle(int node, int parent, boolean vis[], ArrayList<ArrayList<Integer>> adj) {
        // at every current node marks it as true/visited
        vis[node] = true;
        // then try to search for it's adj node and see whether they are visited or not
        for (Integer it : adj.get(node)) {
            if (vis[it] == false) {
                // if not then do dfs in it and at a node where visited becomes true return true
                if (checkForCycle(it, node, vis, adj) == true) {
                    return true;
                } 
                // and remember if the parent node of current node is not equal to the node from
                // where the cycle is formed then it;s true
                else if (it != parent)
                    return true;
            }
        }
        return false;
    }

    // 0 based indexing graph
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                if (checkForCycle(i, -1, vis, adj)) {
                    return true;
                }
            }
        }
        return false;
    }
}