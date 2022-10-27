import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        // tc is O(n2) and Sc is O(n)
    }
    public static void sortedInsert(Stack<Integer>stack , int current){
        if(stack.empty() == true || current > stack.peek()){
            stack.push(current);
            return;
        }
        // remove the top element
        int top = stack.peek();
        stack.pop();
        // recursion for remaining elements in the stack
        sortedInsert(stack, current);
        // insert the popped element back in the stack
        stack.push(top);
    }
    // recursive method to sort a stack
    public static void SortStack(Stack<Integer> stack){
        // base case : stack is empty
        if(stack.empty() == true) return;
        // remove the top element
        int top = stack.peek();
        stack.pop();
        // recursion for remaining elements in the stack
        SortStack(stack);
        // insert the popped element back in sorted stack
        sortedInsert(stack, top);
    }
}
