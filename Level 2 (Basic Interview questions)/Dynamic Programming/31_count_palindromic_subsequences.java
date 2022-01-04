/*abstract
1. You are given a string str.
2. You are required to print the count of palindromic subsequences in string str.
Input Format
A string str
Output Format
A number representing the count of palindromic subsequences in string str.
Question Video

  COMMENTConstraints
0 <= str.length <= 10
Sample Input
ccbbgd
Sample Output
8
*/

import java.io.*;
import java.util.*;

class count_palindromic_subsequences {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(countPalindromeSubsequence(str));
    }

    private static int countPalindromeSubsequence(String str) {
        
        int [][] dp = new int[str.length()][str.length()];
        for(int gap = 0;gap<str.length();gap++){
            int i = 0, j = gap;

            while(j < str.length()){
                if(gap == 0){
                    dp[i][j] = 1;
                }else if(gap == 1){
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? 3 : 2;
                }else{
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] = dp[i+1][j-1]+1;
                    }else{       
                        dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
                    }
                }
                i++;
                j++;
            }
        }

        // show(dp);
        
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