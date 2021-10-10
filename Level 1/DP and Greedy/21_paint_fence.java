/*
1. You are given a number n and a number k in separate lines, representing the number of fences and number of colors.
2. You are required to calculate and print the number of ways in which the fences could be painted so that not more than two consecutive  fences have same colors.
Input Format
A number n
A number k
Output Format
A number representing the number of ways in which the fences could be painted so that not more than two fences have same colors.
Question Video

  COMMENTConstraints
1 <= n <= 10
1 <= k <= 10
Sample Input
8
3
Sample Output
3672
*/

import java.util.*;

class paint_fence {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();

        int [][] dp = new int[n+1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        if(n>=1){
            dp[1][0] = k;
            dp[1][1] = k;
        }
        if(n>=2){
            dp[2][0] = k;
            dp[2][1] = k*k;
        }
        for(int i = 3;i<=n;i++){
            dp[i][0] = dp[i-1][1];
            dp[i][1] = (dp[i-1][0]+dp[i-1][1])*(k-1);
        }
        System.out.println(dp[n][1]);
        // for(int [] dd:dp){
        //     for(int d:dd){
        //         System.out.print(d+" ");
        //     }
        //     System.out.println();
        // }
    }
}
