/*abstract
You are given an array of k linked-lists, each linked-list is sorted in increasing order.
Merge all the linkedlists into one sorted linkedlist and return it.
Input Format
3 sorted linkedlist :
{
    0->0->0->null,
    0->0->1->1->1->2->2->4->null,
    0->0->0->0->5->5->6->null
}
Output Format
after merging them : 
0->0->0->0->0->0->0->0->0->1->1->1->2->2->4->5->5->6->null
Question Video

  COMMENTConstraints
0 <= k <= 10^5
0 <= size of linkedlist <= 1000
Sample Input
3
3
0 0 0 
8
0 0 1 1 1 2 2 4 
7
0 0 0 0 5 5 6 
Sample Output
0 0 0 0 0 0 0 0 0 1 1 1 2 2 4 5 5 6
*/

import java.util.*;

class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode implements Comparable<ListNode>{
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public int compareTo(Main.ListNode o) {
            // TODO Auto-generated method stub
            return this.val - o.val;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>();

        for(ListNode list: lists){
            if(list!=null){
                pq.add(list);
            }
        }

        ListNode head = null;
        ListNode tail = null;

        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            if(curr!=null){
                ListNode temp = new ListNode(curr.val);
                if(head == null){
                    head = temp;
                    tail = temp;
                }else{
                    tail.next = temp;
                    tail = temp;
                }
                if(curr.next != null){
                    pq.add(curr.next);
                }
            }
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
        int n = scn.nextInt();
        ListNode[] list = new ListNode[n];
        for (int i = 0; i < n; i++) {
            int m = scn.nextInt();
            list[i] = createList(m);
        }

        ListNode head = mergeKLists(list);
        printList(head);
    }
}