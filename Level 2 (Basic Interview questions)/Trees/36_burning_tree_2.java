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
2 
1 3 4 
6 
5 7 
*/

import java.util.*;

class burning_tree_2 {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
        this.val = val;
        }
    }

    public static ArrayList<ArrayList<Integer>> burningTree(TreeNode root, int data) {
        ArrayList<TreeNode> root_to_node = root_to_node_path(root, data);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> ll = new LinkedList<>();
        for(int i = 0;i<root_to_node.size();i++){
            ArrayList<Integer> temp = new ArrayList<>();
            ll.add(root_to_node.get(i));

            int size = ll.size();
            while(size-- > 0){
                TreeNode curr = ll.removeFirst();
                temp.add(curr.val);

                if(i == 0){
                    if(curr.left != null){
                        ll.add(curr.left);
                    }

                    if(curr.right != null){
                        ll.add(curr.right);
                    }
                }else{
                    if(curr.left != null && curr.left != root_to_node.get(i-1)){
                        ll.add(curr.left);
                    }

                    if(curr.right != null && curr.right != root_to_node.get(i-1)){
                        ll.add(curr.right);
                    }
                }
            }

            ans.add(temp);
        }

        while(!ll.isEmpty()){
            int size = ll.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while(size-->0){
                TreeNode curr = ll.removeFirst();
                temp.add(curr.val);

                if(curr.left != null && curr.left != root_to_node.get(root_to_node.size()-2)){
                    ll.add(curr.left);
                }

                if(curr.right != null && curr.right != root_to_node.get(root_to_node.size()-2)){
                    ll.add(curr.right);
                }                
            }
            ans.add(temp);
        }
        return ans;
    }

    // input_section=================================================

    private static ArrayList<TreeNode> root_to_node_path(TreeNode root, int data) {
        if(root == null){
            return new ArrayList<>();
        }

        if(root.val == data){
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(root);
            return base;
        }

        ArrayList<TreeNode> left = root_to_node_path(root.left, data);
        if(left.size()>0){
            left.add(root);
            return left;
        }

        ArrayList<TreeNode> right = root_to_node_path(root.right, data);
        if(right.size()>0){
            right.add(root);
            return right;
        }

        return new ArrayList<>();
    }

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
        int fireNode = scn.nextInt();

        // display(root);
        ArrayList<ArrayList<Integer>> ans = burningTree(root, fireNode);
        if (ans.size() == 0)
        System.out.println();
        for (ArrayList<Integer> ar : ans) {
        for (Integer ele : ar)
            System.out.print(ele + " ");
        System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}