import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Node implements Comparator<Node>{
    private int v;
    private int weight;
    Node(int _v,int _w){
        v = _v;
        weight = _w;
    }
	Node(){}
	int getV(){return v;}
	int getWeight(){ return weight;}

	public int compare(Node node1, Node node2){
		if(node1.weight < node2.weight){
			return -1;
		}
		if(node1.weight > node2.weight){
			return 1;
		}
		return 0;
	}
}



public class ImplementDijkstra {
    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Node> > adj = new ArrayList<ArrayList<Node> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Node>());
		
			// node connected with another node with weight
		adj.get(0).add(new Node(1, 2));
		adj.get(1).add(new Node(0, 2));
		
		adj.get(1).add(new Node(2, 4));
		adj.get(2).add(new Node(1, 4));
		
		adj.get(0).add(new Node(3, 1));
		adj.get(3).add(new Node(0, 1));
		
		adj.get(3).add(new Node(2, 3));
		adj.get(2).add(new Node(3, 3));
		
		adj.get(1).add(new Node(4, 5));
		adj.get(4).add(new Node(1, 5));
		
		adj.get(2).add(new Node(4, 1));
		adj.get(4).add(new Node(2, 1));
		
		Main obj = new Main(); 
		obj.shortestPath(0, adj, n); 
    }
}

class Main{
	public void shortestPath(int s, ArrayList<ArrayList<Node>> adj, int N ){
		// for storing the distance from source to current node
		int[] dist = new int[N];
		// intialising every node distance to infinity
		for(int i =0;i<N;i++) dist[i] = 1000000000;
		dist[s] =0;
		// creating min-heap so that node  will be at top
		PriorityQueue<Node> pq = new PriorityQueue<>(N,new Node());
		// store the starting node in queue with distance as 0bcz it will act as source node
		pq.add(new Node(s,0));
		while(pq.size()>0){
			// poll the node from queue
			Node node = pq.poll();
			// and check it's neighbour node
			for(Node it: adj.get(node.getV())){
				// if their neighbour node weight + the current weight from the source is 
				// smaller than the intialised weight(i.e infinity) , then update the distance.
				// else don't do anything
				if(dist[node.getV()]+it.getWeight()<dist[it.getV()]){
					dist[it.getV()] = dist[node.getV()] + it.getWeight();
					pq.add(new Node(it.getV(),dist[it.getV()]));
				}
			}
		}
		// finally print the distance from source to every node
		System.out.println("The distance from source "+s+"are : ");
		for(int i=0;i<N;i++){
			System.out.println(dist[i]+" ");
		}
	}

}

// Time Complexity: O((N+E)*logN). Going through N nodes and E edges and log N for priority queue

// Space Complexity: O(N). Distance array and priority queue