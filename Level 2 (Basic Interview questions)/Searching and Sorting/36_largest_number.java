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

    static class comp implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            // TODO Auto-generated method stub
            String n1 = o1+o2;
            String n2 = o2+o1;
            return n1.compareTo(n2);
        }

    }

    public static String largestNumber(int[]n) {
        //write your code here
        String [] nums = new String[n.length];
        int i = 0;
        for(int val:n){
            nums[i] = val+"";
            i++;
        }
        Arrays.sort(nums, new comp());
        String ans = "";
        for(i = nums.length-1;i>=0;i--){
            ans = ans+nums[i];
        }
        return ans;
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