/*
1. You are given a graph and a source vertex. The vertices represent cities and the edges represent 
    distance in kms.
2. You are required to find the shortest path to each city (in terms of kms) from the source city along 
    with the total distance on path from source to destinations.

Note -> For output, check the sample output and question video.
Input Format
Input has been managed for you
Output Format
Check the sample output
Question Video

  COMMENTConstraints
None
Sample Input
7
9
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8
2 5 5
0
Sample Output
0 via 0 @ 0
1 via 01 @ 10
2 via 012 @ 20
5 via 0125 @ 25
4 via 01254 @ 28
6 via 01256 @ 28
3 via 012543 @ 30
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

      int src = Integer.parseInt(br.readLine());
      // write your code here

      PriorityQueue<pair> pq = new PriorityQueue<>();
      pq.add(new pair(src, "", 0));
      Set<Integer> s = new HashSet<>();

      while(pq.size() > 0){
      	pair curr = pq.poll();
      	if(!s.contains(curr.val)){
      		System.out.println(curr.val + " via " + curr.psf+curr.val+" @ " + curr.weight);
      	}      	
      	s.add(curr.val);
      	for(Edge e : graph[curr.val]){
      		if(!s.contains(e.nbr)){
      			pq.add(new pair(e.nbr, curr.psf+curr.val, curr.weight+e.wt));
      		}
      	}
      }

   }

   static class pair implements Comparable<pair>{
   	int val;
   	String psf;
   	int weight;
   	pair(int v, String p, int w){
   		val = v;
   		psf = p;
   		weight = w;
   	}

   	public int compareTo(pair o){
   		return this.weight - o.weight;
   	}
   }
}