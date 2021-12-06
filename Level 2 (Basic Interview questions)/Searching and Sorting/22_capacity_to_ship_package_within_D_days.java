/*abstract
1. A conveyor belt has packages that must be shipped from one port to another within D days.
2. The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
3. Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1 <= days <= weights.length <= 5 * 10^4
1 <= weights[i] <= 500
Sample Input
10
2 3 4 1 5 6 7 9 8 10
5
Sample Output
15
*/

import java.util.*;
import java.io.*;

class capacity_to_ship_package_within_D_days {

    public static int shipWithinDays(int[]arr, int days) {
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
            if(is_possible(arr, days, mid)){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
            // System.out.println(ans);
        }

        return ans;
    }

    private static boolean is_possible(int[] arr, int days, int mid) {
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

        return cnt <= days;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for (int i = 0; i < n; i++) {
        arr[i] = scn.nextInt();
        }

        int days = scn.nextInt();

        int ans = shipWithinDays(arr, days);
        System.out.println(ans);
    }
}