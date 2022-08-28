import java.util.*;
class Solution {
    
    HashMap<Integer, Node> map = new HashMap<>();
    DLL list;
    
    public Solution(int capacity) {
        list = new DLL(capacity);
        
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        
        Node node = map.get(key);
        list.remove(node);
        list.add(node);
        return node.val;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            list.remove(node);
            list.add(node);
            return ;
        }
        
        Node nn = new Node(key, value);
        map.put(key, nn);
        list.add(nn);
    }

}

class DLL{
    
    int size = 0;
    int capacity;
    Node head;
    Node tail;
    
    DLL(int c){
        capacity = c;
        head = new Node();
        tail = new Node();
        head.prev = tail;
        tail.next = head;
    }
    
    DLL(){
        this(0);
    }
    
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        size--;
    }
    
    public void add(Node node){
        
        if(size >= capacity){
            remove(tail.next);
        }
        
        node.next = head;
        node.prev = head.prev;
        head.prev.next = node;
        head.prev = node;
        size++;
    }
}


class Node{
    int key;
    int val;
    Node prev;
    Node next;
    
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
    
    Node(){
        this(-1, -1);
    }
}



class Main{
    public static void main(String[] args) {
        Solution sol = new Solution(2);
        sol.set(1, 10);
        sol.set(5, 12);
        sol.get(5);     //   returns 12
        sol.get(1) ;  //     returns 10
        sol.get(10) ;      //returns -1
        sol.set(6, 14) ; //  this pushes out key = 5 as LRU is full. 
        sol.get(5); 
    }
}