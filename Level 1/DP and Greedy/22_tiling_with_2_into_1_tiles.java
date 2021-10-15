import java.util.Scanner;

/*
1. You are given a number n representing the length of a floor space which is 2m wide. It's a 2 * n board.
2. You've an infinite supply of 2 * 1 tiles.
3. You are required to calculate and print the number of ways floor can be tiled using tiles.
Input Format
A number n
Output Format
A number representing the number of ways in which the number of ways floor can be tiled using tiles.
Question Video

  COMMENTConstraints
1 <= n <= 100
Sample Input
8
Sample Output
34
*/

class tiling_with_2_into_1_tiles {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] dp = new int[n+1];
        dp[0] = 1;
        if(n>=1){
          dp[1] = 1;
        }

        for(int i = 2;i<=n;i++){
          int s1 = dp[i-1];
          int s2 = dp[i-2]*dp[1];
          dp[i] = s1+s2;
        }

        System.out.println(dp[n]);
    }
}
