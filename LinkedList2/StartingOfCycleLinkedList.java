// import java.util.HashSet;

// class Node{
//     int num;
//     Node next;
//     Node(int val){
//         num = val;
//         next = null;
//     }
// }

// public class StartingOfCycleLinkedList {
//     public static void main(String[] args) {
//         Node head = null;
//         head = insertNode(head,1);
//         head = insertNode(head,2);
//         head = insertNode(head,3);
//         head = insertNode(head,4);
//         head = insertNode(head,3);
//         head = insertNode(head,6);
//         head = insertNode(head,10);

//         createCycle(head,2);

//         Node nodeReceive = detectCycle(head);
//         if(nodeReceive == null) System.out.println("No Cycle");
//         else{
//             Node temp = head;
//             int pos =0;
//             while(temp != nodeReceive){
//                 pos++;
//                 temp = temp.next;
//             }
//             System.out.println("Tail connects at pos "+pos);
//         }
//     }

//     private static Node insertNode(Node head, int val) {
//         Node newNode = new Node(val);
//         if(head == null){
//             head = newNode;
//             return head;
//         }
//         Node temp = head;
//         while(temp.next != null) temp = temp.next;
//         temp.next = newNode;
//         return head;
//     }

//     private static void createCycle(Node head, int pos) {
//         Node ptr = head;
//         Node temp = head;
//         int count =0;
//         while(temp.next != null){
//             if(count != pos){
//                 count++;
//                 ptr = ptr.next;
//             }
//             temp = temp.next;
//         }
//         temp.next = ptr;
//     }

//     private static Node detectCycle(Node head) {
//         // Using Hashing with Tc as O(n) and Sc as O(n)
//         // HashSet<Node> st = new HashSet<>();
//         // while(head != null){
//         //     if(st.contains(head)) return head;
//         //     st.add(head);
//         //     head = head.next;
//         // }
//         // return null;

//         // Using SLow and Pointer with Tc as O(n) and Sc as O(1)

//         if(head == null||head.next == null) return null;
        
//         Node fast = head;
//         Node slow = head;
//         Node entry = head;
            
//         while(fast.next != null&&fast.next.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
                
//             if(slow == fast) {
//                 while(slow != entry) {
//                     slow = slow.next;
//                     entry = entry.next;
//                 }
//                 return slow;
//             }
//         }
//         return null;
//     }
// }
