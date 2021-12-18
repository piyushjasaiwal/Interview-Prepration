/*abstract
1. Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
2. The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL. 
3. The order of nodes in DLL must be the same as in Inorder for the given Binary Search Tree. The first node of Inorder traversal (leftmost node in BST) must be the head node of the DLL. 
Input Format
Input is managed for you.
Output Format
Output is managed for you. 
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Sample Input
7
1 2 3 4 5 6 7
Sample Output
1 2 3 4 5 6 7 
*/

import java.util.Scanner;

 class convert_BST_to_doubly_linked_list {
    public static Scanner scn = new Scanner(System.in);

    public static class Node {
        int val = 0;
        Node left = null;
        Node right = null;

        Node(int val) {
        this.val = val;
        }
    }

    public static Node bToDLL(Node root) {
        if(root == null){
            return null;
        }

        if(root.left == null && root.right == null){
            return new Node(root.val);
        }

        Node left = bToDLL(root.left);
        Node right = bToDLL(root.right);

        Node node = new Node(root.val);
        
        Node left_head = left;
        Node left_tail = left;

        while(left_tail != null && left_tail.right != null){
            left_tail = left_tail.right;
        }

        Node right_head = right;
        Node right_tail = right;

        while(right_tail != null && right_tail.right != null){
            right_tail = right_tail.right;
        }
        if(left_tail != null){
            left_tail.right = node;
        }
        node.left = left_tail;
        if(right_head != null){
            right_head.left = node;
        }
        node.right = right_head;

        return left_head == null ? node : left_head;
    }

    // input_section=================================================

    public static void display(Node node) {
        Node head = node;
        while (node != null) {
        System.out.print(node.val + " ");
        node = node.right;
        if (node == head)
            break;
        }

    }

    public static Node constructFromInOrder_(int[] in, int si, int ei) {
        if (si > ei)
        return null;

        int mid = (si + ei) / 2;
        Node node = new Node(in[mid]);

        node.left = constructFromInOrder_(in, si, mid - 1);
        node.right = constructFromInOrder_(in, mid + 1, ei);

        return node;
    }

    public static Node constructFromInOrder(int[] inOrder) {
        int n = inOrder.length;
        return constructFromInOrder_(inOrder, 0, n - 1);
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        Node root = constructFromInOrder(in);
        root = bToDLL(root);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}