/*
 * Implement LRU(Least Recently Used Cache), Task is to complete implementations of put(),get().
1. capacity : capacity of the cache will be provided as input.
2. put(key,value) : add the key-value pair to the Cache & override if the pair is already present in cache;
3. get(key) : get the value associated with the key, return "-1" incase key-value pair doesn't exists

NOTE : Watch Question video to get better understanding of problem.
Example  : 
    Input : Start 3
            put 1 10
            put 2 20
            put 3 30
            get 1
            put 1 15
            get 1
            get 2
            put 4 40
            get 3
            get 4
            Stop
            
            
    Output : 10
             15
             20
             -1
             40
Input Format
Output Format is handled for you.
Output Format
Output Format is handled for you.
Question Video

  COMMENTConstraints
1 <= cap <= 2000
0 <= key <= 100000
0 <= val <= 100000
Sample Input
start 3
put 1 10
put 2 20
put 3 30
put 4 40
get 1
stop
Sample Output
-1

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class DLL{
    int cap;
    int size;
    Node head;
    Node tail;

    DLL(){
        this(0);
    }

    DLL(int c){
        cap = c;
        size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;

        node.prev = null;
        node.next = null;
        prev.next = next;
        next.prev = prev;
        size--;
    }

    public void add(Node node, HashMap<Integer, Node> map){
        if(size >= cap){
            map.remove(tail.prev.key);
            remove(tail.prev);
        }

        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    public void print(){
        Node temp = head.next;
        System.out.println("-------------------------------------------------");
        while(temp != tail){
            System.out.println(temp.key + " " + temp.value);
            temp = temp.next;
        }
        System.out.println("-------------------------------------------------");
    }
}

class Node{
    int key;
    int value;
    Node next;
    Node prev;

    Node(){
        this(-1, -1);
    }

    Node(int k, int v){
        key = k;
        value = v;
    }
}

class LRU_cache {
  public static class LRU {
    HashMap<Integer, Node> map;
    DLL list;
    LRU(int capacity) {
        map = new HashMap<>();
        list= new DLL(capacity);
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        list.remove(node);
        list.add(node, map);
        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            list.remove(node);
            list.add(node, map);
        }else{
            Node nn = new Node(key, value);
            map.put(key, nn);
            list.add(nn, map);
        }
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    LRU obj = new LRU(Integer.parseInt(str.split(" ")[1]));

    while (true) {
      str = br.readLine();
      String inp[] = str.split(" ");
      if (inp.length == 1) {
        break;
      } else if (inp.length == 2) {
        System.out.println(obj.get(Integer.parseInt(inp[1])));
      } else if (inp.length == 3) {
        obj.put(Integer.parseInt(inp[1]), Integer.parseInt(inp[2]));
      }
    }
  }
}
