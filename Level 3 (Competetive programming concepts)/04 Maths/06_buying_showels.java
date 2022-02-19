/*abstract
Polycarp wants to buy exactly n shovels. The shop sells packages with shovels. The store has k types of packages: the package of the i-th type consists of exactly i shovels (1≤i≤k). The store has an infinite number of packages of each type.

Polycarp wants to choose one type of packages and then buy several (one or more) packages of this type. What is the smallest number of packages Polycarp will have to buy to get exactly n shovels?

For example, if n=8 and k=7, then Polycarp will buy 2 packages of 4 shovels.

Help Polycarp find the minimum number of packages that he needs to buy, given that he:

will buy exactly n shovels in total;
the sizes of all packages he will buy are all the same and the number of shovels in each package is an integer from 1 to k, inclusive.
Input
The first line contains an integer t (1≤t≤100) — the number of test cases in the input. Then, t test cases follow, one per line.

Each test case consists of two positive integers n (1≤n≤109) and k (1≤k≤109) — the number of shovels and the number of types of packages.

Output
Print t answers to the test cases. Each answer is a positive integer — the minimum number of packages.

Example
inputCopy
5
8 7
8 1
6 10
999999733 999999732
999999733 999999733
outputCopy
2
8
1
999999733
1
Note
The answer to the first test case was explained in the statement.

In the second test case, there is only one way to buy 8 shovels — 8 packages of one shovel.

In the third test case, you need to buy a 1 package of 6 shovels.
*/

import java.util.*;
import java.io.*;

class buying_showels{
    static StringBuilder sb;
    static dsu dsu;
    static long fact[];
    static int mod = (int) (1e9 + 7);
    static InputReader reader;

    static void solve() {
        int n = reader.Int();
        int k = reader.Int();

        int min = Integer.MAX_VALUE;
        
        for(int a = 1;a*a<=n;a++){
            if(n%a == 0){
                int b = n/a;
                if(b<=k){
                    min = Math.min(min,a);
                }
                if(a<=k){
                    min = Math.min(min, b);
                }
            }
        }
        sb.append(min+"\n");
    }

    static int prime(int n){
        int ans = -1;
        for(long i = 2;(i*i)<=n;i++){
            if(n%i == 0){
                return -1;
            }
            ans = (int)i;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        sb = new StringBuilder();
        reader = new InputReader(System.in);
        int test = reader.Int();
        // int test = 1;
        while (test-- > 0) {
            solve();
        }
        System.out.println(sb);

    }

    /*
    * fact=new long[(int)1e6+10]; fact[0]=fact[1]=1; for(int i=2;i<fact.length;i++)
    * { fact[i]=((long)(i%mod)1L(long)(fact[i-1]%mod))%mod; }
    */
    //**************NCR%P******************
    static long ncr(int n, int r) {
        if (r > n)
        return (long) 0;

        long res = fact[n] % mod;
        // System.out.println(res);
        res = ((long) (res % mod) * (long) (p(fact[r], mod - 2) % mod)) % mod;
        res = ((long) (res % mod) * (long) (p(fact[n - r], mod - 2) % mod)) % mod;
        // System.out.println(res);
        return res;

    }

    static long p(long x, long y)// POWER FXN //
    {
        if (y == 0)
        return 1;

        long res = 1;
        while (y > 0) {
        if (y % 2 == 1) {
            res = (res * x) % mod;
            y--;
        }

        x = (x * x) % mod;
        y = y / 2;

        }
        return res;
    }

    //**************END******************

    // *************Disjoint set
    // union*********//
    static class dsu {
        int parent[];

        dsu(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = -1;
        }

        int find(int a) {
        if (parent[a] < 0)
            return a;
        else {
            int x = find(parent[a]);
            parent[a] = x;
            return x;
        }
        }

        void merge(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b)
            return;
        parent[b] = a;
        }
    }

    //**************PRIME FACTORIZE **********************************//
    static TreeMap<Integer, Integer> prime(long n) {
        TreeMap<Integer, Integer> h = new TreeMap<>();
        long num = n;
        for (int i = 2; i <= Math.sqrt(num); i++) {
        if (n % i == 0) {
            int nt = 0;
            while (n % i == 0) {
            n = n / i;
            nt++;
            }
            h.put(i, nt);
        }
        }
        if (n != 1)
        h.put((int) n, 1);
        return h;

    }

    //****CLASS PAIR ************************************************
    static class Pair implements Comparable<Pair> {
        int x;
        long y;

        Pair(int x, long y) {
        this.x = x;
        this.y = y;
        }

        public int compareTo(Pair o) {
        return (int) (this.y - o.y);

        }

    }
    //****CLASS PAIR **************************************************

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
        this.stream = stream;
        }

        public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
            numChars = stream.read(buf);
            } catch (IOException e) {
            throw new InputMismatchException();
            }
            if (numChars <= 0)
            return -1;
        }
        return buf[curChar++];
        }

        public int Int() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
            throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
        }

        public String String() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
        }

        public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
        return String();
        }

        public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
            writer.print(' ');
            writer.print(objects[i]);
        }
        }

        public void printLine(Object... objects) {
        print(objects);
        writer.println();
        }

        public void close() {
        writer.close();
        }

        public void flush() {
        writer.flush();
        }
    }

    static InputReader in = new InputReader(System.in);
    static OutputWriter out = new OutputWriter(System.out);

    public static long[] sort(long[] a2) {
        int n = a2.length;
        ArrayList<Long> l = new ArrayList<>();
        for (long i : a2)
        l.add(i);
        Collections.sort(l);
        for (int i = 0; i < l.size(); i++)
        a2[i] = l.get(i);
        return a2;
    }

    public static char[] sort(char[] a2) {
        int n = a2.length;
        ArrayList<Character> l = new ArrayList<>();
        for (char i : a2)
        l.add(i);
        Collections.sort(l);
        for (int i = 0; i < l.size(); i++)
        a2[i] = l.get(i);
        return a2;
    }

    public static long pow(long x, long y) {
        long res = 1;
        while (y > 0) {
        if (y % 2 != 0) {
            res = (res * x);// % modulus;
            y--;

        }
        x = (x * x);// % modulus;
        y = y / 2;
        }
        return res;
    }

    //GCD___+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static long gcd(long x, long y) {
        if (x == 0)
        return y;
        else
        return gcd(y % x, x);
    }
    // ******LOWEST COMMON MULTIPLE
    // *********************************************

    public static long lcm(long x, long y) {
        return (x * (y / gcd(x, y)));
    }

    //INPUT PATTERN********************************************************
    public static int i() {
        return in.Int();
    }

    public static long l() {
        String s = in.String();
        return Long.parseLong(s);
    }

    public static String s() {
        return in.String();
    }

    public static int[] readArrayi(int n) {
        int A[] = new int[n];
        for (int i = 0; i < n; i++) {
        A[i] = i();
        }
        return A;
    }

    public static long[] readArray(long n) {
        long A[] = new long[(int) n];
        for (int i = 0; i < n; i++) {
        A[i] = l();
        }
        return A;
    }

}