package UndirectedGraph;
import java.util.*;
import java.io.*;

// Time Complexity: O(N+E)

// Space Complexity: O(N+E) +  O(N) + O(N) , space for adjacent list , array and queue


class GFG {
    public static void main(String[] args) throws IOException {

        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(i, new ArrayList<Integer>());
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(2).add(3);
        adj.get(1).add(3);
        adj.get(2).add(4);

        DetectBFSCycle obj = new DetectBFSCycle();
        boolean ans = obj.isCycle(V, adj);
        if (ans)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}

class Node {
    int first;
    int second;

    public Node(int first, int second) {
        // first is the current node
        this.first = first;
        // second is the parent of current node means path from first is arrived
        this.second = second;
    }
}

class DetectBFSCycle {
    static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s,
            boolean vis[]) {
                // we are using bfs here that's why queue
        Queue<Node> q = new LinkedList<>(); // BFS
        // at starting, -1 will be the parent node of our starting node
        // so we added -1 to queue and search for neighbor node
        q.add(new Node(s, -1));
        vis[s] = true;

        // until q is not empty try to find the current node and it's parent node
        while (!q.isEmpty()) {
            int node = q.peek().first;
            int par = q.peek().second;
            // and then remove it from queue
            q.remove();

            // start travering 
            for (Integer it : adj.get(node)) {
                if (vis[it] == false) {
                    q.add(new Node(it, node));
                    vis[it] = true;
                }

                // this means that if it is visited but it doesn't come from the same path
                // that means it has come from some different path and hence we can say
                // it's a cycle formation return true
                else if (par != it)
                    return true;
            }
        }
        // at last if the queue is empty and is not previously visited and also not the parent node
        // then return false means no cycle formation happens.

        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // created an boolean array for storing whether node is visited or not
        boolean vis[] = new boolean[V];
        Arrays.fill(vis, false);
        for (int i = 0; i < V; i++)
        // check for cycle if node is not visited
            if (vis[i] == false)
                if (checkForCycle(adj, i, vis))
                    return true;

        return false;
    }
}