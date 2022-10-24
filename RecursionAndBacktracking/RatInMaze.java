import java.util.ArrayList;

public class RatInMaze {
    public static void main(String[] args) {
        int n = 4;
        int[][] a = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };

        Solution obj = new Solution();
        ArrayList<String> res = obj.findPath(a, n);
        if (res.size() > 0) {
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }
}

class Solution {

    // public ArrayList<String> findPath(int[][] m, int n) {
    // int vis[][] = new int[n][n];
    // for(int i=0;i<n;i++){
    // for(int j =0;j<n;j++){
    // vis[i][j]=0;
    // }
    // }
    // ArrayList<String> ans = new ArrayList<>();
    // if(m[0][0]==1) solve(0,0,m,n,ans,"",vis);
    // return ans;
    // }

    // private void solve(int i, int j, int[][] a, int n, ArrayList<String> ans,
    // String move, int[][] vis) {
    // if(i== n-1 && j==n-1){
    // ans.add(move);
    // return;
    // }

    // // downward
    // if(i+1 <n && vis[i+1][j] ==0 && a[i+1][j]==1){
    // vis[i][j]=1;
    // solve(i+1,j,a,n,ans,move+'D',vis);
    // vis[i][j]=0;
    // }

    // // left
    // if(j-1>=0 && vis[i][j-1]==0 && a[i][j-1]==1){
    // vis[i][j]=1;
    // solve(i, j-1, a, n, ans, move+'L', vis);
    // vis[i][j]=0;
    // }

    // // right
    // if(j+1<n && vis[i][j+1]==0 && a[i][j+1]==1){
    // vis[i][j]=1;
    // solve(i, j+1, a, n, ans, move+'R', vis);
    // vis[i][j]=0;
    // }

    // // upward
    // if (i - 1 >= 0 && vis[i - 1][j] == 0 && a[i - 1][j] == 1) {
    // vis[i][j] = 1;
    // solve(i - 1, j, a, n, ans, move + 'U', vis);
    // vis[i][j] = 0;
    // }

    // }

    // Above was long solution with extra line of code .
// Time Complexity: O(4^(m*n)), Space Complexity:  O(m*n)
    public ArrayList<String> findPath(int[][] m, int n) {
        int vis[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = 0;
            }
        }
        int di[] = {+1,0,0,-1};
        int dj[] = {0,-1,1,0};
        ArrayList<String> ans = new ArrayList<>();
        if (m[0][0] == 1)
            solve(0, 0, m, n, ans, "", vis, di, dj);
        return ans;
    }

    private static void solve(int i, int j, int a[][], int n, ArrayList<String> ans, String move,int vis[][], int di[], int dj[]) {
        // at last index
        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }
        String dir = "DLRU";
        // check for all cases of down , left , right and up
        for (int ind = 0; ind < 4; ind++) {
            int nexti = i + di[ind];
            int nextj = j + dj[ind];
            // checking if not visited and movement is possible as given in question that can't move there is 0 in array.
            if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n &&
                    vis[nexti][nextj] == 0 && a[nexti][nextj] == 1) {

                vis[i][j] = 1;
                solve(nexti, nextj, a, n, ans, move + dir.charAt(ind), vis, di, dj);
                vis[i][j] = 0;

            }
        }
    }

}