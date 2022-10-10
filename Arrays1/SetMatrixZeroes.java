// import java.util.HashSet;
// import java.util.Set;

// class SetMatrixZeroes {
//     public static void main(String[] args) {
//         int[][] matrix = {
//                 { 1, 1, 1 },
//                 { 1, 0, 1 },
//                 { 1, 1, 1 }
//         };
//         int row = matrix.length;
//         // length of 1st column
//         int col = matrix[0].length;
//         // created a new array and copy all elements from matrix to it.
//         int[][] arr = new int[row][col];
//         Solution(matrix,arr,row,col);
//         for(int i=0;i<matrix.length;i++){
//             for(int j=0;j<matrix[i].length;j++){
//                 System.out.print(matrix[i][j]+" ");
//             }
//             System.out.println(' ');
//         }
//     }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// //     private static void Solution(int[][] matrix,int[][]arr,int row , int col) {

// //         for (int i = 0; i < row; i++) {
// //             for (int j = 0; j < col; j++) {
// //                 arr[i][j] = matrix[i][j];
// //             }
// //         }
// //         // then we have to update the array
// //         for (int i = 0; i < row; i++) {
// //             for (int j = 0; j < col; j++) {
// //                 if (arr[i][j] == 0) {
// //                     zeromaker(matrix, row, col, i, j);
// //                 }
// //             }
// //         }

// //     }

// //     private static void zeromaker(int[][] matrix, int row, int col, int r, int c) {
// //         // making row elements 0
// //         for (int i = 0; i < col; i++) {
// //             matrix[r][i] = 0;
// //         }
// //         // making column elements 0
// //         for (int i = 0; i < row; i++) {
// //             matrix[i][c] = 0;
// //         }

// //     }
// // }

// class SetMatrixZeroes {
//     public static void main(String[] args) {
//         int[][] matrix = {
//                 { 1, 1, 1 },
//                 { 1, 0, 1 },
//                 { 1, 1, 1 }
//         };
//         Solution(matrix);
//     }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//     private static void Solution(int[][] matrix) {
//     int row = matrix.length;
//     int column = matrix[0].length;
//     Set<Integer> rows = new HashSet<>();
//     Set<Integer>cols = new HashSet<>();
//     for(int i=0;i<row;i++){
//         for(int j=0;j<column;j++){
//             if(matrix[i][j]==0){
//                 // here we are storing our row and column(that are having zeroes) in set . so that we can update it
//                 rows.add(i);
//                 cols.add(j);
//             }
//         }
//     }
//     for(int i =0;i<row;i++){
//         for(int j=0;j<column;j++){
//             // here we are   checking  for every row and col whether , present in set or not if yes than update it to
//             // 0
//             if(rows.contains(i) || cols.contains(j)){
//                 matrix[i][j] =0;
//             }
//         }
//     }
//     }
// }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


// class SetMatrixZeroes {
//     public static void main(String[] args) {
//         int[][] matrix = {
//                 { 1, 1, 1 },
//                 { 1, 0, 1 },
//                 { 1, 1, 1 }
//         };
//         Solution(matrix);
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[i].length; j++) {
//                 System.out.print(matrix[i][j] + " ");
//             }
//             System.out.println(' ');
//         }

//     }

//     private static void Solution(int[][] matrix) {
//        int m = matrix.length , n = matrix[0].length;
//        boolean isRow0 = false , isCol0 = false;
//        for(int j=0;j<n;j++){
//         if(matrix[0][j]==0) isRow0 = true;
//        } 
//        for(int i=0;i<m;i++){
//         if(matrix[i][0]==0) isCol0=true;
//        }
//        for(int i=1;i<m;i++){
//         for(int j=1;j<n;j++){
//            if(matrix[i][j]==0){
//             matrix[i][0] =0;
//             matrix[0][j] = 0;
//            }
//         }
//        }
//        for(int i=1;i<m;i++){
//         for(int j=1;j<n;j++){
//             if(matrix[0][j]==0 || matrix[i][0]==0) matrix[i][j]=0;
//         }
//        }
//        if(isRow0){
//         for(int j=0;j<n;j++) matrix[0][j]=0;
//        }
//        if(isCol0){
//         for(int i=0;i<m;i++) matrix[i][0] =0;
//        }
//     }
// }