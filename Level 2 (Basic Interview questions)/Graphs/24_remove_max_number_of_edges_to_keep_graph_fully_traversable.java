/*
Alice and Bob have an undirected graph of n nodes and 3 types of edges:

Type 1: Can be traversed by Alice only.
Type 2: Can be traversed by Bob only.
Type 3: Can by traversed by both Alice and Bob.

Given an array edges where edges[i] = [typei, ui, vi] represents a bidirectional edge of type typei between nodes ui and vi, find the maximum number of edges you can remove so that after removing the edges, the graph can still be fully traversed by both Alice and Bob. The graph is fully traversed by Alice and Bob if starting from any node, they can reach all other nodes.
Return the maximum number of edges you can remove, or return -1 if it's impossible for the graph to be fully traversed by Alice and Bob.
Input Format
First line contains two integers n and m.
Each of next n lines contain 3 numbers denoting type of edges and the node between which node is placed.
Output Format
Print the maximum number of edges you can remove.
Question Video

  COMMENTConstraints
1<= n <= 1000
1 <= edges.length <=  n * (n-1) / 2
1 <= edges[i][0] <= 3
1 <= edges[i][1] < edges[i][2] <= n
All tuples (typei, ui, vi) are distinct.
Sample Input
4 6
3 1 2
3 2 3
1 1 3
1 2 4
1 1 2
2 3 4
Sample Output
2
*/

import java.io.*;
import java.util.*;

class remove_max_number_of_edges_to_keep_graph_fully_traversable {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            edges[i][0] = Integer.parseInt(st[0]);
            edges[i][1] = Integer.parseInt(st[1]);
            edges[i][2] = Integer.parseInt(st[2]);
        }
        System.out.println(maxNumEdgesToRemove(n, edges));
    }

    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, new comp());

        int [] parenta = new int[n+1];
        int [] parentb = new int[n+1];
        int [] ranka = new int[n+1];
        int [] rankb = new int[n+1];

        for(int i = 0;i<parenta.length;i++){
            parenta[i] = i;
            parentb[i] = i;
            ranka[i] = 1;
            rankb[i] = 1;
        }

        int mergeda = 1;
        int mergedb = 1;
        int removedEdge = 0;

        for(int [] e:edges){
            if(e[0] == 3){
                boolean tempa = union(e[1], e[2], parenta, ranka);
                boolean tempb = union(e[1], e[2], parentb, rankb);

                if(tempa == true){
                    mergeda++;
                }

                if(tempb == true){
                    mergedb++;
                }

                if(tempa == false && tempb == false){
                    removedEdge++;
                }
            }else if(e[0] == 1){
                boolean tempa = union(e[1], e[2], parenta, ranka);

                if(tempa == true){
                    mergeda++;
                }else{
                    removedEdge++;
                }
            }else{
                boolean tempb = union(e[1], e[2], parentb, rankb);

                if(tempb == true){
                    mergedb++;
                }else{
                    removedEdge++;
                }
            }
        }

        if(mergeda == n && mergedb == n){
            return removedEdge;
        }
        return -1;
    }

    public static boolean union(int x, int y, int [] parent, int [] rank){
        int lx = find(x, parent);
        int ly = find(y, parent);

        if(lx != ly){
            if(rank[lx] > rank[ly]){
                parent[ly] = lx;
            }else if(rank[lx] < rank[ly]){
                parent[lx] = ly;
            }else{
                parent[lx] = ly;
                rank[y]++;
            }
            return true;
        }

        return false;
    }

    public static int find(int x, int [] parent){
        if(parent[x] == x){
            return x;
        }

        int temp = find(parent[x], parent);
        parent[x] = temp;
        return temp;
    }

    static class comp implements Comparator<int[]>{

        @Override
        public int compare(int[] o1, int[] o2) {
            // TODO Auto-generated method stub
            return o2[0]-o1[0];
        }

    }
}