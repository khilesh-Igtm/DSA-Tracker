import java.util.ArrayList;

public class KthPermutationSequence {
    public static void main(String[] args) {
        int n = 3, k = 3;
        String ans = getPermutation(n, k);
        System.out.println("The Kth permutation sequence is " + ans);

    }

    // Brute force is using recursion but that might cause TLE
    // Optimised approach
    // Tc was O(n2) and Sc was O(n)
    private static String getPermutation(int n, int k) {
    //    factorial
        int fact = 1;
       ArrayList<Integer> numbers = new ArrayList<>();
       for(int i=1;i<n;i++){
        // we compute N-1 factorial bcz if N= 3 , 1st block size will be 2 i.e 2!
        fact = fact * i;
        // we are creating size of N
        numbers.add(i);
       }
       numbers.add(n);
    //    final answer
       String ans = "";
    //    0 based indexing
       k = k-1;
    //    infinite loop until size ==0
       while(true){
        // using this i will get my 1st , 2nd , 3rd no of permutation.
        ans = ans +""+numbers.get(k/fact);
        // then we remove that particular item from the array and size get decreased
        numbers.remove(k/fact);
        if(numbers.size()==0) break;
        // we get next value of k ,as size is decreased
        k = k% fact;
        // reduce the size of fact , as with every block fact get decreaed . AT starting fact was 6 i.e 3! and then it reduces to
        // 2 i.e 2! and then 1.
        fact = fact / numbers.size();
       }
    //    finally return your answer
       return ans;
    }
}
