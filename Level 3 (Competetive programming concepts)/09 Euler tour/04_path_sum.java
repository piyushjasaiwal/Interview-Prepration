/*
You are given a tree with n nodes (numbered from 1 to n), node 1 is the root of tree.
Each node has a value say Vi is the value of i'th node.

You have to perform q queries of two types:-
1 i v : change the value of i'th node to v,
2 i   : add all nodes on path from root to i'th node.
Input Format
First line contains single integer n.
second line contains n integers v1 v2 v3 .... vn
third line contains n-1 integers p2 p3 p4 ... pn here pi is the parent of i'th node
fourth line contains single int q
q following lines contains queries of type 1 and 2
Output Format
of every query of type 2 print sum of values.
Question Video

Constraints
1. 1 <= N <= 10^5
2. 1 <= Vi <= 10^4
3. 1 <= q <= 10^4
Sample Input
8
4 7 9 5 2 1 3 5 
1 1 1 4 3 4 1 
7
1 4 3
1 3 8
2 7
1 4 6
1 1 7
2 3
2 4
Sample Output
10
15
13
*/

import java.util.*;
import java.io.*;

class path_sum {
    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int [] values;
    static int [] parent;
    static int[] order_nodes ;
    static int idx = 1;
    public static void main(String[] args) throws IOException {

        // write your code here
        int n = in.nextInt();
        values = new int [n];
        parent = new int[n-1];
        order_nodes = new int[2*n];

        HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();
        for(int i = 0;i<n;i++){
            values[i] = in.nextInt();
        }
        for(int i = 2;i<=n;i++){
            parent[i-2] = in.nextInt();
            ArrayList<Integer> list = tree.getOrDefault(parent[i-2], new ArrayList<>());
            list.add(i);
            tree.put(parent[i-2], list);
        }
        int q = in.nextInt();
        HashMap<Integer, Pair> map = new HashMap<>();
        traverse(1, tree, map);
        // System.out.println(map);
        int [] ar = new int[(values.length*2)+1];
        for(int key : map.keySet()){
            ar[map.get(key).si] = values[key-1];
            ar[map.get(key).ei] = -values[key-1];
        }

        FenwickTree ft = new FenwickTree(ar);
        
        while(q-->0){
            solve(ft, map);
        }

        out.close();
    }

    private static void solve(FenwickTree ft, HashMap<Integer, Pair> map) throws IOException {
        int q = in.nextInt();
        if(q == 1){
            int i = in.nextInt();
            int v = in.nextInt();

            Pair curr = map.get(i);
            ft.update(curr.si, v);            
            ft.update(curr.ei, -v);            
        }else{
            int i = in.nextInt();
            Pair curr = map.get(i);

            System.out.println(ft.query(curr.si));
        }
    }



    private static void traverse(int root, HashMap<Integer, ArrayList<Integer>> tree, HashMap<Integer, Pair> map) {
        int si = idx;
        idx+=1;

        ArrayList<Integer> children = tree.get(root);
        if(children != null){    
            for(int child:children){
                traverse(child, tree, map);
            }
        }

        int ei = idx;
        idx+=1;

        map.put(root, new Pair(si, ei));

    }



    private static class InputReader implements AutoCloseable {

        private static final int DEFAULT_BUFFER_SIZE = 1 << 16;


        private static final InputStream DEFAULT_STREAM = System.in;

        private static final int MAX_DECIMAL_PRECISION = 21;

        private int c;

        private final byte[] buf;
        private final int bufferSize;
        private int bufIndex;
        private int numBytesRead;

        private final InputStream stream;

        private static final byte EOF = -1;

        private static final byte NEW_LINE = 10;

        private static final byte SPACE = 32;

        private static final byte DASH = 45;

        private static final byte DOT = 46;
        private char[] charBuffer;
        private static final byte[] bytes = new byte[58];
        private static final int[] ints = new int[58];
        private static final char[] chars = new char[128];

