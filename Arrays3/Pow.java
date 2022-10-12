public class Pow {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 9;
        System.out.println(findpow(x, n));
    }

    private static double findpow(double x, int n) {

        // Brute force Tc is O(n) and Sc is (1)
        // double pow = 1;
        // for (int i = 1; i <= n; i++) {
        //     pow = pow * x;
        // }
        // return pow;


        // optimised approach with Tc is (Logn) and Sc is O(1)
       double ans = 1.0;
       long nn = n;
       if(nn < 0) nn = -1 * nn;
       while(nn > 0){
        if(nn % 2 == 1){
            ans = ans * x;
            nn = nn -1;
        }else{
            x = x * x;
            nn = nn/2;
        }
       }
       if(n <0) ans = (double) (1.0)/(double)(ans);
       return ans;
    }
}
