/*
1. You are required to complete the code of our Hashmap class. Please watch the question video carefully. The theoretical details of required functionality is explained in detail there. Implement the functions to achieve what is explained in the theoretical discussion in question video.
2. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
None
Sample Input
put India 135
put Aus 5
put Canada 3
display
get China
remove Aus
get Aus
containsKey US
put US 10
put UK 20
remove US
containsKey US
put Pak 80
put China 200
display
put Utopia 0
display
put Nigeria 3
display
put India 138
display
put Sweden 1
display
put finland 20
display
quit
Sample Output
Display Begins
Bucket0 .
Bucket1 .
Bucket2 Canada@3 .
Bucket3 India@135 Aus@5 .
Display Ends
null
5
null
false
10
false
Display Begins
Bucket0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 Nigeria@3 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@138 China@200 Nigeria@3 .
Display Ends
Display Begins
Bucket0 Utopia@0 Sweden@1 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@138 China@200 Nigeria@3 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Pak@80 finland@20 .
Bucket3 .
Bucket4 Sweden@1 .
Bucket5 .
Bucket6 Canada@3 UK@20 .
Bucket7 India@138 China@200 Nigeria@3 .
Display Ends
*/

import java.io.*;
import java.util.*;

class hashmap {

    public static class HashMap<K, V> {
      private class HMNode {
        K key;
        V value;

        public HMNode(K key, V value) {
          this.key = key;
          this.value = value;
        }
      }

      private int size; // n
      private LinkedList<HMNode>[] buckets; // N = buckets.length

      public HashMap() {
        initbuckets(4);
        size = 0;
      }

      private void initbuckets(int N) {
        buckets = new LinkedList[N];
        for (int bi = 0; bi < buckets.length; bi++) {
          buckets[bi] = new LinkedList<>();
        }
      }

      public void put(K key, V value) throws Exception {
        // write your code here
        int hash = hashcode(key);
        LinkedList<HMNode> bucket = buckets[hash];
        int idx = find_index(key, bucket);
        if(idx != -1){
          bucket.get(idx).value = value;
        }else{
          bucket.add(new HMNode(key, value));
          size+=1;
          double lambda = loading_factor();

          if(lambda > 2.0){
            
          }
        }
      }

      public double loading_factor(){
        return (size*1.0)/buckets.length;
      }

      public int find_index(K key, LinkedList<HMNode> bucket){
        int idx = 0;
        for(HMNode node:bucket){
          if(node.key.equals(key)){
            return idx;
          }
          idx+=1;
        }

        return -1;
      }

      public int hashcode(K key){
        int hash = key.hashCode();
        return Math.abs(hash)%buckets.length;
      }

      // public V get(K key) throws Exception {
      //   // write your code here
        
      // }

      // public boolean containsKey(K key) {
      //   // write your code here
      // }

      // public V remove(K key) throws Exception {
      //   // write your code here
      // }

      // public ArrayList<K> keyset() throws Exception {
      //   // write your code here
      // }

      public int size() {
        // write your code here
        return size;
      }

    public void display() {
        System.out.println("Display Begins");
        for (int bi = 0; bi < buckets.length; bi++) {
          System.out.print("Bucket" + bi + " ");
          for (HMNode node : buckets[bi]) {
            System.out.print( node.key + "@" + node.value + " ");
          }
          System.out.println(".");
        }
        System.out.println("Display Ends");
    }
  }

    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      HashMap<String, Integer> map = new HashMap();

      String str = br.readLine();
      while (str.equals("quit") == false) {
        if (str.startsWith("put")) {
          String[] parts = str.split(" ");
          String key = parts[1];
          Integer val = Integer.parseInt(parts[2]);
          map.put(key, val);
        } else if (str.startsWith("get")) {
          String[] parts = str.split(" ");
          String key = parts[1];
          System.out.println(map.get(key));
        } else if (str.startsWith("containsKey")) {
          String[] parts = str.split(" ");
          String key = parts[1];
          System.out.println(map.containsKey(key));
        } else if (str.startsWith("remove")) {
          String[] parts = str.split(" ");
          String key = parts[1];
          System.out.println(map.remove(key));
        } else if (str.startsWith("size")) {
          System.out.println(map.size());
        } else if (str.startsWith("keyset")) {
          System.out.println(map.keyset());
        } else if (str.startsWith("display")) {
          map.display();
        }
        str = br.readLine();
      }
    }
}