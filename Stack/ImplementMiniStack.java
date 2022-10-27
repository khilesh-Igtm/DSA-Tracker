import java.util.Stack;

// Problem Statement: Implement Min Stack | O(2N) and O(N) Space Complexity. Design a
//  stack that supports push, pop, top, and retrieving the minimum element in constant time.

// Input Format:["MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"]
// [
    // [ ], [-2], [0], [-3], [ ], [ ], [ ], [ ]
// ]
// Result: [null, null, null, null, -3, null, 0, -2]
public class ImplementMiniStack {
    
}
// Solution 1: Using pairs to store the value and minimum element till now.

// Approach: The first element in the pair will store the value and the second element will store the minimum element till now.

// When the first push operation comes in we will push the value and store it as minimum
//  itself in the pair. 

// In the second push operation, we will check if the top element’s minimum is less than the
//  new value. If it is then we will push the value with minimum as the previous top’s 
// minimum. To get the getMin element to take the top’s second element.

// One Approach with Tc as O(1) and Sc as O(2n)

// class Pair{
//     int x , y;
//     Pair(int x , int y){
//         this.x = x;
//         this.y = y;
//     }
// }
// class MinStack{
//     Stack<Pair> st;
//     public MinStack(){
//         st = new Stack<>();
//     }

//     public void push(int x){
//         int min;
//         if(st.isEmpty()) min = x;
//         else min = Math.min(st.peek().y,x);
//         st.push(new Pair(x, min));
//     }

//     public void pop(){
//         st.pop();
//     }

//     public int top(){
//         return st.peek().x;
//     }
//     public int getMin(){
//         return st.peek().y;
//     }
// }

// Optimal solution with Tc as O(1) and Sc as O(n)

class MinStack {
    Stack < Long > st = new Stack < Long > ();
    // we specified long bcz here constraint is given that val should be greater than
    // int minimum value and smaller than int max value
    // but for modifing value we multiply num by 2 so to avoid integer overflow we consider long data type
    Long mini;

    /** initialize your data structure here. */
    public MinStack() {
        mini = Long.MAX_VALUE;
    }

    public void push(int value) {
        Long val = Long.valueOf(value);
        if (st.isEmpty()) {
            mini = val;
            st.push(val);
        } else {
            if (val < mini) {
                st.push(2 * val - mini);
                mini = val;
            } else {
                st.push(val);
            }
        }
    }

    public void pop() {
        if (st.isEmpty()) return;

        Long val = st.pop();
        if (val < mini) {
            mini = 2 * mini - val;
        }
    }

    public int top() {
        Long val = st.peek();
        if (val < mini) {
            return mini.intValue();
        }
        return val.intValue();
    }

    public int getMin() {
        return mini.intValue();
    }
}
