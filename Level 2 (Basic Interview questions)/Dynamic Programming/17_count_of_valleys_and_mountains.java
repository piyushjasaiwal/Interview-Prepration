/*abstract
1. You are given a number n, representing the number of upstrokes / and number of downstrokes .
2. You are required to find the number of valleys and mountains you can create using strokes.
E.g.

countvalleys

Note -> At no point should we go below the sea-level. (number of downstrokes should never be more than number of upstrokes).
Input Format
A number n
Output Format
A number representing the number of valleys and mountains you can create using strokes.
Question Video

  COMMENTConstraints
0 <= n <= 15
Sample Input
4
Sample Output
14
*/

// just calculate the catalan number for the specific number

import java.util.*;

class count_valleys_and_mountains{
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        // from now on the code for catalan number starts
        
        int [] dp = new int[n+1];

        for(int i = 0;i<=n;i++){
            if(i == 0 || i == 1){
                dp[i] = 1;
            }else{
                int start = 0;
                int end = i-1;
                
                int ans = 0;

                while(start <= end){
                    if(start == end){
                        ans += (dp[start]*dp[end]);
                    }else{
                        ans += (2*dp[start]*dp[end]);
                    }
                    start++;
                    end--;
                }
                dp[i] = ans;
            }
        }

        System.out.println(dp[n]);

    }
}