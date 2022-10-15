class ReverseLinkedList{
    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// Approach is simple : we will create 3 pointer , 1 for tracking current node , 2nd for tracking
// the previous node and 3rd for the next node

////////////////////////////////////////////////////////////////////////
////// Tc is O(N) and Sc is O(1)

// class Solution {
//     public ListNode reverseList(ListNode head) {

    // we created a previous node named as newHead that will point to null
//         ListNode newHead = null;

// then we traverse the linkedlist until the head == null
//         while (head != null) {

    // then we create a next named pointer for tracking next node
//             ListNode next = head.next;

// then we interchange the linking of head.next to newhead so that we can reverse it
//             head.next = newHead;

// then we pointed our newhead as our head
//             newHead = head;

// and head moves to next node
//             head = next;
//         }

// finally return newHead , and we get our reversed linkedlist
//         return newHead;
//     }
// }
}