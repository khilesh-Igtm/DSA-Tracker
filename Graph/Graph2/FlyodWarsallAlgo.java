
// Tc is O(n3) and Sc is O(n2)

class FloydWarshallAlgo {

    final static int INF = 1000000000, V = 4;


    public static void main(String[] args) {
        int graph[][] = { { 0, 3, INF, 5 }, { 2, 0, INF, 4 }, { INF, 1, 0, INF }, { INF, INF, 2, 0 } };
        floydWarshall(graph);
    }

    // Implementing algo
    public static void floydWarshall(int[][] graph) {
        // this is also an optional step , we can directly solve the problem
        int matrix[][] = new int[V][V];
        int i, j, k;
        for (i = 0; i < V; i++) {
            for (j = 0; j < V; j++) {
                matrix[i][j] = graph[i][j];
            }
        }
        // adding vertices individually
        // k is the path via we traverse
        for (k = 0; k < V; k++) {
            // i is source
            for (i = 0; i < V; i++) {
                // j is destination
                for (j = 0; j < V; j++) {
                    // if the path between i and j via k is smaller than total distance from
                    // i to j then update the path else don't do anything
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }
        printMatrix(matrix);
    }

    // optional step in interview , it will print our answer
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (matrix[i][j] == INF) {
                    System.out.print("INF");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}