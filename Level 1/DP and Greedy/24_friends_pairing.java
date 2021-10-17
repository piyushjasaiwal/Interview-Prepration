/*
1. You are given a number n, representing the number of friends.
2. Each friend can stay single or pair up with any of it's friends.
3. You are required to print the number of ways in which these friends can stay single or pair up.
E.g.
1 person can stay single or pair up in 1 way.
2 people can stay singles or pair up in 2 ways. 12 => 1-2, 12.
3 people (123) can stay singles or pair up in 4 ways. 123 => 1-2-3, 12-3, 13-2, 23-1.
Input Format
A number n
Output Format
A number representing the number of ways in which n friends can stay single or pair up.
Question Video

  COMMENTConstraints
0 <= n <= 20
Sample Input
4
Sample Output
10
*/

import java.util.*;

class friends_pairing {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n = s.nextInt();
        long [] dp = new long [n+1];
        dp[0] = 1;
        for(int i = 1;i<=n;i++){
            if(i == 1){
                dp[i] = 1;
            }else{
                // when this person is alone
                long alone = dp[i-1];
                //when this person pairs up with each of the remaining persons one at a time
                long pair = (i-1)*dp[i-2];
                dp[i] = alone+pair;
            }
        }
        System.out.println(dp[n]);
    }
}
