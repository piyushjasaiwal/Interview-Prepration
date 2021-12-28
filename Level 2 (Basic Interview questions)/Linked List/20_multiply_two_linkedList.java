/*abstract
1. You are given two single linkedlist of digits. 
2. The most significant digit comes first and each of their nodes contain a single digit. Multiply the two numbers and return it as a linked list.
3. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input Format
1->2->3->4->5->null
7->8->9->null
Output Format
9->7->4->0->2->0->6->null
Question Video

  COMMENTConstraints
0 <= N <= 10^6
Sample Input
6
6 1 3 2 4 0 
2
3 5 
Sample Output
2 1 4 6 3 4 0 0 
*/

import java.util.*;

class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {
        return null;
    }

    // Input_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = makeList(scn.nextInt());
        ListNode head2 = makeList(scn.nextInt());

        ListNode ans = multiplyTwoLL(head1, head2);
        printList(ans);
    }

}