// You are given a sorted array consisting of only integers where every element appears exactly twice,
//  except for one element which appears exactly once.

// Return the single element that appears only once.

// Your solution must run in O(log n) time and O(1) space.

public class SingleElementSortedArr {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        unique(nums);
    }

    private static int unique(int[] nums) {
        // brute force way is to use XOR of all element and we will get unique element
        // tc will be O(n) and Sc will be O(1)

        // Optimised is using Binary search Tc is O(log n) and Sc is O(1)
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // for even index
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) ||
            // for odd index
             (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
