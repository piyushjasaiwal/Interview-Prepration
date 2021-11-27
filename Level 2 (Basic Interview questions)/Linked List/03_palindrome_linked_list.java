/*
Given a singly linked list of Integers, determine it is a palindrome or not.
Input Format
1->2->3->4->3->2->1->null
1->2->3->4->2->1->null
Output Format
true
false
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
true
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

    public static boolean isPalindrome(ListNode head) {
    	int size = size(head);
    	ListNode middle = give_middle(head);
    	ListNode tail = reverse(middle);

    	ListNode first = head;
    	ListNode last = tail;

    	int i = 0;
    	int j = size-1;

    	while(i < j){
    		// System.out.println(i+" "+j);
    		// System.out.println(first.val+" "+last.val);
    		// System.out.println("---------------------------------------------------");
    		if(first.val != last.val){
    			return false;
    		}

    		first = first.next;
    		last = last.next;
    		i++;
    		j--;
    	}
    
        return true;
    }

    public static ListNode give_middle(ListNode head){
    	ListNode slow = head;
    	ListNode fast = head;

    	while(fast != null && fast.next != null){
    		slow = slow.next;
    		fast = fast.next.next;
    	}

    	return slow;
    }

    public static ListNode reverse(ListNode head){
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

    public static int size(ListNode head){
    	ListNode temp = head;
    	int i = 0;
    	while(temp != null){
    		i+=1;
    		temp = temp.next;
    	}
    	return i;
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

        System.out.println(isPalindrome(dummy.next));
    }
}