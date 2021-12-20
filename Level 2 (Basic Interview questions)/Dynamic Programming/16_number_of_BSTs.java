/*abstract1. You are given a number n, representing the number of elements.
2. You are required to find the number of Binary Search Trees you can create using the elements.
Input Format
A number n
Output Format
A number representing the number of Binary Search Trees you can create using the elements.
Question Video

  COMMENTConstraints
0 <= n <= 15
Sample Input
4
Sample Output
14
*/

// the number of bsts can be calculated using catalan number

import java.io.*;
import java.util.*;

class number_of_BSTs{

    public static void main(String[] args) throws Exception {
        // write your code here
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