/*
1. You are given a number N, which represents the number of sides in a polygon.
2. You have to find the total number of ways in which the given polygon can be triangulated.
Input Format
A number N
Output Format
A number representing number of ways of traingulating a N-sided polygon.
Question Video

  COMMENTConstraints
1 <= N <= 15
Sample Input
5
Sample Output
5
*/

import java.util.*;

class number_of_ways_of_triangulation {

    public static long solution(int n){
		// write your code here
        long [] dp = new long[n+1];
        dp[0] = 1;
        for(int i =1;i<=n;i++){
          int j = 0;
          int k = i-1;
          while(j<=k){
            if(j==k){
              dp[i] += (dp[j]*dp[k]);
            }else{
              dp[i] += (2*dp[j]*dp[k]);
            }
            j++;
            k--;
          }
        }
        return dp[n-2];
	 }
	 
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
        scn.close();
	}  
}
