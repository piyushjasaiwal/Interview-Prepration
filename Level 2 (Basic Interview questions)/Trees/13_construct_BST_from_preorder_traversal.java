/*abstract
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Search Tree from given PreOrder Traversal.
3. you will be given an array representing a valid PreOrder of a Binary Search Tree. Program is required to create a unique Binary Search Tree.
Input Format
Input is managed for you.
Output Format
Output is managed for you.
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Valid PreOrder traversal.
Sample Input
6
3 2 1 6 5 7
Sample Output
2 -> 3 <- 6
1 -> 2 <- .
. -> 1 <- .
5 -> 6 <- 7
. -> 5 <- .
. -> 7 <- .
*/

import java.util.Scanner;

class construct_BST_from_preorder_traversal {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderHelper(preorder, 0, preorder.length);
    }

    // input_section=================================================

    private static TreeNode bstFromPreorderHelper(int[] preorder, int beg, int end) {
        if(beg > end || beg >= preorder.length){
            return null;
        }

        if(beg == end){
            return new TreeNode(preorder[beg]);
        }

        int curr = preorder[beg];
        int left_last_index = beg+1;

        while(left_last_index < preorder.length && preorder[left_last_index] <= curr){
            left_last_index+=1;
        }

        TreeNode node = new TreeNode(curr);
        node.left = bstFromPreorderHelper(preorder, beg+1, left_last_index-1);
        node.right = bstFromPreorderHelper(preorder, left_last_index, end);
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
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = bstFromPreorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}