/*abstract
1. You are given an array(arr) of length N, where N is an even number.
2. The elements of the array represent N coins of values arr1,arr1...arrN.
3. You are playing a game against an opponent in an alternative way, where the opponent is equally smart.
4. In this game, a player selects either the first or the last coin from the row in every turn, removes it from the row permanently, and receives the value of the coin.
5. You have to find the maximum possible amount of money you can win if you make the first move.
Input Format
A number N
arr1
arr2...N numbers
Output Format
Check the sample output and question video.
Question Video

  COMMENTConstraints
2 <= N <= 1000
1 <= arr[i] <= 10^6
Sample Input
4
5
3
7
10
Sample Output
15
*/

import java.io.*;
import java.util.*;

class optimal_strategy_for_a_game {

	public static void optimalStrategy(int[] arr) {
		//write your code here

        int [][] dp = new int[arr.length][arr.length];

        for(int k = 0;k<arr.length;k++){
            int i = 0;
            int j = k;

            while(j < arr.length){
                if(i == j){
                    dp[i][j] = arr[i];
                }else if(Math.abs(i-j) == 1){
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }else{
                    int min1 = arr[i] + Math.min(dp[i+2][j], dp[i+1][j-1]);
                    int min2 = arr[j] + Math.min(dp[i][j-2], dp[i+1][j-1]);

                    dp[i][j] = Math.max(min1, min2);
                }
                i++;
                j++;
            }
        }
        
        // for(int []d:dp){
        //     for(int val:d){
        //         System.out.print(val+" ");
        //     }
        //     System.out.println();
        // }

        System.out.println(dp[0][arr.length-1]);		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = scn.nextInt();
		}
		optimalStrategy(a);
	}

}