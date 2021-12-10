/*
1. You are given a partially written BinaryTree class.
2. You are required to find the root of largest sub-tree which is a BST. Also, find the number of nodes in that sub-tree.
3. Input is managed for you. 

Note -> Please refer the question video for clarity.
Input Format
Input is managed for you.
Output Format
@
Question Video

  COMMENTConstraints
Time complexity must be O(n)
Space should not be more than required for recursion (call-stack)
Sample Input
15
50 25 12 n n 37 n n 75 62 n n 87 n n
Sample Output
50@7
*/

import java.io.*;
import java.util.*;

class Main {
  static String ans = "";
  static int count = 0;

  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    
    // write your code here
    display(root);
    largest_bst_subtree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    System.out.println(ans);
  }

  public static int largest_bst_subtree(Node root, int lo, int hi){
    if(root == null){
      return 0;
    }

    System.out.println(root.data + " = > "+"lo => "+lo+" hi => "+hi);
    // System.out.println();

    if(root.data < lo || root.data > hi){
      return -1;
    }

    int left = largest_bst_subtree(root.left, lo, root.data-1);
    int right = largest_bst_subtree(root.right, root.data+1, hi);
    // System.out.println(root.data + " = > "+"left => "+left+" right => "+right);

    if(left == -1 || right == -1){
      return -1;
    }

    int total = left+right+1;
    if(count < total){
      ans = (root.data + "@" + total);
      // System.out.println((root.data + "@" + total));
      count = total;
    }
    // System.out.println(ans);
    // ans = (root.data + "@" + total);
    return total;
  }



}