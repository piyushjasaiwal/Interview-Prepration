/*abstract
1. Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
2. Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
3. It is guaranteed that there will be an answer.
Input Format
Input is managed for you
Output Format
Output is managed for you
 
Question Video

  COMMENTConstraints
1 <= nums.length <= 5 * 10^4
1 <= nums[i] <= 10^6
nums.length <= threshold <= 10^6
Sample Input
4
1 2 5 9
6
Sample Output
5
*/

import java.util.*;
import java.io.*;

class find_smallest_divisor_given_the_threshgold {
    public static int findSmallestDivisor(int[]nums,int th) {
        //write your code here
        int min = 1;
        int max = -1;

        for(int val : nums){
            max = Math.max(max, val);
        }
        int ans = -1;
        while(min <= max){
            int mid = (min+max)/2;
            if(is_possible(nums, th, mid)){
                ans = mid;
                max = mid-1;
            }else{
                min = mid+1;
            }
        }

        return ans;
    }

    private static boolean is_possible(int[] nums, int th, int divisor) {
        int sum = 0;
        for(int val : nums){
            sum += Math.ceil((val*1.0)/divisor);
        }

        return sum <=th;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]nums = new int[n];

        for(int i=0 ; i < n ; i++) {
            nums[i] = scn.nextInt();
        }

        int th = scn.nextInt();

        int speed = findSmallestDivisor(nums,th);
        System.out.println(speed);
    }
}