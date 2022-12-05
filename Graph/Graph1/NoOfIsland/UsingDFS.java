package NoOfIsland;

public class UsingDFS {
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
    int n ,m;
    public int numIslands(char[][]grid){
        int count =0;
        n = grid.length;
        if(n==0) return 0;
        m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    DFSmarking(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    private void DFSmarking(char[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]!= '1') return;
        grid[i][j] ='0';
        DFSmarking(grid, i+1, j);
        DFSmarking(grid, i-1, j);
        DFSmarking(grid, i, j+1);
        DFSmarking(grid, i, j-1);
    }
}
