/*abstract
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Search Tree from given PostOrder Traversal.
3. you will be given an array representing a valid PostOrder of a Binary Search Tree. Program is required to create a unique Binary Search Tree.
Input Format
Input is managed for you.
Output Format
Output is managed for you. 
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Valid PostOrder traversal.
Sample Input
6
1 2 6 7 5 3
Sample Output
2 -> 3 <- 5
1 -> 2 <- .
. -> 1 <- .
. -> 5 <- 7
6 -> 7 <- .
. -> 6 <- .
*/

import java.util.Scanner;

class construct_BST_from_postorder_traversal {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode bstFromPostorder(int[] postorder) {
        return bstFromPostorderHelper(postorder, 0, postorder.length-1);
    }

    // input_section=================================================

    private static TreeNode bstFromPostorderHelper(int[] postorder, int beg, int end) {
        if(beg > end || beg >= postorder.length){
            return null;
        }

        if(beg == end){
            return new TreeNode(postorder[beg]);
        }

        int curr = postorder[end];
        int right_first_index = end-1;

        while(right_first_index >=0 && postorder[right_first_index] >= curr){
            right_first_index--;
        }

        TreeNode node = new TreeNode(curr);
        node.left = bstFromPostorderHelper(postorder, beg, right_first_index);
        node.right = bstFromPostorderHelper(postorder, right_first_index+1, end-1);
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

        TreeNode root = bstFromPostorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}