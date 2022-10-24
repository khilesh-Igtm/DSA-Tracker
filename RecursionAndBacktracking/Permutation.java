import java.util.ArrayList;
import java.util.List;

// import java.util.ArrayList;
// import java.util.List;

// class Permutation{
//     public static void main(String[] args) {
//         int[] arr = {1, 2, 3};
//         System.out.println(permute(arr));
//     }


//     ////////////////////////////////Using Extra Space //////////////////////////
//     ////////// Tc is O(N! * N) and Sc is O(N)

// //     public static List<List<Integer>> permute(int[] nums) {
// //         List<List<Integer>> result = new ArrayList<>();
        
// //         List<Integer> candidates = new ArrayList<>();
        
// //         for(int num : nums) {
// //             candidates.add( num );
// //         }
        
// //         permutes(candidates, new ArrayList<>(), result);
        
// //         return result;
// //     }
// //     private static void permutes(List<Integer> candidates, List<Integer> permutation, List<List<Integer>> result) {
        
// //         // Since no number is left for permutation, a permutation is generated
// //         if( candidates.isEmpty() ) {
// //             result.add( new ArrayList<>( permutation ) );
// //             return;
// //         }
        
// //         int n = candidates.size();
        
// //         for(int i=0; i<n; i++) {
// //             int num = candidates.get(i);
            
// //             // Fix the current number
// //             permutation.add( num );
            
// //             // Remove the current number from candidates
// //             candidates.remove( i );
            
// //             // And permute for remaining numbers
// //             permutes(candidates, permutation, result);
            
// //             // Add the number back to it's original index
// //             candidates.add(i, num );
            
// //             // Remove the number from the permutation
// //             permutation.remove( permutation.size() - 1 );
// //         }
// // }
// }

class Permutation{
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        permute(nums);
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0,nums,ans);
        return ans;
        
    }

    private static void recurPermute(int index, int[] nums, List<List<Integer>> ans) {
        if(index==nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(i,index,nums);
            recurPermute(index+1, nums, ans);
            swap(i,index,nums);
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}