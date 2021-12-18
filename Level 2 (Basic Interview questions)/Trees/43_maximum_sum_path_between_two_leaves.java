/*abstract
1. You are given a partially written function to solve.
2. You are required to complete the body of maxPathSum function. The function is expected to return Integer value depending upon maximum leaf-to-leaf paths sum.
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
Sample Output
6
*/

import java.util.Scanner;

class maximum_sum_path_between_two_leaves {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
        this.val = val;
        }
    }

    static class Pair{
        int LTLmaxSum;
        int NTLmaxSum;

        Pair(){
            LTLmaxSum = Integer.MIN_VALUE;
            NTLmaxSum = Integer.MIN_VALUE;
        }
    }

    public static int maxPathSum(TreeNode root) {
        Pair ans = maxSum(root);
        return ans.LTLmaxSum;
    } 

    public static Pair maxSum(TreeNode root){
        Pair myAns = new Pair();
        
        if(root == null){
            return myAns;
        }

        Pair lp = maxSum(root.left);
        Pair rp = maxSum(root.right);

        myAns.LTLmaxSum = Math.max(lp.LTLmaxSum, rp.LTLmaxSum);

        if(root.left != null && root.right != null){
            myAns.LTLmaxSum = Math.max(myAns.LTLmaxSum, lp.NTLmaxSum+rp.NTLmaxSum+root.val);
        }

        myAns.NTLmaxSum = Math.max(lp.NTLmaxSum, rp.NTLmaxSum)+root.val;
        return myAns;
    }

    // input_Section=================================================

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
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        // display(root);
        System.out.println(maxPathSum(root));
    }

    public static void main(String[] args) {
        solve();
    }
}