/*abstract
You are given 2 integers N and M , N is the number of vertices, M is the number of edges. You'll also be given ai, bi and wi where ai and bi represents an edge from a vertex ai to a vertex bi and wi respresents the weight of that edge.
Your task is to find the shortest path from source vertex (vertex number 1) to all other vertices.

Note : use bellman ford algo.
Input Format
First line contains two space separated integers,N and M. Then M lines follow, each line has 3 space separated integers ai, bi and wi.
Output Format
Print the shortest distances from the source vertex (vertex number 1) to all other vertices in a line. Print 10^9 in case the vertex can't be reached form the source vertex.
Question Video

  COMMENTConstraints
1<= N <= 10^4
1<= M <= 10^6
1<= ai, bi <= N
-1000 <= wi <= 1000
Sample Input
5 5
1 2 5
1 3 2
3 4 1
1 4 6
3 5 5
Sample Output
5 2 3 7 
*/

import java.io.*;
import java.util.*;

class bellman_ford {
	public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        long [] dist = new long[n+1];
        Arrays.fill(dist, 1000000000);
        Edge [] edges = new Edge[m];
        dist[1] = 0L;

        for(int i = 0;i<m;i++){
            int u = s.nextInt();
            int v = s.nextInt();

            int wt = s.nextInt();

            edges[i] = new Edge(u, v, wt);
        }

        for(int i = 0;i<m-1;i++){
            for(Edge edge:edges){
                if(dist[edge.u] + edge.wt < dist[edge.v]){
                    dist[edge.v] = dist[edge.u]+edge.wt;
                }
            }
        }

        for(int i = 2;i<=n;i++)
        {
            System.out.print(dist[i]+" ");
        }
	}
}

class Edge{
    int u, v, wt;
    public Edge(int u, int v, int wt){
        this.u = u;
        this.v = v;
        this.wt = wt;
    }
}
