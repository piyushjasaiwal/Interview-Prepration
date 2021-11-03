/*abstract
1. Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
2. Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
3. Given the sorted rotated array nums of unique elements, return the minimum element of this array.
4. You must write an algorithm that runs in O(log n) time.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
All the integers of nums are unique.
nums is sorted and rotated between 1 and n times.
Sample Input
6
5 6 1 2 3 4
Sample Output
1
*/

import java.util.*;

class find_minimum_in_sorted_array {

    public static int findMinimum(int[]arr) {
        //write your code here
        int lo = 0;
        int hi = arr.length-1;
        int min = Integer.MAX_VALUE;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(arr[lo] <= arr[mid]){
                min = Math.min(min, arr[lo]);
                lo = mid+1;
            }else if(arr[mid] <= arr[hi]){
                min = Math.min(min, arr[mid]);
                hi = mid-1;
            }
        }

        return min;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = findMinimum(arr);
        System.out.println(ans);
    }
}