/*abstract
1. Convert a sorted Doubly-Linked List to a Balanced Binary Search Tree in place.
2. The previous and next pointers in nodes are to be used as left and right pointers respectively in converted Binary Search Tree. 
3. The tree must be constructed in-place (No new node should be allocated for tree conversion) 
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
2 -> 4 <- 6
1 -> 2 <- 3
. -> 1 <- .
. -> 3 <- .
5 -> 6 <- 7
. -> 5 <- .
. -> 7 <- .
*/

import java.util.*;

class convert_sorted_doubly_linked_list_to_BST {
    public static Scanner scn = new Scanner(System.in);

    public static class Node {
        int val = 0;
        Node left = null;
        Node right = null;

        Node(int val) {
        this.val = val;
        }
    }

    // left : prev, right : next
    public static Node SortedDLLToBST(Node head) {
        HashMap<Integer, Node> map = new HashMap<>();
        Node temp = head;
        int len = 0;
        while(temp != null){
            map.put(len, temp);
            len++;
            temp = temp.right;
        }

        return SortedDLLToBST(0, len-1, map);
    }

    // Input_code===================================================

    private static Node SortedDLLToBST(int lo, int hi, HashMap<Integer, Node> map) {
        if(lo > hi){
            return null;
        }

        if(lo == hi){
            return new Node(map.get(lo).val);
        }

        int mid = (lo+hi)/2;
        Node node = new Node(map.get(mid).val);
        node.left = SortedDLLToBST(lo, mid-1, map);
        node.right = SortedDLLToBST(mid+1, hi, map);
        return node;
    }

    public static void display(Node node) {
        if (node == null)
        return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static Node makeList(int n) {
        Node dummy = new Node(-1);
        Node prev = dummy;
        while (n-- > 0) {
            Node node = new Node(scn.nextInt());
            prev.right = node;
            node.left = prev;
            prev = prev.right;
        }

        Node head = dummy.right;
        head.left = dummy.right = null;

        return head;
    }

    public static void main(String[] args) {
        Node head = makeList(scn.nextInt());

        head = SortedDLLToBST(head);
        display(head);
    }

}