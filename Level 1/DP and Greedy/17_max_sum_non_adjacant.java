import java.util.Scanner;

/*
1. You are given a number n, representing the count of elements.
2. You are given n numbers, representing n elements.
3. You are required to find the maximum sum of a subsequence with no adjacent elements.
Input Format
A number n
n1
n2
.. n number of elements
Output Format
A number representing the maximum sum of a subsequence with no adjacent elements.
Question Video

  COMMENTConstraints
1 <= n <= 1000
-1000 <= n1, n2, .. n elements <= 1000
Sample Input
6
5
10
10
100
5
6
Sample Output
116
*/

class max_sum_non_adjacant {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] ar = new int[n];
        for(int i = 0;i<n;i++){
            ar[i] = s.nextInt();
        }

        int [][] dp = new int[n][2];
        dp[0][0] = ar[0];
        dp[0][1] = 0;

        for(int i = 1;i<n;i++){
            // dp[i] = Math.max(dp[i-1], dp[i-2]+ar[i]);
            dp[i][0] = dp[i-1][1]+ar[i];
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
        }
        System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
    }
}
