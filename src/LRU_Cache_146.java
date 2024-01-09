//
//Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
//
//get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
//
//Follow up:
//Could you do both operations in O(1) time complexity?
//
//Example:
//
//LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        cache.get(2);       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4

import java.util.HashMap;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */



//Time: O(1)
//Space: O(capacity)
/*
Soln: put()

 */
 class LRUCache {

    int capacity;

    Node head = new Node(0,0);  //Dummy node to maintain head
    Node tail = new Node(0,0);  //Dummy node to maintain tail
    HashMap<Integer, Node> map = new HashMap<>();

    class Node{  //Doubly linked list node
        int key;
        int val;
        Node prev;
        Node next;

       public  Node(int k, int v) {
           key = k;
           val = v;
       }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }



    public int get(int key) {
        if (map.containsKey(key)) {
           Node node = map.get(key);

           //Delete the node in list (it could be somewhere in the beginning of the list)
            deleteNode(node);

           //Add the node to list at end (i.e., just before dummy Tail node) to make it recently used.
            return addNodeBeforeTail(node).val;
        }
        else{
            return -1;
        }

    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            //update the node's value with new value in the map.
            Node node = map.get(key);
            node.val = value;

            //Delete the node in list
            deleteNode(node);

            //add the node at end (i.e., just before dummy Tail node) of list
            addNodeBeforeTail(node);
        }
        else{
            if(map.size() == capacity){ //map size reached the capacity, so delete the oldest one to create space for new one.

                //delete the oldest node's key from map
                map.remove(head.next.key);

                //delete the oldest node in the linked list
                deleteNode(head.next);
            }
            //add new node in map
            Node node = new Node(key, value);
            //add new node to the map
            map.put(key, node);

            //add new node to the tail of the list.
            addNodeBeforeTail(node);

        }

    }

    public void deleteNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next; // prev -> next are connected (skipping the node or deleting the node)
        next.prev = prev; // next -> prev are connected (skipping the node or deleting the node)
    }

    public Node addNodeBeforeTail(Node node){
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
        return node;
    }

    public static void main(String[] args) {
        LRUCache lru1 = new LRUCache(2);
        lru1.put(1,1);   // list = 1
        lru1.put(2,2);   // list = 1,2
        System.out.println("1.least recently used element is " + lru1.get(1)); //1  //list = 2,1
        lru1.put(3,3);  //list = 1,3 (2 is deleted bcoz the capacity of LRU is only 2)
        System.out.println("2. least recently used element is " + lru1.get(2));//-1 // 2 is not in the list
        lru1.put(4,4);  // list = 3,4 (1 is deleted)
        System.out.println("3. least recently used element is " + lru1.get(1));// -1 (1 is deleted)
        System.out.println("4. least recently used element is " + lru1.get(3));// 3 // list = 4,3
        System.out.println("5. least recently used element is " + lru1.get(4));//4  // list = 3,4


        LRUCache lru2 = new LRUCache(1);
        lru1.put(2,1);   // list = 2 (2 is the key and 1 is the value)
        System.out.println("1.least recently used element is " + lru2.get(2)); //1  //list = 2 (2 is the key and its value is 1)
    }

}
