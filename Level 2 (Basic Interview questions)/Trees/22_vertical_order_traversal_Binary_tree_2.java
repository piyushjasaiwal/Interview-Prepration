/*abstract
1. Given a Binary Tree, print Vertical Order of it. 
2. For each node at position (row, col), its left and right 
   children will be at positions (row + 1, col - 1) and (row + 1, col + 1) 
   respectively. The root of the tree is at (0, 0).
3. The vertical order traversal of a binary tree is a list of top-to-bottom 
   orderings for each column index starting from the leftmost column and ending 
   on the rightmost column. There may be multiple nodes in the same row and same 
   column. In such a case, sort these nodes by their values.
4. For More Information Watch Question Video link below.
Input Format
Input is managed for you.
Output Format
Output is managed for you. 
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^5
-1000 <= value of Node data <= 1000
Sample Input
15
1
1
-1
1
1
-1
1
-1
-1
1
-1
-1
1
-1
-1
Sample Output
0 -> 1 1 
1 -> 1 1 1 
2 -> 1 1 
*/

import java.util.*;

class vertical_order_traversal_Binary_tree_2 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Pair{
        TreeNode node;
        int idx;

        public Pair(TreeNode n, int i){
            node = n;
            idx = i;
        }
    }
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        int min = 0;
        int max = 0;
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        LinkedList<Pair> ll = new LinkedList<>();
        if(root != null){
            ll.add(new Pair(root, 0));
        }
        
        while(!ll.isEmpty()){
            Pair curr = ll.removeFirst();
            if(curr.node == null){
                continue;
            }

            PriorityQueue<Integer> temp = map.getOrDefault(curr.idx, new PriorityQueue<>());
            temp.add(curr.node.val);
            min = Math.min(min, curr.idx);
            max = Integer.max(max, curr.idx);
            map.put(curr.idx, temp);

            ll.add(new Pair(curr.node.left, curr.idx-1));
            ll.add(new Pair(curr.node.right, curr.idx+1));
        }

        int len = max-min+1;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<len;i++){
            ans.add(new ArrayList<>());
            PriorityQueue<Integer> pq = map.get(i+min);
            if(pq!=null){    
                while(!pq.isEmpty()){
                    ans.get(i).add(pq.poll());
                }
            }
        }

        return ans;
    }

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
        int idx = 0;
        display(root);
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}