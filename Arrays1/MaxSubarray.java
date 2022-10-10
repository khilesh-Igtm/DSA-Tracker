public class MaxSubarray {
    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(Solution(nums,0,nums.length-1));
    }

    private static int Solution(int[] nums,int start , int end) {


        ////////////////////////////////////////////////////////////////////////////
        ////////////////// 2nd Approach Divide and Conquer O(nlogn)
        if(start== end) return nums[start];
        int mid = start + (end-start)/2;
        int leftMax = Solution(nums,start,mid);
        int rightMax = Solution(nums, mid+1, end);
        int arrMax = findMaxCrossSum(nums,start,mid,end);
        return Math.max(leftMax,Math.max(rightMax, arrMax));
    }
        private static int findMaxCrossSum(int[] nums, int start, int mid, int end) {
           int lSum =0, lMax = Integer.MIN_VALUE;
           for(int i=mid;i>=start;i--){
            lSum += nums[i];
            lMax = Math.max(lMax, lSum);
           }
           int rSum =0, rMax = Integer.MIN_VALUE;
           for(int i=mid+1;i<=end;i++){
            rSum += nums[i];
            rMax = Math.max(rMax, rSum);
           }
           return lMax+rMax;
        }

        //////////////////////////////////////////////////////////////////
        ////////// Brute force O(n2)

        // int max = Integer.MIN_VALUE;
        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        //     int sum = 0;
        //     for (int j = 0; j < n; j++) {
        //         sum += nums[j];
        //         if (sum < 0)
        //             sum = 0;
        //         if (sum > max)
        //             max = sum;

        //     }

        // }
        // return max;

        ////////////////////////////////////////////////////////////////////
        ///////// Kandane's algo (DP Approach) O(n)
        // int n = nums.length;
        // int max = Integer.MIN_VALUE, sum = 0;

        // for(int i=0;i<n;i++){
        // sum += nums[i];
        // max = Math.max(sum,max);

        // if(sum<0) sum = 0;
        // }

        // return max;

    

    
}
