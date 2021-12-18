/*abstract
1. You are given a partially written function to solve.
2. You are required to complete the body of diameterOfBinaryTree function. The function is expected to return diameter of binary tree.
3. Input and Output is managed for you.
Input Format
Input is managed for you.
Output Format
Output is managed for you. 
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Sample Input
11
1
2
4
-1
-1
5
-1
-1
3
-1
-1
Sample Output
3
*/

import java.util.Scanner;

class diameter_of_binary_tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
        this.val = val;
        }
    }

    static int diameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    // input_Section=================================================

    private static int height(TreeNode root) {
        if(root == null){
            return 0;
        }

        int height_left = height(root.left);
        int height_right = height(root.right);

        int curr_diameter = height_left+height_right;
        diameter = Math.max(diameter, curr_diameter);

        return Math.max(height_left, height_right)+1;
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
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        // display(root);
        System.out.println(diameterOfBinaryTree(root));
    }

    public static void main(String[] args) {
        solve();
    }
}