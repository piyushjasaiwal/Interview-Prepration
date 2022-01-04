/*abstract
1. You are given an array(arr) of length N which represents N number of balloons.
2. Each balloon is painted with a number on it.
3. You have to collect maximum coins by bursting all the balloons.
4. If you burst a balloon with index i, you will get (arr[i-1] * arr[i] * arr[i+1]) number of coins.
5. If arr[i-1] and arr[i+1] don't exist, then you may assume their value as 1.
Input Format
A number N
a1
a2.. N integers
Output Format
Check the sample output and question video.
Question Video

  COMMENTConstraints
1 <= N <= 1000
1 <= arr[i] <= 100
Sample Input
3
1
2
3
Sample Output
12
*/

import java.util.*;

class burst_balloons {

  public static int solution(int[] arr) {
      //write your code here

      int n = arr.length;
      
      int [][] dp = new int[n][n];
      for(int gap = 0;gap<n;gap++){
        int i = 0, j = gap;
        while(j<n){
            int max = Integer.MIN_VALUE;
            for(int k = i;k<=j;k++){
              int left = k == i ? 0 : dp[i][k-1];
              int right = k == j ? 0 : dp[k+1][j];

              int val = arr[k];

              if(i > 0){
                val = val*arr[i-1];
              }

              if(j != arr.length-1){
                val = val*arr[j+1];
              }

              int ans = left+right+val;
              max = Math.max(max, ans);
            }
          dp[i][j] = max;
          i++;
          j++;
        }
      }

      // show(dp);

      return dp[0][n-1];
  }

    private static void show(int[][] dp) {
      System.out.println("-----------------------------------");
      for(int [] d:dp){
        for(int val:d){
          System.out.print(val+" ");
        }
        System.out.println();
      }
      System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
        scn.close();
    }

}