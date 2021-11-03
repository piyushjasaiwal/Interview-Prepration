/*abstract
1. Given an ascending sorted rotated array arr of distinct integers of size N. 
2. The array is right rotated K times. 
3. Your task is to find the value of K.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1 <= N <=10^5
1 <= arr[i] <= 10^7
Sample Input
6
5 6 1 2 3 4
Sample Output
2
*/

import java.util.*;

class find_rotation_count {

    public static int findRotationCount(int[]arr) {
        //write your code here
        int lo = 0;
        int hi = arr.length-1;
        int min = Integer.MAX_VALUE;
        int min_idx = -1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(arr[lo] <= arr[mid]){
                if(arr[lo] < min){
                    min = Math.min(min, arr[lo]);
                    min_idx = lo;
                }
                lo = mid+1;
            }else if(arr[mid] <= arr[hi]){
                if(arr[mid] < min){
                    min = Math.min(min, arr[mid]);
                    min_idx = mid;
                }
                hi = mid-1;
            }
        }

        return min_idx;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = findRotationCount(arr);
        System.out.println(ans);
    }
}