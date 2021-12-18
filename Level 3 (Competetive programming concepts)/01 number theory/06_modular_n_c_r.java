import java.util.Scanner;

/*
here the fornula that we will use is 

C(n,r) = C(n-1, r) + C(n-1, r-1);
*/


/*
You have T test cases and for each test case you have been given n and r values and you need to find nCr mod 10^9+7.
Input Format
The first line contains an integer T.
Next T lines contain integers n and r.
Output Format
for each query print nCr mod 10^9+7 in a line.
Question Video

  COMMENTConstraints
1 <= T <= 10^6
1 <= n <= 3000
1 <= r <= n
Sample Input
3
4 3
5 2
10 8
Sample Output
4
10
45
*/

class modular_n_c_r {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        long [][] dp = new long[3001][3001];
        for(int i = 0;i<=dp.length-1;i++){
            for(int j = 0;j<=i;j++){
                if(j == 0){
                    dp[i][j] = 1;
                }else if(j == 1){
                    dp[i][j] = i;
                }else if(i == j){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = (dp[i-1][j]+dp[i-1][j-1])%1000000007;
                }
            }
        }      

        while(t-- > 0){
            int n = s.nextInt();
            int r = s.nextInt();
            System.out.println(dp[n][r]);
        }
    }
}
