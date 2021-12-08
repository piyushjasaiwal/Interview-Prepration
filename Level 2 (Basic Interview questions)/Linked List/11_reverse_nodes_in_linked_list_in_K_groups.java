/*abstract
1. Given a singly linklist, reverse the nodes of a linked list k at a time and return its modified linkedlist.
2. If number of nodes in multiple of k then it will reverse otherwise it will add inn the end of linkedlist without any change.
Input Format
1->5->2->9->5->14->11->1->10->10->1->3->null
7
Output Format
11->14->5->9->2->5->1->10->10->1->3->null
Question Video

  COMMENTConstraints
1 <= size Of LinkedList <= 10^6
0 <= k <= 10^6
Sample Input
12
1 5 2 9 5 14 11 1 10 10 1 3 
7
Sample Output
11 14 5 9 2 5 1 1 10 10 1 3 
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

    public static ListNode reverseInKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode dummy_head = null;
        ListNode dummy_tail = null;
        int size = size(head);
        int i = 0;

        while(i+k < size && temp != null){
            ListNode curr = temp;
            ListNode next = temp.next;
            temp.next = null;

            if(dummy_head == null){
                dummy_head = curr;
                dummy_tail = curr;
            }else{
                curr.next = dummy_head;
                dummy_head = curr;
            }
            i+=1;
        }

        return null;
    }

    private static int size(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        return size;
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

        int k = scn.nextInt();
        h1 = reverseInKGroup(h1, k);
        printList(h1);
    }
}