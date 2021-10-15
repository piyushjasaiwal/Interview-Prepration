import java.util.Scanner;

/*
1. You are given a number n and a number m separated by line-break representing the length and breadth of a m * n floor.
2. You've an infinite supply of m * 1 tiles.
3. You are required to calculate and print the number of ways floor can be tiled using tiles.
Input Format
A number n
A number m
Output Format
A number representing the number of ways in which the number of ways floor can be tiled using tiles.
Question Video

  COMMENTConstraints
1 <= n <= 100
1 <= m <= 50
Sample Input
39
16
Sample Output
61
*/

class tiling_wth_m_cross_1_tiles {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        int [][] dp = new int[m+1][n+1];
        for(int j = 0;j<=n;j++){
            for(int i = 0;i<=m;i++){
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                }else{
                    int ans = dp[i-1][j];
                    int sum = 1;
                    if(i-m >= 0){
                        sum= dp[i-m][j];
                    }
                    if(j>=m){
                        sum = sum*dp[i-1][m];     
                    }
                    dp[i][j] = ans+sum;         
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
