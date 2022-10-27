import java.util.HashMap;

class LFUCache{
    int capacity;
    // hashmap for key and it's address
    HashMap<Integer, Node> keyNodeMap = new HashMap<>();
// hashmap for doublylinkedlist and frequency
    HashMap<Integer, NodeDLinkedList> freqNodeDLLMap = new HashMap<>();
    int minimumFrequency = 1;

    public LFUCache(int capacity){
        this.capacity = capacity;
    }

    public int get(int key){
        Node node = keyNodeMap.get(key);
        // item exist
        if(node != null){
            // increment frequency
            incrementFrequency(node);
            // return value
            return node.value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value){
        if(capacity <=0) return;
        // item exist
        if(keyNodeMap.containsKey(key)){
            // get old node
            Node node = keyNodeMap.get(key);
            // update with new value
            node.value = value;
            // increment frequency
            incrementFrequency(node);
            // put (update ) in cache
            keyNodeMap.put(key, node);
        }
        // item doesn't exist
        else{
            // create new node
            Node node = new Node(key, value);
            // if cache is full
            if(keyNodeMap.size() == capacity){
                // remove lfu node from removedLastNode
                Node removedLastNode = freqNodeDLLMap.get(minimumFrequency).removeLastNode();
                // also remove lfu node from cache
                keyNodeMap.remove(removedLastNode.key);
            }
            // add to frequency map
            incrementFrequency(node);
            // add to cache
            keyNodeMap.put(key,node);
            // since new node is having frequency as 1, update minimumFrequency to be 1
            minimumFrequency = 1;
        }
    }

    private void incrementFrequency(Node node){
        int oldFrequency = node.frequency;
        // frequency already exist
        if(freqNodeDLLMap.containsKey(oldFrequency)){
            // get frequency linkedlist
            NodeDLinkedList oldNodeDLinkedList = freqNodeDLLMap.get(oldFrequency);
            // remove current node
            oldNodeDLinkedList.remove(node);
            // if this frequency was the minimum freq and no node is having this freq anymore
            // increment minimum frequency
            if(node.frequency == minimumFrequency && oldNodeDLinkedList.length==0){
                minimumFrequency++;
            }
        }
        // increment frequency
        int newFrequency = oldFrequency+1;
        // set new frequency to node
        node.frequency = newFrequency;
        // get or create the linkedlist for this new frequnecy
        NodeDLinkedList newNodeDLinkedList = freqNodeDLLMap.getOrDefault(newFrequency , new NodeDLinkedList());
    //    add node to the freq linkedlist
        newNodeDLinkedList.add(node);
        // out freq linkedlist to freqNodeDllMap
        freqNodeDLLMap.put(newFrequency, newNodeDLinkedList);
    }

    private class Node{
        int key;
        int value;
        int frequency;
        Node prev;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
            // this.frequency = frequency;
        }
    }
    private class NodeDLinkedList{
        Node head, tail;
        int length;

        // Add a node to top
        void add(Node node){
            // remove old pointers
            node.prev = null;
            node.next = null;
// empty list
            if(head == null){
                head = node;
                tail = node;
            }else{
                // forward linking
                node.next = head;
                // backward linking
                head.prev = node;
                head = node;
            }
            length++;
        }
        // Remove a node
        void remove(Node node){
            // need to remove head node
            if(node == head){
                // tail node is the same(list size =1)
                if(node == tail){
                    // make tail null
                    tail = null;
                }
                // make head point to next node
                head = head.next;
            }
            // need to remove later node
            else{
                node.prev.next = node.next;
                // need to remove tail node
                // forwrd linking
                if(node== tail){
                    // point tail to prev node
                    tail = node.prev;
                }else{
                    // backward linking
                    node.next.prev = node.prev;
                }
            }
            length--;
        }
        // remove last node
        Node removeLastNode(){
            Node tailNode = tail;
            // lastnode exist
            if(tailNode != null){
                remove(tailNode);
            }
            return tailNode;
        }
    }
}