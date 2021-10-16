import java.util.Scanner;

/*
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are given a number k, representing the number of transactions allowed.
3. You are required to print the maximum profit you can make if you are allowed k transactions at-most.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
Input Format
A number n
.. n more elements
A number k
Output Format
A number representing the maximum profit you can make if you are allowed a single transaction.
Question Video

  COMMENTConstraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
0 <= k <= n / 2
Sample Input
6
9
6
7
6
3
8
1

Sample Output
5
*/

class buy_and_sell_stocks_k_transaction_allowed {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] ar = new int[n];
        for(int i = 0;i<n;i++){
            ar[i] = s.nextInt();
        }
        int k = s.nextInt();

        int [][] dp = new int [k+1][n];
        // for(int i = 0;i<=k;i++){
        //     for(int j = 0;j<n;j++){
        //         if(i == 0 || j == 0){
        //             dp[i][j] = 0;
        //         }else{
        //             int max_profit = 0;
        //             for(int m = 0;m<j;m++){
        //                 max_profit = Math.max(max_profit, dp[i-1][m] + ar[j] - ar[m]);
        //             }
        //             dp[i][j] = Math.max(max_profit, dp[i][j-1]);
        //         }
        //         // System.out.print(dp[i][j]+" ");
        //     }
        //     // System.out.println();
        // }
        // //to improve the complexity from n^3 to n^2

        for(int i = 0;i<=k;i++){
            int max = Integer.MIN_VALUE;;
            for(int j = 0;j<n;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else{
                    max = Math.max(max, dp[i-1][j-1] - ar[j-1]);
                    dp[i][j] = Math.max(max+ar[j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[k][n-1]);
        
    }
}
