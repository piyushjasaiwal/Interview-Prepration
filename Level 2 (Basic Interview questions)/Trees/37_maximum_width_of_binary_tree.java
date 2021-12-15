/*abstract
1. Given the root of a binary tree, return the maximum width of the given tree.
2. The maximum width of a tree is the maximum width among all levels.
3. The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes are also counted into the length calculation.
Input Format
Input is managed for you.
Output Format
Output is managed for you. 
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^5
-1000 <= value of Node data <= 1000
Sample Input
1 3 5 null null 3 null null 2 null 9 null null
Sample Output
4
*/

import java.util.*;

class maximum_width_of_binary_tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
        this.val = val;
        }
    }

    public static class Pair{
        TreeNode root;
        int idx;

        Pair(TreeNode root, int idx){
            this.root = root;
            this.idx = idx;
        }
    }

    public static int widthOfBinaryTree(TreeNode root) {
        LinkedList<Pair> q = new LinkedList<>();
        if(root != null){
            q.add(new Pair(root, 0));
        }

        int width = 0;

        while(!q.isEmpty()){
            int size = q.size();
            int min = 0;
            int max = 0;

            for(int i=0;i<size;i++){
                Pair curr = q.removeFirst();
                if(i == 0){
                    min = curr.idx;
                }

                if(i == size-1){
                    max = curr.idx;
                }

                if(curr.root.left != null){
                    q.add(new Pair(curr.root.left, 2*(curr.idx)+1));
                }

                if(curr.root.right != null){
                    q.add(new Pair(curr.root.right, 2*(curr.idx)+2));
                }
            }

            width = Math.max(width, max-min+1);
        }

        return width;
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

        int ans = widthOfBinaryTree(root);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        solve();
    }
}