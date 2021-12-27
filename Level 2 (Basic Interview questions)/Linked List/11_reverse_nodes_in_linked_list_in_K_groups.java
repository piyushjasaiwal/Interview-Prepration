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

    static ListNode th = null;
    static ListNode tt = null;
    static ListNode oh = null;
    static ListNode ot = null;
    
    private static void addFirst(ListNode curr) {
        if(th == null){
            th = curr;
            tt = curr;
        }else{
            curr.next = th;
            th = curr;
        }
    }

    public static ListNode reverseInKGroup(ListNode head, int k) {

        if(head == null || head.next == null || k < 1){
            return head;
        }

        int length = size(head);
        ListNode curr = head;

        while(length >= k){
            int temp_k = k;
            while(temp_k-- > 0){
                ListNode next = curr.next;
                curr.next = next;
                addFirst(curr);

                curr = next;
            }

            if(oh == null){
                oh = th;
                ot = tt;
            }else{
                ot.next = th;
                ot = tt;
            }

            th = null;
            tt = null;
            length-=k;
        }

        ot.next = curr;

        return oh;
        
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