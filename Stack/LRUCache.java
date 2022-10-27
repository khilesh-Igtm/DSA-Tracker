import java.util.HashMap;
import java.util.Map;
// O(n) and sc as O(1)

class LRUCache{
    // doubly linkedlist
    Node head = new Node(0,0), tail = new Node(0,0);
    // hashmap
    Map<Integer, Node> map = new HashMap<>();
    // size 
    int capacity;

    // constructor for intialising the values
    public LRUCache(int _capacity){
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            // 1st remove the node then
            remove(node);
            // insert the same node after head , so that it became the most recently used cache
            insert(node);
            return node.value;
        }else{
            return -1;
        }
    }
    public void put(int key, int value){
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == capacity){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }
    private void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void insert(Node node){
        map.put(node.key,node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    class Node{
        Node prev , next;
        int key , value;
        Node(int _key , int _value){
            key = _key;
            value = _value;
        }
    }


    
}