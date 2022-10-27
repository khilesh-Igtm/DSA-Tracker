import java.util.Stack;

// Problem Statement: Given an array of integers heights representing the histogram’s bar 
// height where the width of each bar is 1  return the area of the largest rectangle
//  in histogram.


public class LargestRectangleHistogram {
    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 6, 2, 3, 1};
        int n = 7;
        System.out.println("The largest area in the histogram is " + largestarea(arr, n));
    }

    private static int largestarea(int[] arr, int n) {
        // Brute force with Tc as O(n2) and Sc as O(1)
        // Intuition: The intuition behind the approach is taking different bars and 
        // finding the maximum width possible using the bar.

        // my final answer will store here
        // int maxArea = 0;
        // for(int i=0;i<n;i++){
        //     int minHeight = Integer.MAX_VALUE;
        //     for(int j =i;j<n;j++){
        //         minHeight = Math.min(minHeight,arr[j]);
        //         maxArea = Math.max(maxArea,minHeight * (j-i+1));
        //     }
        // }
        // return maxArea;

        // Optimised Approach using stack with Tc as O(n) and Sc as O(n)
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<=n;i++){
            int currHeight = i == n? 0 : arr[i];
            // check if currHeight becomes greater then height[top] element of stack. we do a push because
            // it's an increasing sequence otherwise we do pop and find area , so for that we write a while loop
            while(!st.isEmpty() && currHeight < arr[st.peek()]){
                // current element on which we are working now we need width & area
                int top = st.pop();
                // width differ , if stack is empty or not empty after we pop the element
                int width = st.isEmpty() ? i : i-st.peek() -1;
                // current height * width
                int area = arr[top] * width;
                maxArea = Math.max(area, maxArea);


            }  
            // if it doesn't enter in while loop , it means it's an increasing sequence and we need to push index
            st.push(i);
        }
        return maxArea;
    }

}
