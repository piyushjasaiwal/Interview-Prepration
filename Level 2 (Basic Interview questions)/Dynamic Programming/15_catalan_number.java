/*abstract
1. You are given a number n.
2. You are required to find the value of nth catalan number.
C0 -> 1
C1 -> 1
C2 -> 2
C3 -> 5
..
Cn -> C0.Cn-1 + C1.Cn-2 + .. + Cn-2.C1 + Cn-1.C0
Input Format
A number n
Output Format
A number representing the value of nth catalan number.
Question Video

  COMMENTConstraints
0 <= n <= 15
Sample Input
4
Sample Output
14
*/

import java.io.*;
import java.util.*;

class catalan_number{

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        // write your code here
        int n = s.nextInt();
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