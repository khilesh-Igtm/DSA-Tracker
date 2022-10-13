// import java.util.Arrays;
// Input: [100, 200, 1, 3, 2, 4]
// Output: 4
// Explanation: The longest consecutive subsequence is 1, 2, 3, and 4.
import java.util.HashSet;
import java.util.Set;

class LongestConsecutivepublic  {
   public static void main(String[] args) {
    int arr[]={100,200,1,2,3,4};
    consequence(arr);
   }

private static int consequence(int[] arr) {
    // Tc is O(nlogn) + O(n) and Sc is O(1)
    // if(arr.length == 0 || arr == null) return 0;
    // Arrays.sort(arr);
    // int ans = 1;
    // int prev = arr[0];
    // int current = 1;
    // for(int i =1;i<arr.length;i++){
    //     if(arr[i] == prev+1){
    //         current++;
    //     }else if(arr[i] != prev){
    //         current = 1;
    //     }
    //     prev = arr[i];
    //     ans = Math.max(ans,current);
    // }
    // return ans;

 
    Set<Integer> hashSet = new HashSet<>();
    for(int num: arr) hashSet.add(num);
    int longestStreak = 0;
    for(int num : arr){
        if(!hashSet.contains(num-1)){
            int currentNum = num;
            int currentStreak = 1;
            while(hashSet.contains(currentNum + 1)){
                currentNum += 1;
                currentStreak += 1;
            }
            longestStreak = Math.max(longestStreak,currentStreak);
        }
    }
    return longestStreak;


} 
}
