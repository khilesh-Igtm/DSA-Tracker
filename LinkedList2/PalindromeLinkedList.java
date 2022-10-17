// // import java.util.ArrayList;

// class Node {
//     int num;
//     Node next;

//     Node(int val) {
//         num = val;
//         next = null;
//     }
// }

// public class PalindromeLinkedList {
//     public static void main(String[] args) {
//         Node head = null;
//         head = insertNode(head, 1);
//         head = insertNode(head, 2);
//         head = insertNode(head, 3);
//         head = insertNode(head, 2);
//         head = insertNode(head, 1);
//         if (isPalindrome(head) == true)
//             System.out.println("True");
//         else
//             System.out.println("False");
//     }

//     private static Node insertNode(Node head, int val) {
//         Node newNode = new Node(val);
//         if (head == null) {
//             head = newNode;
//             return head;
//         }
//         Node temp = head;
//         while (temp.next != null)
//             temp = temp.next;
//         temp.next = newNode;
//         return head;
//     }

//     private static boolean isPalindrome(Node head) {
        
//         // Brute force with Tc as O(n) and Sc as O(n)

//         // ArrayList<Integer> ans = new ArrayList<>();
//         // while(head != null){
//         // ans.add(head.num);
//         // head = head.next;
//         // }
//         // for(int i=0;i<ans.size()/2;i++){
//         // if(ans.get(i) != ans.get(ans.size()-i-1)) return false;

//         // }
//         // return true;


//         // Optimised way with Tc as O(n/2)+O(n/2)+O(n/2) and Sc as O(1)
//         if (head == null || head.next == null)
//             return true;
//         Node slow = head;
//         Node fast = head;
//         while (fast.next != null && fast.next.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }
//         slow.next = reverse(slow.next);
//         slow = slow.next;
//         Node dummy = head;
//         while (slow != null) {
//             if (dummy.num != slow.num)
//                 return false;
//             dummy = dummy.next;
//             slow = slow.next;
//         }
//         return true;

//     }

//     private static Node reverse(Node ptr) {
//         Node pre = null;
//         Node nex = null;
//         while(ptr != null){
//             nex = ptr.next;
//             ptr.next =pre;
//             pre = ptr;
//             ptr= nex;
//         }
//         return pre;
//     }
// }
