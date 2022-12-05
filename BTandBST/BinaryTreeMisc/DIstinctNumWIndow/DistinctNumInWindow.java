package DIstinctNumWIndow;

// “Given an array of integers and a number K. Find the count of distinct elements in every window of size K in the array.”

// Input: 
// K=4,
// array[] = {1,2,1,3,4,2,3}
// Output: 3  4  3  3
// Explanation:
// First window is {1, 2, 1, 3}, count of distinct numbers is 3
// Second window is {2, 1, 3, 4} count of distinct numbers is 4
// Third window is {1, 3, 4, 2} count of distinct numbers is 4
// Fourth window is {3, 4, 2, 3} count of distinct numbers is 3


// Time complexity: O(N * K2)
// Space Complexity: O(1) 

public class DistinctNumInWindow {
    public static void main(String[] args) {
    int arr[] = { 1, 2, 1, 3, 4, 2, 3 }, k = 4;
    int n = arr.length;
    countDistinct(arr, n, k);
    }

    private static void countDistinct(int[] arr, int n, int k) {
        // traverse through every window
        for (int i = 0; i <= n - k; i++)
        // For the given array, traverse through from index 0 to n-k(to avoid array out of bound exception).
        // and then traverse array from i to i+k.
        System.out.print(windows(arr,i, k)+" ");
    }

    //check the distinct elements in the window
    private static int windows(int[] arr, int num, int k) {
        int count =0;
        for(int i= num;i<num+k;i++){
            // Check if element arr[i] exists in arr[0..i-1]
            int j;
            for(j=num;j<num+k;j++){
                if(arr[i]==arr[j]){
                    break;
                }
            }
            if(j==i) count++;
        }
        return count;
    }
}
