/*abstract
1. Given a Binary Tree, return root To Node path of it. 
2. For more Information watch given video link below.
Input Format
Input is managed for you.
Output Format
Input is managed for you.
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
5
Sample Output
5 6 4 
*/

import java.util.*;

class node_to_root_path_binary_tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
        this.val = val;
        }
    }

    public static ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data) {
        // write your code here
        if(node == null){
            return new ArrayList<>();
        }

        if(node.val == data){
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(node);
            return base;
        }

        ArrayList<TreeNode> left = nodeToRootPath(node.left, data);
        ArrayList<TreeNode> right = nodeToRootPath(node.right, data);

        if(left.size() == 0 && right.size() == 0){
            return left;
        }
        
        if(left.size() != 0){
            left.add(node);
            return left;
        }else{
            right.add(node);
            return right;
        }
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

        int data = scn.nextInt();
        ArrayList<TreeNode> ans = nodeToRootPath(root, data);
        if (ans.size() == 0)  System.out.println();
        for (TreeNode node : ans)
        System.out.print(node.val + " ");
        // display(root);

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

    public static void main(String[] args) {
        solve();
    }
}