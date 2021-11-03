/*abstract
1. Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
2. If target is not found in the array, return [-1, -1].
3. You must write an algorithm with O(log n) runtime complexity.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums is a non-decreasing array.
-10^9 <= target <= 10^9
Sample Input
7
2 2 3 3 3 4 5
3
Sample Output
2 4
*/

import java.util.*;
import java.io.*;

class first_and_last_position_in_sorted_array {

    //return an array of size two, which contains first and last index of target.
    public static int[] find(int[]arr,int target) {
        //write your code here
        int left = -1;

        int lo = 0;
        int hi = arr.length-1;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid] < target){
                lo = mid+1;
            }else{
                left = mid;
                hi = mid-1;
            }
        }

        if(left != -1 && arr[left] != target){
            left = -1;
        }

        int right = -1;

        lo = 0;
        hi = arr.length-1;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid] <= target){
                right= mid;
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }

        if(right != -1 && arr[right] != target){
            right = -1;
        }

        return new int[]{left, right};
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[]arr = new int[n];

        for(int i=0;i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();

        int[]ans = find(arr,target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}