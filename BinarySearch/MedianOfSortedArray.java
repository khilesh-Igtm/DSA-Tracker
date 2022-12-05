// Problem Statement: Given two sorted arrays arr1 and arr2 of size m and n respectively, return the median of the two sorted arrays.
class MedianOfSortedArray {
    public static void main(String[] args) {
        int arr1[] = { 1, 4, 7, 10, 12 };
        int arr2[] = { 2, 3, 6, 15 };
        int m = arr1.length;
        int n = arr2.length;
        System.out.print("The Median of two sorted array is ");
        System.out.println( median(arr1, arr2, m, n));
    }

    private static Object median(int[] arr1, int[] arr2, int m, int n) {
        // Naive Approach is using Merge sort
        // Tc as O(m+n) and Sc as O(m+n)
        // Take two pointers, each pointing to each array. Take an array of size (m+n)
        // to store the final sorted
        // array. If the first pointed element is smaller than the second one, store
        // that value in an array and
        // move the first pointer ahead by one. Else do the same for the second pointer
        // when the case is vice-versa.
        // Then use the formula to get the median position and return the element
        // present at that position.

        // Optimised Naive Approach / Better Approach
        // Tc as O(m+n) and Sc as O(1)
        // Similar to the naive approach, instead of storing the final merged sorted
        // array, we can keep a counter
        // to keep track of the required position where the median will exist. First,
        // using the median formula, get
        // a position where the median will exist. Then, follow the above approach and
        // instead of storing elements
        // in another array, we will increase the counter value. When the counter value
        // is equal to the median
        // positions, return element.

        // Optimised approach using Binary search
        // Tc is O(log(min(m,n))) and Sc is O(1)
        if (m > n) {
            // ensuring that binary search happens on minimum size array
            return median(arr2, arr1, n, m);
        }
        int low = 0, high = m, medianPos = ((m + n) + 1) / 2;
        while (low <= high) {
            int cut1 = (low + high) >> 1;
            int cut2 = medianPos - cut1;
            // it's 0 based indexing that's why i did cut1-1.
            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = (cut1 == m) ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = (cut2 == n) ? Integer.MAX_VALUE : arr2[cut2];

            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 != 0) {
                    return Math.max(l1, l2);
                } else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            } else if (l1 > r2)
                high = cut1 - 1;
            else
                low = cut1 + 1;

        }
        return 0.0;
    }

}