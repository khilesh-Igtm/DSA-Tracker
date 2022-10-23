import java.util.ArrayList;
import java.util.List;

// Input: array = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation: 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7. These are the only two combinations.

public class CombinationSum {
    public static void main(String[] args) {
        int arr[] = {2,3,6,7};
        int target = 7;
        Solution sol = new Solution();
        List < List < Integer >> ls = sol.combinationSum(arr, target);
        System.out.println("Combinations are: ");
        for (int i = 0; i < ls.size(); i++) {
            for (int j = 0; j < ls.get(i).size(); j++) {
                System.out.print(ls.get(i).get(j) + " ");
            }
            System.out.println();
    }
}
}
class Solution{

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List < List < Integer >> ans = new ArrayList < > ();
        findCombinations(0, candidates, target, ans, new ArrayList < > ());
        return ans;
    }

    private void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer>ds) {
        if(ind == arr.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[ind]<= target){
            ds.add(arr[ind]);
            findCombinations(ind, arr, target-arr[ind], ans, ds);
            ds.remove(ds.size()-1);
        }
        findCombinations(ind+1, arr, target, ans, ds);
    
    
    }
    

}