/*abstract
1. You are given a partially written function to solve.
2. The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
It will automatically contact the police if two directly-linked houses were broken into on the same night.
Determine the maximum amount of money the thief can rob tonight without alerting the police.
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

import java.util.*;

class house_robber_in_binary_tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int HouseRobber(TreeNode root) {
        Pair ans = HouseRobber_helper(root);
        return Math.max(ans.with_robbery, ans.without_robbery);
    }

    public static Pair HouseRobber_helper(TreeNode root){
        if(root == null){
            return new Pair(0, 0);
        }

        Pair left = HouseRobber_helper(root.left);
        Pair right = HouseRobber_helper(root.right);

        int with_root = root.val + left.without_robbery + right.without_robbery;
        int without_root = Math.max(left.with_robbery, left.without_robbery) + Math.max(right.with_robbery, right.without_robbery);

        return new Pair(with_root, without_root);


    }

    // input_Section_====================================================================

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
        System.out.println(HouseRobber(root));
    }

    public static void main(String[] args) {
        solve();
    }
}

class Pair{
    int with_robbery;
    int without_robbery;

    Pair(int wr, int wtr){
        with_robbery = wr;
        without_robbery = wtr;
    }
}