/*abstract
You are given a directed graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [xi, yi] indicates that there is a directed edge between nodes xi and yi in the graph.
Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

Note : The difference between redundant connection and redundant connection 2 is that in later the graph is directed and in the former graph is undirected.
Input Format
First line contains an integer n.
Each of next n lines contain 2 numbers denoting a bidirectional edge between them.
Output Format
Print the edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.
Question Video

  COMMENTConstraints
1<= n <= 10000
number of edge = number of vertices
Sample Input
3
1 2
1 3
2 3
Sample Output
2 3
*/

// here the graph is directed so dsu won't work over here

import java.util.*;
import java.io.*;

class redundant_connection_2 {
  public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);

        int[][] pos = new int[n][2];
        for (int i = 0; i < n; i++) {
        st = br.readLine().split(" ");
            pos[i][0] = Integer.parseInt(st[0]);
            pos[i][1] = Integer.parseInt(st[1]);
        }

        int[] ans = findRedundantDirectedConnection(pos);
        System.out.println(ans[0] + " " + ans[1]);
    }



    public static int[] findRedundantDirectedConnection(int[][] edges) {
        return null;
    }
}