/*
1. Merge two sorted linkedlists and return head of a sorted linkedlist. The list should be made by splicing together the nodes of the first two lists
2. Both list are sorted in increasing order.
Input Format
1->2->6->7->15->24->null
-1->0->6->17->25->null
Output Format
-1->0->1->2->6->6->7->15->17->24->25->null
Question Video

  COMMENTConstraints
0 <= size of linkedlist <= 10^6
Sample Input
2
1 5 
4
1 3 6 10 
Sample Output
1 1 3 5 6 10 
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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h1 = l1;
        ListNode h2 = l2;

        ListNode head = null;
        ListNode tail = null;

        while(h1 != null && h2 != null){
            if(h1.val < h2.val){
                ListNode temp = new ListNode(h1.val);
                if(head == null){
                    head = temp;
                    tail = temp;
                }else{
                    tail.next = temp;
                    tail = temp;
                }
                h1 = h1.next;
            }else{
                ListNode temp = new ListNode(h2.val);
                if(head == null){
                    head = temp;
                    tail = temp;
                }else{
                    tail.next = temp;
                    tail = temp;
                }
                h2 = h2.next;
            }
        }

        while(h1 != null){
            ListNode temp = new ListNode(h1.val);
            if(head == null){
                head = temp;
                tail = temp;
            }else{
                tail.next = temp;
                tail = temp;
            }
            h1 = h1.next;
        }

        while(h2 != null){
            ListNode temp = new ListNode(h2.val);
            if(head == null){
                head = temp;
                tail = temp;
            }else{
                tail.next = temp;
                tail = temp;
            }
            h2 = h2.next;
        }

        return head;
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
        int m = scn.nextInt();
        ListNode h2 = createList(m);


        ListNode head = mergeTwoLists(h1, h2);
        printList(head);
    }
}