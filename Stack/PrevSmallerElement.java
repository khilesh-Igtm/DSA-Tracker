import java.util.ArrayList;
import java.util.Stack;

class PrevSmallerElement{
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(5);
        arr.add(2);
        arr.add(10);
        arr.add(8);
        System.out.println(prevSmaller(arr));
        
    }
        public static ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
            // Tc as O(n) and Sc as O(n)
            ArrayList<Integer> retval=new ArrayList<>();
            Stack<Integer> st=new Stack<Integer>();
            
            for(int i=0;i<arr.size();++i){
                while(!st.isEmpty() && arr.get(i)<=st.peek()){
                    st.pop();
                }
                if(st.isEmpty()){
                    retval.add(-1);
                }
                else{
                    retval.add(st.peek());
                }
                st.add(arr.get(i));
            }
            
            return retval;
        }
    }
    
    
