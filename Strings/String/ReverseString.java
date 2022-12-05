// import java.util.Stack;

class ReverseString {
    public static void main(String[] args) {
        String s = "hekk nama tatat iyo sky love you";
        System.out.println(reverseit(s));
    }

    private static String reverseit(String s) {
        // Brute force with Tc as O(n) and Sc as O(n)

        // without this last character will not be included
        // s += " ";
        // // stack bcz , it LIFO so we can reverse string through this
        // Stack<String> st = new Stack<>();
        // // we created another string bcz at every moment of revrsal it get destroyed
        // // and if we don't use this our original string will be destroyed
        // String str = " ";
        // for(int i=0;i<s.length();i++){
        // // if we encounter the space between the string then
        // if(s.charAt(i)== ' '){
        // // 1st push our 1st word of string to stack and then pop that word from
        // // the string
        // st.push(str);
        // str = " ";
        // }else{
        // // if space is not present then add continuously
        // str += s.charAt(i);
        // }
        // }
        // // this will store my final answer
        // String ans = " ";
        // // until my stack becomes empty peek every word from it from top and delete
        // the word
        // // from the string
        // while(st.size() != 0){
        // ans += st.peek()+" ";
        // st.pop();
        // }
        // // return answer
        // return ans;

        // Optimised Approach without using Stack
// Tc is O(n) and Sc is O(1)
        // Approach:
        // We start traversing the string from the end until we hit a space. It
        // indicates that we have gone past a word and now we need to store it.
        // We check if our answer variable is empty or not
        // If it’s empty, it indicates that this is the last word we need to print, and
        // hence, there shouldn’t be any space after this word.
        // If it’s empty we add it to our result with a space after it. Here’s a quick
        // demonstration of the same

        int left =0;
        int right = s.length()-1;
        String temp = "";
        String ans = "";
        // Iterate the string and keep on adding to form a word
        // If empty space is encountered then add the current word to the result
        while(left <= right){
            char ch = s.charAt(left);
            if(ch != ' '){
                temp += ch;
            }else if( ch == ' '){
                if(!ans.equals("")){
                    ans = temp + " "+ans;
                }else{
                    ans = temp;
                }
                temp = " ";
            }
            left++;
        }
        // If not empty string then add to the result(Last word is added)
        if( !temp.equals("")){
            if(!ans.equals(" ")){
                ans = temp + " "+ans;
            }else{
                ans = temp;
            }
        }
        return ans;

    }
}