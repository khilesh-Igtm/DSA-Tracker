import java.util.HashMap;

public class SubarrayXORk {
    public static void main(String[] args) {
        int[] A = {4, 2, 2, 6, 4};
        int B = 6;
        System.out.println(xork(A,B));
    }

    private static int xork(int[] a, int b) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int xor = 0;
        int n = a.length;
        for(int i=0;i<n;i++){
            xor = xor ^ a[i];
            if(map.get(xor ^ b) != null){
                count += map.get(xor ^ b);
            }
            if(xor == b) count++;
            if(map.get(xor) != null){
                map.put(xor, map.get(xor)+1);
            }else{
                map.put(xor,1);
            }
        }
        return count;
    }
}
