import java.util.Scanner;

/**
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed infinite transactions, but have to cooldown for 1 day after 1 transaction
i.e. you cannot buy on the next day after you sell, you have to cooldown for a day at-least before buying again.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
Input Format
A number n
.. n more elements
Output Format
A number representing the maximum profit you can make if you are allowed infinite transactions with cooldown of 1 day.
Question Video

  COMMENTConstraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
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
Sample Output
19
 */

class buy_sell_stocks_infinite_transaction_allowed_cooldown {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] ar = new int[n];
        for(int i = 0;i<n;i++){
            ar[i] = s.nextInt();
        }

        int bsp = -ar[0];
        int ssp = 0;
        int ssp_a_day_before = -1;
        for(int i = 1;i<ar.length;i++){
            if(i == 1){
                int nbsp = Math.max(bsp, ssp - ar[i]);
                int nssp = Math.max(ssp, ar[i]-bsp);
                ssp_a_day_before = ssp;
                bsp = nbsp;
                ssp = nssp;
            }else{
                int nbsp = Math.max(bsp, ssp_a_day_before - ar[i]);
                int nssp = Math.max(ssp, ar[i]-bsp);
                ssp_a_day_before = ssp;
                bsp = nbsp;
                ssp = nssp;
            }
        }
        System.out.println(ssp);
    }
}
