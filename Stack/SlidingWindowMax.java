import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMax {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxwindow(nums,k)));
    }

    private static int[] maxwindow(int[] nums, int k) {
        
        // Brute force with Tc as O(n2) and Sc as O(n)
        // int[] ans = new int[nums.length-k+1];
        // int n = nums.length;
        // for(int i=0;i<=n-k;i++){
        //     int max = nums[i];
        //     for(int j =1;j<k;j++){
        //         max = Math.max(max,nums[i+j]);
        //     }
        //     nums[i] = max;
        // }
        // return ans;

        // Optimised approach using dqueue with Tc as O(n) and Sc as O(k)
        // Every time before entering a new element, we first need to check whether the element present
        //  at the front is out of bounds of our present window size. If so, we need to pop that out. 
        // Also, we need to check from the rear that the element present is smaller than the incoming element.
        //  If yes, there’s no point storing them and hence we pop them out. Finally, the element present
        //  at the front would be our largest element.

        int n = nums.length;
        int [] ans = new int[n-k+1];
        int index =0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            // remove numbers out of range k
            if(!q.isEmpty() && q.peek() == i-k){
                q.poll();
            }
            // remove smaller number sin k range as they are useless
            // peekLast will retrieve the last element of the queue but will not remove
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i]){
                // remove last element from queue
                q.pollLast();
            }
            q.offer(i);
            // finally add everything to my ans array
            if(i >= k-1){
                ans[index++] = nums[q.peek()];
            }
        }
        return ans;
    }
}
