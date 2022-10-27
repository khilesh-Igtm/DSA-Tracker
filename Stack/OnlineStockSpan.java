// import java.util.ArrayList;
// import java.util.Stack;

// Design an algorithm that collects daily price quotes for some stock and returns the
//  span of that stock's price for the current day.
// The span of the stock's price today is defined as the maximum number of consecutive
//  days (starting from today and going backward) for which the stock price was less
//  than or equal to today's price.
// For example, if the price of a stock over the next 7 days were [100,80,60,70,60,75,85],
//  then the stock spans would be [1,1,1,2,1,4,6].

// public class OnlineStockSpan {

//     // Brute force 

//     // ArrayList<Integer> arr;
//     // public OnlineStockSpan(){
//     //     arr = new ArrayList<>();
//     // }
//     // public int next(int price){
//     //     arr.add(price);
//     //     int ans =0;
//     //     for(int i=arr.size()-1;i>=0;i--){
    // price is the parameter 
//     //         if(arr.get(i)<=price){
//     //             ans++;
//     //         }else{
//     //             break;
//     //         }
//     //     }
//     //     return ans;
//     }
// }

// optimal approach with Tc as O(1) and Sc as O(n)

// Algorithm

// Initialise an array S[0] = 1 for day 0.
// Initialise a stack and push the index of the first day into the stack.
// Traverse a loop from 1 to N and for each iteration, do the following:
// If the stack is not empty and price of current element is greater than the top of stack, pop the element.
// Else if, stack is not empty then, subtract index from S[i], i.e. S[i] = i – S.top().
// Else, S[i] =  i + 1
// Push the current index i into the stack.


// static void calculateSpan(int price[], int n, int S[]) {
//     // created a stack and push 0 to it
//     Stack < Integer > st = new Stack < > ();
//     st.push(0);
   

//     S[0] = 1;
//     for (int i = 1; i < n; i++) {
//       while (!st.empty() && price[st.peek()] <= price[i])
//     //   pop the element from the stack until we find the element that is greater than
//     // our current element
//         st.pop();
   
//       S[i] = (st.empty()) ? (i + 1) : (i - st.peek());
//       st.push(i);
//     }
//   }