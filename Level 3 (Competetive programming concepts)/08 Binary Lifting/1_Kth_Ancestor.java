/*
You are given a tree of n nodes numbered from 0 to n-1 and is rooted at 0.
You are given an array parent of length n where parent[i] denotes parent of i'th node (in case of root it's parent is itself).

Now you have to answer q queries of format:
a k
answer to this query is k'th ancistor of node a if k'th ancistor does not exist simply print root.
In simple words you have to find k'th ancistor of a node.

Task: could u do it in log(n) or better time complexity.
Input Format
n
p1
p2
p3
... n numbers till pn
q
a1 k1
a2 k2
... q queries till a(q) k(q)
Output Format
for each query print in single line value of k'th ancistor
Question Video

  COMMENTConstraints
1. 2 <= n <= 10^5
2. parent[0] = 0
3. 1 <= q <= 10^5
4. 0 <= a <= n-1
5. 1 <= k <= n
Sample Input
7
0
0
0
1
3
2
3
6
5 1
6 2
3 2
3 3
6 3
4 1
Sample Output
2
1
0
0
0
3
*/

import java.io.*;
import java.util.*;

class Kth_Ancestor {

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());

        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
        parent[i] = Integer.parseInt(read.readLine());
        }
        int q = Integer.parseInt(read.readLine());
        // write your code here

        int [][] kth_Ancestors = ancestor_table_maker(parent);

        // show(kth_Ancestors);

        while(q-->0){
            String [] parts = read.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);

            int ancestor = a;
            int k = b;
            int mask = 0;
            while(k >= (int)(Math.pow(2, mask))){
                if((k&(int)(Math.pow(2, mask))) > 0){
                    ancestor = kth_Ancestors[mask][ancestor];
                }
                mask = mask+1;
            }
            System.out.println(ancestor);
        }
    }

    private static void show(int[][] kth_Ancestors) {
        for(int [] ar:kth_Ancestors){
            for(int a : ar){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }

    public static int [][] ancestor_table_maker(int [] parent){
        int [][] kth_parents = new int[17][parent.length];

        for(int i = 0;i<kth_parents.length;i++){
            // Arrays.fill(kth_parents[0], 0);
            for(int j = 0;j<kth_parents[0].length;j++){
                if(i == 0 && j == 0){
                    kth_parents[i][j] = 0;
                }else if(i == 0){
                    kth_parents[i][j] = parent[j];
                }else if(j == 0){
                    kth_parents[i][j] = 0;
                }else{
                    kth_parents[i][j] = kth_parents[i-1][kth_parents[i-1][j]];
                }
            }
        }

        return kth_parents;
    }
}
