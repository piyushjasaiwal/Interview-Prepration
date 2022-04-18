/*abstract
Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
3 <= nums.length <= 10^4
1 <= nums[i] <= 10^6
Sample Input
4
3 6 2 3
Sample Output
8
*/

import java.util.*;
import java.io.*;

class largest_perimeter_triangle {
    public static int largestPerimeter(int[]nums) {
        //write your code here
        Arrays.sort(nums);
        for(int i = nums.length-1;i>=2;i--){
            if(nums[i-1]+nums[i-2] > nums[i]){
                return nums[i]+nums[i-1]+nums[i-2];
            }
        }
        return 0;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scn.nextInt();
        }

        System.out.println(largestPerimeter(nums));
    }
}