class AllocateMiniPages{
    public static void main(String[] args) {
        int[] arr ={12,34,67,90};
        int B = 2;
        System.out.println(minipages(arr,B));
    }

    // Tc is O(n log n) and Sc as O(1)
    private static int minipages(int[] arr, int b) {
        if(b > arr.length) return -1;
        int low = arr[0];
        int high =0;
        for(int i=0;i<arr.length;i++){
            high = high + arr[i];
            low = Math.min(low,arr[i]);
        }
        // int res = -1;
        while(low <=high){
            int mid = (low+high) >> 1;
            if(isPossible(arr,mid , b)){
                // res = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }

    private static boolean isPossible(int[] arr, int pages, int student) {
        int count =0;
        int sumAll = 0;
        for(int i=0;i<arr.length;i++){
            if(sumAll + arr[i]>pages){
                count++;
                sumAll = arr[i];
                if(sumAll> pages) return false;
            }
            else{
                sumAll += arr[i];
            }
        }
        if(count < student) return true;
        return false;
       
    }
}