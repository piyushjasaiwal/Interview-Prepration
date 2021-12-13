/*abstract
1. You are given a partially written function to solve(Refer question video).
2. you will be given two arrays representing a valid PostOrder & PostOrder of a Binary Tree. Program is required to create a unique Binary Tree.
Input Format
Input is managed for you.
Output Format
Input is managed for you.
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Valid PreOrder and PostOrder traversals.
Sample Input
7
1 3 2 5 7 6 4
4 2 1 3 6 5 7
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

class construct_binary_tree_from_preorder_postorder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePostHelper(pre, 0, pre.length-1, post, 0, post.length-1);
    }

    // input_section=================================================

    private static TreeNode constructFromPrePostHelper(int[] pre, int pre_beg, int pre_end, int[] post, int post_beg, int post_end) {
        if(pre_beg > pre_end){
            return null;
        }

        if(pre_beg == pre_end){
            return new TreeNode(pre[pre_beg]);
        }

        int curr = pre[pre_beg];
        TreeNode node = new TreeNode(curr);

        int left_sub_root = pre[pre_beg+1];
        int post_idx_left_root = post_beg;

        while(post[post_idx_left_root] != left_sub_root){
            post_idx_left_root+=1;
        }

        int left_length = post_idx_left_root-post_beg+1;

        node.left = constructFromPrePostHelper(pre, pre_beg+1, pre_beg+left_length, post, post_beg, post_idx_left_root);
        node.right = constructFromPrePostHelper(pre, pre_beg+left_length+1, pre_end, post, post_idx_left_root+1, post_end-1);

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
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = constructFromPrePost(pre, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}