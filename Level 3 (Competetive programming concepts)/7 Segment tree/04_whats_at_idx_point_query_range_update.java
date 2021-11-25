/*abstract
You are given an array(of integers) of length n.
You are required to answer q queries.

Queries can be of two types
0. 0 ind : In this you have to tell the value of arr[ind].
1. 1 l r val: In this query u have to increase all elements in this interval [l, r] by val.

To do the above task u have to create a datastructure as follows :-

Implement the SegmentTree class:
1. SegmentTree(int arr[]): Initializes the SegmentTree object with an array,
2. void update(int l, int r, int val): increase all elements in this interval [l, r] by val,
3. int query(int ind): return arr[ind].
Input Format
A number n
n1
n2
.. n number of elements
A number q
following q lines contains queries of format either of two 
0 ind,
1 l r val
Output Format
for each query of type 0 print a single integer in seperate line
Question Video

  COMMENTConstraints
1. 1 <= n, q <= 10^5
2. 0 <= l <= r < n
3. 10^4 <= arr[i], val <= 10^4.
4. 0 <= ind < n
Sample Input
8
4
3
9
3
9
8
7
2
5
1 4 6 0
0 7
1 0 3 4
0 4
0 5
Sample Output
2
9
8
*/

import java.io.*;
import java.util.*;

class whats_at_idx_point_query_range_update {

  public static class SegmentTree {

    int [] lazy;

    SegmentTree(int arr[]) {
        lazy = new int[arr.length*4];
        construct(arr, 0, arr.length-1, 0);
    }

    private void construct(int[] arr, int i, int j, int k) {
        if(i>j){
            return ;
        }

        if(i == j){
            lazy[k] = arr[i];
            return ;
        }

        int mid = (i+j)/2;
        construct(arr, i, mid, 2*k+1);
        construct(arr, mid+1, j, 2*k+2);
        lazy[k] = 0;
    }

    void update(int l, int r, int val) {
        update(l, r, 0, (lazy.length/4)-1, val, 0);
    }

    private void update(int l, int r, int start, int end, int val, int k) {

        if(start > r || end < l){
            return ;
        }

        if(start == end){
            lazy[k] += val;
            return ;
        }else if(start >= l && end <= r){
            lazy[k] += val;
            return ;
        }

        int mid = (start + end)/2;
        update(l, r, start, mid, val, 2*k+1);
        update(l, r, mid+1, end, val, 2*k+2);
    }

    int query(int ind) {
        return query(0, (lazy.length/4)-1, ind, 0);
    }

    private int query(int i, int j, int ind, int k) {

        if(i == ind && j == ind){
            return lazy[k];
        }

        propogate(k);

        int mid = (i+j)/2;
        if(i <= ind && ind <= mid){
            return query(i, mid, ind, 2*k+1);
        }else{
            return query(mid+1, j, ind, 2*k+2);
        }
    }

    private void propogate(int k) {
        int left = 2*k+1;
        int right = 2*k+2;

        lazy[left] += lazy[k];
        lazy[right] += lazy[k];

        lazy[k] = 0;
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
      String[]inp = read.readLine().split(" ");

      int t = Integer.parseInt(inp[0]);

      if (t == 0) {
        int ind = Integer.parseInt(inp[1]);
        long ans = obj.query(ind);
        out.append(ans + "\n");
      } else {
        int l = Integer.parseInt(inp[1]);
        int r = Integer.parseInt(inp[2]);
        int val = Integer.parseInt(inp[3]);
        obj.update(l, r, val);
      }
    }

    System.out.println(out);
  }

}