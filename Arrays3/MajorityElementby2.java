// import java.util.HashMap;
// import java.util.Map;

class MajorityElementby2{
    public static void main(String[] args) {
        int[] nums = {3,2,2,2};
        System.out.println(major(nums));
    }

    private static int major(int[] nums) {

        // brute force way of solving Tc is O(n2) and Sc is O(1).
        // if(nums.length == 1) return nums[0];
        // int max = nums.length/2;
        // int majority =0;
        // for(int i=0;i<nums.length-1;i++){
        //     int count = 1;
        //     for(int j = i+1;j<nums.length;j++){
        //         if(nums[i]==nums[j]) count++;
        //     }
        //     if(count>max) majority = nums[i];
        // }
        // return majority;

        // Using HashMap
        // Map<Integer,Integer> myMap = new HashMap<Integer,Integer>();
        // int result =0;
        // for(int num : nums){
        //     if(!myMap.containsKey(num)){
        //         myMap.put(num,1);
        //     }
        //     else{
        //         myMap.put(num,myMap.get(num)+1);
        //     }
        //     if(myMap.get(num)>nums.length/2){
        //         result = num;
        //         break;
        //     }
        // }

        // return result;

        ///////////////////////////////////////////////////////////////////////////////////////////
        /////// Moore's voting algo Tc is O(n) and O(1)
                int count = 0;
                int candidate = 0;
        
                for (int num : nums) {
                    if (count == 0) {
                        candidate = num;
                    }
                    if(num==candidate)
                    count += 1; 
                    else count -= 1; 
                }
        
                return candidate;
            }
        }
    
