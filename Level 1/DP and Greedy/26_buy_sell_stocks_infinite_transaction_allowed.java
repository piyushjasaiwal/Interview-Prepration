import java.util.Scanner;

/*
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed infinite transactions.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy)
Input Format
A number n
.. n more elements
Output Format
A number representing the maximum profit you can make if you are allowed infinite transactions.
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

class buy_sell_stocks_infinite_transaction_allowed {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] ar = new int[n];
        for(int i = 0;i<n;i++){
            ar[i] = s.nextInt();
        }
        int max_profit = 0;
        int i = 0;
        while(i<ar.length){
            int j = i+1;
            while(j<ar.length && ar[j] > ar[j-1]){
                j++;
            }
            j-=1;
            max_profit += (ar[j]-ar[i]);
            i = j+1;
        }
        System.out.println(max_profit);
    }
}
