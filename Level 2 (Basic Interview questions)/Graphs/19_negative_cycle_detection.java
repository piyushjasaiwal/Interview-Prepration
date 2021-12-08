// /*abstract
// You are given 2 integers N and M , N is the number of vertices, M is the number of edges. You'll also be given ai, bi and wi where ai and bi represents an edge from a vertex ai to a vertex bi and wi respresents the weight of that edge.

// Task is to find if it contains a negative weight cycle or not.
// Input Format
// First line contains two space separated integers,N and M. Then M lines follow, each line has 3 space separated integers ai, bi and wi.
// Output Format
// Print 1 if it contains a negative weight cycle else print 0.
// Question Video

//   COMMENTConstraints
// 1<= N <= 10^4
// 1<= M <= 10^6
// 0<= ai, bi <= N-1
// 1<= wi <= 1000
// Sample Input
// 3 3
// 0 1 -1
// 1 2 -4
// 2 0 3
// Sample Output
// 1
// */

// import java.io.*;
// import java.util.*;

// class negative_cycle_detection {

// 	public static void main(String[] args) throws NumberFormatException, IOException {
// 		Scanner s = new Scanner(System.in);
//         int n = s.nextInt();
//         int m = s.nextInt();
//         long [] dist = new long[n+1];
//         Arrays.fill(dist, 1000000000);
//         Edge [] edges = new Edge[m];
//         dist[1] = 0L;

//         for(int i = 0;i<m;i++){
//             int u = s.nextInt();
//             int v = s.nextInt();

//             int wt = s.nextInt();

//             edges[i] = new Edge(u, v, wt);
//         }

//         for(int i = 0;i<m-1;i++){
//             for(Edge edge:edges){
//                 if(dist[edge.u] + edge.wt < dist[edge.v]){
//                     dist[edge.v] = dist[edge.u]+edge.wt;
//                 }
//             }
//         }

//         boolean flag = false;
//         for(Edge edge:edges){
//             if(dist[edge.u]+edge.wt < dist[edge.v]){
//                 flag=true;
//                 break;
//             }
//         }

//         System.out.println(flag ? 1 : 0);
// 	}
// }

// class Edge{
//     int u, v, wt;
//     public Edge(int u, int v, int wt){
//         this.u = u;
//         this.v = v;
//         this.wt = wt;
//     }
// }