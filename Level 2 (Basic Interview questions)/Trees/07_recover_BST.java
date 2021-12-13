/*abstract
1. You are given a partially written function to solve(Refer question video).
2. You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

Follow up: You are Not Allowed To Use Extra Space(Example : Storing All Element In Arrays).
Input Format
Input is managed for you.
Output Format
Output is managed for you. 
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
10
-1
-1
5
-1
12
-1
-1
Sample Output
3 -> 7 <- 10
2 -> 3 <- 5
. -> 2 <- .
. -> 5 <- .
. -> 10 <- 12
. -> 12 <- .
*/

import java.util.Scanner;

class recover_BST {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void recoverTree(TreeNode root) {

    }

    // input_section=================================================

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
        recoverTree(root);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}