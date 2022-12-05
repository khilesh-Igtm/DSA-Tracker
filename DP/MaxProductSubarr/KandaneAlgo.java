package MaxProductSubarr;

public class KandaneAlgo {
    public static void main(String[] args) {
        int nums[] = {1,2,-3,0,-4,-5};
		int answer = maxProductSubArray(nums);
		System.out.print("The maximum product subarray is: "+answer);
    }

    private static int maxProductSubArray(int[] nums) {
        // Time Complexity: O(N)
        int prod1 = nums[0]; // max positive product
        int prod2 = nums[0]; //mini negative product
        int result = nums[0]; // overall maximum product
        for(int i=1;i<nums.length;i++){
            int temp = Math.max(nums[i],Math.max(prod1 * nums[i],prod2*nums[i]));
            prod2 = Math.min(nums[i],Math.min(prod1* nums[i],prod2*nums[i]));
            prod1 = temp;
            result = Math.max(result,prod1);
        }
        return result;

        
    }
}
