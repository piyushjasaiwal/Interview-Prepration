/*
1. You are given an integer N, which represents the length of a rod, and an array of integers, which represents the prices of rod pieces of length varying from 1 to 
     N.
2. You have to find the maximum value that can be obtained by selling the rod.
3. You can sell it in pieces or as a whole.
Input Format
A number N
arr1
arr2.. N integers
Output Format
Check the sample output and question video.
Question Video

  COMMENTConstraints
1 <= N <= 100000
1 <= arr[i] <= 10^8
Sample Input
8
1   
5   
8   
9  
10 
17  
17  
20
Sample Output
22
*/

import java.io.*;
import java.util.*;

class rod_cutting {

    public static int solution(int[] prices) {
        // write your code here
        int [] dp = new int[prices.length+1];
        dp[0] = 0;
        for(int i = 1;i<=prices.length;i++){
            int max = prices[i-1];
            // System.out.println("----------------------------------");
            for(int j = 1;j<i;j++){
                int first = j;
                int second = i-j;
                // System.out.println(first+" "+second+" "+(dp[first]+dp[second]));
                max = Math.max(max, dp[first]+dp[second]);
            }
            // System.out.println("----------------------------------");
            dp[i] = max;
        }
        return dp[prices.length];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        System.out.println(solution(prices));
    }

}
