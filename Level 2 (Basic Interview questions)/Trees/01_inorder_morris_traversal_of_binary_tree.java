/*abstract
1. Given a Binary Tree, return inorder Traversal of it. 
2. For more Information watch given video link below.
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
1 2 3 4 5 6 7 
*/

import java.util.*;

class inorder_morris_traversal_of_binary_tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
        this.val = val;
        }
    }

    public static ArrayList<Integer> morrisInTraversal(TreeNode Treenode) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode curr = Treenode;
        while(curr != null){
            if(curr.left == null){
                list.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode pre = curr.left;
                while(pre.right != null && pre.right != curr){
                    pre = pre.right;
                }

                if(pre.right == null){
                    pre.right = curr;
                    curr = curr.left;
                }else if(pre.right == curr){
                    list.add(curr.val);
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }
        return list;
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

        ArrayList<Integer> ans = morrisInTraversal(root);
        for (Integer i : ans)
        System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}