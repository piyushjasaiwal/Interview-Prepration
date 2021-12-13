/*abstract
1. Serialization is to store tree in a file so that it can be later restored.
2. The structure of tree must be maintained. Deserialization is reading tree back from file.
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
1 -> 1 <- 1
. -> 1 <- 1
1 -> 1 <- 1
. -> 1 <- 1
. -> 1 <- .
. -> 1 <- .
. -> 1 <- .
*/

import java.util.*;

class serialize_and_deserialize_binary_tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("");
        serialize_helper(root, sb);
        return new String(sb);
    }

    private static void serialize_helper(TreeNode root, StringBuilder sb) {
        if(root == null){
            sb.append("null ");
            return ;
        }

        sb.append(root.val+" ");
        serialize_helper(root.left, sb);
        serialize_helper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    static int idx = 0;
    public static TreeNode deserialize(String str) {
        String [] arr = str.split(" ");
        idx = 0;
        return deserialize_helper(arr);
    }

    private static TreeNode deserialize_helper(String[] arr) {
        if(idx >= arr.length ||arr[idx].equals("null")){
            return null;
        }

        int curr = Integer.parseInt(arr[idx]);
        TreeNode node = new TreeNode(curr);

        idx+=1;
        node.left = deserialize_helper(arr);
        idx+=1;
        node.right = deserialize_helper(arr);
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

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        String s = serialize(root);
        display(deserialize(s));
    }

    public static void main(String[] args) {
        solve();
    }
}