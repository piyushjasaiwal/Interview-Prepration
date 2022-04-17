/*abstract
1. You are given a string.
2. You have to find the minimum number of cuts required to convert the given string into palindromic partitions.
3. Partitioning of the string is a palindromic partitioning if every substring of the partition is a palindrome.
Input Format
A string
Output Format
Check the sample output and question video.
Question Video

  COMMENTConstraints
1 <= length of string <= 10^4
Sample Input
abccbc
Sample Output
2
*/

import java.io.*;
import java.util.*;

class minimum_palindromic_cut {

	public static int minPalindromicCut(String s) {
		//write your code here
        int n = s.length();
        int [][] dp = new int[n][n];

        for(int gap = 0;gap<n;gap++){
            int i = 0;
            int j = gap;
            while(j < n){
                if(gap == 0){
                    dp[i][j] = 0;
                }else if(gap == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = 1;
                    }
                }else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 0){
                        dp[i][j] = 0;
                    }else{
                        int min = Integer.MAX_VALUE;
                        for(int k = i;k<j;k++){
                            min = Math.min(min, dp[i][k]+dp[k+1][j]);
                        }
                        dp[i][j] = min+1;
                    }
                }
                i++;
                j++;
            }
        }

		return dp[0][n-1];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(minPalindromicCut(str));
	}
}