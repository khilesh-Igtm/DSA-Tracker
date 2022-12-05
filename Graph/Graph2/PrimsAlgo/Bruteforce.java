package PrimsAlgo;

import java.util.ArrayList;

// Time Complexity: O(N^2). Going through N Node for N-1 times

// Space Complexity: O(N). 3 arrays of size N


class Node {
    private int v;
    private int weight;

    Node(int _v, int _w) {
        v = _v;
        weight = _w;
    }

    Node() {
    }

    int getV() {
        return v;
    }

    int getWeight() {
        return weight;
    }
}

public class Bruteforce {
    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
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
        // key is for storing the weight of mst
        int[] key = new int[N];
        // this is for stroing the parent of the particular node
        int[] parent = new int[N];
        // this is for checking whether a node is being visited or not
        boolean[] mstSet = new boolean[N];
        // we intialised our weight as max and mstset as unvisited
        for (int i = 0; i < N; i++) {
            key[i] = 1000000000;
            mstSet[i] = false;
        }
        // then we intialise the first node weight as 0 and parent as -1 bcz
        // it's a source node or starting point
        key[0] = 0;
        parent[0] = -1;

        // then we start traversing the whole graph
        for (int i = 0; i < N - 1; i++) {
            int mini = 1000000000, u = 0;
            for (int v = 0; v < N; v++) {
                // if mstset of particular node is unvisited .And if the weight of node is less then
                //  intial value then update it.
                if (mstSet[v] == false && key[v] < mini) {
                    mini = key[v];
                    u = v;
                }
            }
            // after visiting node mark them as visited
            mstSet[u] = true;

            // this is for avoiding the cycle , bcz a node can also be neighbour of it;s neighbour.
            // so this might get into infinite loop , that's why mstset is required to check for ut
            for (Node it : adj.get(u)) {
                if (mstSet[it.getV()] == false && it.getWeight() < key[it.getV()]) {
                    parent[it.getV()] = u;
                    key[it.getV()] = it.getWeight();
                }
            }
        }
        // print the  mst 
        for (int i = 1; i < N; i++) {
            System.out.println(parent[i] + " - " + i);
        }
    }
}
