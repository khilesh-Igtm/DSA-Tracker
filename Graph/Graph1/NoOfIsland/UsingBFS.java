package NoOfIsland;

// This is a solution if we have to check diagonally too


// Time Complexity ~ O(N² + NxMx9), N² for the nested loops, and NxMx9 for the overall 
// DFS of the matrix, that will happen throughout if all the cells are filled with 1.

// Space Complexity: O(N²) for visited array max queue space O(N²), If all are marked as
//  1 then the maximum queue space will be N².


import java.util.LinkedList;
import java.util.Queue;

// used this to check what is our starting node for find the island
class Pair{
    // it is a pair of row and col
    int first;  // it is a row
    int second;  // it is col
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}

public class UsingBFS{
    public static void main(String[] args) {
        char[][] grid =  {
            {'0', '1', '1', '1', '0', '0', '0'},
            {'0', '0', '1', '1', '0', '1', '0'}
        };
                
        Solution obj = new Solution();
        System.out.println(obj.numIslands(grid));
    }
}

class Solution{

    // function to find the number of islands
    public int numIslands(char[][]grid){
        int n = grid.length;
        int m = grid[0].length;
        // for storing the visited path
        int[][] visited = new int[n][m];
        // my final answer
        int count =0;
        // traverse through whole matrix and search for land
        for(int row =0;row<n;row++){
            for(int col =0;col<m;col++){
                // if not visited and is a land
                if(visited[row][col]==0 && grid[row][col]=='1'){
                    count++;
                    bfs(row,col,visited,grid);
                }
            }
        }
        return count;
    }

    private void bfs(int row, int col, int[][] visited, char[][] grid) {
        // intially mark as visited , from where we are starting
        visited[row][col] =1;
        // as it is a bfs  so we used queue
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        int n = grid.length;
        int m = grid[0].length;

        // until the queue becomes empty
        while(!q.isEmpty()){
            // peek row and col and see their neighbor , if there is a land or water
            int ro = q.peek().first;
            int co = q.peek().second;
            q.remove();

            // traverse in the neighbours and mark them if its a land
            for(int delrow =-1;delrow<=1;delrow++){
                for(int delcol =-1;delcol<=1;delcol++){
                    int nrow = ro+delrow;
                    int ncol = co+delcol;
                    // check if neighbour row and column is valid, and is an unvisited land
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && visited[nrow][ncol]==0){
                        visited[nrow][ncol]=1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
}