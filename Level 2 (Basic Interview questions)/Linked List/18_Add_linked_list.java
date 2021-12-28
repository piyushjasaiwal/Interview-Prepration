/*abstract
1. You are give two single linkedlist of digits. 
2. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
3. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input Format
1->2->3->4->5->6->7->null
7->8->9->null
Output Format
1->2->3->5->3->5->6->null
Question Video

  COMMENTConstraints
0 <= N <= 10^6
Sample Input
6
6 1 3 2 4 0 
2
3 5 
Sample Output
6 1 3 2 7 5 
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        ListNode c1 = reverse(l1), c2 = reverse(l2);
        int carry = 0;

        while(c1 != null || c2 != null || carry != 0){
            int sum = ((c1 != null) ? c1.val : 0) + ((c2 != null) ? c2.val : 0) + carry;
            carry = sum/10;
            sum = sum%10;
            
            c1 = (c1 == null) ? c1 :c1.next;
            c2 = (c2 == null) ? c2 :c2.next;
            temp.next = new ListNode(sum);
            temp = temp.next;
        }

        return reverse(head.next);
    }
    
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
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

        ListNode ans = addTwoNumbers(head1, head2);
        printList(ans);
    }

}