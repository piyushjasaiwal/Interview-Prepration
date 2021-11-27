/*
You have given a pointer to the head node of a linked list, the task is to reverse the linked list. 
We need to reverse the list by changing the links between nodes.
Input Format
1->2->3->4->5->6->7->null
Output Format
7->6->5->4->3->2->1->null
Question Video

  COMMENTConstraints
0 <= N <= 10^6
Sample Input
7
1 2 3 4 5 6 7
Sample Output
7 6 5 4 3 2 1
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

    public static ListNode reverse(ListNode head) {
      	ListNode prev = null;
      	ListNode curr = head;
      	ListNode next = null;
      	if(curr != null){
      		next = head.next;
      	}

      	while(curr != null){
      		curr.next = prev;
      		prev = curr;
      		curr = next;

      		if(next != null){
      			next = next.next;
      		}
      	}

      	head = prev;
      	
        return head;
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

        ListNode head = reverse(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
			head = head.next;
        }
    }
}