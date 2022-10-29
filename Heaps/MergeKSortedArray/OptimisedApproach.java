import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// The idea is to use Min Heap. This MinHeap based solution has the same time
//  complexity which is O(NK log K). But for a different and particular sized array, this
//  solution works much better. The process must start with creating a MinHeap and 
// inserting the first element of all the k arrays. Remove the root element of Minheap and
//  put it in the output array and insert the next element from the array of removed 
// element. To get the result the step must continue until there is no element left in the MinHeap. 


// Follow the given steps to solve the problem:

// Create a min Heap and insert the first element of all the K arrays.
// Run a loop until the size of MinHeap is greater than zero.
// Remove the top element of the MinHeap and print the element.
// Now insert the next element from the same array in which the removed element belonged.
// If the array doesn’t have any more elements, then replace root with infinite. After replacing the root, heapify the tree.
// Return the output array

public class OptimisedApproach {
    public static void main(String[] args) {
        ArrayList<Integer> n1 = new ArrayList<>();
        ArrayList<Integer> n2 = new ArrayList<>();
        ArrayList<Integer> n3 = new ArrayList<>();
        n1.add(2);
        n1.add(5);
        n1.add(9);
        n2.add(1);
        n2.add(8);
        n2.add(7);
        n3.add(3);
        n3.add(4);
        n3.add(6);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.add(n1);
        ans.add(n3);
        ans.add(n2);
        System.out.println(solve(ans));

    }
// Tc is O(nk log(k)) with Sc as O(1)
    public static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        // this will store my final answer
        ArrayList<Integer> res = new ArrayList<>();
        // creating priority queue for storing all items of arraylist to it
        // it's a min heap so that smallest element will be at top and we can pop out in ascending order
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (List<Integer> al : A)
        // added all items to queue
            pq.addAll(al);
            // until queue becomes empty pop all elements from it
        while (pq.size() != 0)
            res.add(pq.poll());
            // finally return the result
        return res;
    }

}