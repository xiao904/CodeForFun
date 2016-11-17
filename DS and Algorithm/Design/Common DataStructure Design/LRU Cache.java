/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

*/

public class LRUCache {
    
    Node head = new Node();
    Node tail = head;
    Map<Integer, Node> cache = new HashMap<Integer, Node>();
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
           return -1;
        Node n = cache.get(key);
        moveNodeToTail(n);
        return n.val;
    }
    
    public void set(int key, int value) {
        if(cache.containsKey(key)){
            cache.get(key).val = value;
            moveNodeToTail(cache.get(key));
        }else{
            if(cache.size() == capacity){
                
                cache.remove(head.next.key);
                head.next.delete();
            }
            Node n = new Node(key, value);
            addNodeToTail(n);
            cache.put(key, n);
        }
    }
    
    public void addNodeToTail(Node n){
        tail.next = n;
        n.pre = tail;
        n.next = null;
        tail = n;
    }
    
    public void moveNodeToTail(Node n){
        if(n == tail) return;
        n.delete();
        addNodeToTail(n);
    }
}

class Node{
    int key;
    int val;
    Node pre;
    Node next;
    
    Node(){
        
    }
    
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
    
    public void delete(){
        pre.next = next;
        if(next != null){
          next.pre = pre;
        }
    }
    
}