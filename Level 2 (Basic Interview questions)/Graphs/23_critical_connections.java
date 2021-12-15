/*abstract
An edge in an undirected graph is a Bridge iff removing it disconnects the graph. You have to print all the Bridges of the given graph.
Input Format
First line contains two integers V and E.
Each of next E line contains two integer u and v denoting an edge between vertex u and v.
Output Format
Print all the bridges.
Question Video

  COMMENTConstraints
1 <= number of vertices(V) <= 1000
1 <= number of Edges(E) <= V*(V-1)/2;
Sample Input
5 5
0 1
0 2
2 1
2 3
4 3
Sample Output
[[3, 4], [2, 3]]
*/

import java.util.*;
import java.io.*;

class critical_connections {

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> Edges) {
        return null;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int e = Integer.parseInt(st[1]);
        List<List<Integer>> edges = new ArrayList<>();


        for (int i = 0; i < e; i++) {
            edges.add(new ArrayList<>());
            st = br.readLine().split(" ");
            edges.get(i).add(Integer.parseInt(st[0]));
            edges.get(i).add(Integer.parseInt(st[1]));
        }

        System.out.println(criticalConnections(n, edges));

    }

}