/*abstract
A tree is an undirected graph in which any two vertices are connected by exactly one simple path. In other words, any connected graph without cycles is a tree. - Wikipedia 

The lowest common ancestor (LCA) is a concept in graph theory and computer science. Let T be a rooted tree with N nodes. The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself). - Wikipedia

Your task in this problem is to find the LCA of any two given nodes v and w in a given tree T.


For example the LCA of nodes 9 and 12 in this tree is the node number 3.

Input
The first line of input will be the number of test cases. Each test case will start with a number N the number of nodes in the tree, 1 <= N <= 1,000. Nodes are numbered from 1 to N. The next N lines each one will start with a number M the number of child nodes of the Nth node, 0 <= M <= 999 followed by M numbers the child nodes of the Nth node. The next line will be a number Q the number of queries you have to answer for the given tree T, 1 <= Q <= 1000. The next Q lines each one will have two number v and w in which you have to find the LCA of v and w in T, 1 <= v, w <= 1,000.

Input will guarantee that there is only one root and no cycles.

Output
For each test case print Q + 1 lines, The first line will have “Case C:” without quotes where C is the case number starting with 1. The next Q lines should be the LCA of the given v and w respectively.

Example
Input:
1
7
3 2 3 4
0
3 5 6 7
0
0
0
0
2
5 7
2 7

Output:
Case 1:
3
1
*/

import java.io.*;
import java.util.*;

class LCA_lowest_common_ancestor_when_constraints_are_small {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    /*
    use in for reading input
    use out for printing output
    */

    public static void main(String[] args) throws IOException {

      // write your code here.
      int t = Integer.parseInt(in.readLine());
      while(t-->0){
        solve();
      }
      out.close();
    }

    private static void solve() throws NumberFormatException, IOException {
      int n = Integer.parseInt(in.readLine());
      int [] parent = new int[n+1];
      int [] level = new int[n+1];

      for(int i=1;i<=n;i++){
        parent[i] = i;
        level[i] = 1;
      }
      for(int i = 1;i<=n;i++){
        String []tokens = in.readLine().split(" ");
        int n_childs = Integer.parseInt(tokens[0]);
        int j = 1;
        while(n_childs-->0){
          int child = Integer.parseInt(tokens[j]);
          parent[child] = i;
          level[child] = level[i]+1;
          j++;
        }
      }
      // show(parent);
      // show(level);

      int q = Integer.parseInt(in.readLine());
      String [] tokens ;
      while(q-->0){
        tokens = in.readLine().split(" ");
        int a = Integer.parseInt(tokens[0]);
        int b = Integer.parseInt(tokens[1]);

        int parent_a = parent[a];
        int parent_b = parent[b];
        int level_a = level[a];
        int level_b = level[b];

        if(level_a > level_b){
          int dif = level_a - level_b;
          while(dif-- > 0){
            parent_a = parent[parent_a];
          }
        }else{
          int dif = level_b-level_a;
          while(dif-- > 0){
            parent_b = parent[parent_b];
          }
        }

        while(parent_a != parent_b){
          parent_a = parent[parent_a];
          parent_b = parent[parent_b];
        }

        // System.out.println(parent_a);
        out.println(parent_a);
      }
    }

    // private static void show(int[] parent) {
    //   System.out.println("---------------------------------------------------------");
    //   for(int val:parent){
    //     System.out.print(val+" ");
    //   }
    //   System.out.println();
    //   System.out.println("---------------------------------------------------------");
    // }

    
}
