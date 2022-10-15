// class MergeSortedLinked{
//     public static void main(String[] args) {
        
//     }
// }

// class Solution{
//     public ListNode mergeTwoLists(ListNode list1 , ListNode list2){

//         //////////////////////////////////////////////////////////////////////////////////////////////
//         ///////// This is solutin when we can use extra space Tc is O(n1+n2) and Sc is O(n1+n2)

// //         // we just created a new Listnode named as head which is empty now
// //         // or we can say a dummy first node to hang the result on
// //         ListNode head = new ListNode(0);
// //         // check if any of them is empty
// //         if(list1==null && list2==null) return null;
// //         if(list1== null) return list2;
// //         if(list2==null) return list1;


// //  /* Compare the data of the two
// //         lists whichever lists' data is 
// //         smaller, append it into tail and
// //         advance the head to the next Node
// //         */

// // // if our 1st list value is greater than 2nd list value then our newnode will have list2 value bcz we need sorted
// // // order. And then list2 will have list.next
// //         if(list1.val > list2.val){
// //             head = list2;
// //             list2 = list2.next;
// //         }  
// //         // similar like above but for list1 
// //         else{
// //             head = list1;
// //             list1 = list1.next;
// //         }
// //         // after every traversal we recursively call the function for the next values of list1 and list2.
// //         head.next = mergeTwoLists(list1,list2);
// //         return head;

// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// ///////// When we can't use extra space Tc is  O(n1+n2) and Sc is O(1)

// if(list1==null) return list2;
// if(list2==null) return list1;

// //here we assign list1 to the smaller one and list2 to the larger one.
// if(list1.val > list2.val){
//     ListNode temp = list1;
//     list1 = list2;
//     list2 = temp;
// }
// // and we kept our result pointing to the list1
// Listnode result = list1;
// while(list1 != null && list2 != null){
//     ListNode temp = null;
//     while(list1 != null && list1.val <=list2.val){
//         temp = list1;
//         list1 = list1.next;
//     }
//     temp.next = list2;

//     ListNode tmp = list1;
//     list1 = list2;
//     list2 = tmp;
// }
// return result;
//     }
// }