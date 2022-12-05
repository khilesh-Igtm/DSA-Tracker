import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Node{
    private int u;
    private int v;
    private int weight;
    Node(int _u, int _v , int _w){
        u = _u;
        v = _v;
        weight = _w;
    }
    Node(){}
    int getV(){ return v;}
    int getU(){ return u;}
    int getWeight(){ return weight;}
}

class SortComparator implements Comparator<Node>{
    @Override
    public int compare(Node node1, Node node2){
        if(node1.getWeight() < node2.getWeight()) return -1;
        if(node1.getWeight() > node2.getWeight()) return 1;
        return 0;
    }
}

public class KruskalAlgo {
    public static void main(String[] args) {
        int n = 5;
        ArrayList<Node> adj = new ArrayList<Node>();
		
			
		adj.add(new Node(0, 1, 2));
		adj.add(new Node(0, 3, 6));
		adj.add(new Node(1, 3, 8));
		adj.add(new Node(1, 2, 3));
		adj.add(new Node(1, 4, 5));
		adj.add(new Node(2, 4, 7));


		KruskalAlgo(adj, n);
		
    }

    private static void KruskalAlgo(ArrayList<Node> adj, int N) {
        // sorting on the basis of weight in ascending order
        Collections.sort(adj,new SortComparator());
        // for stroing the parent of particular node
        int [] parent = new int[N];
        // for storing the rank of particular node
        int [] rank = new int[N];
        for(int i=0;i<N;i++){
            parent[i] = i;
            rank[i] =0;
        }
        // for storing the total cost/weight
        int costMst =0;
        ArrayList<Node> mst = new ArrayList<>();
        for(Node it: adj){
            if(findPar(it.getU(),parent) != findPar(it.getV(),parent)){
                costMst += it.getWeight();
                mst.add(it);
                union(it.getU(),it.getV(),parent,rank);
            }
        }
        System.out.println(costMst);
        for(Node it: mst){
            System.out.println(it.getU()+" - "+it.getV());
        }
    }

    // for finding parent
    private static int findPar(int u, int[] parent) {
        if(u==parent[u]) return u;
        return parent[u] = findPar(parent[u], parent);
    }

    // for comparing the parents
    private static void union(int u, int v, int[] parent, int[] rank) {
        u = findPar(u, parent);
        v = findPar(v, parent);
        if(rank[u]<rank[v]){
            parent[u] = v;
        }
        else if(rank[v]<rank[u]){
            parent[v] = u;
        }else{
            parent[v] = u;
            rank[u]++;
        }
    }
}
