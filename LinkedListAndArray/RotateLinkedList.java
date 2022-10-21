// class Node{
//     int num;
//     Node next;
//     Node(int a){
//         num = a;
//         next = null;
//     }
// }
// class RotateLinkedList{
//     static Node insertNode(Node head, int val){
//         Node newNode = new Node(val);
//         if(head==null){
//             head = newNode;
//             return head;
//         }
//         Node temp = head;
//         while(temp.next !=null) temp = temp.next;
//         temp.next = newNode;
//         return head;
//     }

//     static Node rotateRight(Node head, int k){

        /////// Brute force with Tc as O(n*k) and Sc as O(1) but this will fail for k value extremely greater tham n.
        // like length is 5 and k is 2000000000.

        // if(head==null || head.next==null ) return head;
        // for(int i=0;i<k;i++){
        //     Node temp = head;
        //     while(temp.next.next != null) temp = temp.next;
        //     Node end = temp.next;
        //     temp.next = null;
        //     end.next = head;
        //     head = end;
        // }
        // return head;



        // Optimised approach with Tc as O(lenght of list) + O(length of list - (length of list%k))
        // and Sc as O(1)
//         if(head == null||head.next == null||k == 0) return head;
//     //calculating length
//     Node temp = head;
//     int length = 1;
//     while(temp.next != null) {
//         ++length;
//         temp = temp.next;
//     }
//     //link last node to first node
//     temp.next = head;
//     k = k%length; //when k is more than length of list
//     int end = length-k; //to get end of the list
//     while(end--!=0) temp = temp.next;
//     //breaking last node link and pointing to NULL
//     head = temp.next;
//     temp.next = null;
        
//     return head;
//     }

//     static void printList(Node head){
//         while(head.next!= null){
//             System.out.print(head.num+" -> ");
//             head = head.next;
//         }
//         System.out.println(head.num);
//     }

//     public static void main(String[] args) {
//         Node head = null;
//         head = insertNode(head, 1);
//         head = insertNode(head, 2);
//         head = insertNode(head, 3);
//         head = insertNode(head, 4);
//         head = insertNode(head, 5);

//         System.out.println("Original list: ");
//         printList(head);
    
//         int k = 2;
//         Node newHead = rotateRight(head, k); 
    
//         System.out.println("After " + k + " iterations: ");
//         printList(newHead); //list after rotating nodes
    
//     }


// }