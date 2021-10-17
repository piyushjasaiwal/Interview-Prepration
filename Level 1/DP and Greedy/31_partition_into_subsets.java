import java.util.Scanner;

/*
1. You are given a number n, representing the number of elements.
2. You are given a number k, representing the number of subsets.
3. You are required to print the number of ways in which these elements can be partitioned in k non-empty subsets.
E.g.
For n = 4 and k = 3 total ways is 6
12-3-4
1-23-4
13-2-4
14-2-3
1-24-3
1-2-34
Input Format
A number n
A number k
Output Format
A number representing the number of ways in which these elements can be partitioned in k non-empty subsets.
Question Video

  COMMENTConstraints
0 <= n <= 20
0 <= k <= n
Sample Input
4
3
Sample Output
6
*/

class partition_into_subsets {
    public static long partitionKSubset(int n, int k) {
        // write your code here
        long [][] dp = new long[k+1][n+1];
        for(int i = 0;i<=k;i++){
            for(int j = 0;j<=n;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if(i>j){
                    dp[i][j] = 0;
                }else if(i == 1 || i == j){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = (i*dp[i][j-1]) + dp[i-1][j-1];
                }
            }
        }

        // for(long [] dd:dp){
        //     for(long d : dd){
        //         System.out.print(d+" ");
        //     }
        //     System.out.println();
        // }
        return dp[k][n];
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        long res = partitionKSubset(n, k);
        System.out.println(res);
    }
}
