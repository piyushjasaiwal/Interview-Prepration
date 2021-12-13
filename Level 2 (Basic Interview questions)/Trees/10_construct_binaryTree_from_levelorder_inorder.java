/*
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Tree from InOrder and LevelOrder Traversal.
3. you will be given two arrays representing a valid InOrder & LevelOrder of a Binary Tree. Program is required to create a unique Binary Tree.
Input Format
Input is managed for you.
Output Format
Output is managed for you.
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Valid InOrder and LevelOrder traversals.
Sample Input
9
2 7 15 12 6 9 5 11 4
12 7 5 6 11 2 15 4 9
Sample Output
7 -> 12 <- 5
2 -> 7 <- 15
. -> 2 <- .
. -> 15 <- .
6 -> 5 <- 11
. -> 6 <- 9
. -> 9 <- .
. -> 11 <- 4
. -> 4 <- .
*/

import java.util.*;

class construct_binaryTree_from_levelorder_inorder {
    public static Scanner scn = new Scanner(System.in);

    static class TreeNode {
        int val;
        TreeNode left = null, right = null;

        TreeNode(int val) {
        this.val = val;
        }
    }

    public static TreeNode buildTree(int[] inorder, int[] levelOrder){
        return buildTreeHelper(inorder, 0, inorder.length-1, levelOrder);
    }

    // input_section=================================================

    private static TreeNode buildTreeHelper(int[] inorder, int isi, int iei, int[] levelOrder) {
        if(isi > iei){
            return null;
        }

        int curr = levelOrder[0];
        TreeNode node = new TreeNode(curr);

        if(levelOrder.length == 1){
            return node;
        }

        int idx = isi;
        while(inorder[idx] != curr){
            idx++;
        }

        int [] llot = new int[idx-isi];
        int [] rlot = new int[iei-idx];

        HashSet<Integer> set = new HashSet<>();

        for(int i = isi;i<idx;i++){
            set.add(inorder[i]);
        }

        int l = 0, r = 0;

        for(int i = 1;i<levelOrder.length;i++){
            if(!set.isEmpty() && set.contains(levelOrder[i])){
                llot[l++] = levelOrder[i];
            }else{
                rlot[r++] = levelOrder[i];
            }
        }

        node.left = buildTreeHelper(inorder, isi, idx-1, llot);
        node.right = buildTreeHelper(inorder, idx+1, iei, rlot);
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

    int[] InOrder = new int[n];
    for (int i = 0; i < n; i++)
        InOrder[i] = scn.nextInt();

    int[] LevelOrder = new int[n];
    for (int i = 0; i < n; i++)
        LevelOrder[i] = scn.nextInt();

    TreeNode root = buildTree(InOrder, LevelOrder);
    display(root);
    }

    public static void main(String[] args) {
    solve();
    }
}
