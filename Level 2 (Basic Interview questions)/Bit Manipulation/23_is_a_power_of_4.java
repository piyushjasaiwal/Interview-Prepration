/*abstract
Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.

 

Example 1:

Input: n = 16
Output: true
Example 2:

Input: n = 5
Output: false
Example 3:

Input: n = 1
Output: true
 

Constraints:

-2^31 <= n <= 2^31 - 1
 

Follow up: Could you solve it without loops/recursion?
*/

class is_a_power_of_4{
    static class Solution {
        public boolean isPowerOfFour(int n) {
            int mask = 0b10101010101010101010101010101010;
            return n > 0 && ((n&(n-1)) == 0) && ((n&mask)) == 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfFour(-2147483648));
    }
}