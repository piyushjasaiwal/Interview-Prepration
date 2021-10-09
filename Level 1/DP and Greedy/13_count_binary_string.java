/*
1. You are given a number n.
2. You are required to print the number of binary strings of length n with no consecutive 0's.
Input Format
A number n
Output Format
A number representing the number of binary strings of length n with no consecutive 0's.
Question Video

  COMMENTConstraints
0 < n <= 45
Sample Input
6
Sample Output
21
 */

import java.io.*;
import java.util.*;

class count_binary_string{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int [][] dp = new int[n+1][2];
    if(n>=1){
        dp[1][0] = 1;
        dp[1][1] = 1;
    }

    for(int i = 2;i<=n;i++){
        dp[i][0] = dp[i-1][0]+dp[i-1][1];
        dp[i][1] = dp[i-1][0];
    }
    System.out.println(dp[n][0]+dp[n][1]);
 }

}