// class RemoveNthNodeEnd{

// }

// class Solution{
//     public ListNode removenthnode(ListNode head , int n){
//         // find length
//         // int len = 0;
//         // ListNode temp = head;
//         // while(temp != null){
//         //     temp = temp.next;
//         //     len++;
//         // }
        
//         // if(len == n) return head.next;
        
//         // // Reach to the previous node of the last node
//         // temp = head;
//         // n = len-n-1;
//         // while(temp.next != null && n != 0){
//         //     temp = temp.next;
//         //     n--;
//         // }
        
//         // // remove 
//         // if(temp.next != null)
//         //     temp.next = temp.next.next;
        
        
//         // return head;


//         /////////////////////////////////////////////////////////////////////////////////////////////////
//         //////////////////////////// Two pointer efficient approach
//         // Tc is O(n) and Sc is O(1)
        
//         ListNode start = new ListNode();
//         start.next = head;
//         ListNode fast = start;
//         ListNode slow = start;

//         for(int i=1;i<=n;i++){
//             fast = fast.next;
//         }
//         while(fast.next != null){
//             fast = fast.next;
//             slow = slow.next;
//         }
//         slow.next = slow.next.next;
//         return start.next;
//     }
// }