/*
1. You are given a number n, representing the number of houses.
2. In the next n rows, you are given 3 space separated numbers representing the cost of painting nth house with red or blue or green color.
3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.
Input Format
A number n
n1red n1blue n1green
n2red n2blue n2green
.. n number of elements
Output Format
A number representing the minimum cost of painting all houses without painting any consecutive house with same color.
Question Video

  COMMENTConstraints
1 <= n <= 1000
0 <= n1red, n1blue, .. <= 1000
Sample Input
4
1 5 7
5 8 4
3 2 9
1 2 4
Sample Output
8
 */
import java.util.*;

class paint_house {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [][] paint =new int[n][3];
        int [][] dp =new int[n][3];
        for(int i= 0;i<n;i++){
            for(int j = 0;j<3;j++){
                paint[i][j] = s.nextInt();
            }
        }

        for(int i= 0;i<n;i++){
            if(i == 0){
                dp[i][0] = paint[i][0];
                dp[i][1] = paint[i][1];
                dp[i][2] = paint[i][2];
            }else{
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+paint[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+paint[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+paint[i][2];
            }
        }
        System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
    }
}
