/*
1. You are given a graph.
2. You are required to find and print all connected components of the graph.
Input Format
Input has been managed for you
Output Format
Check the sample output
Question Video

  COMMENTConstraints
None
Sample Input
7
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10
Sample Output
[[0, 1], [2, 3], [4, 5, 6]]
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

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      
      // write your code here
      Set<Integer> visited = new HashSet<>();
      for(int i = 0;i<vtces;i++){
      	if(!visited.contains(i)){
      		ArrayList<Integer> list = new ArrayList<>();
	      	get_connected(i, visited, list, graph);
	      	comps.add(list);
      	}
      }
      System.out.println(comps);
   }

   public static void get_connected(int src, Set<Integer> visited, ArrayList<Integer> list, ArrayList<Edge>[] graph){
	   	if(visited.contains(src)){
	   		return;
	   	}

	   	list.add(src);
	   	visited.add(src);

	   	for(Edge e : graph[src]){
	   		get_connected(e.nbr, visited, list, graph);
	   	}
   }
}