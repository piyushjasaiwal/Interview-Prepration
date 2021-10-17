/*
1. You are given a partially written GenericTree class.
2. You are required to find and print the diameter of tree. THe diameter is defined as maximum number of edges between any two nodes in the tree. Check the question video for clarity.
3. Input is managed for you.
Input Format
Input is managed for you
Output Format
diameter
Question Video

  COMMENTConstraints
None
Sample Input
20
10 20 -50 -1 60 -1 -1 30 -70 -1 80 -1 90 -1 -1 40 -100 -1 -1 -1
Sample Output
4
*/

import java.io.*;
import java.util.*;

class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  
  static HashMap<Node, Integer> map ;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    // write your code here
    map = new HashMap<>();
    // display(root);
    System.out.println(diameter(root));
  }

  public static int height(Node node){
    if(node == null){
      return -1;
    }
    if(map.containsKey(node)){
      return map.get(node);
    }

    int h = Integer.MIN_VALUE;
    for(Node nn : node.children){
      h = Math.max(h, height(nn));
    }
    map.put(node, h+1);
    return h+1;
  }

  public static int diameter(Node node){
    if(node == null){
      return 0;
    }

    int diameter_child = Integer.MIN_VALUE;
    int max_1 = Integer.MIN_VALUE;
    int max_2 = Integer.MIN_VALUE;
    for(Node nn : node.children){
      int h = height(nn);
      if(h > max_1){
        max_2 = max_1;
        max_1 = h;
      }else if(h > max_2){
        max_2 = h;
      }

      diameter_child = Math.max(diameter(nn), diameter_child);
    }

    int diameter_curr = max_1+max_2;
    return Math.max(diameter_curr, diameter_child);
  }

}