/*abstract
1. You are given a string str.
2. You are required to print the length of longest palindromic subsequence of string str.
Input Format
A string str
Output Format
A number representing the length of longest palindromic subsequence of string str.
Question Video

  COMMENTConstraints
0 <= str.length <= 10
Sample Input
abcgackbc
Sample Output
5
*/

import java.io.*;
import java.util.*;

class longest_palindromic_subsequence {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(LPS(str));
    }

    private static int LPS(String str) {
        int [][] dp = new int[str.length()][str.length()];
        for(int gap = 0;gap<str.length();gap++){
            int i = 0, j = gap;

            while(j < str.length()){
                if(gap == 0){
                    dp[i][j] = 1;
                }else if(gap == 1){
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? 2 : 1;
                }else{
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] = dp[i+1][j-1]+2;
                    }else{
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                    }
                }

                i++;
                j++;
            }
        }

        show(dp);

        return dp[0][str.length()-1];
    }

    private static void show(int[][] dp) {
        System.out.println("-----------------------------------");
        for(int [] d:dp){
          for(int val:d){
            System.out.print(val+" ");
          }
          System.out.println();
        }
        System.out.println("-----------------------------------");
    }

}