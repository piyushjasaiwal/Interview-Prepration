/*abstract
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Tree from PostOrder and InOrder Traversal.
3. you will be given two arrays representing a valid PostOrder & InOrder of a Binary Tree. Program is required to create a unique Binary Tree.
Input Format
Input is managed for you.
Output Format
Output is managed for you. 
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Valid InOrder & PostOrder traversals.
Sample Input
7
1 3 2 5 7 6 4
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

class construct_binaryTree_from_inorder_postorder_traversal {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    // input_section=================================================

    private static TreeNode buildTreeHelper(int[] inorder, int inorder_begin, int inorder_end, int[] postorder, int postorder_begin, int postorder_end) {

        if(postorder_begin > postorder_end){
            return null;
        }

        if(postorder_begin == postorder_end){
            return new TreeNode(postorder[postorder_begin]);
        }
        

        int curr = postorder[postorder_end];

        int idx_in_inorder = -1;
        for(int i = inorder_begin;i<=inorder_end;i++){
            if(inorder[i] == curr){
                idx_in_inorder = i;
            }
        }

        int right_length = inorder_end-idx_in_inorder;
        int left_length = idx_in_inorder-inorder_begin;

        TreeNode node = new TreeNode(curr);
        node.left = buildTreeHelper(inorder, inorder_begin, idx_in_inorder-1, postorder, postorder_begin, postorder_begin+left_length-1);
        node.right = buildTreeHelper(inorder, idx_in_inorder+1, inorder_end, postorder, postorder_end-right_length, postorder_end-1);

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

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(in, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}