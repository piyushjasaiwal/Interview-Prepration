/*
1. Given a singly linklist, Reverse a linkedlist from position starting position to end position.
2. Do it in one-pass. without using any extra space.
3. Indexing start from numeric 1.
Input Format
8->8->14->1->10->12->null 
3
5
Output Format
8->8->10->1->14->12->null
Question Video

Constraints
1 <= size Of LinkedList <= 10^6
1 <= starting Position, ending Position <= 10^6
Sample Input
6
8 8 14 1 10 12 
3
5
Sample Output
8 8 10 1 14 12 
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

    public static void addNode(ListNode curr){
        if(th == null){
            th = curr;
            tt = curr;
        }else{
            curr.next = th;
            th = curr;
        }
    }

    public static ListNode reverseInRange(ListNode head, int n, int m) {
        n = n-1;
        m = m-1;
        ListNode n_1_node = null;
        ListNode m_1_node = null;

        ListNode temp = head;
        int i = 0;
        while(temp != null){
            if(i == n-1){
                n_1_node = temp;
                temp = temp.next;
            }else if(i == m+1){
                m_1_node = temp;
                temp = temp.next;
            }else if(i >= n && i <= m){
                ListNode next = temp.next;
                temp.next = null;
                addNode(temp);
                temp = next;
            }else{
                temp = temp.next;
            }
            i+=1;
        }

        if(n_1_node == null){
            head = th;
            tt.next = m_1_node;
        }else{
            n_1_node.next = th;
            tt.next = m_1_node;
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
        int sz = scn.nextInt();
        ListNode h1 = createList(sz);

        int m = scn.nextInt();
        int n = scn.nextInt();

        h1 = reverseInRange(h1, m, n);
        printList(h1);
    }
}