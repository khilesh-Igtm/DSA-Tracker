package MaximumProfitInJob;

// Sort the interval objects in increasing order of startTime.
// Create a dp[] array to store the max profit seen so far.
// Traverse from the last interval to the first (you could do the other way too!) and store the 
// maxprofit seen so far at dp[i].
// Return dp[0].



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class IntervalProfit {
    int start;
    int end;
    int profit;
    
    public IntervalProfit(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}



public class Optimal {
    public static void main(String[] args) {
        int[] start = {1,2,3,3};
        int[] end = {3,4,5,6};
        int[] profit = {50,10,40,70};
        System.out.println(jobScheduling(start,end,profit));
    }

    private static int jobScheduling(int[] start, int[] end, int[] profit) {
        int len = start.length;
        List<IntervalProfit>list = new ArrayList<>();
        for(int i=0;i<len;i++){
            list.add(new IntervalProfit(start[i], end[i], profit[i]));
        }
        Collections.sort(list,(i1,i2)->i1.start - i2.start);
        int [] dp = new int[len+1];

        for(int i = len-1;i>=0;i--){
            dp[i] = list.get(i).profit;
            for(int j =i+1;j<len;j++){
                if(list.get(i).end <= list.get(j).start){
                    dp[i] += dp[j];
                    break;
                }
            }
            dp[i] = Math.max(dp[i],dp[i+1]);
        }
        return dp[0];
    }
}
