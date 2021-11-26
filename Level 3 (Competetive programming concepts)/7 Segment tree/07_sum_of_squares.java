/*abstract
You are given an array(of integers) of length n.
You are required to answer q queries.

Queries can be of two types
0. 0 l r : In this you have to return sum of squares of all elements int range [l, r].
1. 1 l r val: In this query u have to increase all elements in this interval [l, r] by val.

To do the above task u have to create a datastructure as follows :-

Implement the SegmentTree class:
1. SegmentTree(int arr[]): Initializes the SegmentTree object with an array,
2. void update(int l, int r, int val): increase all elements in this interval [l, r] by val,
3. long query(int l, int r): return sum of squares of all elements arr[i] for which i is in range [l, r].
Input Format
A number n
n1
n2
.. n number of elements
A number q
following q lines contains queries of format
0 l r
1 l r val
Output Format
for each query of type 0 print a single integer in seperate line
Question Video

  COMMENTConstraints
1. 1 <= n, q <= 10^5
2. 0 <= l <= r < n
3. -10^4 <= arr[i], val <= 10^4.
Sample Input
8
0
10
10
-1
5
8
10
2
5
0 7 7
1 4 6 1
0 2 4
1 5 5 7
0 3 7
Sample Output
4
137
418
*/

import java.io.*;
import java.util.*;

class sum_of_squares {

  public static class SegmentTree {

    long [] tree;
    int [] ar;

    SegmentTree(int arr[]) {
        tree = new long[arr.length*4];
        ar = new int[arr.length];

        construct(arr, 0, arr.length-1, 0);
    }



    private void construct(int[] arr, int i, int j, int k) {
        if(i > j){
            return ;
        }

        if(i == j){
            tree[k] = arr[i]*arr[i];
            return ;
        }

        int mid = (i+j)/2;
        construct(arr, i, mid, 2*k+1);
        construct(arr, mid+1, j, 2*k+2);
        tree[k] = tree[2*k+1]+tree[2*k+2];
    }



    void update(int l, int r, int val) {
        update(l, r, 0, ar.length-1, 0, val);
    }

    private void update(int l, int r, int start, int end, int k, int val) {
        if(l > end || r < start){
            return ;
        }

        if()
    }

    long query(int l, int r) {
        return query(l, r, 0, ar.length-1, 0);
    }

    private long query(int l, int r, int start, int end, int k) {
        if(l > end || start > r){
            return 0;
        }

        if(start == end){
            return tree[k];
        }

        if(l <= start && end <= r){
            return tree[k];
        }

        int mid = (start+end)/2;
        long left = query(l, r, start, mid, 2*k+1);
        long right = query(l, r, mid+1, end, 2*k+2);

        return right+left;
    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    int arr[] = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(read.readLine());
    }

    SegmentTree obj = new SegmentTree(arr);

    int q = Integer.parseInt(read.readLine());

    StringBuilder out = new StringBuilder();
    while (q-- > 0) {
      String[] inp = read.readLine().split(" ");

      int t = Integer.parseInt(inp[0]);
      int l = Integer.parseInt(inp[1]);
      int r = Integer.parseInt(inp[2]);

      if (t == 0) {
        long ans = obj.query(l, r);
        out.append(ans + "\n");
      } else {
        // int val = Integer.parseInt(inp[3]);
        // obj.update(l, r, val);
      }
    }

    System.out.println(out);
  }

}