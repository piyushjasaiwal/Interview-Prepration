/*
1. You are given a number n, representing the number of elements.
2. You are given n numbers, representing the contents of array of length n.
3. You are required to print the sum of elements of the increasing subsequence with maximum sum for the array.
Input Format
A number n
.. n more elements
Output Format
A number representing the sum of elements of the increasing subsequence with maximum sum for the array.
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
255
*/

import java.io.*;
import java.util.*;

class maximum_sum_non_decreasing_subsequence {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] ar = new int[n];
        for(int i = 0;i<n;i++){
        	ar[i] = s.nextInt();
        }

        System.out.println(max_sum_IS(ar));
    }

    public static int max_sum_IS(int [] ar){
    	int [] dp = new int[ar.length];
    	int ans = 0;

    	for(int i = 0;i<ar.length;i++){
    		int max = 0;
    		for(int j = 0;j<i;j++){
    			if(ar[i] > ar[j]){
    				max = Math.max(max, dp[j]);
    			}
    		}

    		dp[i] = max+ar[i];
    		ans = Math.max(ans, dp[i]);
    	}

    	return ans;
    }
}