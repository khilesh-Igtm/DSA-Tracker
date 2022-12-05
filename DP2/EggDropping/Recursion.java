package EggDropping;

public class Recursion {
    public static void main(String[] args) {
        int n = 2, k = 10;
        System.out.print("Minimum number of "
                + "trials in worst case with "
                + n + " eggs and " + k
                + " floors is " + eggDrop(n, k));
    }

    // function to get minimum number of trials needed in worst case with n
    // eggs and k floors
    private static int eggDrop(int n, int k) {
        // if there are no floors, then no trials needed or if there is one floor , one
        // trial needed.
        if (k == 1 || k == 0)
            return k;
        // we need k trials for one egg and k floors
        if (n == 1)
            return k;
        int min = Integer.MAX_VALUE;
        int x, result;
        // consider all droppings from 1st floor to kth floor and return the mini of
        // these
        // values plus 1 . +1 is done bcz , 1 attempt is done and we need mini attempt
        // as answer.
        for (x = 1; x <= k; x++) {
            // 2 cases will arise either egg break or it doesn't break.
            // if it breaks then recursively call for n-1 floor bcz we know logically
            // that after this floor egg will break and egg became -1 as one is broken.
            // if not broken then search in k-x with n eggs bcz egg is not broken so
            //  we can reuse it.

            // we use max here bcz we are getting worst answer in call
            result = Math.max(eggDrop(n - 1, x - 1), eggDrop(n, k - x));
            // then find the best out of all worst
            // min bcz we have asked to get mini attempts
            min = Math.min(min, result);
        }
        return min + 1;

    }
}
