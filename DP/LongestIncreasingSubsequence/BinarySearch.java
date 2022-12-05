package LongestIncreasingSubsequence;

// // TC = O(n logn)
// SC = O(n)
import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        lengthOfLIS(nums);
    }

    private static int lengthOfLIS(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > ans.get(ans.size() - 1))
                ans.add(nums[i]);
            else {
                int j = binSearch(ans, nums[i]);
                ans.add(j, nums[i]);
            }
        }
        return ans.size();

    }

    private static int binSearch(List<Integer> ans, int val) {
        int low = 0;
        int high = ans.size() - 1;
        while (high > low) {
            int mid = low + (high - low) / 2;
            if (ans.get(mid) < val)
                low = mid + 1;
            else
                high = mid;
        }
        return high;
    }
}
