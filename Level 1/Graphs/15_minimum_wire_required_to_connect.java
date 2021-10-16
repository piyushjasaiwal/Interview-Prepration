/*
1. You are given a graph and a source vertex. The vertices represent computers and the edges 
     represent length of LAN wire required to connect them.
2. You are required to find the minimum length of wire required to connect all PCs over a network. 
     Print the output in terms of which all PCs need to be connected, and the length of wire between 
     them.

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
[1-0@10]
[2-1@10]
[3-2@10]
[4-3@2]
[5-4@3]
[6-5@3]
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
      prims(graph);
   }

   public static void prims(ArrayList<Edge>[]graph){
      PriorityQueue<pair> pq= new PriorityQueue<>();
      pq.add(new pair(0, -1, 0));
      Set<Integer> set = new HashSet<>();
      while(!pq.isEmpty()){
         pair curr = pq.poll();
         if(!set.contains(curr.v)){
            if(curr.acq != -1){
               System.out.println("["+curr.v+"-"+curr.acq+"@"+curr.weight+"]");
            }            
            set.add(curr.v);
         }else{
            continue;
         }

         for(Edge e:graph[curr.v]){
            pq.add(new pair(e.nbr, curr.v, e.wt));
         }
      } 
   }

   static class pair implements Comparable<pair>{
      int v;
      int acq;
      int weight;
      pair(int v, int acq, int weight){
         this.v = v;
         this.acq = acq;
         this.weight = weight;
      }

      public int compareTo(pair o){
         return this.weight - o.weight;
      }
   }

}