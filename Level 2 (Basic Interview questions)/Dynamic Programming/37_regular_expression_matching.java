/*abstract
1. You are given two strings S1 and S2. S1 represents a text and S2 represents a pattern.
2. You have to print 'true' if the pattern is matched with the given text, otherwise print 'false'.

The pattern can include the characters '.' and '*'
'.' - matches any single character
'*' - matches zero or more of the preceding character
Input Format
2 strings S1 and S2
Output Format
true or false as required
Question Video

  COMMENTConstraints
1 < length of strings S1 amd S2 <= 200
Sample Input
aa
a
Sample Output
false
*/


import java.io.*;
import java.util.*;

class regular_expression_matching {

	public static boolean solution(String s, String p) {
		//write your code here

        boolean [][] dp = new boolean[p.length()+1][s.length()+1];
		
        dp[p.length()][s.length()] = true;

        for(int i = 0;i<p.length();i++){
            dp[i][s.length()] = false;
        }

        for(int j = 0;j<s.length();j++){
            dp[s.length()][j] = false;
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
