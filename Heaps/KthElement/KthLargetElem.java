// import java.util.Arrays;
// import java.util.PriorityQueue;

public class KthLargetElem {
    public static void main(String[] args) {
        int arr[] = {1, 2, 6, 4, 5, 3};
        System.out.println(largest(arr,3));
    }

    private static int largest(int[] arr, int k) {
        // Brute force with Tc as O(nlogn) and Sc as O(1)
        
        // Arrays.sort(arr);
        // int n = arr.length;
        // System.out.println("kth Largest element "+arr[n - k]);

        // Better approach with Tc as O(k+(n-k)logk) and Sc as O(k)

        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        // for(int i=0;i<arr.length;i++){
        //     pq.add(arr[i]);
        // }
        // int f = k-1;
        // while(f>0){
        //     pq.remove();
        //     f--;
        // }
        // System.out.println("Kth Largest element "+ pq.peek());


        // Optimised approach(Quicksort algo) with Tc as O(n) and Sc as O(1)

        int left =0,right =arr.length-1, kth;
        while(true){
            int idx = partition(arr,left,right);
            if(idx == k-1){
                kth = arr[idx];
                break;
            }
            if(idx < k-1){
                left = idx+1;
            }else{
                right = idx -1;
            }
        }
        return kth;
    }

    private static int partition(int[] arr, int left, int right) {
       int pivot = arr[left];
       int l = left+1;
       int r = right;
       while(l<=r){
        if(arr[l]<pivot && arr[r]>pivot){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        if(arr[l]>= pivot){
            l++;
        }
        if(arr[r]<=pivot){
            r--;
        }
       }
       int temp2 = arr[left];
       arr[left] = arr[r];
       arr[r] = temp2;
       return r;
    }

}
