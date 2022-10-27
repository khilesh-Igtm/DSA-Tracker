import java.util.LinkedList;
import java.util.Queue;

// Problem Statement: You will be given an m x n grid, where each cell has the following values : 

// 2  –  represents a rotten orange
// 1  –  represents a Fresh orange
// 0  –  represents an Empty Cell

// Every minute, if a Fresh Orange is adjacent to a Rotten Orange in 4-direction ( upward, downwards, right, and left )
//  it becomes Rotten.Return the minimum number of minutes required such that none of the cells has a Fresh Orange.
//  If it’s not possible, return -1.


// Tc is O(n * n) *4 for all 4 directions
// Sc is O(n*n)
public class RottenOranges {
    public static void main(String[] args) {
        int[][] arr = {{2,1,1},{1,1,0},{0,1,1}};
        int rotting = orangesRotting(arr);
        System.out.println("Minimum Number of Minutes Required"+rotting);
        
    }

    private static int orangesRotting(int[][] grid) {
        if(grid == null || grid.length ==0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        // put the position of all rotten oranges in queue 
        // count the number of fresh oranges
        for(int i=0;i<rows;i++){
            for(int j =0;j<cols;j++){
                // put all rotten oranges in the queue
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
                if(grid[i][j] != 0){
                    count_fresh++;
                }
            }
        }
        if(count_fresh ==0) return 0;
        // this will store my total time taken to rotten all oranges
        int countMin =0;
        // this will store my total oranges that has been rotten 
        // and if this cnt == count_frsh means all oranges has been rotten , if not return -1 
        // means there are some fresh oranges that hadn't been rotten
        int cnt =0;
        // coordinates of all the directions
        int [] dx = {0,0,1,-1};
        int [] dy = {1,-1,0,0};
        
        // bfs starting from initially rotten oranges
        while(!queue.isEmpty()){
            int size = queue.size();
            cnt += size;
            for(int i=0;i<size;i++){
                // this will remove the front element from the queue and store in point
                int[] point = queue.poll();
                // till 4 bcz there are only 4 directions
                for(int j =0;j<4;j++){
                    // this x and y will store the all direction of my rotten oranges
// dx[j] will have value ranges in int[] dx ={0,0,1,-1} means at j =0 , dx[0] will be 0 
// dy[j] will have value ranges in int[] dy ={1,-1,0,0} means at j =0 , dy[0] will be 1  
// and with chnages of j values it will check for all direction
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    // this is the base case for all direction means we have to rotten fresh one and should be in 
                    // the range
                    if(x<0 || y<0 || x>= rows || y>= cols || grid[x][y]==0 
                    || grid[x][y]==2) continue;
                    // make it rotten
                    grid[x][y] = 2;
                    queue.offer(new int[]{x,y});
                }
            }
            // if queue becomes empty then no further execution is required
            if(queue.size() !=0){
                countMin++;
            }
        }
        return count_fresh == cnt ? countMin : -1;


    }
}


// same answer as above but with some explanation of every line of code

// public int orangesRotting(int[][] grid) {
    
//     if(grid.length == 0)
//         return 0;
    
//     int row = grid.length;
//     int col = grid[0].length;
    
//     Queue<int[]> q = new LinkedList<>();        //to store the rotten oranges of the grid
//     int TotalOranges=0;                         //to get count of total oranges (rotten + Fresh)
    
//     for(int i=0;i<row;i++){                     //to traverse row
//         for(int j=0;j<col;j++){                 //to traverse each column
            
//             if(grid[i][j] == 2){                //if that orange is rotten, store it into the queue
//                 q.add(new int[]{i,j});
//             }
            
//             if(grid[i][j]!=0)                   //if that cell is not empty, then definitly have rotten or fresh orange
//                 TotalOranges++;                 //count increase by 1
            
//         }
//     }
    
//     if(TotalOranges==0) return 0;               //if there is no orange in grid, then there is no need to count how much time require!
    
//     //bfs
//     int min=0, rottedOranges=0;                 
//     int[] xAxis = {0,0,-1,1};                   // xAxis and yAxis array are use to move in adjacent cells that are one step up, down, left and right
//     int[] yAxis = {-1,1,0,0};                   // when the xAxis value is 0 and yAxis value is -1 then it means we move one step towards left
    
//     while(!q.isEmpty()){                        //while queue is not empty
//         int rottenSize = q.size();              //size of queue gives us the idea of rotten oranges(fresh conv. into rotten oranges, add into the queue)
//         rottedOranges += q.size();              //so how much amount of rotten oranges are present (or added into) the queue, keep count of it.
        
//         while(rottenSize>0){                    //in each pass we pop all the rotten oranges currently present in the queue & make adjacent fresh into
//             int[] rotten = q.poll();            //rotten and add into the queue in this while loop
//             for(int i=0; i<4; i++){             //According to problem statement, we to move one step in each directiom(up,down,left,right)
//                 int x = rotten[0] + xAxis[i];   //on whatever cell we are just add the xAxis & yAxis accordinly in row & col to move in all 4 direction
//                 int y = rotten[1] + yAxis[i];

//                 if(x<0 || x>=row || y<0 || y>=col || grid[x][y] == 0 || grid[x][y] == 2)        //Our boundary Condition, if we come out from the grid
//                     continue;

//                 grid[x][y] = 2;             //mark that orange as rotten
//                 q.add(new int[]{x,y});      //add into the queue

//             }
//             rottenSize--;                   //decrease the size of rottenOranges in the queue, because one is popped out from the queue
//         }
        
//         min++;                              //after each pass increase a minute
//     }
    
//     return (rottedOranges==TotalOranges )? min-1:-1;            //if rottedOranges are equal to TotalOranges then it means no fresh orange left, so return min else -1
    
// }