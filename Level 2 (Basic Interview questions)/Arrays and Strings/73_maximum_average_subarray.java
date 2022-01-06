/*abstract
Given a list of Integers(array) & a number K.
Task is to "Find MAXIMUM AVERAGE of Contiguous subarray of size k."

Example 1 : 
    Nums : [-10,5,-6,8,-7,2,-4,8,-6,7] , K : 3
    Output : 3.0
    Explanation : average of 8,-6,7 is maximum

Example 2 : 
    Nums : [1,2,-3,-4,5,-6] , K = 2
    Output : 1.5
Input Format
A number n(representing number of Integers)
Ele1
Ele2
Ele3
...
Elen (n more integer inputs)
A number k
NOTE : Input is handled for you.
Output Format
Find MAXIMUM AVERAGE of Contiguous subarray of size k.
(Output Format is handled for you.)
Question Video

  COMMENTConstraints
1. 0 < n(Number of Integers) <= 10^5
2. 0 <= k <= n
Sample Input
10
-10 5 -6 8 -7 2 -4 8 -6 7
3
Sample Output
3.0
*/

import java.util.Scanner;

class maximum_average_subarray {
    public static double solution(int nums[], int k) {
        // write your code here
        int sum = 0;

        double ans = Double.MIN_VALUE;

        for(int i = 0;i<k;i++){
            sum += nums[i];
        }

        double average = (sum*1.0)/k;
        // System.out.println(average);
        ans = Math.max(ans, average);

        for(int i = k;i<nums.length;i++){
            sum = (sum-nums[i-k]+nums[i]);
            average = (sum*1.0)/k;
            ans = Math.max(ans, average);
            // System.out.println(average);
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int nums[] = new int[n];
        for (int i = 0 ; i < n ; i++) {
            nums[i] = scn.nextInt();
        }
        int k = scn.nextInt();

        System.out.println(solution(nums, k));
    }
}