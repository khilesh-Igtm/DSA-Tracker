import java.util.HashMap;

public class LongestSubarraysum0 {
    public static void main(String[] args) {
        int a[] = {9, -3, 3, -1, 6, -5};
        solve(a);
    }

    private static int solve(int[] a) {
        // int max =0;
        // for(int i=0;i<a.length;i++){
        //     int sum =0;
        //     for(int j =i;j<a.length;j++){
        //         sum += a[j];
        //         if(sum==0){
        //             // basically j-i+1 is the size of our window
        //             // means according to this question -3 to -5 will give output sum as 0.
        //             // and there can also be more other combination but the length from -3 to -5 is 5.
        //             // hence this is the answer as it is the longest one.
        //             max = Math.max(max,j-i+1);
        //         }
        //     }
        // }
        // return max;


        HashMap<Integer,Integer> map = new HashMap<>();
        int max =0;
         int sum =0;
         for(int i=0;i<a.length;i++){
            sum += a[i];
            if(sum==0){
                max = i+1;
            }else{
                if(map.get(sum) != null){
                    max = Math.max(max,i-map.get(sum));
                }else{
                    map.put(sum,i);
                }
            }
         }
         return max;
    }
}
