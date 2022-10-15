// // Given the head of a singly linked list, return the middle node of the linked list.
// // If there are two middle nodes, return the second middle node.

 
// public class MiddleOfLinkedList {
//     public static void main(String[] args) {
        
//     }
// }

//  public class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }
 
// class Solution{
//     public static ListNode middleList(ListNode head){
        
//         // Naive Approach  Tc is O(n)+O(n/2) and Sc is O(1)
//         // we created a counter and a temporary node and we try to increment it till our temporay node
//         // is not null . And with that temp will point to it's next node
        
//         // int n =0;
//         // ListNode temp = head;
//         // while(temp != null){
//         //     n++;
//         //     temp = temp.next;
//         // }

//         // then again we start traversing through temporary node which is pointing to head
//         // and we traverse till n/2 bcz it will be the middle point and hence return temp.

//         // temp = head;
//         // for(int i =0;i<n/2;i++){
//         //     temp = temp.next;
//         // }
//         // return temp;


//         // Tortoise-Hare-Approach same as slow and fast pointer approach
//         //  we create 2 pointer in which 1 moves by 1 step and 2nd moves by 2 steps and when 2nd reaches the end
//         // the slow will be at middle .
//         // Tc is O(n) and Sc is O(1)
//         ListNode slow = head, fast = head;
//         while (fast != null && fast.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }
//         return slow;

//     }
// }