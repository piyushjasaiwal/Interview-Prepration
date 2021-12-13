/*abstract
1. You are given a partially written function to solve.
2. Given a binary tree root, a ZigZag path for a binary tree is defined as follow:
    a. Choose any node in the binary tree and a direction (right or left).
    b. If the current direction is right then move to the right child of the current node otherwise move to the left child.
    c. Change the direction from right to left or right to left.
    d. Repeat the second and third step until you can't move in the tree.

3.Zigzag length is defined in terms of edges. (A single node has a length of 0).
4. Return the longest ZigZag path contained in that tree.
Input Format
Input is managed for you.
Output Format
Output is managed for you. 
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Sample Input
15
1
1
-1
1
1
-1
1
-1
-1
1
-1
-1
1
-1
-1
Sample Output
4
*/

import java.util.Scanner;

class Longest_zig_zag_path_Binary_tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int longest = 0;

    public static int longestZigZagPath(TreeNode root) {
        longest = 0;
        longest_path(root, -1);
        longest_path(root, 1);
        return longest;
    }

    // input_Section_====================================================================

    private static int longest_path(TreeNode root, int dir) {
        if(root == null){
            return 0;
        }

        int left = longest_path(root.left, -1);
        int right = longest_path(root.right, 1);

        if(dir == -1){
            longest = Math.max(longest, left);
            return right+1;
        }else{
            longest = Math.max(longest, right);
            return left+1;
        }
    }

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        System.out.println(longestZigZagPath(root));
    }

    public static void main(String[] args) {
        solve();
    }
}