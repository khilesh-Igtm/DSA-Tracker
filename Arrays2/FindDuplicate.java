// import java.util.Arrays;

class FindDuplicate{
    public static void main(String[] args) {
        int arr[] = {1,3,4,2,2};
        System.out.println("The duplicate element is " + findDuplicate(arr));
    }

    private static int findDuplicate(int[] arr) {
        // Brute force Time Complexity:O(Nlogn + N) and Sc is O(1)
        // int n = arr.length;
        // Arrays.sort(arr);
        // for (int i = 0; i < n - 1; i++) {
        //     if (arr[i] == arr[i + 1]) {
        //         return arr[i];
        //     }
        // }
        // return 0;

// Frequency Approach Time Complexity: O(N), and Sc is O(n)
        // int n = arr.length;
        // int freq[] = new int[n + 1];
        // for (int i = 0; i < n; i++) {
        //     if (freq[arr[i]] == 0) {
        //         freq[arr[i]] += 1;
        //     } else {
        //         return arr[i];
        //     }
        // }
        // return 0;


        // Linked List cycle approach
        // Tc is O(n) and Sc is O(1)
        int slow = arr[0];
        int fast = arr[0];
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        fast = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }
}