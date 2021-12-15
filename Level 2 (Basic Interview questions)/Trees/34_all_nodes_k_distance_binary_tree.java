/*abstract
1. Given the root of a binary tree.
2. The value of a target node target, and an integer k.
3. You have return an array of the values of all nodes that have a distance k from the target node.
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
5. 0 <= k <= 1000
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
2 2
Sample Output
6 
*/

import java.util.*;

class all_nodes_k_distance_binary_tree {
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
            // TODO Auto-generated method stub
            return val+"";
        }
    }

    public static ArrayList<Integer> distanceK(TreeNode root, int target, int k) {
        ArrayList<TreeNode> root_to_path = nodeToRootPath(root, target);
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0;i<root_to_path.size();i++){
            K_levels_down(root_to_path.get(i), k-i, i == 0 ? null : root_to_path.get(i-1), ans);
        }
        return ans;
    }

    public static void K_levels_down(TreeNode root, int k, TreeNode block, ArrayList<Integer> ans){
        if(root == null || k < 0 || root == block){
            return ;
        }


        if(k == 0){
            ans.add(root.val);
            return ;
        }

        K_levels_down(root.left, k-1, block, ans);
        K_levels_down(root.right, k-1, block, ans);
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
        int target = scn.nextInt();
        int k = scn.nextInt();

        ArrayList<Integer> ans = distanceK(root, target, k);
        if (ans.size() == 0)
        System.out.println();
        for (Integer ele : ans)
        System.out.println(ele + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}