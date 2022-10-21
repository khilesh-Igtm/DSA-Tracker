import java.util.ArrayList;
// Problem Statement: Given a value V, if we want to make a change for V Rs, and we
//  have an infinite supply of each of the denominations in Indian currency, i.e., we 
// have an infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes,
//  what is the minimum number of coins and/or notes needed to make the change.
public class MinimumNoOfCoins {
    public static void main(String[] args) {
        // Tc as O(V) and Sc as O(1)
        int V = 70;
        ArrayList<Integer> ans = new ArrayList<>();
        int [] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int n = coins.length;
        for(int i =n-1;i>=0;i--){
            while(V >= coins[i]){
                V -= coins[i];
                ans.add(coins[i]);
            }
        }
        System.out.println("The minimum number of coins is "+ans.size());
        System.out.println("The coins are");
        for(int i=0;i<ans.size();i++){
            System.out.println(" "+ans.get(i));
        }
    }
}
