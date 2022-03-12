/*abstract
1. You are given two strings S1 and S2. S1 represents a text and S2 represents a wildcard pattern.
2. You have to print 'true' if the wildcard pattern is matched with the given text, otherwise print 'false'.

The wildcard pattern can include the characters '?' and '*'
'?' - matches any single character
'*' - matches any sequence of characters (including the empty sequence)
Input Format
2 strings S1 and S2
Output Format
Check the sample output and question video.
Question Video

  COMMENTConstraints
1 < length of strings S1 and S2 <= 200
Sample Input
baaabab
ba*a?
Sample Output
true
*/

import java.io.*;
import java.util.*;

class wildcard_pattern_matching {

	public static boolean solution(String str, String pattern) {
		//write your code here

        boolean [][] dp = new boolean[pattern.length()+1][str.length()+1];
        dp[dp.length-1][dp[0].length-1] = true;
        for(int i = 0;i<dp.length-1;i++){
            if(pattern.charAt(i) == '*'){
                dp[i][dp[0].length-1] = dp[i+1][dp[0].length-1];
            }else{
                dp[i][dp[0].length-1] = false;
            }
            
        }

        for(int j = 0;j<dp[0].length-1;j++){
            dp[dp.length-1][j] = false;
        }

        for(int i = dp.length-2;i>=0;i--){
            for(int j = dp[0].length-2;j>=0;j--){
                if(pattern.charAt(i) == '?'){
                    dp[i][j] = dp[i+1][j+1];
                }else if(pattern.charAt(i) == '*'){
                    for(int k = j;k<dp[0].length;k++){
                        dp[i][j] = dp[i][j] || dp[i+1][k];
                    }
                }else{
                    dp[i][j] = pattern.charAt(i) == str.charAt(j);
                }
            }
        }
		return dp[0][0];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}