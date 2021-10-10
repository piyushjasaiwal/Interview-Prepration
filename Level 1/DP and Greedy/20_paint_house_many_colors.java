/*
1. You are given a number n and a number k separated by a space, representing the number of houses and number of colors.
2. In the next n rows, you are given k space separated numbers representing the cost of painting nth house with one of the k colors.
3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.
Input Format
A number n
n1-0th n1-1st n1-2nd .. n1-kth
n2-0th n2-1st n2-2nd .. n2-kth
.. n number of elements
Output Format
A number representing the minimum cost of painting all houses without painting any consecutive house with same color.
Question Video

  COMMENTConstraints
1 <= n <= 1000
1 <= k <= 10
0 <= n1-0th, n1-1st, .. <= 1000
Sample Input
4 3
1 5 7
5 8 4
3 2 9
1 2 4
Sample Output
8
*/
import java.util.*;

class paint_house_many_colors {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int [][] paint =new int[n][k];
        int [][] dp =new int[n][k];
        for(int i= 0;i<n;i++){
            for(int j = 0;j<k;j++){
                paint[i][j] = s.nextInt();
            }
        }

        for(int i= 0;i<n;i++){
            for(int j = 0;j<k;j++){
                if(i == 0){
                    dp[i][j] = paint[i][j];
                }else{
                    int min = Integer.MAX_VALUE;
                    for(int m = 0;m<k;m++){
                        if(m != j){
                            min = Math.min(min, dp[i-1][m]);
                        }
                    }
                    dp[i][j] = min+paint[i][j];
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<k;i++){
            ans = Math.min(ans, dp[n-1][i]);
        }
        System.out.println(ans);
    }
}
