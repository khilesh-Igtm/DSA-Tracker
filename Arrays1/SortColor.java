
public class SortColor {
    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        Solution(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }

    }

    private static void Solution(int[] nums) {
        // easiest way is to sort the nums i.e O(nlogn)


        // Brute force way is to compare one by one and do insertion sort

        // int size = nums.length;
        // for (int i = 1; i < size; i++) {
        //     int key = nums[i];
        //     int j = i - 1;
        //     // Compare key with each element on the left of it until an element smaller than
        //     // it is found.
        //     // For descending order, change key<nums[j] to key>nums[j].
        //     while (j >= 0 && key < nums[j]) {
        //         nums[j + 1] = nums[j];
        //         j--;
        //     }
        //     // Place key at after the element just smaller than it.
        //     nums[j + 1] = key;
        // }

        //////////////////////////////////////////////////////////////////////////////
        //////////// Optimised is Dutch National Flag
        int low = 0, high = nums.length - 1, mid = 0;
	while( mid <= high) {
        // if nums[mid] is 0 then swap nums[mid] with nums[low] and increment both by 1
		if( nums[mid] == 0 ) 
			swap(nums, low++, mid++);
            // if this below condition satisfy then swap nums[mid] with nums[high] and decrement high by 1
		else if( nums[mid] == 2)
			swap(nums, high--, mid);  
            // if nums[mid] is 1 then no swapping is required , increment only mid by 1  
		else
			mid++;
	}

    }
public static void swap(int[] nums, int i, int j) {
	int temp = nums[i];
	nums[i] = nums[j];
	nums[j] = temp;


    }
}
