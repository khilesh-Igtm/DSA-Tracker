package DirectedGraph;

import java.util.ArrayList;

// Time Complexity: O(V + E)
// Sc is O(V)

public class DFSCycleDetect {
    public static void main(String[] args) {
        int V =6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        // vertex - 0
        ArrayList<Integer> neighbors = new ArrayList<>();
        neighbors.add(1);
        graph.add(neighbors);

        // vertex -1
        neighbors = new ArrayList<>();
        neighbors.add(2);
        neighbors.add(5);
        graph.add(neighbors);

        //vertex -2
        neighbors = new ArrayList<>();
        neighbors.add(3);
        graph.add(neighbors);

        //vertex -3
        neighbors = new ArrayList<>();
        neighbors.add(4);
        graph.add(neighbors);

        //vertex -4
        neighbors = new ArrayList<>();
        neighbors.add(0);
        neighbors.add(1);
        graph.add(neighbors);

        //Vertex - 5
        neighbors = new ArrayList<Integer>();
        graph.add(neighbors);
        
        if(isCyclic(V, graph))
         System.out.println("Cycle detected");
        else
         System.out.println("No cycles detected");

    }

    private static boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        // for checking whether we visited this node or not
        int[] visited = new int[N];
        // for checking the path from where we visited this
        int [] pathvisited = new int[N];
        for(int i=0;i<N;i++){
            // if not visited then
            if(visited[i]==0){
                if(checkCycle(i,adj,visited,pathvisited)==true) return true;
            }
        }
        return false;
    }

    private static boolean checkCycle(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathvisited) {
        // mark both visited and pathvisited as visited
        visited[node] =1;
        pathvisited[node] =1;
        // then try to get their neighbor and check which is not visited
        // and then recursively call the function
        for(Integer neighbor : adj.get(node)){
            if(visited[neighbor]==0){
                if(checkCycle(neighbor, adj, visited, pathvisited)==true) return true;
            //    if the neighbor  path is same and visited then return true as
            // there is a cycle
                else if(pathvisited[neighbor]==1) return true;
            }

        }
        // else backtrack and mark as unvisited path
        pathvisited[node] =0;
        // return false
        return false;
    } 
}
