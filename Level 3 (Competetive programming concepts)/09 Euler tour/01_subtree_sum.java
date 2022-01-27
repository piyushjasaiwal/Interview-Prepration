/*abstract
You are given a rooted tree consisting of n nodes. The nodes are numbered 1,2,…,n, and node 1 is the root. Each node has a value.

Your task is to process following types of queries:
change the value of node s to x
calculate the sum of values in the subtree of node s
Input

The first input line contains two integers n and q: the number of nodes and queries. The nodes are numbered 1,2,…,n.

The next line has n integers v1,v2,…,vn: the value of each node.

Then there are n−1 lines describing the edges. Each line contans two integers a and b: there is an edge between nodes a and b.

Finally, there are q lines describing the queries. Each query is either of the form "1 s x" or "2 s".

Output

Print the answer to each query of type 2.

Constraints
1≤n,q≤2⋅105
1≤a,b,s≤n
1≤vi,x≤109
Example

Input:
5 3
4 2 5 2 1
1 2
1 3
3 4
3 5
2 3
1 5 3
2 3

Output:
8
10
*/

import java.io.*;
import java.util.*;

class subtree_sum {
    static InputReader in = new InputReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int idx = 0;
    /*
    input_functions in.nextInt();     in.nextIntArray(n);      in.nextIntArray1(n);
    output_functions out.println();    out.print();
    */


    public static void main(String[] args) throws IOException {
      // write your code here.
      int n = in.nextInt();
      int q = in.nextInt();
      // int [] parent = new int[n];
      int [] val = in.nextIntArray(n);
      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
      for(int i = 0;i<=n;i++){
        graph.add(new ArrayList<>());
      }
      for(int i = 0;i<n-1;i++){
        int u = in.nextInt();
        int v = in.nextInt();

        graph.get(u).add(v);
      }

      // System.out.println(graph);

      int [] eular_tour = new int[2*n+1];
      idx = 1;
      HashMap<Integer, Range> map = new HashMap<>();
      eularTour(eular_tour,graph,1,map, val);
      // out.println(graph);
      // display(val);
      // display(eular_tour);
      // out.println(map);
      FenwickTree ft = new FenwickTree(eular_tour);
      while(q-->0){
        int t = in.nextInt();
        if(t == 1){
          int s = in.nextInt(), x = in.nextInt();
          // out.println(s);
          // out.println(x);
          int start = map.get(s).s;
          int end = map.get(s).e;
          System.out.println(map.get(s));

          ft.update(start, x);
          ft.update(end, x);
          ft.ar[start] = x;
          ft.ar[end] = x;
          // System.out.println(map);
          // // Range pair = map.remove(s);
          // // System.out.println(pair);
          // // map.put(x, new Range(start, end));
          // System.out.println(map);
        }else{
          int s = in.nextInt();
          int start = map.get(s).s;
          int end = map.get(s).e;
          System.out.println((ft.query(end)-ft.query(start-1))/2);
          // .out.println(ft.query(eular_tour.length-1));
        }
      }
      out.close();
    }

    public static void display(int [] ar){
      out.println("---------------------------------------------------------");
      for(int val:ar){
        out.print(val+" ");
      }
      out.println();
      out.println("---------------------------------------------------------");
    }

    private static void eularTour(int[] eular_tour, ArrayList<ArrayList<Integer>> graph, int root, HashMap<Integer, Range> map, int [] val) {
      int s = idx;
      eular_tour[idx] = val[root-1];
      idx+=1;
      for(int child:graph.get(root)){
        eularTour(eular_tour, graph, child, map, val);
      }
      int e = idx;
      eular_tour[idx] = val[root-1];
      idx+=1;
      map.put(root, new Range(s, e));
    }

    static class Range{
      int s, e;
      Range(int s, int e){
        this.s = s;
        this.e = e;
      }
      @Override
          public String toString() {
              // TODO Auto-generated method stub
              return "{"+s+","+e+"}";
          }
    }

    static class FenwickTree{
      long [] ft;
      int [] ar;
      FenwickTree(int [] ar){
        ft = new long[ar.length];
        this.ar = ar;
        for(int i = 1;i<ar.length;i++){
          add(i, ar[i]);
        }
      }

      public void add(int idx, int val){
        while(idx < ft.length){
          ft[idx] += val;
          idx = (idx+(idx&-idx));
        }
      }

      public long query(int idx){
        long sum = 0;
        while(idx > 0){
          sum += ft[idx];
          idx = (idx-(idx&-idx));
        }
        return sum;
      }

      public void update(int idx, int val){
        int new_val = val-ar[idx];
        ar[idx] = new_val;
        while(idx < ft.length){
          ft[idx] += new_val;
          idx = idx+(idx&-idx);
        }
      }

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