/*
1. You are given a matrix of 0's and 1's.
2. You have to find the maximum size square sub-matrix with all 1's.
Input Format
A number N, which represents number of rows in matrix
A number M, which represents number of columns in matrix
arr1
arr2...N*M numbers
Output Format
Check the sample output and question video.
Question Video

  COMMENTConstraints
1 <= N,M <= 100
0<= arr[i][j] <= 1
Sample Input
5 6
0 1 0 1 0 1 
1 0 1 0 1 0 
0 1 1 1 1 0 
0 0 1 1 1 0 
1 1 1 1 1 1
Sample Output
3
*/

import java.io.*;
import java.util.*;

class largest_square_submatrix_with_all_1s {

	public static int solution(int[][] arr) {
		//write your code here
        int ans = 0;
        int [][] dp = new int[arr.length][arr[0].length];
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = arr[i][j];
                }else{
                    if(arr[i][j] == 1){
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m =scn.nextInt();
		int[][] arr = new int[n][m];
		for(int i = 0 ; i < n; i++){
			for(int j = 0 ; j < m; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		System.out.println(solution(arr));
	}

}