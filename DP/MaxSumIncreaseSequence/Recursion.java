package MaxSumIncreaseSequence;

public class Recursion {
    public static void main(String[] args) {
        int[] nums = { 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11 };
 
        System.out.println("The maximum sum of the increasing subsequence is " +
                        MSIS(nums, 0, Integer.MIN_VALUE, 0));
    }

    private static int MSIS(int[] nums, int i, int prev, int sum) {
        // base case: nothing is remaining
        if(i == nums.length){
            return sum;
        }
        // case 1: exclude the current element and process the remaining 
        //elements or not take
        int exclude = MSIS(nums, i+1, prev, sum);

        //case 2: include the current element if it is greater than the previous element
        // or take
        int include = sum;
        if(nums[i]>prev){
            include = MSIS(nums, i+1,nums[i], sum+nums[i]);
        }
        //return the maximum of the take and not take
        return Math.max(exclude, include);

    }
}
