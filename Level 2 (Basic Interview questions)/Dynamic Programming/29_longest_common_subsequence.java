/*abstract
1. You are given a string str1.
2. You are given another string str2.
3. You are required to print the length of longest common subsequence of two strings.
Input Format
A string str1
A string str2
Output Format
A number representing the length of longest common subsequence of two strings.
Question Video

  COMMENTConstraints
0 <= str1.length <= 10
0 <= str2.length <= 10
Sample Input
abcd
aebd
Sample Output
3*/

import java.io.*;

class longest_common_subsequence {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        System.out.println(LCS(str1, str2));
    }

    private static int LCS(String str1, String str2) {
        int [][] dp = new int[str1.length()+1][str2.length()+1];

        for(int i = 0;i<=str1.length();i++){
            for(int j = 0;j<=str2.length();j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else{
                    if(str1.charAt(i-1) == str2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1]+1;
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }

        // show(dp);

        return dp[str1.length()][str2.length()];
    }

    

    // private static void show(int[][] dp) {
    //     System.out.println("-----------------------------------");
    //     for(int [] d:dp){
    //       for(int val:d){
    //         System.out.print(val+" ");
    //       }
    //       System.out.println();
    //     }
    //     System.out.println("-----------------------------------");
    //   }
}