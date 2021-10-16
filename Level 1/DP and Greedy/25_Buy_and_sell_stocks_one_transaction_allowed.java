import java.util.Scanner;

/*
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed a single transaction.
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
17
*/

class Buy_and_sell_stocks_one_transaction_allowed {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] ar = new int[n];
        for(int i = 0;i<n;i++){
            ar[i] = s.nextInt();
        }

        int min_price = ar[0];
        int max_profit = Integer.MIN_VALUE;

        for(int i = 1;i<n;i++){
            max_profit = Math.max(max_profit, ar[i]-min_price);
            min_price = Math.min(min_price, ar[i]);
        }
        System.out.println(max_profit);
    }
}
