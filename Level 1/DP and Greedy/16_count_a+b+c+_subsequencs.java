/*
1. You are given a string str.
2. You are required to calculate and print the count of subsequences of the nature a+b+c+.
For abbc -> there are 3 subsequences. abc, abc, abbc
For abcabc -> there are 7 subsequences. abc, abc, abbc, aabc, abcc, abc, abc.
Input Format
A string str
Output Format
count of subsequences of the nature a+b+c+
Question Video

  COMMENTConstraints
0 < str.length <= 10
Sample Input
abcabc
Sample Output
7
*/
import java.util.*;

class count_abc_subsequencs {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        int [][] dp = new int[str.length()+1][3];
        for(int i = 1;i<=str.length();i++){
            char ch = str.charAt(i-1);
            dp[i][0] = dp[i-1][0];
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-1][2];
            if(ch == 'a'){
                dp[i][0] = (2*dp[i-1][0])+1;
            }else if(ch == 'b'){
                dp[i][1] = (2*dp[i-1][1])+dp[i-1][0];
            }else{
                dp[i][2] = (2*dp[i-1][2])+dp[i-1][1];
            }
        }
        System.out.println(dp[str.length()][2]);

        System.out.println("------------------------------------------------");

        for(int [] d:dp){
            for(int a : d){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
}
