/*
There are n construction sites in a town. We want to supply water for all the construction sites by building wells and laying pipes.

For each site i, we can either build a well inside it directly with cost wells[i-1], or pipe in water from another well to it. The costs to lay pipes between
sites are given by the 2d array cost, where each row of cost contains 3 numbers ai,bi and wi where wi is the cost to connect ai to bi. connections are bidirectional.

Return the minimum total cost to supply water to all the construction sites.

Constraints
1 <= n <= 10^4
wells.length == n
0 <= wells[i] <= 10^5
1 <= cost.length <= 10^4
cost[i].length == 3

Format
Input
First line contains two integers V and E denoting number of houses and number of pipelines respectively.
Second line contains n integer denoting cost to dig well at ith house.
Each of next E lines contain 3 numbers ui and vi and c denoting a pipeline between u and v with cost c to build.

Output
Return the minimum total cost to supply water to all the construction sites.

Example
Sample Input

3 2
1 2 2
1 2 1
2 3 1


Sample Output
3
*/

import java.io.*;
import java.nio.file.NotLinkException;
import java.util.*;


class optimize_water_distribution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int v = Integer.parseInt(st[0]);
        int e = Integer.parseInt(st[1]);

        int[] wells = new int[v];
        String[] words = br.readLine().split(" ");

        for (int i = 0; i < wells.length; i++) {
            wells[i] = Integer.parseInt(words[i]);
        }

        int[][] pipes = new int[e][3];
        for (int i = 0; i < e; i++) {
            String[] st1 = br.readLine().split(" ");
            pipes[i][0] = Integer.parseInt(st1[0]);
            pipes[i][1] = Integer.parseInt(st1[1]);
            pipes[i][2] = Integer.parseInt(st1[2]);
        }

        System.out.println(minCostToSupplyWater(v, wells, pipes));
  }

    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0;i<wells.length;i++){
            graph.get(0).add(new Pair(i+1, wells[i]));
            graph.get(i+1).add(new Pair(0, wells[i]));
        }

        for(int i = 0;i<pipes.length;i++){
            int u = pipes[i][0];
            int v = pipes[i][1];
            int wt = pipes[i][2];

            graph.get(u).add(new Pair(v, wt));
            graph.get(v).add(new Pair(u, wt));
        }

        // System.out.println(graph);

        boolean [] visited = new boolean[n+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        int cost=0;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(visited[curr.nbr]){
                continue;
            }

            visited[curr.nbr] = true;

            cost+=curr.wt;
            for(Pair nbr:graph.get(curr.nbr)){
                if(!visited[nbr.nbr]){
                    pq.add(nbr);
                }
            }
        }

        return cost;
    }

    static class Pair implements Comparable<Pair>{
        int nbr;
        int wt;
        
        public Pair(int n, int w){
            nbr = n;
            wt = w;
        }
    
        @Override
        public int compareTo(Pair o) {
            // TODO Auto-generated method stub
            return this.wt-o.wt;
        }
    
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return nbr+"";
        }
        
    }
}
