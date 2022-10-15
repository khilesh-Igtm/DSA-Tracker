// // There is a singly-linked list head and we want to delete a node node in it.
// // You are given the node to be deleted node. You will not be given access to the
// //  first node of head.
// class DeleteNode{

// }
// // Tc is O(1) and Sc is O(1)
// class Solution {
//     public void deleteNode(ListNode node) {
//         // Since we know input node is not last node, so nextNode will not be null
//         ListNode nextNode = node.next;
//         // Step 2
//         node.val = nextNode.val;
//         // Step 3
//         node.next = nextNode.next;
//         nextNode.next = null;
//     }
// }
// // Short line code Tc is O(1) and Sc is O(1)
// class Solution {
//     public void deleteNode(ListNode node) {
//        node.val = node.next.val;
//         node.next = node.next.next;
//     }
// }