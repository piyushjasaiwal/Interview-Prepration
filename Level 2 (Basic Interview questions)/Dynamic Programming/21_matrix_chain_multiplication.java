/*
1. You are given an array(arr) of positive integers of length N which represents the dimensions of N-1 matrices such that the ith matrix is of dimension arr[i-1] x arr[i].
2. You have to find the minimum number of multiplications needed to multiply the given chain of matrices.
Input Format
A number N
arr1
arr2.. N integers
Output Format
Check the sample output and question video.
Question Video

  COMMENTConstraints
2 <= N <= 1000
1 <= arr[i] <= 500
Sample Input
3
1
2
3
Sample Output
6
*/

import java.util.*;

class matrix_chain_multiplication {

	public static int mcm(int[] arr){
		//write your code here
        int n = arr.length;
        int [][] dp = new int[n-1][n-1];
        
        for(int gap = 0;gap<n-1;gap++){
            int i = 0;
            int j = gap;
            while(j < n-1){
                if(gap == 0){
                    dp[i][j] = 0;
                }else if(gap == 1){
                    dp[i][j] = (arr[i]*arr[j]*arr[j+1]);
                }else{
                    
                    int min = Integer.MAX_VALUE;

                    for(int k = i;k<j;k++){
                        int lc = dp[i][k];
                        int rc = dp[k+1][j];

                        int mc = arr[i]*arr[k+1]*arr[j+1];
                        int tc = lc+rc+mc;

                        min = Math.min(min, tc);
                    }
                    
                    dp[i][j] = min;
                    
                }

                i++;
                j++;
            }
        }

		return dp[0][n-2];
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(mcm(arr));
	}

	
}