//  import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int arr1[] = { 1, 4, 7, 8, 10 };
        int arr2[] = { 2, 3, 9 };
        merge(arr1, arr2, arr1.length, arr2.length);
        System.out.println("After merge:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }

    // Using this approach Tc will be O(mlogn) + O(n)+O(n) and Sc is O(n)

    // private static void merge(int[] arr1, int[] arr2, int n, int m) {
    // int[] arr3 = new int[n + m];
    // int k = 0;
    // for (int i = 0; i < n; i++) {
    // arr3[k++] = arr1[i];
    // }
    // for (int i = 0; i < m; i++) {
    // // value of k is n+1 here , so arr3 will start filling from n+1 index
    // arr3[k++] = arr2[i];
    // }
    // Arrays.sort(arr3);
    // k = 0;
    // for (int i = 0; i < n; i++) {

    // arr1[i] = arr3[k++];
    // }
    // // k value becomes n+1 , so from n+1 value of arr3 will be placed in arr2.
    // for (int i = 0; i < m; i++) {
    // arr2[i] = arr3[k++];
    // }
    // }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////// Two Pointer or Optimised approach

    // Intuition: We can think of Iterating in arr1 and whenever we encounter an
    // element that is greater than the
    // first element of arr2, just swap it. Now rearrange the arr2 in a sorted
    // manner, after completion of
    // the loop we will get elements of both the arrays in non-decreasing order.
    // Here we will use insertion sort for rearranging the arr2 in sorted manner.

    // Time complexity is O(m*n) bcz 1st we are trvaersing through the array and
    // then
    // we are sorting this 2nd array. And Sc is O(1)

    // private static void merge(int[] arr1, int[] arr2, int n, int m) {
    // int i, k;
    // for (i = 0; i < n; i++) {
    // // take first element from arr1 compare it with first element of second array
    // if
    // // condition match, then swap
    // if (arr1[i] > arr2[0]) {
    // int temp = arr1[i];
    // arr1[i] = arr2[0];
    // arr2[0] = temp;
    // }

    // // then sort the second array put the element in its correct position so that
    // // next cycle can swap elements correctly
    // int first = arr2[0];
    // // insertion sort is used here
    // for (k = 1; k < m && arr2[k] < first; k++) {
    // arr2[k - 1] = arr2[k];
    // }
    // arr2[k - 1] = first;
    // }
    // }

    // ////////////////////////////////////////////////////////////////////////////////
    ///// Another Appproach / Gap Method
    // Time complexity: O(n+m) Space Complexity: O(1)

    private static void merge(int[] arr1, int[] arr2, int n, int m) {
        int gap = (int) Math.ceil((double) (n + m) / 2.0);
        while (gap > 0) {
            int i = 0;
            int j = gap;
            while (j < (n + m)) {
                if (j < n && arr1[i] > arr1[j]) {
                    swap(arr1[i], arr1[j]);
                } else if (j >= n && i < n && arr1[i] > arr2[j - n]) {
                    swap(arr1[i], arr2[j - n]);
                } else if (j >= n && i >= n && arr2[i - n] > arr2[j - n]) {
                    swap(arr2[i - n], arr2[j - n]);
                }
                j++;
                i++;
            }
            if (gap == 1) {
                gap = 0;
            } else {
                gap = (int) Math.ceil((double) gap / 2.0);
            }
        }

    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

    }

}
