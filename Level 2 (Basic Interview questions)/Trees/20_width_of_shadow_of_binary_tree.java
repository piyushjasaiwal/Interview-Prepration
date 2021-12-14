/*abstract
1. Given a Binary Tree, return Width Of Shadow Of A Binary Tree. 
2. For more detail watch the video.
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
3
*/

import java.util.*;

class width_of_shadow_of_binary_tree {
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
        int idx ;
        TreeNode node;

        public Pair(int idx, TreeNode node){
            this.idx = idx;
            this.node = node;
        }
    }

    public static int width(TreeNode root) {
       int left = 0;
       int right = 0;

       LinkedList<Pair> q = new LinkedList<>();

       if(root != null){
           q.add(new Pair(0, root));
       }

       while(!q.isEmpty()){
           int size = q.size();
           for(int i = 0;i<size;i++){
               Pair curr = q.removeFirst();
               
               if(i == 0){
                   left = Math.min(left, curr.idx);
               }

               if(i == size-1){
                   right = Math.max(right, curr.idx);
               }

               if(curr.node.left != null){
                   q.add(new Pair(curr.idx-1, curr.node.left));
               }

               if(curr.node.right != null){
                   q.add(new Pair(curr.idx+1, curr.node.right));
               }
           }

        //    width = Math.max(width, right - left.idx + 1);
       }

       return right - left + 1;
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

        System.out.println(width(root));
    }

    public static void main(String[] args) {
        solve();
    }
}