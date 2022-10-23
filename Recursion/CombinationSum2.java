import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// return all possible combination that sums equals to the target and that should be uniue.
//  Tc will be O(2^n *k) and Sc will be O(k*n)
class CombinationSum2{
    public static void main(String[] args) {
        int v[]={10,1,2,7,6,1,5};
        List < List < Integer >> comb = combinationSum2(v, 8);
        System.out.println(comb.toString().replace(",", " "));
    }

    private static List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        findcombination(0,arr,target,ans,new ArrayList<>());
        return ans;
        
    }

    private static void findcombination(int index, int[] arr, int target, List<List<Integer>> ans,List<Integer> ds ) {
        if(target ==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;
            ds.add(arr[i]);
            // check for next possible combination till depth here dfs is used internally
            findcombination(index+1, arr, target-arr[i], ans, ds);
            // backtrack i.e we reached depth and now no other possible combination is there, so backtrack and remove the element
            ds.remove(ds.size()-1);
        }
    }
}