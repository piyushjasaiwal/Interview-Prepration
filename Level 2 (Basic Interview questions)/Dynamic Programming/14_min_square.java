/*abstract
1. You are given a number N.
2. You have to find the minimum number of squares that sum to N.
3. You can always represent a number as a sum of squares of other numbers.
   For eg -> In worst case N can be represented as (1*1) + (1*1) + (1*1)..... N times.
Input Format
An integer N
Output Format
Check the sample output and question video.
Question Video

  COMMENTConstraints
1 <= N <= 10^5
Sample Input
35
Sample Output
3
*/

import java.io.*;
import java.util.*;

class min_square {

	public static int solution(int n){
		//write your code here
        int [] dp = new int[n+1];
        ArrayList<Integer> roots = new ArrayList<>();
        for(int i = 1;i*i<=n;i++){
            roots.add(i);
        }

        dp[0] = 0;
        for(int i = 1;i<=n;i++){
            // int sqrt = (int)(Math.sqrt(i));
            // int square = sqrt*sqrt;

            // int rem = i-square;
            // dp[i] = dp[rem]+1;

            int ans = Integer.MAX_VALUE;

            for(int root:roots){
                int mult = root*root;
                if(mult > i){
                    break;
                }

                int temp = dp[i-mult] + 1;
                ans = Math.min(ans, temp);
            }

            dp[i] = ans;
        }

        // for(int i = 0;i<=n;i++){
        //     System.out.println(i+" "+dp[i]);
        // }
		return dp[n];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}	
}