/*abstract
You are given an array(of integers) of length n.
You are required to answer q queries.

Queries can be of two types :-
Update
0 idx val : set arr[idx] to val.
Query
1 l r: find i,j such that l <= i < j <= r, such that arr[i]+arr[j] is maximized. return arr[i]+arr[j].
Input Format
A number n
n1
n2
.. n number of elements
A number q
following q lines contains queries of format either of two 
0 idx val
1 l r
Output Format
for each query of type 1 print a single integer in seperate line
Question Video

  COMMENTConstraints
1. 1 <= n, q <= 10^5
2. 0 <= l < r < n
3. 0 <= idx < n
4. 1 <= arr[i], val <= 10^4.
Sample Input
8
2
6
1
5
4
10
10
9
5
1 0 4
0 0 10
1 0 4
1 0 7
1 3 4
Sample Output
11
16
20
9
*/

import java.io.*;

class maximum_sum {

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(read.readLine());
        int [] ar = new int[n];
        for(int i = 0;i<n;i++){
            ar[i] = Integer.parseInt(read.readLine());
        }

        int q = Integer.parseInt(read.readLine());

        String [] queries = new String[q];
        while(q-->0){
            queries[queries.length-q-1] = read.readLine();
        }

        Segment_tree st = new Segment_tree(ar);
        // st.show();

        for(String query : queries){
            String [] parts = query.split(" ");
            if(Integer.parseInt(parts[0]) == 0){
                int l = Integer.parseInt(parts[1]);
                int r = Integer.parseInt(parts[2]);
                st.update(l, r);
            }else{
                int l = Integer.parseInt(parts[1]);
                int r = Integer.parseInt(parts[2]);
                System.out.println(st.query(l, r));
            }
        }
    }
}

class Segment_tree{

    private Pair [] tree ;

    public Segment_tree(int [] arr){
        tree = new Pair[arr.length*4];
        construct(arr, 0, arr.length-1, 0);
    }

    private void construct(int[] arr, int i, int j, int k) {
        if(i > j){
            return ;
        }

        if(i == j){
            tree[k] = new Pair(arr[i], -1);
            return ;
        }

        int mid = (i+j)/2;

        construct(arr, i, mid, 2*k+1);
        construct(arr, mid+1, j, 2*k+2);

        Pair left = tree[2*k+1];
        Pair right = tree[2*k+2];

        tree[k] = give_max_2(left, right);
    }

    public void show(){
        for(int i = 0;i<tree.length;i++){
            System.out.println(i+" "+tree[i]);
        }
    }

    public int query(int l, int r){
        Pair ans = query(l, r, 0, tree.length/4-1, 0);
        return ans.max1 + ans.max2;
    }

    private Pair query(int l, int r, int start, int end, int k) {
        if(start > r || end < l){
            return new Pair();
        }

        if(start == end){
            return tree[k];
        }

        if(l <= start && end <= r){
            return tree[k];
        }

        int mid = (start+end)/2;
        Pair left = query(l, r, start, mid, 2*k+1);
        Pair right = query(l, r, mid+1, end, 2*k+2);

        return give_max_2(left, right);
    }

    public void update(int idx, int val){
        update(0, tree.length/4-1, idx, val, 0);
    }

    private void update(int start, int end, int idx, int val, int k) {
        if(start > end){
            return ;
        }

        if(start == idx && idx == end){
            tree[k] = new Pair(val, -1);
            return ;
        }

        int mid = (start+end)/2;
        if(mid < idx){
            update(mid+1, end, idx, val, 2*k+2);
        }else{
            update(start, mid, idx, val, 2*k+1);
        }

        Pair left = tree[2*k+1];
        Pair right = tree[2*k+2];

        Pair max_of_2 = give_max_2(left, right);
        tree[k] = max_of_2;
    }

    private Pair give_max_2(Pair left, Pair right){
        int max1 = -1;
        int max2 = -1;

        if(left.max1 > max1){
            max2 = max1;
            max1 = left.max1;
        }else if(left.max1 > max2){
            max2 = left.max1;
        }

        if(left.max2 > max1){
            max2 = max1;
            max1 = left.max2;
        }else if(left.max2 > max2){
            max2 = left.max2;
        }

        if(right.max1 > max1){
            max2 = max1;
            max1 = right.max1;
        }else if(right.max1 > max2){
            max2 = right.max1;
        }

        if(right.max2 > max1){
            max2 = max1;
            max1 = right.max2;
        }else if(right.max2 > max2){
            max2 = right.max2;
        }

        return new Pair(max1, max2);
    }
}

class Pair{
    int max1, max2;
    Pair(int m, int n){
        max1 = m;
        max2 = n;
    }

    Pair(){
        this(-1, -1);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "{"+max1+", "+max2+"}";
    }
}