/*abstract
1. You are given a partially written function to solve.
2. You are required to complete the body of PathSum function. The function is expected to return all root-to-leaf paths where each path's sum equals targetSum.
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
7
1
2
-1
-1
3
-1
-1
4
Sample Output
1 3 
*/

import java.util.*;

class path_sum_binary_tree_2 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
        this.val = val;
        }
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

    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        pathSum(root, targetSum, 0, new ArrayList<>(), ans);
        return ans;
    }

    // input_Section=================================================

    private static void pathSum(TreeNode root, int targetSum, int currSum, ArrayList<Integer> arrayList, ArrayList<ArrayList<Integer>> ans) {
        if(root == null){
            return ;
        }

        if(root.left == null && root.right == null){
            if(currSum+root.val == targetSum){
                arrayList.add(root.val);
                ans.add(new ArrayList<>(arrayList));
                arrayList.remove(arrayList.size()-1);
            }

            return ;
        }

        arrayList.add(root.val);
        pathSum(root.left, targetSum, currSum+root.val, arrayList, ans);
        pathSum(root.right, targetSum, currSum+root.val, arrayList, ans);
        arrayList.remove(arrayList.size()-1);
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
            int tar = scn.nextInt();
            int[] IDX = new int[1];
            TreeNode root = createTree(arr, IDX);
            // display(root);
            ArrayList<ArrayList<Integer>> ans = pathSum(root, tar);
            if (ans.size() == 0) System.out.println(" ");
            for (ArrayList<Integer> ar : ans) {
            for (Integer ele : ar) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}