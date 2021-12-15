/*
A vertex in an undirected graph is an articluation point iff removing it disconnects the graph. You have to find the number of articulation point in the given graph.
Input Format
First line contains two integers V and E.
Each of next E line contains two integer u and v denoting an edge betwwen vertex u and v.
Output Format
Print the number of articulation point
Question Video

COMMENTConstraints
1 <= number of vertices(V) <= 1000
1 <= number of Edges(E) <= V*(V-1)/2;
Sample Input
5 5
1 2
1 3
3 2
3 4
5 4
Sample Output
2
*/

/*
Notes:

to calculate the number of articulation points we will build three arrays
1. par = parent array
2. disc = discovery array
3. low = low array
*/

import java.util.*;

class articulation_points {

    static int [] par;
    static int [] disc;
    static int [] low;
    static boolean [] ap;
    static boolean [] vis;

    static int time;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int v = s.nextInt();
        int e = s.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0;i<v;i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0;i<e;i++){
            int u = s.nextInt()-1;
            int v1 = s.nextInt()-1;

            graph.get(u).add(v1);
            graph.get(v1).add(u);
        }
        par = new int[v];
        disc = new int[v];
        low = new int[v];
        ap = new boolean[v];
        vis = new boolean[v];

        time = 0;

        par[0] = -1;

        dfs(0, graph);

        int cnt = 0;
        for(boolean a : ap){
            if(a){
                cnt+=1;
            }
        }
        // show(par);
        // show(low);
        // show(disc);
        // show(vis);
        // show(ap);

        // System.out.println(graph);
        System.out.println(cnt);

        s.close();
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

    private static void dfs(int u, ArrayList<ArrayList<Integer>> graph) {
        vis[u] = true;
        int count = 0;
        disc[u] = time;
        low[u] = time;
        time+=1;

        ArrayList<Integer> nbrs = graph.get(u);

        for(int i = 0;i<nbrs.size();i++){
            int v = nbrs.get(i);

            if(par[u] == v){
                continue;
            }else if(vis[v] == true){
                low[u] = Math.min(low[u], disc[v]);
            }else{
                count++;
                par[v] = u;
                dfs(v, graph);

                low[u] = Math.min(low[u], low[v]);

                if(par[u] == -1){
                    if(count >= 2){
                        ap[u] = true;
                    }
                }else{
                    if(low[v] >= disc[u]){
                        ap[u] = true;
                    }
                }
            }
        }
    }
}
