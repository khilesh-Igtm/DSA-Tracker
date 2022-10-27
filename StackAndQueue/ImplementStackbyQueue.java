import java.util.LinkedList;

public class ImplementStackbyQueue {
    public static void main(String[] args) {
        stack s = new stack();
        s.push(3);
        s.push(2);
        s.push(4);
        s.push(1);
        System.out.println("Top of the stack: "+ s.top());
        System.out.println("Size of the stack before removing element "+s.size());
        System.out.println("The deleted element is : "+s.pop());
        System.out.println("Top of stack after removal is : "+s.top());
        System.out.println("Size of stack after removal is : "+s.size());

    }
}
class stack{
    // This is done using single queue but we can also do using 2 queues
    // but that's not the optimised way . It's Tc is O(n) and Sc is O(n)
    LinkedList<Integer> q = new LinkedList<>();
    void push(int x){
        q.add(x);
        for(int i =0;i<q.size()-1;i++){
            q.add(q.remove());
        }
    }
    int pop(){
        return q.remove();
    }
    int top(){
        return q.peek();
    }
    int size(){
        return q.size();
    }
}