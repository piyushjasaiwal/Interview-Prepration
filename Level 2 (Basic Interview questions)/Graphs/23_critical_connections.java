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

    static int [] parent;
    static int [] disc;
    static int [] low;
    static boolean [] visited;
    static int time = 0;
    static List<List<Integer>> ans;

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> Edges) {

        ArrayList<ArrayList<Integer>> graph = make_graph(n, Edges);

        parent = new int[n];
        disc = new int[n];
        low = new int[n];
        visited = new boolean[n];
        time = 0;
        ans = new ArrayList<>();
        parent[0] = -1;

        dfs(0, graph);

        // show(parent);
        // show(disc);
        // show(low);
        // show(visited);

        return ans;
    }

    private static ArrayList<ArrayList<Integer>> make_graph(int n, List<List<Integer>> edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(List<Integer> edge:edges){
            int u = edge.get(0);
            int v = edge.get(1);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }

    private static void dfs(int u, ArrayList<ArrayList<Integer>> graph) {
        visited[u] = true;
        disc[u] = time;
        low[u] = time;
        time+=1;

        List<Integer> nbrs = graph.get(u);

        for(int i = 0;i<nbrs.size();i++){
            int v = nbrs.get(i);

            if(parent[u] == v){
                continue;
            }else if(visited[v]){
                low[u] = Math.min(low[u], disc[v]);
            }else{
                parent[v] = u;
                dfs(v, graph);

                low[u] = Math.min(low[u], low[v]);
                if(low[v] > disc[u]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(u);
                    temp.add(v);
                    ans.add(temp);
                }
            }
        }
    }

    static void show(int [] arr){
        for(int object: arr){
            System.out.print(object+" ");
        }
        System.out.println();
    }

    static void show(boolean [] arr){
        for(boolean object: arr){
            System.out.print(object+" ");
        }
        System.out.println();
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