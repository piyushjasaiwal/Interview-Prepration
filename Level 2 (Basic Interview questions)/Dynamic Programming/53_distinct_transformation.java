/*abstract
1. You are given two strings S1 and S2.
2. You have to find the number of unique ways in which you can transform S1 to S2.
3. Transformation can be achieved by removing 0 or more characters from S1, such that the sequence formed by the remaining characters of S1 is identical to S2.
Input Format
Two Strings S1 and S2
Output Format
A number representing the count of distinct transformations.
Question Video

Constraints
1 <= length of strings S1 and S2 <= 1000
Sample Input
abcccdf
abccdf
Sample Output
3
*/

import java.io.*;
import java.util.*;

class distinct_transformation {

	public static int solution(String s, String t) {

        return 0;
	}

    public static long[][] ncr(int n, int r){
        long [][] dp = new long[n+1][r+1];
        for(int i = 0;i<=n;i++){
            for(int j = 0;j<=i;j++){
                if(i == 0){
                    dp[i][j] = 1;
                }else if(j == 0){
                    dp[i][j] = 1;
                }else if(j == 1){
                    dp[i][j] = i;
                }else if(i == j){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
                }
            }
        }
        return dp;
    }
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1, s2));
	}

}