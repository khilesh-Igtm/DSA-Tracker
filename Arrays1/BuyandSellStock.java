public class BuyandSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(Solution(prices));
    }

    private static int Solution(int[] prices) {

        // Brute force way and Tc is O(n2)

        // int difference = 0;
        // int profit =0;
        // for(int i=0;i<prices.length;i++){
        //     for(int j =i+1;j<prices.length;j++){
        //         if(prices[j]>prices[i]){
        //             difference = prices[j] - prices[i];
        //             profit = Math.max(difference,profit);
        //         }
        //     }
        // }
        // return profit;

        // /////////////////////////////////////
        ///// Another approach

        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minprice){
                minprice = prices[i];
            }
            else if(prices[i] - minprice >maxprofit){
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;


    }
}
