/*abstract
1. Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
2. Write an algorithm to minimize the largest sum among these m subarrays.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1 <= nums.length <= 1000
0 <= nums[i] <= 10^6
1 <= m <= nums.length
Sample Input
5
7 2 5 10 8
2
Sample Output
18
*/

import java.util.*;
import java.io.*;

class split_array_largest_sum {

    public static int splitArray(int[]arr, int m) {
        //write your code here
        int lo = 0;
        int hi = 0;
        int ans = -1;

        for(int val:arr){
            hi += val;
        }

        while(lo <= hi){
            int mid = (lo+hi)/2;
            // System.out.println(mid);
            if(is_possible(arr, m, mid)){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
            // System.out.println(ans);
        }

        return ans;
    }

    private static boolean is_possible(int[] arr, int m, int mid) {
        int cnt = 1;
        int i = 0;
        int sum = 0;
        while(i<arr.length){
            if(arr[i] > mid){
                return false;
            }
            if(sum+arr[i] <= mid){
                sum += arr[i];
            }else{
                sum = arr[i];
                cnt+=1;
            }
            i++;
        }

        return cnt <= m;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for (int i = 0; i < n; i++) {
        arr[i] = scn.nextInt();
        }

        int m = scn.nextInt();

        int ans = splitArray(arr, m);
        System.out.println(ans);
    }
}