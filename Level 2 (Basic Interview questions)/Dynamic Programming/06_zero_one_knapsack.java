/*abstract
1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
5. Also, you have to print the indices of items that should be selected to make maximum profit.
6. You have to print all such configurations.

Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item again and again.
Input Format
A number n
A number m
e11
e12..
e21
e22..
.. n * m number of elements
Output Format
Check the sample output and question video.
Question Video

  COMMENTConstraints
1 <= n <= 10^2
1 <= m <= 10^2
0 <= e1, e2, .. n * m elements <= 1000
Sample Input
5
15 14 10 45 30
2 5 1 3 4
7
Sample Output
75
3 4 
*/

import java.io.*;
import java.util.*;

class zero_one_knapsack {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        //write your code here
        
        int [][] dp = new int[n+1][cap+1];
        for(int i = 0;i<=n;i++){
            for(int j = 0;j<=cap;j++){
                if(i == 0){
                    dp[i][j] = 0;
                }else{
                    int max = dp[i-1][j];
                    if(j-wts[i-1]>=0){
                        max = Math.max(max, dp[i-1][j-wts[i-1]]+values[i-1]);
                    }

                    dp[i][j] = max;
                }
            }
        }

        System.out.println(dp[n][cap]);
    }
}