/*abstract
1. You are given a number n, representing the number of envelopes.
2. You are given n pair of numbers, representing the width and height of each envelope.
3. You are required to print the count of maximum number of envelopes that can be nested inside each other.
Note -> Rotation is not allowed.
Input Format
A number n
.. n pair of number each on a separate line (and pair separated by space)
Output Format
A number representing the count of maximum number of envelopes that can be nested inside each other.
Question Video

  COMMENTConstraints
0 <= n <= 20
0 <= n1w, n1h, n2w, n2h, .. <= 100
Sample Input
11
17 5
26 18
25 34
48 84
63 72
42 86
9 55
4 70
21 45
68 76
58 51
Sample Output
5
*/

import java.io.*;
import java.util.*;

class russian_doll_envelopes {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        env [] arr = new env[n];
        for(int i = 0;i<n;i++){
            arr[i] = new env(s.nextInt(), s.nextInt());
        }

        Arrays.sort(arr);

        int [] dp = new int[n];
        int ans = 0;
        for(int i = 0;i<n;i++){
            int max = 0;
            for(int j = 0;j<i;j++){
                if(arr[i].h > arr[j].h){
                    max = Math.max(max, dp[j]);
                }
            }

            dp[i] = max+1;
            ans = Math.max(dp[i], ans);
        }

        System.out.println(ans);
    }

}

class env implements Comparable<env>{
    int w, h;
    public env(int w, int h){
        this.w = w;
        this.h = h;
    }

    @Override
    public int compareTo(env e){
        if(this.w != e.w){
            return this.w - e.w;
        }
        return this.h - e.h;
    }
}