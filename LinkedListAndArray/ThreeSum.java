import java.util.ArrayList;
import java.util.Arrays;

// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
//  such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.



class ThreeSum{
    public static void main(String[] args) {
        int arr[]={-1,0,1,2,-1,-4};
        // ArrayList < ArrayList < Integer >> ans;
        threeSum(arr);
    }

    private static ArrayList<ArrayList<Integer>> threeSum(int[] arr) {
        
        // Brute force way with Tc as O(n3) and Sc as O(1). Output space is not considered
        // and in this case we are not handling the duplicates too 
    
        // ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        // int i , j, k;
        //   if (nums.length < 3)
        // return ans;
        // for(i=0;i<arr.length-2;i++){
        //     for(j =i+1;j<arr.length-1;j++){
        //         for(k=j+1;k<arr.length;k++){
        //             ArrayList<Integer> temp = new ArrayList<>();
        //             if(arr[i]+arr[j]+arr[k]==0  && i != j && i != k && j != k){
        //                 temp.add(arr[i]);
        //                 temp.add(arr[j]);
        //                 temp.add(arr[k]);
        //             }
        //             if(temp.size()!=0){
        //                 ans.add(temp);
        //             }
        //         }
        //     }

        // }
        // return ans;


        // Optimised Approach with Tc as O(n2) and O(1)
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=0;i<arr.length-2;i++){
            // checking for duplicate elements and avoiding them
            if(i==0 || (i>0 && arr[i] != arr[i-1])){
                int low = i+1, high = arr.length-1, sum =0-arr[i];
                while(low<high){
                    if(arr[low]+arr[high]==sum){
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[low]);
                        temp.add(arr[high]);
                        result.add(temp);

                        while(low<high && arr[low]==arr[low+1]) low++;
                        while(low <high && arr[high]==arr[high-1]) high--;
                        low++;
                        high--; 
                    }else if(arr[low]+arr[high]<sum) low++;
                    else high--;
                }
            }
        }
        return result;



    }
       
    
    
}