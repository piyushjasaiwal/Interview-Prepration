/*
1. You are given a 2d array where 0's represent land and 1's represent water. 
     Assume every cell is linked to it's north, east, west and south cell.
2. You are required to find and count the number of islands.
Input Format
Input has been managed for you
Output Format
Number of islands
Question Video

  COMMENTConstraints
None
Sample Input
8
8
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
1 1 1 1 1 1 1 0
1 1 0 0 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 1 1 1 0
1 1 1 1 1 1 1 0
Sample Output
3
*/

import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      // write your code here
      boolean [][] visited = new boolean[m][n];
      int cnt = 0;

      for(int i = 0;i<m;i++){
      	for(int j = 0;j<n;j++){
      		if(!visited[i][j] && arr[i][j] == 0){
      			cnt+=1;
      			islands(i, j, arr, visited);
      		}
      	}
      }

      System.out.print(cnt);
   }

   public static void islands(int i, int j, int [][] ar, boolean [][] visited){
   	if(i < 0 || j < 0 || i >= ar.length || j >= ar[0].length || ar[i][j] == 1 || visited[i][j] == true){
   		return ;
   	}
   	visited[i][j] = true;

   	islands(i+1, j, ar, visited);
   	islands(i-1, j, ar, visited);
   	islands(i, j+1, ar, visited);
   	islands(i, j-1, ar, visited);
   }

}