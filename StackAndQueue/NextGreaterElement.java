//import java.util.Stack;

// Problem Statement:The next greater element for an element x is the first element greater than x that we
//  come across  while traversing the array in a clockwise manner. If it doesn’t exist, return -1 for this element.


// Approach:

// This problem can be solved easily and efficiently by using the stack data structure as it is based on the
//  Last in First out (LIFO) principle.To make it a bit easier let’s first try to solve without considering
//  the array as circular. To find the next greater element we start traversing the given array from the right.
//  As for the rightmost element, there is no other element at its right. Hence, we assign -1 at its index in the
//  resultant array. Since this can be the next greater element (NGE) for some other element, we push it in the 
// stack S. We keep checking for other elements. Let’s say we are checking for an element at index i. We keep
//  popping from the stack until the element at the top of the stack is smaller than A[i]. The main intuition
//  behind popping them is that these elements can never be the NGE for any element present at the left of A[i]
//  because A[i] is greater than these elements. Now, if the top element of S is greater than A[i] then this is
//  NGE of A[i] and we will assign it to res[i], where res is the resultant array. If the stack becomes empty 
// then it implies that no element at the right of A[i] is greater than it and we assign -1. At last, 
// we push A[i] in S.

// Now we need to make this algorithm work for a circular array. The only difference between a circular and
//  non-circular array is that while searching for the next greater element in a non-circular array we don’t 
// consider the elements left to the concerned element. This can be easily done by inserting the elements of
//  the array A at the end of A, thus making its size double. But we actually don’t require any extra space.
//  We can just traverse the array twice. We actually run a loop 2*N times, where N is the size of the given array.

class NextGreaterElement{
    public static void main(String[] args) {
        int[] arr = {5,7,1,2,6,0};
        int[] arr2 = nextgreater(arr);
        for(int i=0;i<arr2.length;i++){
            System.out.println(arr2[i]+ " ");
        }
    }

    private static int[] nextgreater(int[] nums) {

        
        // Brute force with Tc as O(n2) and Sc as O(n)

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
            // we started j from 1 bcz if we start from 0 , it starts comparing the number with itself too.
            // do dry run to understand clearly.
            for (int j = 1; j < nums.length; j++) {
                if (nums[(i + j) % nums.length] > nums[i]) {
                    res[i] = nums[(i + j) % nums.length];
                    break;
                }
            }
        }
        return res;


// Optimised one using stack
// Tc as O(n) and Sc as O(n)

        // int n = nums.length;
        // int [] nge = new int[n];
        // Stack<Integer> st = new Stack<>();
        // for(int i = 2*n-1 ; i>=0;i--){
            // i%n will return the modulo , and we will get the index from the 0 to n.
        //     while(st.isEmpty()==false && st.peek()<=nums[i%n]){
        //         st.pop();
        //     }
        //     if(i<n){
        //         if(st.isEmpty()==false) nge[i] = st.peek();
        //         else nge[i] = -1;
        //     }
        //     st.push(nums[i%n]);
        // }
        // return nge;
    }
}