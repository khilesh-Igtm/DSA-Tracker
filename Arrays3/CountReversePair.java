import java.util.ArrayList;

class CountReversePair{
    public static void main(String[] args) {
        int N = 5 ;
        int array[] = {1,3,2,3,1};
       System.out.println( reversepair(N,array));
    }

    private static int reversepair(int n, int[] arr) {

        /////////////////////////////////////////////////////////////////////////
        ////// Brute force with Tc as O(n2) and Sc as O(1)
        // int Pairs = 0;
        // for int i = 0; i < arr.length; i++) {
        //   for (int j = i + 1; j < arr.length; j++) {
        //      if((long)arr[i]>(long)2* arr[j]){
        //   }
        // }
        // return Pairs;

        return mergeSort(arr,0,arr.length-1);
    }





    ///////////////////////////////////////////////////////////////////////////////
    /////////////// Extended Merge sort with Tc as O( N log N ) + O (N) + O (N)   
    //  and Sc as O(n)


    private static int mergeSort(int[] arr, int low, int high) {
       if(low>=high) return 0;
       int mid = (low+high)/2;
    //    dividing the left part until individual items are occured
       int inverse = mergeSort(arr, low, mid);
       //    dividing the right part until individual items are occured
       inverse += mergeSort(arr, mid+1, high);
    //    merging both the part
       inverse += merge(arr, low,mid, high);
       return inverse;
    }

    private static int merge(int[] arr, int low, int mid, int high) {
        // our final output will be stored in count
        int count =0;
        // our j is the starting of right array
        int j = mid+1;
        for(int i=low;i<=mid;i++){
            // if j is not exhausted and satisfy this condition then increment it.
            
            while(j<=high && arr[i]>(2*(long)arr[j])){
                j++;
            }
            // if exhauseted then all elements from mid+1 to j will the number of items
            // contribtuing to our answer
            count += (j-(mid+1));
        }

        // this is the merge part of my array
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low , right=mid+1;
        while(left<=right && right <=high){
            if(arr[left] <=arr[right]){
                temp.add(arr[left++]);
            }else{
                temp.add(arr[right++]);
            }
        }
        // if right part is exhausted then
        while(left<=mid){
            temp.add(arr[left++]);
        }
        // if left part is exhausted then
        while(right<=high){
            temp.add(arr[right++]);
        }
        // we know that we have our array in temp arraylist , so we need to copy it to
        // our original array then do this
        for(int i = low;i<=high;i++){
            arr[i] = temp.get(i-low);
        }
        // finally return count i.e our answer
        return count;

    }
}