/*abstract
1. You are given a string str.
2. You have to find the length of longest subsequence which is appearing twice in the string.
3. Every ith character in both the subsequences must have different indices in the original string.
Input Format
A string str
Output Format
A number representing the length of longest repeating subsequence.
Question Video

  COMMENTConstraints
1 < length of strings str <= 2000
Sample Input
abcdgh
Sample Output
0
*/

import java.io.*;
import java.util.*;

class longest_repeating_subsequence {

	public static int solution(String str){
		//write your code here

        int [][] dp = new int[str.length()+1][str.length()+1];
		for(int i = 0;i<dp.length;i++){
			for(int j = 0;j<dp[0].length;j++){
				if(i == 0 || j == 0){
					dp[i][j] = 0;
				}else if(i != j && str.charAt(i-1) == str.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1]+1;
				}else{
					dp[i][j] = Math.max(dp[i-1][j-1], Math.max(dp[i-1][j], dp[i][j-1]));
				}
			}
		}
		return dp[str.length()][str.length()-1];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}