/*abstract
You are given an array(of integers) of length n.
You are required to answer q queries.

Queries can be of two types
0. 0 l r : In this you have to return sum of all elements arr[i] for i in l<=i<=r.
1. 1 l r val: In this query u have to increase all elements in this interval [l, r] by val.

To do the above task u have to create a datastructure as follows :-

Implement the SegmentTree class:
1. SegmentTree(int arr[]): Initializes the SegmentTree object with an array,
2. void update(int l, int r, int val): increase all elements in this interval [l, r] by val,
3. int query(int l, int r): return sum of all elements arr[i] for which i is in range [l, r].
Input Format
A number n
n1
n2
.. n number of elements
A number q
following q lines contains queries of format either of two 
0 l r,
1 l r val
Output Format
for each query of type 0 print a single integer in seperate line
Question Video

  COMMENTConstraints
1. 1 <= n, q <= 10^5
2. 0 <= l <= r < n
3. 10^4 <= arr[i], val <= 10^4.
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
2
15
34
*/

import java.io.*;
import java.util.Arrays;

class sum_of_range_range_query_update {

  public static class SegmentTree {

    Pair [] tree;

    SegmentTree(int arr[]) {
        tree = new Pair [arr.length*4];
        Arrays.fill(tree, new Pair());
        construct(arr, 0, arr.length-1, 0);
    }

    private void construct(int[] arr, int i, int j, int k) {
        if(i > j){
            return ;
        }

        if(i == j){
            tree[k] = new Pair(arr[i], 0);
            return ;
        }

        int mid = (i+j)/2;
        construct(arr, i, mid, 2*k+1);
        construct(arr, mid+1, j, 2*k+2);
        tree[k] = new Pair(tree[2*k+1].sum+tree[2*k+2].sum, 0);
    }

    void update(int l, int r, int val) {
        update(l, r, 0, tree.length/4-1, 0, val);
    }

    private void update(int l, int r, int start, int end, int k, int val) {

        if(r < start || end < l){
            return ;
        }

        if(start == end){
            tree[k].p_value += val;
            return ;
        }
        
        if(l<=start && r >= end){
            tree[k].p_value += val;
            return ;
        }

        int mid = (start+end)/2;
        update(l, r, start, mid, 2*k+1, val);
        update(l, r, mid+1, end, 2*k+2, val);
    }

    int query(int l, int r) {
        return query(l, r, 0, tree.length/4-1, 0);
    }

    private int query(int l, int r, int start, int end, int k) {

        if(r < start || end < l){
            return 0;
        }     
        
        if(start == end){
            return tree[k].sum+tree[k].p_value;
        }

        if(l <= start && r >= end){
            return tree[k].sum+tree[k].p_value;
        }

        propogate(k);

        int mid = (start+end)/2;

        if(r <= mid){
            return query(l, r, start, mid, 2*k+1);
        }else if(l > mid){
            return query(l, r, mid+1, end, 2*k+2);
        }
        
        return query(l, r, start, mid, 2*k+1)+query(l, r, mid+1, end, 2*k+2);
    }

    private void propogate(int k) {
        int left = 2*k+1;
        int right = 2*k+2;
        tree[left].p_value += tree[k].p_value;
        tree[right].p_value += tree[k].p_value;
        tree[k].p_value = 0;
    }

    static class Pair{
        int sum;
        int p_value;

        Pair(int s, int p){
            sum = s;
            p_value = p;
        }

        Pair(){
            this(0,0);
        }
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
        long ans = obj.query(l, r);
        out.append(ans + "\n");
      } else {
        int val = Integer.parseInt(inp[3]);
        obj.update(l, r, val);
      }
    }

    System.out.println(out);
  }

}