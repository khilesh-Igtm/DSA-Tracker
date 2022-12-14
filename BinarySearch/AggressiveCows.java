import java.util.Arrays;

// Problem Statement: There is a new barn with N stalls and C cows. The stalls are located
//  on a straight line at positions x1,….,xN (0 <= xi <= 1,000,000,000). We want to assign
//  the cows to the stalls, such that the minimum distance between any two of them is as
//  large as possible. What is the largest minimum distance?
class AggressiveCows{
    public static void main(String[] args) {
        int n =5, cows =3;
        int[] inp = {1,2,8,4,9};
        Arrays.sort(inp);
        // For brute force

        // int maxD = inp[n-1] - inp[0];
        // int ans = Integer.MIN_VALUE;
        // for(int d =1;d<=maxD;d++){
        //     boolean possible = isCompatible(inp,d,m);
        //     if(possible){
        //         ans = Math.max(ans,d);
        //     }
        // }

        // for optimised 
        int low =1 , high = inp[n-1] - inp[0];
        while(low <= high){
            int mid = (low+high) >> 1;
            if(isCompatible(inp, n, cows,mid)){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        System.out.println("Mini distance is : "+high);
    }

    private static boolean isCompatible(int[]a, int n, int cows,int minDist) {
        
        // Time complexity: O(n* m) and Space Complexity: O(1) 
        // Brute force

        // int n = inp.length;
        // int k = inp[0];
        // cows--;
        // for(int i=1;i<n;i++){
        //     if(inp[i] - k >= dist){
        //         cows--;
        //         if(cows ==0){
        //             return true;
        //         }
        //         k = inp[i];
        //     }
        // }
        // return false;

        // Optimised approach
        // Time Complexity: O(N*log(M)) and Space Complexity: O(1) 
        int cntCows = 1;
        int lastPlacedCow = a[0];
        for(int i=1;i<n;i++){
            if(a[i]-lastPlacedCow >= minDist){
                cntCows++;
                lastPlacedCow = a[i];
            }
        }
        if(cntCows >= cows) return true;
        return false;
       
    }
}