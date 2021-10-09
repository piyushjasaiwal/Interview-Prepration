/*
1. You are given a number n, which represents the length of a road. The road has n plots on it's each side.
2. The road is to be so planned that there should not be consecutive buildings on either side of the road.
3. You are required to find and print the number of ways in which the buildings can be built on both side of roads.
Input Format
A number n
Output Format
A number representing the number of ways in which the buildings can be built on both side of roads.
Question Video

  COMMENTConstraints
0 < n <= 45
Sample Input
6
Sample Output
441
*/
import java.util.*;
class arrange_buildings {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [][] dp = new int[n+1][2];
        if(n>=1){
            dp[1][0] = 1;
            dp[1][1] = 1;
        }

        for(int i = 2;i<=n;i++){
            dp[i][0] = dp[i-1][0]+dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }
        int ans = dp[n][0]+dp[n][1];
        // System.out.println(ans*ans);
        long ansl = 1L*ans*ans;
        System.out.println(ansl);
    }
}
