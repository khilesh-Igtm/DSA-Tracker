// import java.util.ArrayList;

// // Divide and Conquer
// // The idea is based on the divide and conquer strategy.  We take pairs of arrays at each
// //  step. Then merge the pairs using the two-pointer technique of merging two sorted 
// // arrays. Thus, after merging all the pairs, the number of arrays will reduce by half. 

// // We will continue this till the number of remaining arrays doesn’t become 1. 

// // Algorithm:

// // Create a recursive function which takes ‘K’ arrays and returns the output array.
// // In the recursive function, if the value of ‘K’ is 1 then return the array else if
// //  the value of ‘K’ is 2 then merge the two arrays in linear time using two-pointers and
// //  return the merged array.
// // If the value of ‘K’ is greater than 2, then divide the group of ‘K’ arrays into two 
// // equal halves and recursively call the function, i.e 0 to K/2 array in one recursive 
// // function and K/2 to ‘K’ array in another recursive function.
// // Return the output array.
// // Tc as O(nk *logk)
// // Sc as O((N * K )* log(K))

// public class BetterApproach {
//     public static void main(String[] args) {
//         int[][] arr = { { 2, 6, 12, 34 },
//                 { 1, 9, 20, 1000 },
//                 { 23, 34, 90, 2000 } };
//         int K = 4;
//         mergeKSortedArrays(arr, K);
//     }

//     // this function will call the helper function that is executing the whole code
//     public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
//         ArrayList<Integer> result = mergeKSortedArraysHelper(kArrays, 0, k - 1);
//         return result;
//     }

//     // Main code part where we will do merge sort /divide and conquer
//     private static ArrayList<Integer> mergeKSortedArraysHelper(ArrayList<ArrayList<Integer>> kArrays, int start,
//             int end) {
//         // If there is only one array return that array
//         if (start == end) {
//             return kArrays.get(start);
//         }
//         // If there are only two arrays , merge them and return them
//         if (start + 1 == end) {
//             return merge(kArrays.get(start), kArrays.get(end));
//         }
//         // but in case there are more than 2 array then recurvely call this function and merge 2 array at
//         // a time
//         // for that calculate mid at 1st
//         int mid = start + (end - start) / 2;
//         // Divide the arrays into two halves . Do simple merge sort technique
//         // left half of array
//         ArrayList<Integer> first = mergeKSortedArrays(kArrays, start, mid);
//         // right half of an array
//         ArrayList<Integer> second = mergeKSortedArrays(kArrays, mid + 1, end);
//         // Return the final merged array
//         return merge(first, second);
//     }

//     // after dividing the array into the smallest part and if they can't be divided further more
//     // then sort and merge them
//     private static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
//         ArrayList<Integer> ans = new ArrayList<>();
//         // size of 1st and 2nd half of the array
//         int n = a.size(), m = b.size();
//         int i = 0, j = 0;
//         // Traverse the both arrays
//         while (i < n && j < m) {
//             // merge in sorted order and store in the arraylist of our answer
//             if (a.get(i) < b.get(j)) {
//                 ans.add(a.get(i));
//                 i++;
//             } else {
//                 ans.add(b.get(j));
//                 j++;
//             }
//         }
//         // Add remaining elements of the first array.
//         while (i < n) {
//             ans.add(a.get(i));
//             i++;
//         }
//         // Add remaining elements of the second array.
//         while (j < m) {
//             ans.add(b.get(j));
//             j++;
//         }

//         return ans;
//     }

// }
