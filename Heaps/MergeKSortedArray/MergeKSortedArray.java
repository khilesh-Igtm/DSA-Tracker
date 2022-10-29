
// import java.util.Arrays;

// public class MergeKSortedArray {
//     public static void main(String[] args) {
//         // convert to arraylist
//         int[][] arr = { { 2, 6, 12, 34 },
//                 { 1, 9, 20, 1000 },
//                 { 23, 34, 90, 2000 } };
//         int K = 4;
//         mergeKArrays(arr, K);
//     }

  
//     private static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
//    Time Complexity: O(N * K * log (N*K)), Since the resulting array is of size N*K.
// Space Complexity: O(N * K), The output array is of size N * K.
//         ArrayList<Integer> output = new ArrayList<>();
//         // traverse the matrix
//         for (int i = 0; i < K; i++) {
//             for (int j = 0; j < arr[i].length; j++) {
//                output.add(arr[i][j]);

//             }
//             // collection is used for sorting arraylist and Arrays.sort is for array.
// Collections.sort(output);
//         }
//         return output;
//     }
// }
