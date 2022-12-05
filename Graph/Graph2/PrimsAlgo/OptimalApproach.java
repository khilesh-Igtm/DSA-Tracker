 package PrimsAlgo;

// Time Complexity: O(NlogN). N iterations and logN for priority queue

// Space Complexity: O(N). Three arrays and priority queue

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

// comparator is used here bcz we are having priority queue with min heap
class Node implements Comparator<Node>{
    private int v;
    private int weight;

    Node(int _v,int _w){
        v = _v;
        weight = _w;
    }
    // this is bcz we are gonna use this in priorityqueue 
    Node(){}
    int getV(){ return v;}
    int getWeight(){ return weight;}

    @Override
    public int compare(Node node1 , Node node2){
        if(node1.weight < node2.weight) return -1;
        if(node1.weight > node2.weight) return 1;
        return 0;
    }
}

// This runs fine in online compiler

class OptimalApproach {
    public static void main(String[] args) {
        int n = 5;
        ArrayList < ArrayList < Node > > adj = new ArrayList < ArrayList < Node > > ();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList < Node > ());

        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2, 3));
        adj.get(2).add(new Node(1, 3));

        adj.get(0).add(new Node(3, 6));
        adj.get(3).add(new Node(0, 6));

        adj.get(1).add(new Node(3, 8));
        adj.get(3).add(new Node(1, 8));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 7));
        adj.get(4).add(new Node(2, 7));

        primsAlgo(adj, n);

    }

    private static void primsAlgo(ArrayList<ArrayList<Node>> adj, int N) {
        // key is for stroing the weight of node
        int[] key = new int[N];
        // parent of particular node
        int [] parent = new int[N];
        // visited/unvisited node in mst
        boolean [] mstSet = new boolean[N];
        // intialising our key and mst as 1million and false
        for(int i=0;i<N;i++){
            key[i] = 100000000;
            mstSet[i] = false;
        }
        // creating a pq with min heap for stroring a new node of size N , where a new node
        // will be a pair of node and weight
        PriorityQueue<Node> pq = new PriorityQueue<Node>(N, new Node());
        // intialising the source node key as 0 and parent as -1
        key[0] =0;
        parent[0] =-1;
        // add the source in the queue
        pq.add(new Node(key[0],0));
        // Run the loop till all the nodes have been visited
        // because in the brute code we checked for mstSet[node] == false while computing the minimum
        // but here we simply take the minimal from the priority queue, so a lot of times a node might be taken
        //  twice hence its better to keep running till all the nodes have been taken. 
        while(!pq.isEmpty()){
            // we are stroing the minimum node value and mark it as visited
            int u = pq.poll().getV();
            mstSet[u] = true;
            // try to find it's all neighbour node 
            for(Node it: adj.get(u)){
                // if it is unvisited and it's weight is smaller than previous weight
                // at stating it is infinity, then update them and add them to priority
                // queue(node and it's respective weight)
                if(mstSet[it.getV()]==false && it.getWeight()<key[it.getV()]){
                    parent[it.getV()] = u;
                    key[it.getV()] = it.getWeight();
                    pq.add(new Node(it.getV(),key[it.getV()]));
                }
            }
        }
        // print the parent node
        for(int i=1;i<N;i++){
            System.out.println(parent[i]+ " - "+i + " , " );
        }
    }
}
