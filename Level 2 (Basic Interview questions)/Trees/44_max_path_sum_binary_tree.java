/*abstract
1. You are given a partially written function to solve.

2. You are required to complete the body of maxPathSum function. The function is expected to return Integer value depending upon node-to-node paths where path sum equals targetSum.

3. A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

4. The path sum of a path is the sum of the node's values in the path.
Input Format
Input is managed for you.
Output Format
Output is managed for you.
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Sample Input
7
1
2
-1
-1
3
-1
-1
Sample Output
6
*/

import java.util.Scanner;

class max_path_sum_binary_tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
        this.val = val;
        }
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
    
    public static int maxPathSum(TreeNode root) {
        return maxPathSumHelper(root).max_sum;
    }

    public static Pair maxPathSumHelper(TreeNode root){
        if(root == null){
            return new Pair(0, Integer.MIN_VALUE);
        }

        Pair left = maxPathSumHelper(root.left);
        Pair right = maxPathSumHelper(root.right);

        Pair ans =  new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE);
        ans.max_sum = Math.max(left.max_sum, right.max_sum);
        ans.max_sum = Math.max(ans.max_sum, left.max_to_level+root.val);
        ans.max_sum = Math.max(ans.max_sum, right.max_to_level+root.val);
        ans.max_sum = Math.max(ans.max_sum, right.max_to_level+root.val+left.max_to_level);
        ans.max_to_level = Math.max(left.max_to_level+root.val, right.max_to_level+root.val);
        return ans;       
    }

    static class Pair{
        int max_to_level;
        int max_sum;
        Pair(int mtl, int ms){
            max_to_level= mtl;
            max_sum = ms;
        }
    }

    // input_Section=================================================

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
        // display(root);
        System.out.println(maxPathSum(root));
    }

    public static void main(String[] args) {
        solve();
    }
}