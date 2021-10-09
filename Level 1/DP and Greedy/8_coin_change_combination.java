/*
1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the number of combinations of the n coins using which the 
     amount "amt" can be paid.

Note1 -> You have an infinite supply of each coin denomination i.e. same coin denomination can be 
                  used for many installments in payment of "amt"
Note2 -> You are required to find the count of combinations and not permutations i.e.
                  2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations of same 
                  combination. You should treat them as 1 and not 3.
Input Format
A number n
n1
n2
.. n number of elements
A number amt
Output Format
A number representing the count of combinations of coins which can be used to pay the amount "amt"
Question Video

  COMMENTConstraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 20
0 <= amt <= 50
Sample Input
4
2
3
5
6
7
Sample Output
2
*/

import java.util.*;
class coin_change_combination {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] coins = new int[n];
        for(int i = 0;i<n;i++){
            coins[i] = s.nextInt();
        }

        int amt = s.nextInt();
        int [] dp = new int[amt+1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i = 1;i<=amt;i++){
                if(i-coin>=0){
                    dp[i] += dp[i-coin];
                }
            }
            System.out.println("====================================================");
            for(int a:dp){
                System.out.print(a+" ");
            }
            System.out.println();
            System.out.println("====================================================");
        }
        System.out.println(dp[amt]);
        System.out.println("--------------------------------------------");
        for(int a:dp){
            System.out.print(a+" ");
        }
    }

    // public static void main(String[] args) {
        
    //     Scanner s = new Scanner(System.in);
    //     int n = s.nextInt();
    //     int [] coins = new int[n];
    //     for(int i = 0;i<n;i++){
    //         coins[i] = s.nextInt();
    //     }

    //     int amt = s.nextInt();
    //     int [][] dp = new int[coins.length][amt+1];
    //     for(int i = 0;i<coins.length;i++){
    //         for(int j = 0;j<=amt;j++){
    //             if(j == 0){
    //                 dp[i][j] = 1;
    //             }else{
    //                 if(j - coins[i]>=0){
    //                     dp[i][j] = dp[i][j-coins[i]];
    //                 }                    
    //             }
    //         }
    //     }
    //     int sum = 0;
    //     for(int i = 0;i<coins.length;i++){
    //         sum += dp[i][amt];
    //     }
    //     System.out.println(sum);
    //     System.out.println("---------------------------------");
    //     for(int [] aa:dp){
    //         for(int a:aa){
    //             System.out.print(a+" ");
    //         }
    //         System.out.println();
    //     }
    // }
}
