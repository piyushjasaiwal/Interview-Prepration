/*
1. You are given a partially written function to solve.
2. You are required to complete the body of MinCamerasInBT_ function. The function is expected to return integer value representing minimum number of camera(s) required for the coverage of complete tree.
3.A camera is placed on any node will ensure coverage of parent-node as well as it's child-node(s), if any.
4. Input and Output is managed for you.

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
3
*/

/*
the three conditions used to solve this problem are
you need a camera : -1
you have a camera : 0
you are covered : 1
*/

import java.util.Scanner;

class cameras_in_binary_trees {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int camera = 0;

    public static int MinCamerasInBT(TreeNode root) {
        camera = 0;
        int root_need = minCamera_postorder(root);
        if(root_need == -1){
            camera+=1;
        }
        return camera;
    }

    // input_Section_====================================================================

    private static int minCamera_postorder(TreeNode root) {
        if(root == null){
            return 1;
        }

        int left = minCamera_postorder(root.left);
        int right = minCamera_postorder(root.right);

        if(left == -1 || right == -1){
            camera+=1;
            return 0;
        }

        else if(left == 0 || right == 0){
            return 1;
        }

        else{
            return -1;   
        }        
    }

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
        System.out.println(MinCamerasInBT(root));

    }

    public static void main(String[] args) {
        solve();
    }


}