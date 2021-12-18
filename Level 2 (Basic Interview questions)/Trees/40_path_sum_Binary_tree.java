/*abstract
1. You are given a partially written function to solve.
2. You are required to complete the body of hasPathSum function. The function is expected to return boolean value depending upon root-to-leaf paths where path sum equals targetSum.
3. Input and Output is managed for you.
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
4
Sample Output
true
*/

import java.util.Scanner;

class path_sum_Binary_tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
        this.val = val;
        }
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, targetSum, 0);
    }

    // input_Section=================================================

    private static boolean hasPathSum(TreeNode root, int targetSum, int curr_sum) {
        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null){
            return targetSum == (curr_sum+root.val);
        }

        return hasPathSum(root.left, targetSum, curr_sum+root.val) || hasPathSum(root.right, targetSum, curr_sum+root.val);
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
        int tar = scn.nextInt();
        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        System.out.println(hasPathSum(root, tar));
    }

    public static void main(String[] args) {
        solve();
    }
}