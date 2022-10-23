import java.util.ArrayList;
// import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class SubsetSum2{
    public static void main(String[]args){
        int nums[]={1,2,2};
        List<String> ans = subsetsWithDup(nums);
        printAns(ans);
    }
    public static List < String > subsetsWithDup(int[] nums) {
        
    //     // Brute force with Time Complexity: O( 2^n *(k log (x) )) and Space Complexity:  O(2^n * k)
    
        List < String > ans = new ArrayList < > ();
        HashSet < String > res = new HashSet < > ();
        List < Integer > ds = new ArrayList < > ();
        fun(nums, 0, ds, res);
        for (String it: res) {
            ans.add(it);
        }
        return ans;
    }
    public static void fun(int[] nums, int index, List < Integer > ds, HashSet < String > res) {
        if (index == nums.length) {
            Collections.sort(ds);
            res.add(ds.toString());
            return;
        }
        ds.add(nums[index]);
        fun(nums, index + 1, ds, res);
        ds.remove(ds.size() - 1);
        fun(nums, index + 1, ds, res);
    }



// Optimised code with Time Complexity: O(2^n) and Space Complexity: O(2^n * k)
    // public static void findSubsets(int ind, int[] nums, List<Integer> ds, List<List<Integer>> ansList) {
    //     ansList.add(new ArrayList<>(ds)); 
    //     for(int i = ind;i<nums.length;i++) {
    //         if(i!=ind && nums[i] == nums[i-1]) continue; 
    //         ds.add(nums[i]); 
    //         findSubsets(i+1, nums, ds, ansList); 
    //         ds.remove(ds.size() - 1);
    //     }
        
    // }
    // public static List<List<Integer>> subsetsWithDup(int[] nums) {
    //     Arrays.sort(nums); 
    //     List<List<Integer>> ansList = new ArrayList<>(); 
    //     findSubsets(0, nums, new ArrayList<>(), ansList); 
    //     return ansList; 
    // }
    static void printAns(List<String> ans) {
        System.out.println("The unique subsets are ");
        System.out.println(ans.toString().replace(",", " "));
    }
}