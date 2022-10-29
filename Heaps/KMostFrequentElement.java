import java.util.ArrayList;
// import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// import java.util.PriorityQueue;
// import java.util.Queue;

class KMostFrequentElement {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        System.out.println(frquentele(nums, k));
    }

    private static int[] frquentele(int[] nums, int k) {
        //Using Heap Tc will be O(nlogn) and Sc is O(n)
        
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int num : nums) {
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }

        // Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        // for (int key : map.keySet()) {
        //     heap.add(key);
        // }

        // List<Integer> ans = new ArrayList<>();
        // for (int i = 0; i < k; i++) {
        //     ans.add(heap.poll());
        // }

        // return ans;

        // Using Bucket sort Tc is O(n) and Sc is O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for(int val : nums){
            map.put(val, map.getOrDefault(val, 0)+1);
        }
        List<Integer> bucket[] = new ArrayList[nums.length+1];
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq]==null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        int res[] = new int[k];
        // this help to stop filling res after k length
        int count =0;
        // we starts traversing from the last of the bucket bcz , we want 
        // the element that is occuring most frequently.
        // arr = {1,1,1,2,2,100} . here 100 is occuring 1 , 2 twice and 1 thrice. so we placed
        // them accordingly
        // count = 0 1   2 3 4 5 6
        // value =   100 2 1
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
                for(int v: bucket[i]){
                    res[count++]=v;
                    if(count == k) return res;
                }
            }
        }
        return res;
    }
}