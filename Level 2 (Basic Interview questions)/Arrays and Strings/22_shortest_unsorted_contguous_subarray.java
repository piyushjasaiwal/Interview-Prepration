/*
Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

 

Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [1]
Output: 0
 

Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105
*/

import java.util.Arrays;

class shortest_unsorted_contguous_subarray {
    public int findUnsortedSubarray_in_O_N_Space(int[] nums) {
        int [] extra = Arrays.copyOf(nums, nums.length);
        Arrays.sort(extra);

        int left = 0;
        int right = nums.length-1;
        while(left < nums.length && nums[left] == extra[left]){
            left++;
        }

        while(right >= 0 && nums[right] == extra[right]){
            right--;
        }

        if(left >= right){
            return 0;
        }
        return right-left+1;
    }

    public int findUnsortedSubarray(int[] nums) {
        int left = -1;
        int max = In
    }

    

    public static void main(String[] args) {
        System.out.println(new shortest_unsorted_contguous_subarray().findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
    }
}