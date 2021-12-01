/*abstract
Given the head of a linked list, return the list after sorting it in increasing order.
Time Complexity : O(nlogn)
Space Complexity : constant space 
Input Format
1->7->2->6->3->5->4->null
Output Format
1->2->3->4->5->6->7->null
Question Video

  COMMENTConstraints
0 <= N <= 10^6
Sample Input
4
0
6
7
5
Sample Output
0 5 6 7 
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

    public static ListNode mergeSort(ListNode head) {
        // int size = size(head);
        // return mergeSort(head, )
        return null;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);

        ListNode head = mergeSort(h1);
        printList(head);
    }
}