        static {
        char ch = ' ';
        int value = 0;
        byte _byte = 0;
        for (int i = 48; i < 58; i++)
            bytes[i] = _byte++;
        for (int i = 48; i < 58; i++)
            ints[i] = value++;
        for (int i = 32; i < 128; i++)
            chars[i] = ch++;
        }

        public InputReader() {
        this(DEFAULT_STREAM, DEFAULT_BUFFER_SIZE);
        }
        public InputReader(int bufferSize) {
        this(DEFAULT_STREAM, bufferSize);
        }
        public InputReader(InputStream stream) {
        this(stream, DEFAULT_BUFFER_SIZE);
        }
        public InputReader(InputStream stream, int bufferSize) {
        if (stream == null || bufferSize <= 0)
            throw new IllegalArgumentException();
        buf = new byte[bufferSize];
        charBuffer = new char[128];
        this.bufferSize = bufferSize;
        this.stream = stream;
        }
        private byte read() throws IOException {

        if (numBytesRead == EOF)
            throw new IOException();

        if (bufIndex >= numBytesRead) {
            bufIndex = 0;
            numBytesRead = stream.read(buf);
            if (numBytesRead == EOF)
            return EOF;
        }

        return buf[bufIndex++];
        }
        private int readJunk(int token) throws IOException {

        if (numBytesRead == EOF)
            return EOF;
        do {

            while (bufIndex < numBytesRead) {
            if (buf[bufIndex] > token)
                return 0;
            bufIndex++;
            }
            numBytesRead = stream.read(buf);
            if (numBytesRead == EOF)
            return EOF;
            bufIndex = 0;

        } while (true);

        }
        public byte nextByte() throws IOException {
        return (byte) nextInt();
        }
        public int nextInt() throws IOException {

        if (readJunk(DASH - 1) == EOF)
            throw new IOException();
        int sgn = 1, res = 0;

        c = buf[bufIndex];
        if (c == DASH) {
            sgn = -1;
            bufIndex++;
        }

        do {

            while (bufIndex < numBytesRead) {
            if (buf[bufIndex] > SPACE) {
                res = (res << 3) + (res << 1);
                res += ints[buf[bufIndex++]];
            } else {
                bufIndex++;
                return res * sgn;
            }
            }
            numBytesRead = stream.read(buf);
            if (numBytesRead == EOF)
            return res * sgn;
            bufIndex = 0;

        } while (true);

        }
        public int[] nextIntArray(int n) throws IOException {
        int[] ar = new int[n];
        for (int i = 0; i < n; i++)
            ar[i] = nextInt();
        return ar;
        }
        public int[] nextIntArray1(int n) throws IOException {
        int[] ar = new int[n + 1];
        for (int i = 1; i <= n; i++)
            ar[i] = nextInt();
        return ar;
        }
        public void close() throws IOException {
        stream.close();
        }

    }
}

class Pair{
    int si, ei;
    public Pair(int s, int e){
        si = s;
        ei = e;
    }

    @Override
    public String toString() {
        return "{"+si+", "+ei+"}";
    }
}

class FenwickTree{
    
    long []ft;
    int [] arr;

    FenwickTree(int [] ar){
        ft = new long[ar.length];
        arr = new int[ar.length];
        for(int i = 0;i<ar.length;i++){
            arr[i] = ar[i];
        }
        construct();
    }

    private void construct() {
        for(int i = 1;i<arr.length;i++){
            update(i, arr[i], 0);
        }
    }

    public void update(int idx, int new_val){
        update(idx, new_val, arr[idx]);
        arr[idx] = new_val;
    }

    private void update(int idx, int new_val, int old_val){
        while(idx < ft.length){
            ft[idx] += (new_val-old_val);
            idx = idx + (idx&-idx);
        }
    }

    public long query(int idx){
        long sum = 0;
        while(idx > 0){
            sum += ft[idx];
            idx = idx - (idx&-idx);
        }

        return sum;
    }
}