/*abstract
1. You are give a single sorted linkedlist of numbers. 
2. remove all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the remaning linked list.
Input Format
1->1->1->4->5->6->6->7->8->9->9->9->null
Output Format
4->5->7->8->null
Question Video

  COMMENTConstraints
0 <= N <= 10^6
Sample Input
12
1 1 1 4 5 6 6 7 8 9 9 9
Sample Output
4 5 7 8 
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

    public static ListNode removeDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode itr = dummy;
        itr.next = head;
        ListNode curr = head.next;

        while(curr != null){
            boolean flag = false;
            while(curr != null && itr.next.val == curr.val){
                curr = curr.next;
                flag = true;
            }

            if(flag){
                itr.next = curr;
            }else{
                itr = itr.next;
            }

            if(curr != null){
                curr = curr.next;
            }
        }

        return dummy.next ;
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
        ListNode head = makeList(scn.nextInt());

        ListNode ans = removeDuplicates(head);
        printList(ans);
    }

}