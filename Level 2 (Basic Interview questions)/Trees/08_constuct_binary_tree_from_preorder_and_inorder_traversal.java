/*abstract
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Tree from PreOrder and InOrder Traversal.
3. you will be given two arrays representing a valid PreOrder & InOrder of a Binary Tree. Program is required to create a unique Binary Tree.
Input Format
Input is managed for you.
Output Format
Output is managed for you. 
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Valid InOrder & PreOrder traversals.
Sample Input
7
4 2 1 3 6 5 7
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

class constuct_binary_tree_from_preorder_and_inorder_traversal {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }



    // input_section=================================================

    private static TreeNode buildTreeHelper(int[] preorder, int preorder_begin, int preorder_end, int[] inorder, int inorder_begin, int inorder_end) {

        if(preorder_begin > preorder_end){
            return null;
        }

        if(preorder_begin == preorder_end){
            return new TreeNode(preorder[preorder_begin]);
        }
        
        int curr_node = preorder[preorder_begin];
        int idx_in_inorder = -1;
        for(int i = inorder_begin;i<=inorder_end;i++){
            if(inorder[i] == curr_node){
                idx_in_inorder = i;
            }
        }

        TreeNode node = new TreeNode(curr_node);

        int left_length = idx_in_inorder - inorder_begin;
        // int right_length = inorder_end - idx_in_inorder;
        node.left = buildTreeHelper(preorder, preorder_begin+1, preorder_begin+left_length, inorder, inorder_begin, idx_in_inorder-1);

        node.right = buildTreeHelper(preorder, preorder_begin+left_length+1, preorder_end, inorder, idx_in_inorder+1, inorder_end);

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

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(pre, in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}