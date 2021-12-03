/*abstract
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1: 1 <= nums.length <= 10^4
2: -10^9 <= nums[i] <= 10^9
Sample Input
3
1
2
1
Sample Output
3
2
-1
2
*/

import java.io.*;
import java.util.*;

class next_greater_element_two {
    public static int[] nextGreaterElementII(int[] nums) {
        int [] ans = new int[nums.length];
        Arrays.fill(ans, Integer.MAX_VALUE);
        Stack<Integer> s = new Stack<>();

        for(int idx = 0;idx<2;idx++){
            int i = 0;
            // if(idx == 0){
                s.push(i);
                i+=1;
            // }

            while(!s.empty() && nums[s.peek()] < nums[i]){
                ans[s.pop()] = nums[i];
            }

            if(ans[i] == Integer.MAX_VALUE){
                s.push(i);
            }
            i++;
        }
        return ans;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int nums[] = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(read.readLine());
        }
        
        int ans[] = nextGreaterElementII(nums);

        n = ans.length;

        System.out.println(n);
        for(int e: ans){
            System.out.println(e);
        }
        
    }
}