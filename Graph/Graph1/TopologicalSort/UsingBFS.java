package TopologicalSort;

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


        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(3).add(1);
        adj.get(2).add(3);


       new Solution().isCyclic(6,adj);

    }
}

// Intitution is simple , we have to find the indegree with 0 and add it to queue and
// then try to print in the same order. Then we try to check the neighbor and see the 
// indegree ,If the indegree is not 0 then try to make it by reducing 1 edge at a time.
// and when it becomes then do the above steps.

class Solution{
    public boolean isCyclic(int N,ArrayList<ArrayList<Integer>>adj){
        int[] topo = new int[N];
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
        int index =0;

        while(!q.isEmpty()){
            Integer node = q.poll();
            topo[index++] = node;
            count++;
            // getting neighbour nodes of popped node and decreasing their indegree by 1
            for(Integer it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] ==0){
                    q.add(it);
                }
            } 
        }
         //printing topological ordering of nodes
         for (int i=0;i< topo.length;i++){
            System.out.print(topo[i]+" ");
        }
        if(count == N) return false;
        return true;
    }
}