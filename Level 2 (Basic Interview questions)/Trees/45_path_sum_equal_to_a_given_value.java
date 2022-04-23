/*
1. Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
2. The path does not need to start or end at the root or a leaf,path can start from any where but it must go downwards
Input Format
Input is managed for you.
Output Format
Output is managed for you. 
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^5
-1000 <= value of Node data <= 1000

Sample Input
10 5 3 3 null null -2 null null 2 null 1 null null -3 null 11 null null
8
Sample Output
3
*/

import java.util.*;

class path_sum_equal_to_a_given_value {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int pathSum(TreeNode root, int K) {
        display(root);
        return 0;
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

    public static int idx = 0;

    private static TreeNode deserialize(String[] arr) {
        if (idx >= arr.length || arr[idx].equals("null")) {
            idx++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
        node.left = deserialize(arr);
        node.right = deserialize(arr);

        return node;
    }

    public static TreeNode deserialize(String str) {
        String[] arr = str.split(" ");
        return deserialize(arr);
    }

    public static void solve() {
        String str = scn.nextLine();
        TreeNode root = deserialize(str);
        int tar = scn.nextInt();

        int ans = pathSum(root, tar);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        solve();
    }
}