/*abstract
1. You are given a string str.
2. You are required to print the count of palindromic substrings in string str.

Constraints
0 <= str.length <= 10

Format
Input
A string str

Output
A number representing the count of palindromic substrings in string str.

Example
Sample Input

abccbc

Sample Output
9
*/

import java.io.*;
import java.util.*;

class count_palindromic_substring {
    public static void main(String[] args) {
        String str = new Scanner(System.in).next();
        // String str = "abc";
        boolean [][] dp = new boolean[str.length()][str.length()];
        int cnt = 0;
        for(int g = 0;g<dp.length;g++){
            int i = 0;
            int j = g;
            while(i<dp.length && j<dp.length){
                if(g == 0){
                    dp[i][j] = true;
                }else if(g == 1){
                    dp[i][j] = str.charAt(i) == str.charAt(j);
                }else{
                    dp[i][j] = str.charAt(i) == str.charAt(j) && dp[i+1][j-1];
                }

                if(dp[i][j]){
                    cnt+=1;
                }

                i++;
                j++;
            }
        }
        System.out.println(cnt);
    }
}