/*
Given a list of non-negative integers nums, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1 <= nums.length <= 100
0 <= nums[i] <= 10^9
Sample Input
5
3 30 34 5 9
Sample Output
9534330
*/

import java.util.*;
import java.io.*;

class largest_number {

    public static String largestNumber(int[]nums) {
        //write your code here
        return "";
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scn.nextInt();
        }

        System.out.println(largestNumber(nums));
    }
}