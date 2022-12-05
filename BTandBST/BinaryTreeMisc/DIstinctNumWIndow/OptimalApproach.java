package DIstinctNumWIndow;

import java.util.ArrayList;
import java.util.HashMap;

// Tc is O(n) and Sc is O(n)
// It is based on acquire and release method

public class OptimalApproach {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 1, 3, 4, 2, 3 }, k = 4;
        int n = arr.length;
       System.out.println(countDistinct(arr, n, k));
    }

    private static ArrayList<Integer> countDistinct(int[] arr, int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<k-1;i++){
            // meri arr ki frequency hogi => purani frequency +1 . Assume at starting elements doesn't have any
            // freq so it will be 0 +1 i.e 1 now. But assume if element is already present there and it freq was 1
            // then using this getOrDefault the freq will become 1+1 i.e 2.
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);

        }
        // 0 based indexing me k-1 , k hota hai and k-2 , k-1 hota hai.
        // that's why we started our i value from k-1 bcz it's 0 based indexing means i is starting from k.
        for(int j =0,i=k-1;i<arr.length;){
            // we acquire here all the elements
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            ans.add(map.size());
            // now release the element from starting , based on it's freq.
            int freq = map.get(arr[j]);
            // if freq is 1 then completely remove
            if(freq ==1){
                map.remove(arr[j]);
            }
            // else remove by -1
            else{
                map.put(arr[j],freq-1);
            }
            i++;
            j++;


        }
        return ans;
    }
}