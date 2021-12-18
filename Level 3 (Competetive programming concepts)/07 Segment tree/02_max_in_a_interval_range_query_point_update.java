/*abstract
You are given an array(of integers) of length n.
You are required to answer q queries.

Queries can be of two types
0. 0 pos val : In this you have to update arr[pos] to val.
1. 1 l r: In this query u have to find the max among all elements in this interval.


To do the above task u have to create a datastructure as follows :-

Implement the SegmentTree class:
1. SegmentTree(int arr[]): Initializes the SegmentTree object with an array,
2. void update(int pos, int val): updates the arr[pos] to val,
3. int query(int l, int r): return max of all element's in interval [l, r].

Can u do it in O(log(n)) or better Time Complexity.
Input Format
A number n
n1
n2
.. n number of elements
A number q
following q lines contains queries of format either of two 
0 pos val,
1 l r
Output Format
for each query print a single integer in seperate line
Question Video

  COMMENTConstraints
1. 1 <= n, q <= 10^5
2. 0 <= l <= r < n
3. 10^9 <= arr[i] <= 10^9
4. all input and output will fit in 32bit signed integer
Sample Input
4
1
2
3
4
10
1 0 3
0 1 3
1 0 3
1 1 2
0 2 5
1 2 2
1 2 3
1 0 1
1 0 2
1 1 3
Sample Output
4
4
3
5
5
3
5
5
*/

import java.io.*;

class max_in_a_interval_range_query_point_update {

  public static class SegmentTree {
      int [] tree ;
    SegmentTree(int arr[]) {
        tree = new int[arr.length*4];
        construct(arr, 0, arr.length-1, 0);
    }

    private void construct(int[] arr, int i, int j, int k) {
        if(i > j){
            return ;
        }

        if(i == j){
            tree[k] = arr[i];
            return ;
        }

        int mid = (i+j)/2;
        construct(arr, i, mid, 2*k + 1);
        construct(arr, mid+1, j, 2*k + 2);

        tree[k] = Math.max(tree[2*k+1], tree[2*k+2]);
    }

    void update(int pos, int val) {
        update(0, tree.length/4-1, pos, val, 0);
    }

    void update(int start, int end, int pos, int val, int k){

        if(start > pos || end < pos){
            return ;
        }

        if(start == pos && end == pos){
            tree[k] = val;
            return ;
        }

        int mid = (start+end)/2;

        update(start, mid, pos, val, 2*k+1);
        update(mid+1, end, pos, val, 2*k+2);

        tree[k] = Math.max(tree[2*k+1], tree[2*k+2]);
    }

    int query(int l, int r) {
        return query(l, r, 0, tree.length/4 - 1, 0);
    }

    private int query(int l, int r, int start, int end, int k) {

        if(l > end || start > r){
            return Integer.MIN_VALUE;
        }
        
        if(start == end){
            return tree[k];
        }

        if(start == l && end == r){
            return tree[k];
        }

        int mid = (start+end)/2;
        int left = query(l, r, start, mid, 2*k+1);
        int right = query(l, r, mid+1, end, 2*k+2);

        return Math.max(left, right);
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
      int l = Integer.parseInt(inp[1]);
      int r = Integer.parseInt(inp[2]);

      if (t == 0) {
        obj.update(l, r);
      } else {
        int ans = obj.query(l, r);
        out.append(ans);
        out.append("\n");
      }
    }

    System.out.println(out);
  }

}