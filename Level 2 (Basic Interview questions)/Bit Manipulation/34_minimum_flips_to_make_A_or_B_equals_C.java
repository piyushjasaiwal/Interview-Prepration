/*abstract
Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.

 

Example 1:



Input: a = 2, b = 6, c = 5
Output: 3
Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)
Example 2:

Input: a = 4, b = 2, c = 7
Output: 1
Example 3:

Input: a = 1, b = 2, c = 3
Output: 0
 

Constraints:

1 <= a <= 10^9
1 <= b <= 10^9
1 <= c <= 10^9
*/

class minimum_flips_to_make_A_or_B_equals_C{
    public static void main(String[] args) {
        System.out.println(new Solution().minFlips(2,6,5));
    }

    static class Solution {
        public int minFlips(int a, int b, int c) {
            int cnt = 0;
            for(int i = 0;i<32;i++){
                int mask = (1<<i);
                int bit_c = (mask & c) > 0 ? 1 : 0;
                int bit_a = (mask & a) > 0 ? 1 : 0;
                int bit_b = (mask & b) > 0 ? 1 : 0;

                int or_bit = bit_a|bit_b;

                if(or_bit != bit_c){
                    if(bit_c == 0 && bit_a == 1 && bit_b == 1){
                        cnt+=2;
                    }else if(bit_c == 0 && (bit_a == 1 || bit_b == 1)){
                        cnt+=1;
                    }else if(bit_c == 1 && bit_a == 0 && bit_b == 0){
                        cnt+=1;
                    }
                }
            }
            return cnt;
        }
    }
}