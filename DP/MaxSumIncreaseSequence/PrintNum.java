package MaxSumIncreaseSequence;

import java.util.ArrayList;
import java.util.List;

// The time complexity of the above solution is O(n2) and requires O(n2) extra space,

public class PrintNum {
    public static void main(String[] args) {
        int[] nums = { 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11 };
        printMSIS(nums);
    }

    private static void printMSIS(int[] nums) {
        int n = nums.length;
        // base case
        if(n==0) return;
        // "MSIS[i]" stores the increasing subsequence having the max sum
        // that ends with "nums[i]".
        List<List<Integer>> MSIS = new ArrayList<>();
        for(int i =0;i<n;i++){
            MSIS.add(i,new ArrayList<>());
        }
        MSIS.get(0).add(nums[0]);
        // "sum[i]" stores the maximum sum of the increasing subsequence
        // that ends with "Nums[i]"
        int[] sum = new int[n];
        sum[0] = nums[0];
        // start from the second array element
        for(int i=1;i<n;i++){
            // do for each element in subarray "nums[0...i-1]"
            for(int j =0;j<i;j++){
                // find increasing subsequence with the max sum yhat ends with
                // "nums[j]" where nums[j] is less than current element "nums[i]"
                if(sum[i]<sum[j] && nums[i]>nums[j]){
                    //update increasing subsequence
                    MSIS.set(i, new ArrayList<>(MSIS.get(j)));
                    // update max sum
                    sum[i] = sum[j];
                }
            }
            // include the current element in increasing subsequence
            MSIS.get(i).add(nums[i]);
            // add the current element to the max sum
            sum[i] += nums[i];
        }
       
        // `j` will contain the index of MSIS
        int j = 0;
        for (int i = 1; i < n; i++)
        {
            if (sum[i] > sum[j]) {
                j = i;
            }
        }
 
        // print MSIS
        System.out.println(MSIS.get(j));
    }
}
