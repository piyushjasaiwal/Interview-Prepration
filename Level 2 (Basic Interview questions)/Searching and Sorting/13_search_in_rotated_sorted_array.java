/*abstract
1. There is an integer array nums sorted in ascending order (with distinct values).
2. nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
3. Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
4. You must write an algorithm with O(log n) runtime complexity.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
All values of nums are unique.
nums is guaranteed to be rotated at some pivot.
-10^4 <= target <= 10^4
Sample Input
7
4 5 6 7 0 1 2
1
Sample Output
5
*/

import java.util.*;
import java.io.*;

class search_in_rotated_sorted_array {

    public static int find(int[]arr,int target) {
        //write your code here
        int lo = 0;
        int hi = arr.length-1;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            if(arr[mid] == target){
                return mid;
            }
            if(arr[lo] <= arr[mid]){
                if(arr[lo] <= target && arr[mid] > target){
                    hi = mid-1;
                }else{
                    lo = mid+1;
                }
            }else if(arr[hi] >= arr[mid]){
                if(arr[mid] < target && arr[hi] >= target){
                    lo = mid+1;
                }else{
                    hi = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]arr = new int[n];

        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();
        int ans = find(arr,target);
        System.out.println(ans);
    }
}