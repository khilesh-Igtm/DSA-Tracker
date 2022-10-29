import java.util.Collections;
import java.util.PriorityQueue;

// In this program we are every time adding number to the stream and with that number
// we have to calculate the median of that particular array

// Brute force way

// public class MedianInDataStream {
//     public static void main(String[] args) {
//         int arr[] = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
//         int n = arr.length;

//         printMedian(arr, n);
//     }
//     private static void printMedian(int[]arr ,int n){
//         int i, j, pos,num;
//         int count =1;
//         System.out.println("Median after reading 1"+" element is "+arr[0]);
//         for(i=1;i<n;i++){
//             float median;
//             j = i-1;
//             num = arr[i];
//             // find position to insert current element in sorted path of array
//             pos = binarySearch(arr,num,0,j);
//             // move element to right to create space to insert the current element
//             while(j>= pos){
//                 arr[j+1] = arr[j];
//                 j--;
//             }
//             arr[j+1] = num;
//             // increment count of sorted elements in array
//             count++;
//             // if odd number of intgers are read from stream then middle element in sorted order is median
//             // else average of middle elements is median
//             if(count %2 !=0){
//                 median = arr[count/2];
//             }
//             else{
//                 median = (arr[(count/2)-1]+arr[count/2])/2;
//             }
//             System.out.println("Median after reading "+(i+1)+" elements is "+(int)median);
//         }
//     }
//     static int binarySearch(int arr[], int item, int low, int high)
//     {
//       if (low >= high) {
//         return (item > arr[low]) ? (low + 1) : low;
//       }

//       int mid = (low + high) / 2;

//       if (item == arr[mid])
//         return mid + 1;

//       if (item > arr[mid])
//         return binarySearch(arr, item, mid + 1, high);

//       return binarySearch(arr, item, low, mid - 1);
//     }
// }

// Logic is written in copy 
class MedianInDataStream {
  // put the smaller half elements, it will have k or k + 1 elements
  private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
  // put the larger half elements, it will always have k elements
  private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

  public void insertNum(int num) {
    if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
      maxHeap.add(num);
    } else {
      minHeap.add(num);
    }

    // either both the heaps will have equal number of elements or max-heap will
    // have one more
    // element than min-heap
    if (maxHeap.size() > minHeap.size() + 1) {
      minHeap.add(maxHeap.poll());
    } else if (maxHeap.size() < minHeap.size()) {
      maxHeap.add(minHeap.poll());
    }
  }

  public double findMedian() {
    if (maxHeap.size() == minHeap.size()) {
      // we have even number of element take the average of middle elemenst
      return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
    }
    return maxHeap.peek();
  }

  public static void main(String[] args) {
    MedianInDataStream median = new MedianInDataStream();
    median.insertNum(3);
    median.insertNum(1);
    System.out.println("The median is " + median.findMedian());

  }

}
