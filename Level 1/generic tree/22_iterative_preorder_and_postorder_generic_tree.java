/*
1. You are given a partially written GenericTree class.
2. You are require to complete the body of function IterativePreandPostOrder. The function does not use recursion and prints preorder and postorder of the tree. Both orders are printed in separate lines (preorder first, followed by post order in next line). Elements in an order are separated by space.
3. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Elements in preorder separated by a space
Elements in postorder separated by a space
Question Video

  COMMENTConstraints
None
Sample Input
24
10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1
Sample Output
10 20 -50 60 30 70 -80 110 -120 90 40 -100 
-50 60 20 70 110 -120 -80 90 30 -100 40 10 
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

  public static void IterativePreandPostOrder(Node node) {
    // write your code here
    if(node == null){
    	return ;
    }
    preorder(node);
    postorder(node);
  }

  public static void preorder(Node node){
		Stack<Node> s=new Stack<>();
	  	s.push(node);
	  	
	  	while(!s.empty()){
	  		Node curr = s.pop();
	  		System.out.print(curr.data+" ");
	  		for(int i = curr.children.size()-1;i>=0;i--){
	  			s.push(curr.children.get(i));
	  		}
	  	}
	  	System.out.println();	  	
  }

  public static void postorder(Node node){
  		Stack<Node> s=new Stack<>();
	  	s.push(node);
	  	ArrayList<Integer> list = new ArrayList<>();
	  	while(!s.empty()){
	  		Node curr = s.pop();
	  		list.add(curr.data);
	  		for(Node nn:curr.children){
	  			s.push(nn);
	  		}
	  	}
	  	
	  	// System.out.println(list);
	  	for(int i = list.size()-1;i>=0;i--){
	  		System.out.print(list.get(i)+" ");
	  	}
		System.out.println();
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    IterativePreandPostOrder(root);
    // display(root);
  }

}