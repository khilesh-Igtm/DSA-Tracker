package DirectedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Time Complexity: O(N+E)
// Space complexity: O(N)+O(N)

public class UsingBFS {
    public static void main(String[] args) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();

        // adding new arraylists to 'adj' to add neighbour nodes
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList < > ());
        }


        adj.get(2).add(5);
        adj.get(5).add(0);
        adj.get(0).add(4);
        adj.get(4).add(1);
        adj.get(1).add(3);
        adj.get(3).add(2);


       System.out.println(new Solution().isCyclic(6,adj));
    }
}
class Solution{
    public boolean isCyclic(int N,ArrayList<ArrayList<Integer>>adj){
        int [] indegree = new int[N];

        // finding indegree
        for(int i=0;i<N;i++){
            for(Integer it: adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<N;i++){
            // adding nodes to queue with indegree =0
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int count =0;
       
        while(!q.isEmpty()){
            Integer node = q.peek();
            q.remove();
            count++;
            // getting neighbour nodes of popped node and decreasing their indegree by 1
            for(Integer it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] ==0){
                    q.add(it);
                }
            } 
        }
        if(count == N) return false;
        return true;
    }
}
