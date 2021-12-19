/*abstract
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
4. You are standing in top-left cell and are required to move to bottom-right cell.
5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom-right cell).
7. You are required to traverse through the matrix and print the cost of the path which is least costly.
8. Also, you have to print all the paths with minimum cost.
Input Format
A number n
A number m
e11
e12..
e21
e22..
.. n * m number of elements
Output Format
Check the sample output and question video.
Question Video

  COMMENTConstraints
1 <= n <= 10^2
1 <= m <= 10^2
0 <= e1, e2, .. n * m elements <= 1000
Sample Input
6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1
Sample Output
23
HVVHHVHVHV
HVVHHVHHVV
*/

import java.io.*;
import java.util.*;

class print_all_paths_with_minimum_cost {

   public static class Pair {
      String psf;
      int row;
      int col;

      public Pair(int row, int col, String psf) {
         this.psf = psf;
         this.row = row;
         this.col = col;
      }

      @Override
      public String toString() {
          // TODO Auto-generated method stub
          return "{psf=>"+psf+",row=>"+row+",col=>"+col+".}";
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         String str = br.readLine();
         for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(str.split(" ")[j]);
         }
      }

      //write your code here
      
      int [][] dp = new int[n][m];
      for(int i = n-1;i>=0;i--){
          for(int j = m-1;j>=0;j--){
              if(i == n-1 && j == m-1){
                dp[i][j] = arr[i][j];
              }else if(i == n-1){
                dp[i][j] = dp[i][j+1] + arr[i][j];
              }else if(j == m-1){
                dp[i][j] = dp[i+1][j] + arr[i][j];
              }else{
                  dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1])+arr[i][j];
              }
          }
      }

      System.out.println(dp[0][0]);
    //   show(dp, n, m);
      show_path(arr, dp);
   }

    private static void show_path(int[][] arr, int[][] dp) {
        LinkedList<Pair> ll = new LinkedList<>();
        ll.add(new Pair(0, 0, ""));
        while(!ll.isEmpty()){
            // System.out.println(ll);
            Pair curr = ll.removeFirst();
            if(curr.row == arr.length-1 && curr.col == arr[0].length-1){
                System.out.println(curr.psf);
            }else if(curr.row == arr.length-1){
                ll.add(new Pair(curr.row, curr.col+1, curr.psf+"H"));
            }else if(curr.col == arr[0].length-1){
                ll.add(new Pair(curr.row+1, curr.col, curr.psf+"V"));
            }else{
                int v = dp[curr.row+1][curr.col];
                int h = dp[curr.row][curr.col+1];

                if(v < h){
                    ll.add(new Pair(curr.row+1, curr.col, curr.psf+"V"));
                }else if(v > h){
                    ll.add(new Pair(curr.row, curr.col+1, curr.psf+"H"));
                }else{
                    ll.add(new Pair(curr.row+1, curr.col, curr.psf+"V"));
                    ll.add(new Pair(curr.row, curr.col+1, curr.psf+"H"));
                }
            }
        } 
    }

}