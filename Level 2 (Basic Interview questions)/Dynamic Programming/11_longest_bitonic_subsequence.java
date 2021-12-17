/*
1. You are given a number n, representing the number of elements.
2. You are given n numbers, representing the contents of array of length n.
3. You are required to print the length of longest bitonic subsequence of array.
Note -> bitonic subsequence begins with elements in increasing order, followed by elements in decreasing order.
Input Format
A number n
.. n more elements
Output Format
A number representing the length of longest increasing subsequence of array.
Question Video

  COMMENTConstraints
0 <= n <= 20
0 <= n1, n2, .. <= 100
Sample Input
10
10
22
9
33
21
50
41
60
80
1
Sample Output
7
*/

import java.io.*;
import java.util.*;

class longest_bitonic_subsequence {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] ar = new int[n];
        for(int i = 0;i<n;i++){
        	ar[i] = s.nextInt();
        }

        // System.out.println(max_sum_IS(ar));

        int [] lis = LIS(ar);
        int [] lds = LDS(ar);

        int max = 0;
        for(int i = 0;i<ar.length;i++){
        	max = Math.max(max, lis[i]+lds[i]-1);
        }

        System.out.println(max);
    }

    public static int [] LIS(int [] ar){
    	int [] dp = new int[ar.length];

    	for(int i = 0;i<ar.length;i++){
    		int max = 0;
    		for(int j = 0;j<i;j++){
    			if(ar[i] >= ar[j]){
    				max = Math.max(max, dp[j]);
    			}
    		}

    		dp[i] = max+1;
    	}

    	return dp;
    }

    public static int [] LDS(int [] ar){
    	int [] dp = new int[ar.length];

    	for(int i = ar.length-1;i>=0;i--){
    		int max = 0;
    		for(int j = ar.length-1;j>i;j--){
    			if(ar[i] >= ar[j]){
    				max = Math.max(max, dp[j]);
    			}
    		}

    		dp[i] = max+1;
    	}

    	return dp;
    }
}