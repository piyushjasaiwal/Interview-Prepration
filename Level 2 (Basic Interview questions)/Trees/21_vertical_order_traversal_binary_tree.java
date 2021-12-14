/*abstract
1. Given a Binary Tree, print Vertical Order of it. 
2. For more Information watch given video link below.
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

class vertical_order_traversal_binary_tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Pair{
        int idx ;
        TreeNode node;

        public Pair(int idx, TreeNode node){
            this.idx = idx;
            this.node = node;
        }
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        int min_index = 0;
        int max_index = 0;
        LinkedList<Pair> q = new LinkedList<>();

        if(root != null){
            q.add(new Pair(0, root));
        }

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        while(!q.isEmpty()){
            Pair curr = q.removeFirst();
            min_index = Math.min(min_index, curr.idx);
            max_index = Math.max(max_index, curr.idx);
            ArrayList<Integer> temp = map.getOrDefault(curr.idx, new ArrayList<>());
            temp.add(curr.node.val);
            map.put(curr.idx, temp);

            if(curr.node.left != null){
                q.add(new Pair(curr.idx-1, curr.node.left));
            }

            if(curr.node.right != null){
                q.add(new Pair(curr.idx+1, curr.node.right));
            }
        }

        int len = max_index - min_index + 1;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0;i<len;i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0;i<len;i++){
            int req_idx = i+min_index;
            ArrayList<Integer> temp = map.get(req_idx);

            for(int val:temp){
                list.get(i).add(val);
            }
        }

        return list;
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