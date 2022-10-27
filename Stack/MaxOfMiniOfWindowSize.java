import java.util.Stack;

public class MaxOfMiniOfWindowSize {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        // maxMinWindow(arr, 4);
        maxminwind(arr, 4);
    }

    // private static int[] maxMinWindow(int[] arr, int n) {

    //     // Brute Force
    //     // We will use two nested loops for sliding on the window of every possible size
    //     // and one more inner loop to traverse on the window and store the minimum
    //     // element of the current window in a ‘temp’ variable.
    //     // We will create an array named ‘answer’. The ‘answer[i]’ will store the
    //     // maximum of all the available minimum of every window size ‘i’.
    //     // If ‘i’ and ‘j’ are the starting and ending indexes of the window then its
    //     // length = j-i+1.
    //     // So we update our ‘answer[length]’ with the maximum of all the available
    //     // minimum of every window size ‘i’ with the help of a ‘temp’ variable
    //     // i.e, ‘answer[length]’ = max( answer[length] , temp ).
    //     // Tc is O(n3) and Sc is O(1)
    //     int[] ans = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         ans[i] = Integer.MIN_VALUE;
    //     }
    //     // Sliding on all possible windows
    //     // we are getting all possible windows , so for that 2 loops are required
    //     for (int i = 0; i < n; i++) {
    //         for (int j = i; j < n; j++) {
    //             // start is the starting index of current window
    //             int start = i;
    //             // end is the ending index of current window
    //             int end = j;
    //             // temp will store minimum element for the current window
    //             int temp = Integer.MAX_VALUE;
    //             // this loop is for traversing in the window
    //             // and find minimum element in the current window
    //             for (int k = start; k <= end; k++) {
    //                 temp = Math.min(temp, arr[k]);
    //             }
    //             int length = end - start;
    //             // and from all minimum element find the max
    //             // update the answer of current window length
    //             ans[length] = Math.max(ans[length], temp);
    //         }
    //     }
    //     return ans;
    // }

    private static int[] maxminwind(int[] arr, int n) {
        // ans[i] will store the maximum of minimum of every window of size 'i'
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Integer.MIN_VALUE;
        }
        // next[i] will store the index of next smaller element which lie on the right
        // hand side of 'i'.
        int[] next = nextSmaller(arr, n);
        // prev[i] will store the index of previous smaller element which lie on the
        // left hand side of 'i'.
        int[] prev = previousSmaller(arr, n);
        for (int i = 0; i < n; i++) {
            // length of window in which a[i] is minimum
            int length = next[i] - prev[i] - 1;
            ans[length - 1] = Math.max(ans[length - 1], arr[i]);

        }
        // some entries in answer[] may not be filled yet.
        // we fill them by taking maximum elemeent from suffix starting from 'i'
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        return ans;

    }

    private static int[] previousSmaller(int[] arr, int n) {
        int[] prev = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<n;i++){
            // check is empty stack and top of stack is > then current elemennt
            while(!s.empty() && arr[s.peek()]>= arr[i]){
                s.pop();
            }
            // if stack is empty i.e at starting 
            if(s.empty()) prev[i] =-1;
            // add to list
            else prev[i] = s.peek();
            // push element in stack
            s.push(i);
        }
        return prev;
    }

    private static int[] nextSmaller(int[] arr, int n) {
        Stack<Integer> s = new Stack<>();
        int[] next = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>= arr[i]){
                s.pop();
            }
            if(s.empty()) next[i] = n;
            else next[i] = s.peek();
            s.push(i);
        }
        return next;
    }
}