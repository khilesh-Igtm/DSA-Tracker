package KthElement;
// import java.util.Arrays;
// import java.util.PriorityQueue;

public class KthSmallestElem {
    public static void main(String[] args) {
        int arr[] = {1, 2, 6, 4, 5, 3};
        smallestnum(arr,0,arr.length-1,3);
    }

    private static int smallestnum(int[] arr,int l  ,int r, int k) {
        // Arrays.sort(arr);
        // int n = arr.length;
        // System.out.println("kth Smallest element "+arr[k - 1]);

        // PriorityQueue<Integer>pq= new PriorityQueue<>();
        // int n = arr.length  ;

        // for (int i = 0; i < n; i++) {
        //     pq.add(arr[i])  ;
        // }

        // int f = k - 1 ;

        // while (f > 0) {
        //     pq.remove()  ;
        //     f-- ;
        // }

        // System.out.println("Kth Smallest element "+pq.peek())  ;
    
        if (k <= r - l + 1 && k > 0) {

            int ind = partition(arr, l, r);
    
    
            if (ind - l == k - 1) {
                return arr[ind];
            }
            if (ind - l > k - 1) {
                return smallestnum(arr, l, ind - 1, k);
            }
    
    
            return smallestnum(arr, ind + 1, r, k - ind + l - 1);
        }
        return Integer.MAX_VALUE;
    }

    private static int partition(int[] arr, int l, int r) {
        int f = arr[r] ;
        int i = l;
    
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= f) {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
            }
        }
        int temp=arr[i];
            arr[i]=arr[r];
            arr[r]=temp;
        return i;
    }
}
