/*
1. Given an integer array 'nums' sorted in non-decreasing order.
2. Return an array of the squares of each number sorted in non-decreasing order.
Input Format
nums = [-4,-1,0,3,10]
Output Format
[0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Question Video

  COMMENTConstraints
1. 1 <= nums.length <= 10^4
2. -10^4 <= nums[i] <= 10^4
3. 'nums' is sorted in non-decreasing order.
Sample Input
9
-6 -2 -1 0 1 4 5 7 9
Sample Output
0 1 1 4 16 25 36 49 81
*/
import java.util.*;
class squares_of_sorted_array {
     // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int[] sortedSquares(int[] nums) {
        // write your code here
        int i =0;
        int j = nums.length-1;
        int k = nums.length-1;
        int [] res = new int[nums.length];
        while(i <= j){
            if(Math.abs(nums[i]) > Math.abs(nums[j])){
                res[k] = nums[i]*nums[i];
                i++;
                k--;
            }else{
                res[k] = nums[j]*nums[j];
                j--;
                k--;
            }
        }
        return res;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        
        for(int i = 0; i < n; i++) 
            nums[i] = scn.nextInt();
        
        int[] res = sortedSquares(nums);

        for(int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}

