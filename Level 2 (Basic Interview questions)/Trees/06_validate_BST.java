/*abstract
1. You are given a partially written function to solve.
2. Determine if it is a valid binary search tree (BST).

3. A valid BST is defined as follows:
   3.1 The left subtree of a node contains only nodes with keys less than the node's key.
   3.2 The right subtree of a node contains only nodes with keys greater than the node's key.
   3.3 Both the left and right subtrees must also be binary search trees.
Input Format
Input is managed for you.
Output Format
output is managed for you.
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Sample Input
13
7
3
2
-1
-1
5
-1
-1
10
-1
12
-1
-1
Sample Output
true
*/

import java.util.Scanner;

class validate_BST {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return is_valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean is_valid(TreeNode root, int min, int max) {
        if(root == null){
            return true;
        }

        if(root.val < min || root.val > max){
            return false;
        }

        return is_valid(root.left, min, root.val-1) && is_valid(root.right, root.val+1, max);
    }

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
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
        System.out.println(isValidBST(root));
    }

    public static void main(String[] args) {
        solve();
    }
}