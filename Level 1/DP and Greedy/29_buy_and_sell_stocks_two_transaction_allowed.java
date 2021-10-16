import java.util.Scanner;

/*
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed two transactions at-most.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
Input Format
A number n
.. n more elements
Output Format
A number representing the maximum profit you can make if you are allowed a single transaction.
Question Video

  COMMENTConstraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
Sample Input
9
11
6
7
19
4
1
6
18
4
Sample Output
30
*/

class buy_and_sell_stocks_two_transaction_allowed {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] ar = new int[n];
        for(int i = 0;i<n;i++){
            ar[i] = s.nextInt();
        }

        int [] dp = new int[n];
        int min = ar[0];
        int max_profit = 0;
        for(int i = 1;i<n;i++){
            dp[i] = Math.max(max_profit, ar[i] - min);
            max_profit = dp[i];
            min = Math.min(min, ar[i]);
        }
        max_profit = 0;
        int profit = 0;
        int max = ar[ar.length-1];
        for(int i = ar.length-2;i>=0;i--){
            dp[i] = Math.max(max_profit, max - ar[i]);
            max_profit = dp[i];
            max = Math.max(max, ar[i]);

            if(i != 0){
                profit = dp[i]+dp[i-1];
            }
            dp[i] = Math.max(profit, dp[i+1]);
        }

        // for(int val : dp){
        //     System.out.print(val+" ");
        // }
        // System.out.println();
        System.out.println(dp[0]);
    }  
}
