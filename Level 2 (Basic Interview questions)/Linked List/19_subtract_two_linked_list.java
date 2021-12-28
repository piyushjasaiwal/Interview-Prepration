/*abstract
1. You are give two single linkedlist of digits. 
2. The most significant digit comes first and each of their nodes contain a single digit. Subtract the two numbers and return it as a linked list.
3. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
4. any list can be larger in term of number.
Input Format
1->2->3->4->5->6->7->null
7->8->9->null
Output Format
1->2->3->3->7->7->8->null
Question Video

  COMMENTConstraints
0 <= N <= 10^6
Sample Input
6
1 8 0 5 4 6 
1
1 
Sample Output
1 8 0 5 4 5
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

    public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
        int size1 = size(l1);
        int size2 = size(l2);

        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode g = null , s = null;
        if(size1 == size2){
            g = isGreater(l1, l2) > 0 ? l1 : l2;
            s = isGreater(l1, l2) < 0 ? l1 : l2;
        }else{
            g = size1>size2 ? l1:l2;
            s = size1<size2 ? l1:l2;
        }

        ListNode head = new ListNode(-1);
        ListNode curr = head;

        while(g != null || s != null){
            int val_g = g != null ? g.val:0;
            int val_s = s != null ? s.val:0;

            if(val_g < val_s){
                val_g = val_g+10;
                g.next.val = g.next.val-1;
            }

            int dif = val_g-val_s;

            curr.next = new ListNode(dif);
            curr = curr.next;

            g = g!=null?g.next:g;
            s = s!=null?s.next:s;
        }

        head = reverse(head.next);

        while(head != null && head.next != null && head.val == 0){
            head = head.next;
        }
        
        return head;
    }

    // Input_code===================================================

    private static int isGreater(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while(temp1!= null){
            if(temp1.val > temp2.val){
                return 1;
            }else if(temp1.val > temp2.val){
                return -1;
            }else{
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }

        return 1;
    }

    public static int size(ListNode l) {
        int len = 0;
        ListNode temp = l;

        while(temp!=null){
            temp = temp.next;
            len++;
        }
        return len;
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

        ListNode ans = subtractTwoNumbers(head1, head2);
        printList(ans);
    }

}