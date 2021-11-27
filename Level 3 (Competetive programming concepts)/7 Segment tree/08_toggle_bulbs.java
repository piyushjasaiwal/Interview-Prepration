/*abstract
You are given n bulbs, numbered from 1 to n. Initially all the bulbs are turned off.
You have to perform 2 types of operations:-

1. Toggle all bulbs numbered between A to B.Here toggle mean turn on bulbs to off and off bulbs to on.This is represented by 1 A B.
2. Count how many bulbs numbered between A to B are on.This is represented by 2 A B.
Input Format
First line contains two integers n and q.
Following q lines contains queries of format either 1 A B or 2 A B.
Output Format
Print count of bulbs for query type 2 A B.
Question Video

  COMMENTConstraints
1. 1 <= n <= 10^5
2. 1 <= q <= 10^5
3. 1 <= A <= B <= n
Sample Input
4 7
2 1 4
1 2 3
2 1 2
2 1 1
1 1 4
2 1 4 
2 4 4
Sample Output
0
1
0
2
1
*/

import java.io.*;
import java.util.*;

class toggle_bulbs {

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String inps[] = read.readLine().split(" ");
        int n = Integer.parseInt(inps[0]);
        int q = Integer.parseInt(inps[1]);

        // write your code here

        char [] bulbs = new char[n];
        Arrays.fill(bulbs, '0');
        segment_tree st = new segment_tree(new String(bulbs));

        while(q-->0){
            inps = read.readLine().split(" ");
            if(Integer.parseInt(inps[0]) == 2){
                System.out.println(st.query(Integer.parseInt(inps[1]), Integer.parseInt(inps[2])));
            }else{
                st.update(Integer.parseInt(inps[1]), Integer.parseInt(inps[2]));
            }
        }
    }

    static class segment_tree{
        int [] tree;
        int [] lazy;

        public segment_tree(String input){
            tree = new int[4*input.length()];
            lazy = new int[4*input.length()];
            construct(input, 0, input.length()-1, 0);
        }

        private void construct(String input, int i, int j, int k) {
            if(i > j){
                return ;
            }

            if(i == j){
                tree[k] = input.charAt(i) == '0' ? 0 : 1;
                lazy[k] = 0;
                return ;
            }

            int mid = (i+j)/2;
            construct(input, i, mid, 2*k+1);
            construct(input, mid+1, j, 2*k+2);

            tree[k] = tree[2*k+1] + tree[2*k+2];
        }

        public void update(int l, int r){
            update(l, r, 0, tree.length/4-1, 0);
        }

        private void update(int l, int r, int start, int end, int k) {
            propogate(k, start, end);

            if(l > end || r < start){
                return ;
            }

            if(start == end){
                tree[k] = (tree[k]^1);
                return ;
            }

            if(l <= start && end <= r){
                lazy[k] = (lazy[k]^1);
                propogate(k, start, end);
                return ;
            }

            int mid = (start+end)/2;

            update(l, r, start, mid, 2*k+1);
            update(l, r, mid+1, end, 2*k+2);

            tree[k] = tree[2*k+1] + tree[2*k+2];
        }

        public int query(int l, int r){
            return query(l, r, 0, tree.length/4-1, 0);
        }

        private int query(int l, int r, int start, int end, int k) {
            if(start > r || end < l){
                return 0;
            }

            propogate(k, start, end);

            if(start == end){
                return tree[k];
            }        

            if(l<=start && end <= r){
                return tree[k];
            }

            int mid = (start+end)/2;

            int left = query(l, r, start, mid, 2*k+1);
            int right = query(l, r, mid+1, end, 2*k+2);

            return left+right;
        }

        private void propogate(int k, int start, int end) {
            
            int left = 2*k+1;
            int right = 2*k+2;

            if(start == end){
                tree[k] = tree[k]^lazy[k];
                lazy[k] = 0;
                return ;
            }

            if(lazy[k] == 0){
                return ;
            }

            int total = end-start+1;
            int curr_on = tree[k];
            tree[k] = total - curr_on;

            lazy[left] = lazy[left]^1;
            lazy[right] = lazy[right]^1;
            lazy[k] = 0;
        }
    }
}

