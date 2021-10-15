/*
1. You are given a number n (representing the number of students). Each student will have an id 
     from 0 to n - 1.
2. You are given a number k (representing the number of clubs)
3. In the next k lines, two numbers are given separated by a space. The numbers are ids of 
     students belonging to same club.
4. You have to find in how many ways can we select a pair of students such that both students are 
     from different clubs.
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
0 1
2 3
4 5
5 6
4 6
Sample Output
16
*/

import java.io.*;
import java.util.*;

class Main {
   

   public static void main(String[] args) throws Exception {
      // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   	  Scanner s = new Scanner(System.in);

      int n = s.nextInt();
      int k = s.nextInt();
      
      // write your code here
      ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
      for(int i =0;i<n;i++){
      	graph.add(new ArrayList<>());
      }
      while(k-->0){
      	int a = s.nextInt();
      	int b = s.nextInt();
      	graph.get(a).add(b);
      	graph.get(b).add(a);
      }

      ArrayList<Integer> sizes = new ArrayList<>();
      Set<Integer> visited = new HashSet<>();

      for(int i = 0;i<n;i++){
      	if(!visited.contains(i)){
      		int size = get_component(i, graph, visited);
      		sizes.add(size);
      	}
      }

      int ans = nc2(n);
      for(int size : sizes){
      	ans -= nc2(size);
      }

      System.out.println(ans);
   }

   public static int get_component(int i, ArrayList<ArrayList<Integer>> graph, Set<Integer> visited){
   	if(visited.contains(i)){
   		return 0;
   	}

   	visited.add(i);

   	int cnt = 1;
   	for(int nbr : graph.get(i)){
   		cnt += get_component(nbr, graph, visited);
   	}
   	return cnt;
   }

   public static int nc2(int n){
   		return ((n)*(n-1))/2;
   }

}