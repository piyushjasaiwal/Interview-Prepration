/*abstractThere are n cities and there are roads in between some of the cities. Somehow all the roads are damaged simultaneously. We have to repair the roads to connect the cities again. There is a fixed cost to repair a particular road. Find out the minimum cost to connect all the cities by repairing roads.
Input Format
First line contains number of cities.
Second line contains number of edges roads.
Each of next E lines contain 3 number u and v and c denoting a road between u and v with cost c to repair.
Output Format
print the minimum cost.
Question Video

  COMMENTConstraints
1<= n <= 1000
1<= e <= n*(n-1)/2
Sample Input
7
8
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8
Sample Output
38
*/

import java.io.*;
import java.util.*;

class minimum_cost_to_connect_all_cities {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        int[][] edges = new int[e][3];
        for (int i = 0; i < e; i++) {
        String[] st = br.readLine().split(" ");
        edges[i][0] = Integer.parseInt(st[0]);
        edges[i][1] = Integer.parseInt(st[1]);
        edges[i][2] = Integer.parseInt(st[2]);
        }

        System.out.println(minCostToConnectAllCities(v, edges));
    }

    static int[] parent;
    static int[] rank;

    public static class Pair implements Comparable<Pair> {
        int u;
        int v;
        int wt;

        Pair(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
        }

        public String toString(){
            return "{ " +u + ", " + v+ " } => "+wt;
        }

        @Override
        public int compareTo(Pair o) {
        return this.wt - o.wt;
        }
    }

    public static int minCostToConnectAllCities(int n, int[][] pipes) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int [] pipe:pipes){
            pq.add(new Pair(pipe[0], pipe[1], pipe[2]));
        }

        int sum = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            // System.out.println(curr);
            int parent_1 = find_parent(curr.u);
            int parent_2 = find_parent(curr.v);

            if(parent_1 != parent_2){
                // System.out.println(curr);
                sum += curr.wt;
                if(rank[parent_1] < rank[parent_2]){
                    rank[parent_1] += rank[parent_2];
                    parent[parent_2] = parent_1;
                }else{
                    rank[parent_2] += rank[parent_1];
                    parent[parent_1] = parent_2;
                }
            }
            // show(parent);
            // System.out.println("------------------");
        }

        return sum;
    }

    private static int find_parent(int u) {
        int par = u;
        while(par != parent[par]){
            par = parent[par];
        }
        return par;
    }
}
