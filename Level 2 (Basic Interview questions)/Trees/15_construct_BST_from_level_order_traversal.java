/*abstract
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Search Tree from given LevelOrder Traversal.
3. you will be given an array representing a valid LevelOrder of a Binary Search Tree. Program is required to create a unique Binary Search Tree.
Input Format
Input is managed for you.
Output Format
Output is managed for you.
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Valid LevelOrder traversal.
Sample Input
6
3 2 5 1 6 7
Sample Output
2 -> 3 <- 5
1 -> 2 <- .
. -> 1 <- .
. -> 5 <- 6
. -> 6 <- 7
. -> 7 <- .
*/

import java.util.Scanner;

class construct_BST_from_level_order_traversal {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode constructBSTFromLevelOrder(int[] LevelOrder) {
        
        if(LevelOrder.length == 0 || LevelOrder[0] == 0){
            return null;
        }
        
        TreeNode node = new TreeNode(LevelOrder[0]);

        if(LevelOrder.length == 1){
            return node;
        }

        int small = 0;
        for(int val:LevelOrder){
            if(val < node.val){
                small++;
            }
        }

        int [] left = new int[small];
        int [] right = new int[LevelOrder.length-small];

        int l = 0;
        int r = 0;

        for(int i = 1;i<LevelOrder.length;i++){
            if(LevelOrder[i] < node.val){
                left[l++] = LevelOrder[i];
            }else{
                right[r++] = LevelOrder[i];
            }
        }

        node.left = constructBSTFromLevelOrder(left);
        node.right = constructBSTFromLevelOrder(right);
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

    public static void solve() {
        int n = scn.nextInt();
        int[] level = new int[n];
        for (int i = 0; i < n; i++)
            level[i] = scn.nextInt();

        TreeNode root = constructBSTFromLevelOrder(level);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}