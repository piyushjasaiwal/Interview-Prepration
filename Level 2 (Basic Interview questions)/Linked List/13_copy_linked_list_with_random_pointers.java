/*abstract
1. Given a singly linklist with an additional random pointer which could point to any node in the list or NULL.
2. Return a deep copy of the list.
3. For More Details watch Video.
Input Format
input is handle for you
Output Format
output is handle for you.
Question Video

  COMMENTConstraints
0 <= N <= 10^6
Sample Input
5
7 -1
15 0
18 4
10 2
5 0
Sample Output
(7, -1) (15, 7) (18, 5) (10, 18) (5, 7) 
*/

import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode copyRandomList(ListNode head) {
        HashMap<Integer, ListNode> new_nodes_map = new HashMap<>();
        HashMap<ListNode, Integer> index_map = new HashMap<>();

        new_nodes_map.put(-1, null);
        index_map.put(null, -1);
        ListNode temp = head;
        for(int i=0;temp != null;i++){
            index_map.put(temp, i);
            temp = temp.next;
        }

        ListNode new_head = null, new_tail = null;

        temp = head;
        int i = 0;
        while(temp != null){
            ListNode node = new ListNode(temp.val);
            if(new_head == null){
                new_head = node;
                new_tail = node;
            }else{
                new_tail.next = node;
                new_tail = node;
            }

            new_nodes_map.put(i, node);
            i++;
            temp = temp.next;
        }

        temp = head;
        ListNode curr = new_head;

        while(temp != null){
            ListNode temp_random = temp.random;
            int temp_random_idx = index_map.get(temp_random);
            curr.random = new_nodes_map.get(temp_random_idx);
            
            temp = temp.next;
            curr = curr.next;
        }

        return new_head;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ListNode[] arr = new ListNode[n];
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            arr[i] = new ListNode(0);
            if (prev != null)
                prev.next = arr[i];
            prev = arr[i];
        }

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            int idx = scn.nextInt();

            arr[i].val = val;
            if(idx != -1) arr[i].random = arr[idx];
        }

        ListNode head = copyRandomList(arr[0]);
        while (head != null) {
            System.out.print("(" + head.val + ", " + (head.random != null ? head.random.val : -1) + ") ");
            head = head.next;
        }
    }
}