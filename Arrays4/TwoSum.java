import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum{
    public static void main(String[] args) {
        int []nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(dosum(nums,target)));
    }

    private static int[] dosum(int[] nums, int target) {
        // for(int i=0;i<nums.length;i++){
        //     for(int j =i+1;j<nums.length;j++){
        //         if(nums[i]+nums[j]==target){
        //             return new int[]{nums[i],nums[j]};
        //         }
        //     }
        // }
        // return new int[]{};

        ///////////////////////////////////////////////////////////////////////////////
        /// 

        // Arrays.sort(nums);
        // int i = 0;
        // int j = nums.length - 1;
 
        // while (i < j) {
        //     if (nums[i] + nums[j] == target)
        //         return new int[]{nums[i],nums[j]};
        //     else if (nums[i] + nums[j] < target)
        //         i++;
        //     else
        //         j--;
        // }
        // return new int[]{};


        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { complement, nums[i] };
            } else {
                numMap.put(nums[i], i);
            }
        }
        return new int[] {};
    }
}