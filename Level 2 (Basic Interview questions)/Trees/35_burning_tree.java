/*abstract
1. Given a binary tree and target. 
2. Find the minimum time required to burn the complete binary tree if the target is set on fire. 
3. It is known that in 1 second all nodes connected to a given node get burned. That is, its left child, right child and parent.
Input Format
Input is managed for you.
Output Format
Output is managed for you. 
Question Video

  COMMENTConstraints
1. The number of nodes in the tree is in the range [1, 10000].
2. -1000 <= Node.val <= 1000
3. All the values Node.val are unique.
4. target is the value of one of the nodes in the tree.
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
2
Sample Output
3
*/

import java.util.*;

class burning_tree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
        this.val = val;
        }

        @Override
        public String toString() {
            return val+"";
        }
    }

    public static int burningTree(TreeNode root, int fireNode) {
        int min = Integer.MIN_VALUE;
        ArrayList<TreeNode> root_to_node = nodeToRootPath(root, fireNode);
        for(int i = 0;i<root_to_node.size();i++){
            int time = min_time_to_fire(root_to_node.get(i), i == 0 ? null : root_to_node.get(i-1));
            time += i;
            min = Math.max(min, time);
        }

        return min;
    }

    private static int min_time_to_fire(TreeNode root, TreeNode block) {
        if(root == null || root == block){
            return -1;
        }

        int max = -1;
        max = Math.max(max, min_time_to_fire(root.left, block));
        max = Math.max(max, min_time_to_fire(root.right, block));
        
        return max+1;
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
        int fireNode = scn.nextInt();

        int ans = burningTree(root, fireNode);
        System.out.println(ans);

    }

    public static void main(String[] args) {
        solve();
    }
}