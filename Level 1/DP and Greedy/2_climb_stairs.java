/*1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. In one move, you are allowed to climb 1, 2 or 3 stairs.
4. You are required to print the number of different paths via which you can climb to the top.
Input Format
A number n
Output Format
A number representing the number of ways to climb the stairs from 0 to top.
Question Video

  COMMENTConstraints
0 <= n <= 20
Sample Input
4
Sample Output
7 */

import java.io.*;
import java.util.*;

class climb_steps {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] dp = new int[n+1];
        if(n>=0){
            dp[0] = 1;
        }

        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=3;j++){
                if(i-j>=0){
                    dp[i]+=dp[i-j];
                }
            }
        }
        System.out.println(dp[n]);
    }

}