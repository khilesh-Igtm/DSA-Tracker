import java.util.ArrayList;
import java.util.Collections;

class SubsetSum{
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(1);
        arr.add(2);
        ArrayList<Integer> ans = subsetSums(arr,arr.size());
        Collections.sort(ans);
        System.out.println("The sum of each subset is ");
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }

    private static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> sumSubset = new ArrayList<>();
        subsetSumHelper(0,0,arr,N,sumSubset);
        Collections.sort(sumSubset);
        return sumSubset;
    }

    private static void subsetSumHelper(int index, int sum, ArrayList<Integer> arr, int n, ArrayList<Integer> sumSubset) {
        if(index == n){
            sumSubset.add(sum);
            return;
        }
        // pick the element
        subsetSumHelper(index+1, sum+arr.get(index),arr, n, sumSubset);
        // do not pick
        subsetSumHelper(index+1, sum, arr, n, sumSubset);
    }
}