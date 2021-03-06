/*
1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number "tar".
4. You are required to calculate and print true or false, if there is a subset the elements of which add 
     up to "tar" or not.
Input Format
A number n
n1
n2
.. n number of elements
A number tar
Output Format
true or false as required
Question Video

  COMMENTConstraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 20
0 <= tar <= 50
Sample Input
5
4
2
7
1
3
10
Sample Output
true
*/

import java.util.*;
class target_sum_dp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] num = new int [n];
        for(int i = 0;i<n;i++){
            num[i] = s.nextInt();
        }
        int tar = s.nextInt();
        boolean [][] dp = new boolean[tar+1][n+1];
        for(int i = 0;i<=tar;i++){
            for(int j = 0;j<=n;j++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }else if(i == 0){
                    dp[i][j] = true;
                }else if(j == 0){
                    dp[i][j] = false;
                }else{
                    boolean ans = dp[i][j-1];
                    if(i-num[j-1]>=0){
                        ans = ans || dp[i-num[j-1]][j-1];
                    }
                    dp[i][j] = ans;
                }
            }
        }
        System.out.println(dp[tar][num.length-1]);
        // System.out.println("-----------------------------------------------");
        // for(boolean [] a:dp){
        //     for(boolean bb:a){
        //         System.out.print(bb+" ");
        //     }
        //     System.out.println();
        // }
    }
}
