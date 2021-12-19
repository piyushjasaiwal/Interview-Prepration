/*abstract
1. Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
2. According to the definition of LCA on Wikipedia: 
The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has 
both p and q as descendants (where we allow a node to be a descendant of itself).
3. If LCA does not exist in the tree print null.
Input Format
Input is managed for you.
Output Format
Output is managed for you. 
Question Video

  COMMENTConstraints
1. The number of nodes in the tree is in the range [-1000, 1000].
2. -109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q may or may not exist in the tree.
Sample Input
10 5 3 13 null null -2 null null 2 null 1 null null -3 null 11 null null
13 3
Sample Output
3
*/

import java.util.*;

class LCA_binary_tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
        this.val = val;
        }
    }

    public static boolean is_present(TreeNode node, int val){
        if(node == null){
            return false;
        }

        if(node.val == val){
            return true;
        }

        return is_present(node.left, val) || is_present(node.right, val);
    }


    public static TreeNode LCA(TreeNode node, int p, int q) {
        if(node == null){
            return null;
        }

        if(node.val == p || node.val == q){
            return node;
        }

        TreeNode left = LCA(node.left, p, q);
        TreeNode right = LCA(node.right, p, q);

        if(left == null && right == null){
            return null;
        }

        if(left == null || right == null){
            return left == null ? right : left; 
        }
        return node;
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

        int e1 = scn.nextInt();
        int e2 = scn.nextInt();

        TreeNode ans = lowestCommonAncestor(root, e1, e2);
        System.out.println(ans == null ? null : ans.val);
    }
    private static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        

        TreeNode ans = LCA(root, p, q);
        if(!is_present(root, p) || !is_present(root, q)){
            return null;
        }
        return ans;
    }

    public static void main(String[] args) {
        solve();
    }
}