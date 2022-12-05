package RodCutting;

public class SpaceOptimise {
    public static void main(String[] args) {
        int price[] = {2,5,7,8,10};
  
  int n = price.length;
                                 
  System.out.println("The Maximum price generated is "+cutRod(price,n));
    }

    private static int cutRod(int[] price, int N) {
        int[] cur = new int[N+1];
        // we fill up the base index  and bsed on this we will have next item
        for(int i=0;i<=N;i++){
            cur[i] = i* price[0];
        }
        for(int ind=1;ind<N;ind++){
            for(int length =0;length<=N;length++){
                int notTaken = 0 + cur[length];
                int taken = Integer.MIN_VALUE;
                int rodLength = ind+1;
                if(rodLength<=length){
                    taken = price[ind]+cur[length-rodLength];
                }
                cur[length] = Math.max(notTaken,taken);
            }
        }
        return cur[N];
    }
}

// Time Complexity: O(N*N)
// Space Complexity: O(N)