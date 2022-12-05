// import java.util.Arrays;

// Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K. The task is to find the
//  element that would be at the k’th position of the final sorted array.

public class KthElementTwoSortedArr {
    public static void main(String[] args) {
        int m = 5, n = 4;
        int[] arr1 = { 2, 3, 6, 7, 9 };
        int[] arr2 = { 1, 4, 8, 10 };
        int k = 5;
        System.out.println(kthelement(arr1, arr2, n, m, k));
    }

    private static int kthelement(int[] arr1, int[] arr2, int n, int m, int k) {
        // Extreme naive approach is use extra space and sorting
        // TC will be O(m+n)+ O(mlogn) and Sc is O(m+n).

        // int[] newarr = new int[n+m];
        // for(int i=0;i<n;i++){
        // newarr[i] = arr1[i];
        // }
        // for(int j=0;j<m;j++){
        // newarr[j+n] = arr2[j];
        // }
        // Arrays.sort(newarr);
        // return newarr[k-1];

        // Optimised naive approach
        // Time Complexity: O(k) and Sc is O(1)

        int p1 = 0, p2 = 0, counter = 0, answer = 0;
        while (p1 < m && p2 < n) {
            if (counter == k)
                break;
            else if (arr1[p1] < arr2[p2]) {
                // answer is need bcz this will store my answer at every moment
                answer = arr1[p1];
                p1++;
            } else {
                answer = arr2[p2];
                p2++;
            }
            counter++;
        }
        if (counter != k) {
            if (p1 != m - 1) {
                answer = arr1[k - counter];
            } else {
                answer = arr2[k - counter];
            }
        }
        return answer;

        // Optimal Approach using Binary search
        // Time Complexity : log(min(m,n)) and Sc as O(1)
        // if (m > n) {
        // return kthelement(arr2, arr1, m, n, k);
        // }
        // int low = Math.max(0, k - m), high = Math.min(k, n);
        // while (low <= high) {
        // int cut1 = (low + high) >> 1;
        // int cut2 = k - cut1;
        // int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
        // int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
        // int r1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1];
        // int r2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2];

        // if (l1 <= r2 && l2 <= r1) {
        // return Math.max(l1, l2);
        // } else if (l1 > r2) {
        // high = cut1 - 1;
        // } else {
        // low = cut1 + 1;
        // }
        // }
        // return -1;

    }
}
