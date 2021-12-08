/*abstract
You are given 2 integers N and M , N is the number of vertices, M is the number of edges. You'll also be given ai and bi where ai and bi represents an edge from a vertex ai to a vertex bi.

You have to find the minimum number of edges you have to reverse in order to have atleast one path from vertex 1 to N, where the vertices are numbered from 1 to N.
Input Format
First line contains two space separated integers,N and M. Then M lines follow, each line has 2 space separated integers ai and bi.
Output Format
Print the minimum number of edges we need to revert. If there is no way of having at least one path from 1 to N, print -1.
Question Video

  COMMENTConstraints
1<= N <= 10^4
1<= M <= 10^6
1<= ai, bi <= N
Sample Input
7 7
1 2 
3 2
3 4
7 4
6 2
5 6
7 5
Sample Output
2
*/

import java.io.*;
import java.util.*;

class pepcoder_and_reversing {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        HashMap<Integer, Set<Integer>> directed = new HashMap<>(); 
        ArrayList<ArrayList<Integer>> unDirected = new ArrayList<>();
        
        unDirected.add(new ArrayList<>());
        for(int i = 1;i<=n;i++){
          directed.put(i, new HashSet<>());
          unDirected.add(new ArrayList<>());
        }

        for(int i = 0;i<m;i++){
          tokens = br.readLine().split(" ");
          int u = Integer.parseInt(tokens[0]);
          int v = Integer.parseInt(tokens[1]);

          directed.get(u).add(v);
          unDirected.get(u).add(v);
          unDirected.get(v).add(u);
        }

        LinkedList<Pair> ll = new LinkedList<>();
        ll.add(new Pair(1, 0));
        int min = Integer.MAX_VALUE;

        Set<Integer> set = new HashSet<>();
        while(!ll.isEmpty()){
          Pair curr = ll.removeFirst();
          if(curr.src == n){
            min = Math.min(min, curr.dis);
            continue;
          }

          set.add(curr.src);

          for(int val:unDirected.get(curr.src)){
            if(!set.contains(val)){
              if(directed.get(curr.src).contains(val)){
                ll.add(new Pair(val, curr.dis));
              }else{
                ll.add(new Pair(val, curr.dis+1));
              }
            }
          }
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
}

class Pair{
    int src, dis;
    public Pair(int src, int dis){
        this.src = src;
        this.dis = dis;
    }
}
