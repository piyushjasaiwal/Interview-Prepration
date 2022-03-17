/*abstract
1. You are given a number M representing length of highway(range).
2. You are given a number N representing number of bill boards.
3. You are given N space separated numbers representing (P)position of bill-boards.
4. You are given N space separated numbers representing (R)revenue corresponding to each (P)position.
5. You are given a number T such that bill-boards can only be placed after specific distance(T).
6. Find the maximum revenue that can be generated.
Input Format
A number M(length of highway)
A number N(number of bill boards)
P1 ,P2 ,P3 ,P4 ,P5 .... Pn (placement of N bill-boards)
R1 ,R2 ,R3 ,R4 ,R5 .... Rn (revenue from each bill-board)
A number T (neccessary distance b/w two bill-board)
Output Format
Find the maximum revenue that can be generated.
Check the sample output and question video.
Question Video

  COMMENTConstraints
1 <= M <= 100000
1 <= N <= 50000
1 <= Pi <= M
1 <= Ri <= 100
1 <= T
Sample Input
20
5
6 7 12 14 15
5 8 5 3 1
5
Sample Output
11
*/

import java.util.*;
class Highway_BillBoard{
    public static int solution(int m , int[] x, int[] rev, int t) {
        // write your code here
        // There are two approaches to this questions one is o(m) and the other is o(n^2) based on the constraints choose your approach
        // here the approach used is o(m)

        /* Code for o(n^2)
        int [] dp= new int[rev.length];
        dp[0] = 0;
        int ans = 0;

        for(int i = 1;i<dp.length;i++){
            int max = 0;
            for(int j = 0;j<i;j++){
                if(x[i]-x[j] > t){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max+rev[i];
            ans = Math.max(ans, dp[i]);
        }

        return ans;
        */

        //Code for o(m)

        // int max = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0;i<x.length;i++){
            map.put(x[i], rev[i]);
        }

        int [] dp = new int[m+1];
        dp[0] = 0;
        for(int i = 1;i<=m;i++){
            if(!map.containsKey(i)){
                dp[i] = dp[i-1];
            }else{
                dp[i] = Math.max(dp[i-1], map.get(i) + (i-t-1 >= 0 ? dp[i-t-1] : 0));
            }
        }

        return dp[m];
    }

    public static void input(int []arr,Scanner scn){
        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
    }

    public static void main(String []args){
        Scanner scn = new Scanner(System.in);   
        int m = scn.nextInt();
        int n = scn.nextInt();
        
        int x[] = new int[n];
        input(x, scn);

        int revenue[] = new int[n];
        input(revenue,scn);

        int t = scn.nextInt();

        System.out.println(solution(m, x, revenue, t));
        scn.close();
    }
}