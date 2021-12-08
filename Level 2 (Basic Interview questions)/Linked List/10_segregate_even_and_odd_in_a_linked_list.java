/*abstract
Given a singly linklist, modify the list such that all the even numbers appear before all the odd numbers in the modified list. The order of appearance of numbers within each segregation should be same as that in the original list.
Input Format
1->7->2->6->3->5->4->null
Output Format
2->6->4->1->7->3->5->null
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
0 6 7 5 
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

    public static ListNode segregateEvenOdd(ListNode head) {
        ListNode dummy_even_head = null;
        ListNode dummy_odd_head = null;
        ListNode dummy_even_tail = null;
        ListNode dummy_odd_tail = null;

        ListNode temp = head;

        while(temp != null){
            if(temp.val%2 == 0){
                if(dummy_even_head == null){
                    dummy_even_head = temp;
                    dummy_even_tail = temp;
                }else{
                    dummy_even_tail.next = temp;
                    dummy_even_tail = temp;
                }
            }else{
                if(dummy_odd_head == null){
                    dummy_odd_head = temp;
                    dummy_odd_tail = temp;
                }else{
                    dummy_odd_tail.next = temp;
                    dummy_odd_tail = temp;
                }
            }
            ListNode next = temp.next;
            temp.next = null;
            temp = next;
        }
        if(dummy_even_tail != null){
            dummy_even_tail.next = dummy_odd_head;
            return dummy_even_head;
        }else{
            return dummy_odd_head;
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

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}