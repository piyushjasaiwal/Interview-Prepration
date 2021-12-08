/*
Given a singly linkedlist : l0 -> l1 -> l2 -> l3 -> l4 -> l5 -> l6 ..... -> ln-1 -> ln 
reorder it : l0 -> ln -> l1 -> ln-1 -> l2 -> ln-2 -> l3 -> ln-3 -> ..... 

for more information watch video.
Input Format
1->2->3->4->5->6->7->null
Output Format
1->7->2->6->3->5->4->null
Question Video

  COMMENTConstraints
0 <= N <= 10^6
Sample Input
10
5
1
4
6
9
9
6
4
1
5
Sample Output
5 5 1 1 4 4 6 6 9 9 
*/

import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void fold(ListNode head) {
        ListNode mid = midLinkedList(head);
        ListNode newHead = mid.next;
        mid.next = null;

        newHead = reverse(newHead);

        ListNode c1 = head;
        ListNode c2 = newHead;
        ListNode f1 = null;
        ListNode f2 = null;

        while(c2 != null){
            f1 = c1.next;
            f2 = c2.next;

            c1.next = c2;
            c2.next = f1;

            c1 = f1;
            c2 = f2;
        }
    }

    private static ListNode reverse(ListNode newHead) {
        ListNode prev = null;
        ListNode curr = newHead;
        ListNode next = null;
        if(curr != null){
            next = curr.next;
        }

        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null){
                next = next.next;
            }
        }

        newHead = prev;
        return prev;
    }

    public static ListNode midLinkedList(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        fold(head);
        printList(head);
    }
}