import java.util.PriorityQueue;

// for finding the kth largest element in the data stream
// we used Min heap , where the mini element will be placed at the top and we pop them out
// from the heap until heap size is greater than k

// But for finding the kth smallest element in the data stream we will use the Max heap
// the work is same as above but max element will be popped.

class KthLargestDataStream {
    int k;
    PriorityQueue<Integer> heap;

    public static void main(String[] args) {

    }

    public void kthlargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();
        // we added all the elements in the heap
        for (int num : nums) {
            heap.offer(num);
        }
        // if our heap size becomes greater than the k , then poll out it from the heap
        while (heap.size() > k) {
            heap.poll();
        }
    }

    public int add(int val) {
        // we add , as it;s a data stream means elements will be continusly added to it.
        // so whenever the elements will be added we need to check everytime, who is the
        // kth
        // largest element currently.
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }

}

// Brute Force
// The brute force approach for this problem is very trivial.
// We can always maintain an array that will hold the integers, sort the array
// in non-increasing order and return the element present at the kth
// index(1-based indexing).
// The array should be such that it can add elements efficiently, for example,
// vectors in C++, lists in python, etc. Whenever we receive a query of type 1,
// we add the element in the array and sort it.
// For sorting, we can use the inbuilt sort function in many programming
// languages such as C++, Java, etc.

// public class Kthlargest {
//     private int size;
//     private ArrayList<Integer> aux;

//     Kthlargest(int k, int[] arr) {
//         size = k;
//         aux = new ArrayList<>();
//         for (int it : arr) {
//             aux.add(it);
//         }

//         Collections.sort(aux, Collections.reverseOrder());
//     }

//     void add(int num) {
//         aux.add(num);
//         Collections.sort(aux, Collections.reverseOrder());
//     }

//     int getKthLargest() {
        
//         // The kth largest element will always be at the top of the queue.
//         return aux.get(size - 1);
//     }
// }