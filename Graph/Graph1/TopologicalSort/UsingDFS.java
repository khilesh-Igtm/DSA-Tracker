package TopologicalSort;

import java.util.ArrayList;
import java.util.Stack;

// Time Complexity: O(N+E) 
// Space Complexity: O(N) + O(N)
// Auxiliary Space Complexity:  O(N)
public class UsingDFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=6;
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer> arr=new ArrayList<>();
            adj.add(arr);
        }
        
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        
        int res[] = topoSort(6, adj);
   
        System.out.println("Toposort of the given graph is:" );
        for (int i = 0; i < res.length; i++) {
        System.out.print(res[i]+" ");
    }
}

    private static int[] topoSort(int N, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        int [] visited = new int[N];
        for(int i=0;i<N;i++){
            if(visited[i]==0){
                findTopoSort(i,visited,adj,st);
            }
        }
        int [] topo = new int[N];
        int ind =0;
        while(!st.isEmpty()){
            topo[ind++] = st.peek();
            st.pop();
        }
        return topo;
    }

    private static void findTopoSort(int node, int[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        visited[node] =1;
        for(Integer it: adj.get(node)){
            if(visited[it]==0){
                findTopoSort(it, visited, adj, st);
            }
        }
        st.push(node);
    }
}