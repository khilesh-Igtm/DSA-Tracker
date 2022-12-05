package MaxProductSubarr;
class BruteForce{
    public static void main(String[] args) {
        int[] nums = {1,2,-3,0,-4,-5};
        int answer = maxProduct(nums);
        System.out.println(answer);
    }

    private static int maxProduct(int[] nums) {
        // Time Complexity: O(N2)
        int result = nums[0];
        for(int i=0;i<nums.length-1;i++){
            int p = nums[i];
            for(int j =i+1;j<nums.length;j++){
                result = Math.max(result, p);
                p *= nums[j];
            }

            result = Math.max(result, p);
        }
        return result;
    }

    // private static int maxProduct(int[] nums) {
    //     // Time Complexity: O(N3)
    //     int result = Integer.MIN_VALUE;
    //     for(int i=0;i<nums.length-1;i++){
    //         for(int j =i+1;j<nums.length;j++){
    //             int prod = 1;
    //             for(int k =i;k<=j;k++){
    //                 prod *= nums[k];
    //             }
    //             result = Math.max(result, prod);
    //         }
    //     }
    //     return result;
    // }
}