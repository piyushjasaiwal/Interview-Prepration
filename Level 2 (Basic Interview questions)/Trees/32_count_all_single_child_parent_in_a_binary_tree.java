/*abstract
1. Given a Binary Tree, return count all single child parent of binary tree
2. For more Information watch given video link below.
3. You are not count allowed to use any static or global variable.
Input Format
Input is managed for you.
Output Format
Output is managed for you. 
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^5
-1000 <= value of Node data <= 1000
Sample Input
15
4
2
1
-1
-1
3
-1
-1
6
5
-1
-1
7
-1
-1
Sample Output
0
*/

import java.util.*;

class count_all_single_child_parent_in_a_binary_tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
        this.val = val;
        }
    }

    public static int countExactlyOneChild(TreeNode node) {
        if(node == null){
            return 0;
        }
        
        if(node.left == null && node.right == null){
            return 0;
        }

        int cnt = 0;

        if(node.left == null || node.right == null){
            cnt+=1;
        }

        cnt += countExactlyOneChild(node.left);
        cnt += countExactlyOneChild(node.right);

        return cnt;
    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
        IDX[0]++;
        return null;
        }
        TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
        Treenode.left = createTree(arr, IDX);
        Treenode.right = createTree(arr, IDX);

        return Treenode;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
        arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        System.out.println(countExactlyOneChild(root));
    }

    public static void main(String[] args) {
        solve();
    }
}