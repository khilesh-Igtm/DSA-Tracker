import java.util.Stack;

// Problem Statement: Check Balanced Parentheses. Given string str containing just the characters ‘(‘, ‘)’, ‘{‘, ‘}’, ‘[‘ and ‘]’, check if the input string is valid and return true if the string is balanced otherwise return false.

// Note: string str is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.



// Intitution: We have to keep track of previous as well as most recent opening bracket
// and also keep in mind the sequence , as after opening there must be closing bracket.
// Also handle the corner cases like [)(] where closing one occur 1st which is invalid
// as well as [(]) where the most recent opening didn't get its opposite pair hence it will also
// not be valid.
// So we have to use a data structure that will keep track of first in and last out,
//  hence we will use the stack.


// Approach: 

// Whenever we get the opening bracket we will push it into the stack. I.e ‘{‘, ’[’, ’(‘.
//     Whenever we get the closing bracket we will check if the stack is non-empty or not.
//     If the stack is empty we will return false, else if it is nonempty then we will check if the topmost element of the stack is the opposite pair of the closing bracket or not.
//     If it is not the opposite pair of the closing bracket then return false, else move ahead.
//     After we move out of the string the stack has to be empty if it is non-empty then return it as invalid else it is a valid string.

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()[{}()]";
        if(isValid(s)==true){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }

    private static boolean isValid(String s) {
        // Tc is o(n) and Sc is also O(n)
        Stack<Character> st = new Stack<>();
        for(char it: s.toCharArray()){
            if(it == '(' || it == '[' || it == '{'){
                st.push(it);
            }
            else{
                if(st.isEmpty()) return false;
                char ch = st.pop();
                if((it ==')' && ch=='(') || (it==']' && ch=='[') || (it=='}' && ch =='{')) continue;
                else return false;
            }
        }
        return st.isEmpty();
    }
}
