import java.util.Arrays;

// Problem Statement: We are given two arrays that represent the arrival and departure times of trains
//  that stop at the platform. We need to find the minimum number of platforms needed at the railway station
//  so that no train has to wait.

public class MiniNumOfRailway {
    public static void main(String[] args) {
        int[] arr = { 900, 945, 955, 1100, 1500, 1800 };
        int[] dep = { 920, 1200, 1130, 1150, 1900, 2000 };
        int n = arr.length;
        int totalCount = countPlatforms(n, arr, dep);
        System.out.println("Minimum number of Platforms required " + totalCount);
    }

    private static int countPlatforms(int n, int[] arr, int[] dep) {

        // Brute force with Tc as O(n2) and Sc as O(1)

        // int ans = 1;
        // for (int i = 0; i <= n - 1; i++) {
        //     // count of overlapping interval of only this iteration
        //     int count = 1;
        //     for (int j = i + 1; j <= n - 1; j++) {
        //         if ((arr[i] >= arr[j] && arr[i] <= dep[j]) || (arr[j] >= arr[i] && arr[j] <= dep[i])) {
        //             count++;
        //         }
        //     }
        //     ans = Math.max(ans, count);
        // }
        // return ans;


        // Optimised Approach with Tc as O(nlogn) and Sc as O(1)
        
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platform_needed = 1, result =1;
        int i=1 , j=0;
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                platform_needed++;
                i++;
            }
            else if(arr[i]>dep[j]){
                platform_needed--;
                j++;
            }
            if(platform_needed > result){
                result = platform_needed;
            }
        }
        return result;
    }

}
