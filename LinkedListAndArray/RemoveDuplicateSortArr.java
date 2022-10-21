// import java.util.HashSet;

// what we have to do is print all the unique element in sequence from starting
// and we don't care about the others.
// Input: nums = [1,1,2]
// Output: 2, nums = [1,2,_]

public class RemoveDuplicateSortArr {
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,2,3,3};
        int k = removeDuplicates(arr);
        System.out.println("The array after removing duplicate elements is ");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
    }
}

    private static int removeDuplicates(int[] arr) {
        
        // Brute force WIth Tc as O(n logn) + O(n) -> logn for inserting elements in hashset
        // Sc as O(n)
        // HashSet<Integer> set = new HashSet<>();
        // for(int i=0;i<arr.length;i++){
        //     set.add(arr[i]);
        // }
        // int k = set.size();
        // int j =0;
        // for(int x : set){
        //     arr[j++] = x;
        // }
        // return k;

        // Two Pointer APproach with Tc as O(n) and Sc as O(1)
        int i =0;
        for(int j =1;j<arr.length;j++){
            if(arr[i] != arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }
}