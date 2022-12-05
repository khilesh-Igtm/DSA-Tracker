import java.util.Arrays;

class Memoization{
    public static void main(String[]args){
          int arr[] = {1,2,6,6};
  int k=4;
  int n = arr.length;
                                 
  if(subsetSumToK(n,k,arr))
    System.out.println("Subset with given target found");
  else 
    System.out.println("Subset with given target not found");
    }
    static boolean subsetSumToK(int n,int k,int[]arr){
        int[][]dp = new int[n][k+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return subsetSumUtil(n-1,k,arr,dp);
    }
    static boolean subsetSumUtil(int ind,int target,int[]arr,int[][]dp){
        if(target==0) return true;
        if(ind==0) return arr[0] == target;
        if(dp[ind][target]!=-1){
            return dp[ind][target]==0?false:true;
        }
        boolean notTaken = subsetSumUtil(ind-1,target,arr,dp);
        boolean taken = false;
        if(arr[ind]<=target){
            taken = subsetSumUtil(ind-1,target-arr[ind],arr,dp);
            dp[ind][target] = notTaken || taken?1:0;
        }
        return notTaken || taken;
    }
}

// Time Complexity: O(N*K)
// Space Complexity: O(N*K) + O(N)