/*abstract
You are given a graph with N nodes and M directed edges. Find the number of Strongly connected components in the graph.
Input Format
First line contains two space separated integers,N and M. Then M lines follow, each line has 2 space separated integers ai and bi.
Output Format
Print in one line the number of strongly connected components in the graph.
Question Video

  COMMENTConstraints
1<= N <= 10000
1<= M <= (N*(N-1))/2
1<= ai, bi <= N
Sample Input
5 6
1 4
1 3
2 4
3 4
4 5
5 1
Sample Output
2
*/

import java.io.*;
import java.util.*;

class kosoraju_algorithm {
	public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i = 0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0;i<m;i++){
            graph.get(s.nextInt()).add(s.nextInt());
        }

        LinkedList<Integer> stack = new LinkedList<>();
        boolean []visited = new boolean[n+1];

        for(int i = 1;i<=n;i++){
            if(visited[i] == false){
                dfs1(i, stack, graph, visited);
            }
        }

        ArrayList<ArrayList<Integer>> graph_reverse = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            graph_reverse.add(new ArrayList<>());
        }

        for(int i = 0;i<=n;i++){
            ArrayList<Integer> nbrs = graph.get(i);
            for(int nbr:nbrs){
                graph_reverse.get(nbr).add(i);
            }
        }

        int cnt = 0;
        Arrays.fill(visited, false);

        while(!stack.isEmpty()){
            int curr = stack.removeFirst();
            if(visited[curr] == false){
                cnt += 1;
                DFS(curr, graph_reverse, visited);
            }
        }
        System.out.println(cnt);
	}

    private static void DFS(int curr, ArrayList<ArrayList<Integer>> graph_reverse, boolean[] visited) {
        if(visited[curr] == true){
            return ;
        }

        visited[curr] = true;
        for(int nbr:graph_reverse.get(curr)){
            DFS(nbr, graph_reverse, visited);
        }
    }

    private static void dfs1(int src, LinkedList<Integer> stack, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        if(visited[src]){
            return ;
        }

        visited[src] = true;
        for(int nbrs:graph.get(src)){
            dfs1(nbrs, stack, graph, visited);
        }

        stack.addFirst(src);
    }

}
