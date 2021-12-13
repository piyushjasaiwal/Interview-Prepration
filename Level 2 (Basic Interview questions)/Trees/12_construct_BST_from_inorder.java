/*abstract
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Search Tree from given InOrder Traversal.
3. you will be given an array representing a valid InOrder of a Binary Search Tree. Program is required to create a unique Balanced Binary Search Tree.
Input Format
Input is managed for you.
Output Format
output is managed for you.
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Valid InOrder traversal.
Sample Input
7
1 2 3 4 5 6 7
Sample Output
2 -> 4 <- 6
1 -> 2 <- 3
. -> 1 <- .
. -> 3 <- .
5 -> 6 <- 7
. -> 5 <- .
. -> 7 <- .
*/

import java.util.Scanner;

class construct_BST_from_inorder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode constructFromInOrder(int[] inOrder) {
        return constructFromInOrder_helper(inOrder, 0, inOrder.length-1);
    }

    // input_section=================================================

    private static TreeNode constructFromInOrder_helper(int[] inOrder, int beg, int end) {
        if(beg > end){
            return null;
        }

        if(beg == end){
            return new TreeNode(inOrder[beg]);
        }

        int mid = (beg+end)/2;

        TreeNode node = new TreeNode(inOrder[mid]);
        node.left = constructFromInOrder_helper(inOrder, beg, mid-1);
        node.right = constructFromInOrder_helper(inOrder, mid+1, end);
        return node;
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

    public static void solve() {
        int n = scn.nextInt();
        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = constructFromInOrder(in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}