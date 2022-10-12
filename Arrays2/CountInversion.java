import java.util.Arrays;

public class CountInversion {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        int n = 5;
        int[] aux = Arrays.copyOf(arr, n);
        System.out.println(invert(arr,aux,0,arr.length-1));
    }

    private static int invert(int[] arr,int[] aux,int low , int high) {

        //////////////////////////////////////////////////////////////////////////////
        ////// Brute force approach Tc is O(n2) and Sc is O(1)
        // int count =0;
        // for(int i=0;i<n;i++){
        //     for(int j =i+1;j<n;j++){
        //         if(arr[i]>arr[j]){
        //             count++;
        //         }
        //     }
        // }
        // return count;


        //////////////////////////////////////////////////////////////////////////////////////
        /////// Optimised way with Tc as O(nlogn) and Sc as O(n) this is merge sort

        if (high <= low) {        // if run size <= 1
            return 0;
        }
        
        // find midpoint
        // we can normally find mid , but here we did right shift.
        int mid = (low + ((high - low)/ 2));
        // we initialise the counter to 0. ANd we will increment it when there is a swap.
        int inversionCount = 0;
        
        // recursively split runs into two halves until run size <= 1,
        // then merges them and return up the call chain
        
        // split left half
        inversionCount += invert(arr, aux, low, mid);
        
        // split right half
        inversionCount += invert(arr, aux, mid + 1, high);
        
        // merge the two half runs
        inversionCount += merge(arr, aux, low, mid, high);
        
        return inversionCount;
        }
        
        public static int merge(int[] arr, int[] aux, int low, int mid, int high){
            // we created k , here bcz , it will be the index for our aux array. and we initiliase it
            // with low i.e, 0
            // as we know we have two different array , bcz we split them and now we are merging them
            // so for 1st array we will start from 0 to mid and 2nd array we will start from mid+1 to high
            int k = low, i = low, j = mid + 1;
            int inversionCount = 0;
        
            // while there are elements in the left and right runs
            while (i <= mid && j <= high)
            {
                if (arr[i] <= arr[j]) {
                    aux[k++] = arr[i++];
                }
                else {
                    aux[k++] = arr[j++];
                    // mid is 1
                    // mid+1 -i means all the elements from mid+1 to i as they all form  pairs
                    // mid+1 bcz j is starting from mid+1  as i ranges from low to mid and j ranges mid+1 to high.
                    inversionCount += (mid + 1-i);    // NOTE
                }
            }
        
            // copy remaining elements
            while (i <= mid) {
                aux[k++] = arr[i++];
            }
            while (j <= high) {
                aux[k++] = arr[j++];
            }
        
            /* no need to copy the second half (since the remaining items
               are already in their correct position in the temporary array) */
        
            // copy back to the original array to reflect sorted order
            for (i = low; i <= high; i++) {
                arr[i] = aux[i];
            }
        
            return inversionCount;
        }
        
           
          
    }
