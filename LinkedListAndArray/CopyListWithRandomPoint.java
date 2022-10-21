// import java.util.HashMap;
// import java.util.Map;

// A linked list of length n is given such that each node contains an additional random pointer,
//  which could point to any node in the list, or null.
// Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
// Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
class CopyListWithRandomPoint{
    public static void main(String[] args) {
        
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}



// Brute force with Tc as O(n) and Sc as O(n)

// class Solution{
//     //maintain a map of the old node and its corresponding new node
//     //this is only used to update the random pointer
//     //this helps avoid creating duplicate nodes while trying to update random pointer
//     Map<Node,Node> map = new HashMap<>();
//     public Node copyRandomList(Node head){
//         // create a dummy start node
//         Node copy = new Node(-1);
         
//         //create copies of the start of our new list and the original list 
//         //used to iterate over both lists
//         Node ptr = copy;
//         Node orginal = head;
//         //here we build the copy list - but without updating the random pointers
//         //at this stage we only record the mapping of original and it's corresponding new node
//         while(head!=null){
//             // create a new node in our copy list
//             ptr.next = new Node(head.val);
//             // also record the new node and it's corresponding node from original list
//             map.put(head, ptr.next);
//             // advance both list's pointers
//             ptr = ptr.next;
//             head = head.next;
//         }
//         // now we iterate from the starting of both list
//         ptr = copy;
//         while(orginal != null){
//              //if the current node in original list has a random pointer 
//             //we get the corresponding new node from our map and update our copy list
//             if(orginal.random!= null && map.containsKey(orginal.random)){
//                 ptr.next.random = map.get(orginal.random);
//             }
//             // advance both pointer
//             ptr = ptr.next;
//             orginal = orginal.next;
//         }
//         // since we had created a dummy start node , we discard that and the deep copy list
//         return copy.next;
//     }
// }


// Optimised Approach with Tc as O(n) and Sc as O(1)

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        
        Node curr = head;
        //add a copy extra node after each node
        while (curr != null)
        {
            Node temp = curr.next;
            Node copy = new Node(curr.val);
            curr.next = copy;
            copy.next = temp;
            curr = temp;            
        }
        
        // put the random reference for copies
        curr = head;
        while (curr != null)
        {
            if(curr.next != null)  
              curr.next.random = (curr.random != null) ? curr.random.next : curr.random;  
  
        // move to the next newly added node by  
        // skipping an original node  
        curr = (curr.next != null) ? curr.next.next : curr.next;  
        }
        
        // separa in two lists : original and copy
        // restore initial next configuration
        Node original = head, copy = head.next;  
  
        // save the start of copied linked list  
        Node result = copy;  

        // now separate the original list and copied list  
        while (original != null && copy != null)  
        {  
            original.next = (original.next != null) ? original.next.next : original.next;  
            copy.next = (copy.next != null) ? copy.next.next : copy.next;  
            
            original = original.next;  
            copy = copy.next;  
        }  
        return result;  
    }
}