import java.util.ArrayList;

class Node{
    // first node
    private int u;
    // second node
    private int v;
    // weight between the node
    private int weight;

    Node(int _u, int _v, int _w){
        u = _u;
        v = _v;
        weight = _w;
    }
    Node(){}
    int getV(){ return v;}
    int getU(){ return u;}
    int getWeight(){ return weight;}
}

public class BellManFordNegative {
    public static void main(String[] args) {
        int n = 6;
        ArrayList<Node> adj = new ArrayList<Node>();
		
			
		adj.add(new Node(3, 2, 6));
		adj.add(new Node(5, 3, 1));
		adj.add(new Node(0, 1, 5));
		adj.add(new Node(1, 5, -3));
		adj.add(new Node(1, 2, -2));
		adj.add(new Node(3, 4, -2));
		adj.add(new Node(2, 4, 3));

	
		Main obj = new Main(); 
		obj.bellmanFord(adj, n, 0);
    }
}

class Main{
    public void bellmanFord(ArrayList<Node> edges, int N, int src){
        // for storing the distance from source till current node
        int dist[] = new int[N];
        // intialise by 1 million
        for(int i=0;i<N;i++) dist[i] = 1000000000;
        // considering source as 0
        dist[src] =0;
        // traversing till N-1 times , to get the distance from source that should be
        // shortest
        for(int i=1;i<=N-1;i++){
            for(Node node : edges){
                if(dist[node.getU()]+node.getWeight()<dist[node.getV()]){
                    dist[node.getV()] = dist[node.getU()]+node.getWeight();

                }
            }
        }
        // traversing 1 more time to detect the negative cycle
       int fl =0;
    //    if negative cycle is present then value of fl will be changed
       for(Node node : edges){
        if(dist[node.getU()]+node.getWeight()<dist[node.getV()]){
            fl =1;
            System.out.println("Negative cycle");
            break;
        }
       }
    //    if fl remains 0 then no negative cycle is present in the graph
       if(fl ==0){
        for(int i=0;i<N;i++){
            System.out.println(dist[i]+" ");
        }
       }
    }
}
// Time Complexity: O(N*E). We check E edges N times

// Space Complexity: O(N). Distance Array