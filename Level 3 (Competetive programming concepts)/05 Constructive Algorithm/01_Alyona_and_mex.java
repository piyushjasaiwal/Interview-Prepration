/*abstract
Alyona's mother wants to present an array of n non-negative integers to Alyona. The array should be special.

Alyona is a capricious girl so after she gets the array, she inspects m of its subarrays. Subarray is a set of some subsequent elements of the array. The i-th subarray is described with two integers li and ri, and its elements are a[li], a[li + 1], ..., a[ri].

Alyona is going to find mex for each of the chosen subarrays. Among these m mexes the girl is going to find the smallest. She wants this minimum mex to be as large as possible.

You are to find an array a of n elements so that the minimum mex among those chosen by Alyona subarrays is as large as possible.

The mex of a set S is a minimum possible non-negative integer that is not in S.

Input
The first line contains two integers n and m (1 ≤ n, m ≤ 105).

The next m lines contain information about the subarrays chosen by Alyona. The i-th of these lines contains two integers li and ri (1 ≤ li ≤ ri ≤ n), that describe the subarray a[li], a[li + 1], ..., a[ri].

Output
In the first line print single integer — the maximum possible minimum mex.

In the second line print n integers — the array a. All the elements in a should be between 0 and 109.

It is guaranteed that there is an optimal answer in which all the elements in a are between 0 and 109.

If there are multiple solutions, print any of them.

Examples
inputCopy
5 3
1 3
2 5
4 5
outputCopy
2
1 0 2 1 0
inputCopy
4 2
1 4
2 4
outputCopy
3
5 2 0 1
Note
The first example: the mex of the subarray (1, 3) is equal to 3, the mex of the subarray (2, 5) is equal to 3, the mex of the subarray (4, 5) is equal to 2 as well, thus the minumal mex among the subarrays chosen by Alyona is equal to 2.
*/

import java.io.*;
import java.util.*;

class Alyona_and_mex {
  static InputReader in = new InputReader(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  public static void main(String[] args) throws IOException {
    // write your code here.
    int n = in.nextInt();
    int m = in.nextInt();
    int minMex = Integer.MAX_VALUE;

    while(m-->0){
        int a = in.nextInt();
        int b = in.nextInt();
        minMex = Math.min(minMex, b-a+1);
    }

    out.write(minMex+"");
    out.write("\n");
    int a = 0;
    for(int i = 0;i<n;i++){
        out.write(a+" ");
        a++;
        if(a == minMex){
            a = 0;
        }
    }
    out.flush();
    out.close();
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