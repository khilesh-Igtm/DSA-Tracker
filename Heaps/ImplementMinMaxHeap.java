import java.util.Collections;
import java.util.PriorityQueue;

class ImplementMinMaxHeap{
    public static void main(String[] args) {
        // Implementing Max Heap using Priority Queue
        PriorityQueue<Integer> prq = new PriorityQueue<>(Collections.reverseOrder());
        prq.add(6);
        prq.add(9);
        prq.add(5);
        prq.add(64);
        prq.add(6);

        while(!prq.isEmpty()){
            System.out.println(prq.poll()+" ");
        }

        // Implementing Min Heap using Priority Queue
        PriorityQueue<Integer> prq1 = new PriorityQueue<>();
        prq1.add(6);
        prq1.add(9);
        prq1.add(5);
        prq1.add(64);
        prq1.add(6);

        while(!prq1.isEmpty()){
            System.out.println(prq1.poll()+" ");
        }
    }
}