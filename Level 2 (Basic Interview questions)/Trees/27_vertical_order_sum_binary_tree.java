/*abstract
1. Given a Binary Tree, print Vertical Order Sum of it. 
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
2
3
2
*/

import java.util.*;

class vertical_order_sum_binary_tree {
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

    public static ArrayList<Integer> verticalOrderSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        min = 0;
        max = 0;

        VOT(root, map, 0);
        ArrayList<Integer> ans = new ArrayList<>();

        int len = max - min + 1;

        for(int j = 0;j<len;j++){
            ans.add(map.get(j+min));
        }
        // System.out.println(map);
        return ans;
    }



    // input_section=================================================

    private static void VOT(TreeNode root, HashMap<Integer, Integer> map, int idx) {
        if(root == null){
            return ;
        }

        min = Math.min(min, idx);
        max = Math.max(max, idx);

        int sum = map.getOrDefault(idx, 0);
        sum += root.val;

        map.put(idx, sum);

        VOT(root.left, map, idx-1);
        VOT(root.right, map, idx+1);
    }



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

        ArrayList<Integer> ans = verticalOrderSum(root);
        for (Integer j : ans)
            System.out.println(j);

    }

    public static void main(String[] args) {
        solve();
    }
}