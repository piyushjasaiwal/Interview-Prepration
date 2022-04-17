/*abstract
1. Given a sorted array containing only 0s and 1s, find the transition point.
2. Transition Point is defined as 1's starting point.
3. If there is no transition point, return -1.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1 <= N <= 500000
0 <= arr[i] <= 1
Sample Input
6
0 0 0 0 1 1
Sample Output
4
*/

import java.util.*;
import java.io.*;

class find_transition_point {

    public static int findTransition(int[]arr) {
        //write your code here
        if(arr[arr.length-1] == 0){
            return -1;
        }
        int ans = arr.length-1;
        int lo = 0, hi = arr.length-1;

        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(arr[mid] == 0){
                lo = mid+1;
            }else{
                ans = Math.min(mid, ans);
                hi = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        System.out.println(findTransition(arr));
    }
}