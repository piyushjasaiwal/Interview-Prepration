/*
You are given an array(of integers) of length n.
You are required to answer q queries.
In each query u are given an interval l, r both inclusive and u have to find the maximum element in this interval.

To do the above task u have to create a datastructure as follows :-

Implement the SegmentTree class:
1. SegmentTree(int arr[]): Initializes the SegmentTree object with an array,
2. int query(int l, int r): return max in interval [l, r].

Can u do it in O(log(n)) or better Time Complexity.
Input Format
A number n
n1
n2
.. n number of elements
A number q
following q lines contains queries of format
l r
Output Format
for each query print a single integer in seperate line
Question Video

  COMMENTConstraints
1. 1 <= n, q <= 10^5
2. 0 <= l <= r < n
3. 10^9 <= arr[i] <= 10^9
4. all input and output will fit in 32bit signed integer
Sample Input
8
8
7
4
2
5
3
1
10
4
0 7
0 3
2 7
1 6
Sample Output
10
8
10
7
*/

import java.io.*;

class max_in_interval_range_query {

  public static class SegmentTree {

    int [] tree;

    SegmentTree(int arr[]) {
        tree = new int[arr.length*4];
        construct(arr, 0, arr.length-1, 0);
        // show(arr);
        // show(tree);
    }

    // private void show(int[] arr) {
    //     System.out.println("--------------------------------------");
    //     for(int val:arr){
    //         System.out.print(val+" ");
    //     }
    //     System.out.println("\n---------------------------------------");
    // }

    private void construct(int[] arr, int left, int right, int idx) {
        if(left > right){
            return ;
        }

        if(left == right){
            tree[idx] = arr[left];
            return ;
        }

        int mid = left + (right-left)/2;

        construct(arr, left, mid, 2*idx + 1);
        construct(arr, mid+1, right, 2*idx + 2);

        int curr_val = Math.max(tree[2*idx+1], tree[2*idx+2]);
        tree[idx] = curr_val;
    }

    int query(int l, int r) {
        return query_helper(l, r, 0, (tree.length/4)-1, 0);
        // return 0;
    }

    private int query_helper(int l, int r, int i, int j, int k) {

      if(r < i || l > j){
        return Integer.MIN_VALUE;
      }
      
      if(i == j){
        return tree[k];
      }else if(i == l && j == r){
        return tree[k];
      }else{
        int mid = (i+j)/2;
        int left = query_helper(l, r, i, mid, 2*k+1);
        int right = query_helper(l, r, mid+1, j, 2*k+2);

        return Math.max(left, right);
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

      int l = Integer.parseInt(inp[0]);
      int r = Integer.parseInt(inp[1]);

      int ans = obj.query(l, r);
      out.append(ans);
      out.append("\n");
    }

    System.out.println(out);
  }

}