/*
1. You are given a graph.
2. You are required to find and print if the graph is bipartite

Note -> A graph is called bipartite if it is possible to split it's vertices in two sets of mutually 
               exclusive and exhaustive vertices such that all edges are across sets.
Input Format
Input has been managed for you
Output Format
true if the graph is bipartite, false otherwise
Question Video

  COMMENTConstraints
None
Sample Input
7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
Sample Output
false
*/

import java.io.*;
import java.util.*;

class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      // write your code here

      HashMap<Integer, Boolean> map = new HashMap<>();
      // boolean [] visited = new 

      boolean ans = true;
      for(int i = 0;i<vtces;i++){
      	if(!map.containsKey(i)){
      		ans = ans&&is_bipertite(i, graph, map, true);
      	}
      }
   		System.out.println(ans);
   }

   public static boolean is_bipertite(int src, ArrayList<Edge>[] graph, HashMap<Integer, Boolean> map, boolean color){
   	if(map.containsKey(src)){
   		if(map.get(src) == color){
   			return true;
   		}else{
   			return false;
   		}
   	}

   	map.put(src, color);

   	boolean ans = true;
   	for(Edge e:graph[src]){
   		ans = ans&&is_bipertite(e.nbr, graph, map, !color);
   	}
   	return ans;
   }

}