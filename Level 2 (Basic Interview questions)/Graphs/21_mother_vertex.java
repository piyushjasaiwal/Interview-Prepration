/*abstract
Given a Directed Graph, find a Mother Vertex in the Graph (if present). 
A Mother Vertex is a vertex through which we can reach all the other vertices of the Graph.
Input Format
First line contains two space separated integers,N and M. Then M lines follow, each line has 2 space separated integers ai and bi.
Output Format
Print the mother vertex if present else print -1.
Question Video

  COMMENTConstraints
1<= N <= 10000
1<= M <= (N*(N-1))/2
1<= ai, bi <= N
Sample Input
4 3
1 2
2 3
3 4
Sample Output
1
*/

import java.io.*;
import java.util.*;


class mother_vertex{
    	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = br.readLine().split(" ");
			int u = Integer.parseInt(st[0]) - 1;
			int v = Integer.parseInt(st[1]) - 1;
			graph.get(u).add(v);
		}

		System.out.println(findMotherVertex(n, graph));
	}
    
    public static int findMotherVertex(int N, ArrayList<ArrayList<Integer>>adj){
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
		for(int i = 0;i<N;i++){
            if(!set.contains(i)){
                DFS(i, adj, set, stack);
            }
        }

        int candidate = stack.pop();

        set = new HashSet<>();
        stack = new Stack<>();
        DFS(candidate, adj, set, stack);

        return stack.size() == N ? candidate+1 : -1;
    }

    private static void DFS(int src, ArrayList<ArrayList<Integer>> adj, Set<Integer> set, Stack<Integer> stack) {
        if(set.contains(src)){
            return ;
        }

        set.add(src);

        int cnt = 1;
        for(int nbr : adj.get(src)){
            DFS(nbr, adj, set, stack);
        }
        stack.push(src);
    }
}