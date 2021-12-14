/*abstract
1. Given a Binary Tree, print Bottom View of it. 
2. For more Information watch given video link below.
Input Format
Input is managed for you.
Output Format
Output is managed for you. 
Question Video

Constraints
Constraints:
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
1 1 1 
*/

import java.util.*;

class bottom_view_binary_tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    static int min = 0;
    static int max = 0;
    public static ArrayList<Integer> BottomView(TreeNode root) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        min = 0;
        max = 0;
        vertical_order(root, 0, map);
        ArrayList<Integer> lot = new ArrayList<>();
        lot_make(root, lot);

        int len = max-min+1;
        for(int j = 0;j<len;j++){
            int req = j+min;

            HashSet<Integer> set = map.get(req);
            boolean flag = false;
            for(int i = lot.size()-1;i>=0;i--){
                if(set.contains(lot.get(i))){
                    list.add(lot.get(i));
                    flag = true;
                    break;
                }
            }

            if(flag){
                continue;
            }
        }

        return list;
    }

    
    private static void lot_make(TreeNode root, ArrayList<Integer> lot) {
        LinkedList<TreeNode> q = new LinkedList<>();
        if(root != null){
            q.add(root);
        }

        while(!q.isEmpty()){
            TreeNode curr = q.removeFirst();
            lot.add(curr.val);
            if(curr.left != null){
                q.add(curr.left);
            }

            if(curr.right != null){
                q.add(curr.right);
            }
        }
    }
    
    private static void vertical_order(TreeNode root, int idx, HashMap<Integer, HashSet<Integer>> map) {
        if(root == null){
            return ;
        }
        
        min = Math.min(min, idx);
        max = Math.max(max, idx);
        
        HashSet<Integer> set = map.getOrDefault(idx, new HashSet<>());
        set.add(root.val);
        map.put(idx, set);
        
        vertical_order(root.left, idx-1, map);
        vertical_order(root.right, idx+1, map);
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

        ArrayList<Integer> ans = BottomView(root);
        for (Integer i : ans)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}