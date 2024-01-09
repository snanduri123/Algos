package AppleLeetcode;

import java.security.Key;
import java.util.HashMap;

class LRUCache {

    int capacity;
    HashMap<Integer, DLL> map;
    DLL head = new DLL(-1,-1);
    DLL tail = new DLL(-1,-1);

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            DLL node = map.get(key);
            deleteNode(node);
            addTail(node);
            return node.val;
        }
        else{
            return -1;
        }
    }

    public void put(int key, int value) {

        if(map.containsKey(key)){
            DLL node = map.get(key);
            deleteNode(node);
            node.val = value;
            addTail(node);
        }else{
            if(map.size() == capacity){
                DLL headNode = head.next;
                deleteNode(headNode);
                map.remove(headNode.key);
            }
            DLL node = new DLL(key,value);
            map.put(key,node);
            addTail(node);
        }
    }
    public void deleteNode(DLL node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addTail(DLL node){
        DLL prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }

    class DLL{
        int key;
        int val;
        DLL prev;
        DLL next;

        public DLL(int key, int val){
            this.key = key;
            this.val = val;
        }
    }


    public static void main(String[] args) {
        LRUCache lru1 = new LRUCache(2);
//        lru1.put(1,1);   // list = 1
//        lru1.put(2,2);   // list = 1,2
//        System.out.println("1.least recently used element is " + lru1.get(1)); //1  //list = 2,1
//        lru1.put(3,3);  //list = 1,3 (2 is deleted bcoz the capacity of LRU is only 2)
//        System.out.println("2. least recently used element is " + lru1.get(2));//-1 // 2 is not in the list
//        lru1.put(4,4);  // list = 3,4 (1 is deleted)
//        System.out.println("3. least recently used element is " + lru1.get(1));// -1 (1 is deleted)
//        System.out.println("4. least recently used element is " + lru1.get(3));// 3 // list = 4,3
//        System.out.println("5. least recently used element is " + lru1.get(4));//4  // list = 3,4


        LRUCache lru2 = new LRUCache(1);
        lru2.put(2,1);   // list = 2 (2 is the key and 1 is the value)
        System.out.println("1.least recently used element is " + lru2.get(2)); //1  //list = 2 (2 is the key and its value is 1)
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */