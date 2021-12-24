/*abstract
1. You are given a number N.
2. There are 2*N points on a circle. You have to draw N non-intersecting chords on a circle.
3. You have to find the number of ways in which these chords can be drawn.
Input Format
A number N
Output Format
Check the sample output and question video.
Question Video

  COMMENTConstraints
1 <= N <= 1000
1 <= arr[i] <= 100
Sample Input
3
Sample Output
5
*/

import java.io.*;
import java.util.*;

class circle_and_chords {

    public static long NumberOfChords(int n){
        //write your code here
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
        return dp[n];
    }
  public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(NumberOfChords(n));
	}
}