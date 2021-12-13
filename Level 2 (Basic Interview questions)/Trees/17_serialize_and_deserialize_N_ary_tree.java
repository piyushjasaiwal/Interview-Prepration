/*abstract
1. Serialization is to store tree in a file so that it can be later restored.
2. The structure of tree must be maintained. Deserialization is reading tree back from file.
Input Format
Input is managed for you.
Output Format
Output is managed for you. 
Question Video

  COMMENTConstraints
0 <= Number of Nodes <= 10^5
-1000 <= value of Node data <= 1000
Sample Input
1 3 5 null 6 null null 2 null 4 null null
Sample Output
1 -> 3 2 4 
3 -> 5 6 
5 -> 
6 -> 
2 -> 
4 -> 
*/

import java.util.*;

class serialize_and_deserialize_N_ary_tree {
    public static Scanner scn = new Scanner(System.in);

    static class Node {
        public int val;
        public ArrayList<Node> children;

        public Node() {
        children = new ArrayList<Node>();
        }

        public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
        val = _val;
        children = _children;
        }
    }

    // Encodes a tree to a single string.
    public static String serialize(Node root) {
        StringBuilder sb = new StringBuilder("");
        serialize_helper(root, sb);
        System.out.println(sb);
        return new String(sb);
    }

    private static void serialize_helper(Node root, StringBuilder sb) {
        if(root == null){
            System.out.println("------------------------------------------------------------");
            sb.append("null");
            System.out.println("------------------------------------------------------------");
            return ;
        }

        sb.append(root.val+" ");
        sb.append(root.children.size()+" ");

        for(Node child:root.children){
            serialize_helper(child, sb);
        }
    }

    // Decodes your encoded data to tree.
    static int idx = 0;
    public static Node deserialize(String str) {
        String [] arr = str.split(" ");
        idx = 0;

        return deserialize_helper(arr);
    }

    private static Node deserialize_helper(String[] arr) {
        if(idx >= arr.length || arr[idx].equals("null")){
            return null;
        }

        int curr = Integer.parseInt(arr[idx]);
        idx += 1;
        int child_count = Integer.parseInt(arr[idx]);
        idx+=1;

        Node node = new Node(curr);
        for(int i = 0;i<child_count;i++){
            node.children.add(deserialize_helper(arr));
            idx+=1;
        }

        return node;
    }

    // input_Section=================================================
    public static void display(Node node) {
        if (node == null)
        return;

        StringBuilder sb = new StringBuilder();
        sb.append(node.val + " -> ");
        for (Node child : node.children) {
        sb.append(child.val + " ");
        }
        System.out.println(sb.toString());

        for (Node child : node.children) {
        display(child);
        }
    }

    public static Node createTree(String[] arr) {
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length - 1; i++) {
        String s = arr[i];
        if (s.equals("null")) {
            Node node = st.pop();
            st.peek().children.add(node);
        } else {
            Node node = new Node(Integer.parseInt(s));
            st.push(node);
        }
        }

        return st.size() != 0 ? st.pop() : null;
    }

    public static void solve() {
        String str = scn.nextLine();
        String[] arr = str.split(" ");

        Node root = createTree(arr);
        String s = serialize(root);
        display(deserialize(s));
    }

    public static void main(String[] args) {
        solve();
    }
}