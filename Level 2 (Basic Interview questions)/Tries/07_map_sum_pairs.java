/*abstract
Implement the MapSum class:
1. MapSum() Initializes the MapSum object.
2. void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed, the original key-value pair will be overridden to the new one.
3. int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1. 1 <= key.length, prefix.length <= 50
2. key and prefix consist of only lowercase English letters.
3. 1 <= val <= 1000
Sample Input
apple 3
ap
app 2
apple 2
ap
exit
Sample Output
3
4
*/
import java.io.*;
import java.util.*;

class Main {
  public static class MapSum {

    /** Initialize your data structure here. */

    static class Node{
      Node [] children;
      boolean isEnd;
      int value ;

      Node(){
        children = new Node[26];
        isEnd = false;
        value = 0;
      }
    }

    static Node root ;

    public MapSum() {
      root = new Node();
    }

    public void insert(String key, int val) {
      Node curr = root;
      for(int i = 0;i<key.length();i++){
        char ch = key.charAt(i);
        if(curr.children[ch - 'a'] == null){
          curr.children[ch-'a'] = new Node();
        }

        curr = curr.children[ch-'a'];
      }
      curr.isEnd = true;
      curr.value = val;
    }

    public int sum(String prefix) {
      Node curr = root;
      for(int i = 0;i<prefix.length();i++){
        char ch = prefix.charAt(i);
        if(curr.children[ch - 'a'] == null){
          return 0;
        }
        curr = curr.children[ch-'a'];
      }
      return sum_helper(curr);
    }

    private int sum_helper(Node curr) {
      if(curr == null){
        return 0;
      }

      int sum = curr.value;
      for(Node child : curr.children){
        sum += sum_helper(child);
      }

      return sum;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    MapSum obj = new MapSum();

    while (read.ready()) {
      String inp[] = read.readLine().split(" ");
      if (inp[0].equals("exit"))break;

      if (inp.length == 2) {
        obj.insert(inp[0], Integer.parseInt(inp[1]));
      } else {
        System.out.println(obj.sum(inp[0]));
      }
    }
  }
}

