// The nth root of a number M is defined as a number X when raised to the
//  power N equals M.

// Time Complexity: N x log(M x 10^d)
// Space Complexity: O(1)
class NthrootOfInteger{
    public static void main(String[] args) {
        int N=3 ,M=27;
        getNthroot(N,M);
    }

    private static void getNthroot(int n, int m) {
    double low = 1;
    double high = m;
    double eps = 1e-7;
    while((high-low)>eps){
        double mid = (low+high)/2.0;
        if(multiply(mid,n)<m){
            low = mid;
        }else{
            high = mid;
        }
    }
    System.out.println(n+"th root of "+m+" is"+low);
    
    }

    private static double multiply(double number, int n) {
        double ans = 1.0;
        for(int i=1;i<=n;i++){
            ans = ans*number;
        }
        return ans;
    }
}