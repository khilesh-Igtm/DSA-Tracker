// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Comparator;


// public class MergeInterval {
//     public static void main(String[] args) {
//         int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
//         System.out.println(Arrays.deepToString(Solution(intervals)));
//     }

//     private static int[][] Solution(int[][] intervals) {

//         ////////////////////////////////////////////////////////////////////////////////////////////////
//         /////////////////// O(nlogn) and Sc is O(n) using lambda expression for sorting

//         // // sort the array on the basis of starting interval
//         // Arrays.sort(intervals, (a,b)->a[0]-b[0]);
//         // // storing our final answer
//         // ArrayList<int[]> ans = new ArrayList<>();
//         // // after sorting , get the first interval and store it's starting and ending value in some variable. 
//         // int start = intervals[0][0];
//         // int end = intervals[0][1];
//         // // create a counter
//         // int i  = 1;
//         // while(i < intervals.length){
//         //     // start travering through all intervals starting from 1st index , as 0th index is already
//         //     // intialised and we need to compare our current intervals with the previous interval , and so for
//         //     // for 1st we have 0th.
//         //     int s = intervals[i][0];
//         //     int e = intervals[i][1];
//         //     // next interval start is smaller than prev end and array is sorted
//         //    // so these two internal can merge
//         //    if(s<=end){
//         //     // so merge both intervals
//         //     end = Math.max(end,e);
//         //    }
//         //    else{
//         //     // if merge not possible , then insert prev interval into list
//         //     ans.add(new int[]{start,end});
//         //     start = s;
//         //     end = e;

//         //    }
//         //    i++;

//         // }
//         // ans.add(new int[] {start,end});

//         //   return ans.toArray(new int[0][]);

//         ///////////////////////////////////////////////////////////////////////////////////////////////
//         //////// Using Comparator for sorting

//         // after comparaing we sorted them
//         Arrays.sort(intervals, new MySort());
//         // storing our final answer
//         ArrayList<int[]> ans = new ArrayList<>();
//         // after sorting , get the first interval and store it's starting and ending value in some variable. 
//         int start = intervals[0][0];
//         int end = intervals[0][1];
//         // create a counter
//         int i  = 1;
//         while(i < intervals.length){
//             // start travering through all intervals starting from 1st index , as 0th index is already
//             // intialised and we need to compare our upcoming intervals with the previous interval , and so for
//             // for 1st we have 0th.
//             int s = intervals[i][0];
//             int e = intervals[i][1];
//             // next interval start is smaller than prev end and array is sorted
//            // so these two internal can merge
//            if(s<=end){
//             // so merge both intervals
//             end = Math.max(end,e);
//            }
//            else{
//             // if merge not possible , then insert prev interval into list
//             ans.add(new int[]{start,end});
//             start = s;
//             end = e;

//            }
//            i++;

//         }
//         ans.add(new int[] {start,end});

//           return ans.toArray(new int[0][0]);

//     }
// }
// // created a new class Named as MySort which is implementing Comparator for comapring on the basis of starting interval
// class MySort implements Comparator<int[]>{  //comparator
//     public int compare(int[] a, int[] b){
//         return a[0]-b[0];
//     }

//     }

    