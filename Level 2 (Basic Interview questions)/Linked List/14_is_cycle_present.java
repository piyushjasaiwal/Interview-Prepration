/*abstract
1. Given a singly linklist. determine if the linked list has a cycle in it.
2. There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
Input Format
input is handle for you
Output Format
output is handle for you.
Question Video

  COMMENTConstraints
0 <= N <= 10^6
Sample Input
8
1
18
1
8
-1
138
31
84
3
Sample Output
true
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

    public static boolean isCyclePresentInLL(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    public static ListNode takeInput() {
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }
        int idx = scn.nextInt();
        if (idx >= 0) {
            ListNode curr = dummy.next;
            while (idx-- > 0) {
                curr = curr.next;
            }
            prev.next = curr;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = takeInput();
        System.out.println(isCyclePresentInLL(head));
    }
}