/*abstract
1. You are given a number n, representing the number of opening brackets ( and closing brackets )
2. You are required to find the number of ways in which you can arrange the brackets if the closing brackets should never exceed opening brackets
e.g.
for 1, answer is 1 -> ()
for 2, answer is 2 -> ()(), (())
for 3, asnwer is 5 -> ()()(), () (()), (())(), (()()), ((()))
Input Format
A number n
Output Format
A number representing the number of ways in which you can arrange the brackets if the closing brackets should never exceed opening brackets
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

class count_brackets{
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