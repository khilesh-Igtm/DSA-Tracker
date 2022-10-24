// import java.util.ArrayList;



// public class NQueenOptimised {
//     public static void main(String[] args) {
//         int N = 4;
//         ArrayList<List<String>> queen = solveQueens(N);
//         int i=1;
//         for(List<String> it : queen){
//             System.out.println("Arrangements "+i);
//             for(String s : it){
//                 System.out.println(s);
//             }
//             System.out.println();
//             i +=1;
//         }
        
//     }

//     private static ArrayList<List<String>> solveQueens(int n) {
//         char[][] board = new char[n][n];
//         for(int i=0;i<n;i++){
//             for(int j =0;j<n;j++){
//                 board[i][j] = '.';
//             }
//         }
//         ArrayList<List<String>> res = new ArrayList<List<String>>();
//         int []leftRow = new int[n];
//         int upperDiag[] = new int[2* n-1];
//         int lowerDiag[] = new int[2* n-1];
//         solve(0,board,res,leftRow,lowerDiag,upperDiag);
//         return res;
//     }

//     private static void solve(int col, char[][] board, ArrayList<List<String>> res, int[] leftRow, int[] lowerDiag,
//             int[] upperDiag) {
//                 if(col == board.length){
//                     res.add(construct(board));
//                     return;
//                 }
//                 for(int row=0;row<board.length;row++){
//                     if(leftRow[row] ==0 && lowerDiag[row+col]==0 && upperDiag[board.length-1+col-row]==0){
//                         board[row][col] = 'Q';
//                         leftRow[row] =1;
//                         lowerDiag[row+col] =1;
//                         upperDiag[board.length-1+col-row] =1;
//                         solve(col+1, board, res, leftRow, lowerDiag, upperDiag);
//                         board[row][col] ='.';
//                         leftRow[row] =0;
//                         lowerDiag[row+col] = 0;
//                         upperDiag[board.length-1+col-row]=0;
//                     }
//                 }
//     }

//     private static List<String> construct(char[][] board) {
//         List<String>res = new List<String>();
//         for(int i=0;i<board.length;i++){
//             String s = new String(board[i]);
//             res.add(s);
//         }
//         return res;
//     }
    

// }
