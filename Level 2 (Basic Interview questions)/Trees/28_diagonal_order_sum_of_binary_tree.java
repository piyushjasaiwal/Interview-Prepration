/*abstract
1. Given a Binary Tree, print Diagonal order sum of it. 
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
17 10 1 
*/

import java.util.*;

class diagonal_order_sum_of_binary_tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
        this.val = val;
        }
    }

    public static ArrayList<Integer> diagonalOrderSum(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        if(root != null){
            q.add(root);
        }

        while(!q.isEmpty()){
            int sum = 0;
            int size = q.size();
            while(size-->0){
                TreeNode curr = q.removeFirst();
                while(curr != null){
                    sum += curr.val;
                    if(curr.left != null){
                        q.add(curr.left);
                    }

                    curr = curr.right;
                }
            }

            list.add(sum);
        }
        return list;
    }

    // input_section=================================================

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

        ArrayList<Integer> ans = diagonalOrderSum(root);
        for (Integer j : ans)
        System.out.print(j + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}

