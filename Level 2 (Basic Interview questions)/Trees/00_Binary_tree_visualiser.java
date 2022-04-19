import java.util.*;

class Binary_tree_visualiser {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Node root = null;
        int [] arr = new int[s.nextInt()];
        for(int i = 0;i<arr.length;i++){
            arr[i] = s.nextInt();
        }

        Node idx = new Node(0);
        root = make_tree(arr, idx);
        show(root);
    }

    private static void show(Node root) {
        if(root == null){
            return ;
        }

        String str = root.val+" => ";
        if(root.left != null){
            str = str+root.left.val+" , ";
        }else{
            str = str+". , ";
        }

        if(root.right != null){
            str = str+root.right.val+"";
        }else{
            str = str+" .";
        }

        System.out.println(str);
        show(root.left);
        show(root.right);
    }

    private static Node make_tree(int[] arr, Node idx) {
        if(idx.val >= arr.length){
            return null;
        }

        if(arr[idx.val] == -1){
            idx.val = idx.val+1;
            return null;
        }

        Node node=new Node(arr[idx.val]);
        idx.val = idx.val+1;
        node.left = make_tree(arr, idx);
        node.right = make_tree(arr, idx);
        return node;
    }

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int v){
            this.val = v;
        }
    }
}
