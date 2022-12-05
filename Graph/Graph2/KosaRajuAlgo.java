import java.util.ArrayList;
import java.util.Stack;

// Time Complexity: O(N+E), DFS+TopoSort

// Space Complexity: O(N+E), Transposing the graph

class KosaRajuAlgo{
    public static void main(String[] args) {
        int n = 7;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Integer>());
			
		adj.get(1).add(3);
		adj.get(2).add(1);
		adj.get(3).add(2);
		adj.get(3).add(5);
		adj.get(4).add(6);
		adj.get(5).add(4);
		adj.get(6).add(5);

			
		Main obj = new Main(); 
		obj.kosaRaju(adj, n); 
    }
}

class Main{
    public void kosaRaju(ArrayList<ArrayList<Integer>> adj,int n){
       //intially we did a topo sort 
        int [] visited = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(i,st,adj,visited);
            }
        }
        // we don't know what could be the answer , so we created an arraylist to store
        // transpose
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for(int i=0;i<n;i++){
            transpose.add(new ArrayList<>());
        }
        // and while transposing we unmark as visited to that we can traverse
        for(int i=0;i<n;i++){
            visited[i] =0;
            // these two lines are for reversing the direction or we can say transposing
            // using this we changed the direction of the nodes
            for(Integer it: adj.get(i)){
                transpose.get(it).add(i);
            }
        }
        // now we do dfs according to finish time , or we can say that is in transpose list
        while(st.size()>0){
            int node = st.peek();
            st.pop();
            if(visited[node]==0){
                System.out.println("SCC: ");
                revDfs(node,transpose,visited);
                System.out.println();
            }
        }
    }

    // dfs traversal for topological sort and we now after every dfs we add it to stack
    private void dfs(int node, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[node] =1;
        for(Integer it: adj.get(node)){
            if(visited[it]==0){
                dfs(it, st, adj, visited);
            }
        }
        st.push(node);
    }

    // transpose of the list , dfs according to finish time.
    private void revDfs(int node, ArrayList<ArrayList<Integer>> transpose, int[] visited) {
        visited[node] =1;
        System.out.println(node+ " ");
        for(Integer it : transpose.get(node)){
            if(visited[it]==0){
                revDfs(it, transpose, visited);
            }
        }

    }
}