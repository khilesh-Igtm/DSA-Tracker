package EditDistance;
// Time Complexity: O(N*M)
// Space Complexity: O(M)
public class SpaceOptimisation {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        System.out.println("The minimum number of operations required is: " +
                editDistance(s1, s2));
    }

    private static int editDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m+1];
        int[] cur = new int[m+1];

        for(int j =0;j<=m;j++){
            prev[j] = j;
        }
        for(int i=1;i<n+1;i++){
            cur[0] = i;
            for(int j =1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    cur[j] = 0 + prev[j-1];
                }else{
                    cur[j] = 1+Math.min(prev[j-1],Math.min(prev[j],cur[j-1]));
                }
            }
            prev = cur;
        }
            
        return prev[m];
}}
