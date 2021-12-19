/*abstract
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from any row in the left wall.
5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).
6. Each cell has a value that is the amount of gold available in the cell.
7. You are required to identify the maximum amount of gold that can be dug out from the mine.
8. Also, you have to print all paths with maximum gold.
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
33
4 d3 d1 d2 d3 d1 
*/

import java.io.*;
import java.util.*;

class print_all_paths_with_maximum_gold {

   public static class Pair {
      String psf;
      int i;
      int j;

      public Pair(String psf, int i, int j) {
         this.psf = psf;
         this.i = i;
         this.j = j;
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
      for(int j = m-1;j>=0;j--){
          for(int i = 0;i<n;i++){
            if(j == m-1){
                dp[i][j] = arr[i][j];
            }else if(i == n-1){
                dp[i][j] = Math.max(dp[i-1][j+1], dp[i][j+1])+arr[i][j];
            }else if(i == 0){
                dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j+1])+arr[i][j];
            }else{
                dp[i][j] = Math.max(dp[i][j+1], Math.max(dp[i-1][j+1], dp[i+1][j+1]))+arr[i][j];
            }
          }
      }

      int max = Integer.MIN_VALUE;
      for(int i = 0;i<n;i++){
          max = Math.max(dp[i][0], max);
      }

      System.out.println(max);
    //   show(dp, n, m);
      show_path(dp, max);
   }
    private static void show_path(int[][] dp, int max) {
        LinkedList<Pair> ll = new LinkedList<>();
        for(int i = 0;i<dp.length;i++){
            if(dp[i][0] == max){
                ll.add(new Pair(i+" ", i, 0));
            }
        }

        while(!ll.isEmpty()){
            Pair curr = ll.removeFirst();
            if(curr.j == dp[0].length-1){
                System.out.println(curr.psf);
            }else if(curr.i == dp.length-1){
                int d1 = dp[curr.i-1][curr.j+1];
                int d2 = dp[curr.i][curr.j+1];

                if(d1>d2){
                    ll.add(new Pair(curr.psf+"d1 ", curr.i-1, curr.j+1));
                }else if(d1 < d2){
                    ll.add(new Pair(curr.psf+"d2 ", curr.i, curr.j+1));
                }else{
                    ll.add(new Pair(curr.psf+"d1 ", curr.i-1, curr.j+1));
                    ll.add(new Pair(curr.psf+"d2 ", curr.i, curr.j+1));
                }
            }else if(curr.i == 0){
                int d2 = dp[curr.i][curr.j+1];
                int d3 = dp[curr.i+1][curr.j+1];

                if(d2>d3){
                    ll.add(new Pair(curr.psf+"d2 ", curr.i, curr.j+1));
                }else if(d2 < d3){
                    ll.add(new Pair(curr.psf+"d3 ", curr.i+1, curr.j+1));
                }else{
                    ll.add(new Pair(curr.psf+"d2 ", curr.i, curr.j+1));
                    ll.add(new Pair(curr.psf+"d3 ", curr.i+1, curr.j+1));
                }
            }else{
                int d1 = dp[curr.i-1][curr.j+1];
                int d2 = dp[curr.i][curr.j+1];
                int d3 = dp[curr.i+1][curr.j+1];

                if(d1 > d2 && d2 > d3){
                    ll.add(new Pair(curr.psf+"d1 ", curr.i-1, curr.j+1));
                }else if(d2 > d1 && d2 > d3){
                    ll.add(new Pair(curr.psf+"d2 ", curr.i, curr.j+1));
                }else if(d3 > d1 && d3 > d2){
                    ll.add(new Pair(curr.psf+"d3 ", curr.i+1, curr.j+1));
                }else if(d1 == d2){
                    ll.add(new Pair(curr.psf+"d1 ", curr.i-1, curr.j+1));
                    ll.add(new Pair(curr.psf+"d2 ", curr.i, curr.j+1));
                }else if(d2 == d3){
                    ll.add(new Pair(curr.psf+"d2 ", curr.i, curr.j+1));
                    ll.add(new Pair(curr.psf+"d3 ", curr.i+1, curr.j+1));
                }else if(d1 == d3){
                    ll.add(new Pair(curr.psf+"d1 ", curr.i-1, curr.j+1));
                    ll.add(new Pair(curr.psf+"d3 ", curr.i+1, curr.j+1));
                }else{
                    ll.add(new Pair(curr.psf+"d1 ", curr.i-1, curr.j+1));
                    ll.add(new Pair(curr.psf+"d2 ", curr.i, curr.j+1));
                    ll.add(new Pair(curr.psf+"d3 ", curr.i+1, curr.j+1));
                }
            }
        }
    }

    public static void show(int[][] arr, int n, int m) {
        System.out.println(n == arr.length);
        System.out.println(m == arr[0].length);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               System.out.print(arr[i][j]+" ");
            }
            System.out.println();
         }
    }
}