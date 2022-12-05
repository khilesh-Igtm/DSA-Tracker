// Problem Statement: Given a row-wise sorted matrix of size r*c, where r is no. of rows and c is no. 
// of columns, find the median in the given matrix.
// Assume – r*c is odd

// Input: 
// r = 3 , c = 3
// 1 4 9 
// 2 5 6
// 3 8 7
// Output: Median = 5
// Explanation: If we find the linear sorted array, the array becomes 1 2 3 4 5 6 7 8 9
// So, median = 5

// Approach 1: Brute Force Approach
// Time Complexity: O(row*col log(row*col)) 
// Space Complexity: O(row*col) 
// The approach is very simple, just fill all elements in a linear array sort the array using the
//  sort function, and then find the middle value (Median). 
public class MedianRowSortedMatrix {
    public static void main(String[] args) {
        int row = 3, col = 3;
        int[][] arr = { { 2, 3, 5 },
                { 2, 3, 4 },
                { 1, 7, 9 } };
        System.out.println("The median of the row-wise sorted matrix is: " +
                findMedian(arr, row, col));

    }

    private static int findMedian(int[][] arr, int row, int col) {
        int low = 1;
        int high = row * col;
        int n = row;
        int m = col;
        while (low <= high) {
            int mid = (low + (high - low) / 2);
            int count = 0;
            // we starts traversing 3 times bcz we have 3 rows
            // so this will check in all the 3 rows that how many elements are there that is
            // smaller
            // then the mid
            for (int i = 0; i < n; i++) {
                count += countSmallerThanMid(arr[i], mid, col);
            }
            // we just check if our count is smaller / greater than mid(r*c/2) , then
            // accordingly
            // we collapse the matrix
            if (count <= (n * m) / 2)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    private static int countSmallerThanMid(int[] A, int mid, int n) {
        // here n is number of columns and we check in all row that how many items are
        // there
        // that is smaller than the mid using binary search in each row

        int l = 0, h = n - 1;
        while (l <= h) {
            int md = (l + (h - l) / 2);
            if (A[md] <= mid)
                l = md + 1;
            else
                h = md - 1;
        }
        return l;
    }
}
