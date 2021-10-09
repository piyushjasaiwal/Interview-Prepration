/*
1. You are given a number n.
2. You are required to print the nth element of fibonnaci sequence.

Note -> Notice precisely how we have defined the fibonnaci sequence
0th element -> 0
1st element -> 1
2nd element -> 1
3rd element -> 2
4th element -> 3
5th element -> 5
6th element -> 8
Input Format
A number n
Output Format
A number representing the nth element of fibonnaci sequence
Question Video

  COMMENTConstraints
0 <= n <= 45
Sample Input
10
Sample Output
55
*/
import java.io.*;
import java.util.*;

class fibonaci{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int[] dp = new int[n+1];
    if(n>=0){
        dp[0] = 0;
    }
    if(n>=1){
        dp[1] = 1;
    }

    for(int i = 2;i<=n;i++){
        dp[i] = dp[i-1]+dp[i-2];
    }
    System.out.println(dp[n]);
 }

}