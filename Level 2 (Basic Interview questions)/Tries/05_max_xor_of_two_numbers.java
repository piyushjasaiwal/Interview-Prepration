/*abstract
1. Given an integer array nums.
2. return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1. 1 <= nums.length <= 2 * 10^5
2. 0 <= nums[i] <= 2^31 - 1
Sample Input
6
3 
10 
5 
25 
2 
8
Sample Output
28
*/

import java.io.*;

class Main {

  static class Trie{
    class Node{
      Node left, right;
    }
  
    Node root;
  
    Trie(){
      root = new Node();
    }
  
    public void insert(int num){
      Node curr = root;
      int bitindex = 30;
  
      while(bitindex >= 0){
        int mask = (1<<bitindex);
  
        int bit = ((num&mask) > 0) ? 1 : 0;
        if(bit == 1){
          if(curr.right == null){
            curr.right = new Node();
          }
          curr = curr.right;
        }else{
          if(curr.left == null){
            curr.left = new Node();
          }
          curr = curr.left;
        }
  
        bitindex--;
      }
    }
  
    public int query(int find){
      int ans = 0;
      int bitindex = 30;
      Node curr = root;
  
      while(bitindex >= 0){
        int mask = (1<<bitindex);
        int bit = (find&mask) > 0 ? 1 : 0;
        
        if(bit == 0){
          if(curr.left != null){
            curr = curr.left;
          }else{
            curr = curr.right;
            ans = (ans|mask); 
          }
        }else{
          if(curr.right != null){
            curr = curr.right;
            ans = (ans|mask); 
          }else{
            curr = curr.left;
          }
        }
  
        bitindex--;
      }
  
      return ans;
    }
  
  
  }

  public static int findMaximumXOR(int[] nums) {
    // write your code here

    Trie trie = new Trie();

    int max = 0;

    for(int val:nums){
      trie.insert(val);
    }

    for(int val:nums){
      int find = Integer.MAX_VALUE^val;
      int res = trie.query(find);
      max = Math.max(max, val^res);
    }

    return max;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine().trim());
    int arr[] = new int[n];
    for (int i = 0; i < n; i++)arr[i] = Integer.parseInt(read.readLine().trim());

    int result = findMaximumXOR(arr);
    System.out.println(result);

  }
}
