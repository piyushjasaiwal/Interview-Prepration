/*abstract
Given an array ht representing heights of buildings. You have to count the buildings which will see the sunrise (Assume : Sun rise on the side of array starting point).
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
 1 <= N <= 10^6
1 <= H[i] <= 10^8
Sample Input
5
7 4 8 2 9
Sample Output
3
*/

import java.util.*;
import java.io.*;

class facing_the_sun {
    public static int countBuildings(int[]ht) {
        //write your code here
        int max = Integer.MIN_VALUE;
        int ans = 0;

        for(int val:ht){
            if(val>max){
                ans++;
                max = val;
            }
        }
        return ans;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]ht = new int[n];

        for (int i = 0; i < n; i++) {
            ht[i] = scn.nextInt();
        }

        System.out.println(countBuildings(ht));
    }
}