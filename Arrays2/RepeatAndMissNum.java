// import java.util.ArrayList;
// import java.util.Arrays;

class RepeatAndMissNum {
    static int x, y;

    public static void main(String[] args) {
        int[] arr = { 4, 1, 7, 3, 6, 2, 8, 8 };
        int n = arr.length;
        repeatandmiss(arr, n);
        System.out.println("Missing = " + x + " Repeating = " + y);
    }

    private static void repeatandmiss(int[] arr, int n) {

        //////////////////////////////////////////////////////////////////////////////////////////
        ////////// Brute force Tc is O(n) and Sc is O(n)

        // Also solved using HashMap with same Tc and Sc

        // ArrayList<Integer> ans = new ArrayList<>();
        // int[] newarr = new int[n + 1];
        // Arrays.fill(newarr, 0);
        // for (int i = 0; i < arr.length; i++) {
        // newarr[arr[i]]++;
        // }
        // for (int i = 1; i <= arr.length; i++) {
        // if (newarr[i] == 0 || newarr[i] > 1)
        // ans.add(i);
        // }

        // return ans;

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////// Using XOR

        // this will hold xor of all elements and numbers from 1 to n
        int xor1;

        // will have only single set bit of xor1
        int set_bit_no;
        int i;
        x = 0;
        y = 0;

        xor1 = arr[0];
        // get the xor of all array elements
        for (i = 1; i < n; i++) {
            xor1 = xor1 ^ arr[i];
        }

        // XOR the previous result with numbers from 1 to n
        for (i = 1; i <= n; i++) {
            xor1 = xor1 ^ i;
        }

        // get the rightmost set bit in set_bit_no
        set_bit_no = xor1 & ~(xor1 - 1);

        /*
         * Now divide elements into two sets by comparing
         * rightmost set bit of xor1 with the bit at the same
         * position in each element. Also, get XORs of two
         * sets. The two XORs are the output elements. The
         * following two for loops serve the purpose
         */

        //  finding  set and not set in my given array
        for (i = 0; i < n; i++) {
            if ((arr[i] & set_bit_no) != 0) {
                // arr[i] belongs to first set
                x = x ^ arr[i];
            } else {
                // arr[i] belongs to second set
                y = y ^ arr[i];
            }
        }

        // finding set and not set from n+1 array
        for (i = 1; i <= n; i++) {
            if ((i & set_bit_no) != 0) {
                // i belongs to first set
                x = x ^ i;
            } else {
                // i belongs to second set
                y = y ^ i;
            }
        }

        // hence x and y holds the desired output elements

    }

}