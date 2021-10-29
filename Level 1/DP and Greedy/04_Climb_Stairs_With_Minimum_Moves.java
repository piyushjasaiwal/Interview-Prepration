/*
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. You are given n numbers, where ith element's value represents - till how far from the step you 
     could jump to in a single move.  You can of-course fewer number of steps in the move.
4. You are required to print the number of minimum moves in which you can reach the top of 
     staircase.
Note -> If there is no path through the staircase print null.
Input Format
A number n
.. n more elements
Output Format
A number representing the number of ways to climb the stairs from 0 to top.
Question Video

  COMMENTConstraints
0 <= n <= 20
0 <= n1, n2, .. <= 20
Sample Input
10
3
3
0
2
1
2
4
2
0
0
Sample Output
4
*/

import java.io.*;
import java.util.*;

class Climb_Stairs_With_Minimum_Moves {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] jumps = new int[n];
        for(int i = 0;i<n;i++){
            jumps[jumps.length-i-1] = s.nextInt();
        }

        int [] dp = new int[n+1];
        dp[0] = 0;

        for(int i = 1;i<=n;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1;j<=jumps[i-1];j++){
                if(i-j>=0){
                    min = Math.min(min, dp[i-j]);
                }
            }
            if(min == Integer.MAX_VALUE){
                dp[i] = min;
            }else{
                dp[i] = min+1;
            }
        }
        System.out.println(dp[n] == Integer.MAX_VALUE ? "null" : dp[n]);        
    }

}
