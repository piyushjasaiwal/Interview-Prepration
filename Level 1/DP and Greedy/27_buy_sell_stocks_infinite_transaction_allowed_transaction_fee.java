/*
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are give a number fee, representing the transaction fee for every transaction.
4. You are required to print the maximum profit you can make if you are allowed infinite transactions, but has to pay "fee" for every closed transaction.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
Input Format
A number n
.. n more elements
A number fee
Output Format
A number representing the maximum profit you can make if you are allowed infinite transactions with transaction fee.
Question Video

  COMMENTConstraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
0 <= fee <= 5
Sample Input
12
10
15
17
20
16
18
22
20
22
20
23
25
3
Sample Output
13
*/

import java.util.*;

class buy_sell_stocks_infinite_transaction_allowed_transaction_fee {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] ar = new int[n];
        for(int i = 0;i<n;i++){
            ar[i] = s.nextInt();
        }
        int fee = s.nextInt();

        int bsp = -ar[0];
        int ssp = 0;

        for(int i = 1;i<ar.length;i++){
            int nbsp = Math.max(bsp, ssp - ar[i]);
            int nssp = Math.max(ssp, bsp + ar[i] - fee);

            bsp = nbsp;
            ssp = nssp;
        }
        System.out.println(ssp);
    }

}