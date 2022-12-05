package NoOfIsland;

// if we don't have to consider the diagonall
import java.util.LinkedList;
import java.util.Queue;

public class BFSNotDiagonal {
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
    public int numIslands(char[][] grid){
        if(grid==null || grid.length==0){
            return 0;
        }
        int m= grid.length;
        int n = grid[0].length;
        boolean[][]marked = new boolean[m][n];
        int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
        int count =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!marked[i][j] && grid[i][j]=='1'){
                    bfs(i,j,grid,marked,direction);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(int i, int j, char[][] grid, boolean[][] marked, int[][] direction) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        marked[i][j] = true;
        while(!queue.isEmpty()){
            // pair of row and col will be storeed here
            int[] curr = queue.poll();
            for(int[] dir: direction){
                int x = curr[0]+dir[0];
                int y = curr[1] + dir[1];
                if(x>=0 && x<m && y>=0 && y<n){
                    if(!marked[x][y] && grid[x][y]=='1'){
                        queue.offer(new int[]{x,y});
                        marked[x][y] = true;
                    }
                }
            }
        }
    }
}
