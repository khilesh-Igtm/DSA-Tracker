import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(charrsum(arr,target));
        
    }

    private static ArrayList<List<Integer>> charrsum(int[] arr, int target) {

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //// Brute force is little bit modified Time Complexity: O(N log N + N³ logN) Sc is O(n)
        ArrayList<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for(int i =0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                for(int k = j+1;k<arr.length;k++){
                    List<Integer> list1 = new ArrayList<>();
                    int x = ((target - arr[i])-arr[j])-arr[k];
                    if(binarySearch(arr,k+1,arr.length-1,x)){
                        list1.add(arr[i]);
                        list1.add(arr[j]);
                        list1.add(arr[k]);
                        list1.add(x);
                        // checking whether the list contains duplicates
                        if(ans.contains(list1)) continue;
                        else ans.add(new ArrayList<>(list1));
                        
                    }
                }
            }
        }
        return ans;
    }

    private static boolean binarySearch(int[] arr, int low, int high, int element) {
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==element) return true;
            else if(element>arr[mid]) low = mid+1;
            else if(element < arr[mid]) high = mid-1;
        }
        return false;
        
    }
}
