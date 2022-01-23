// to be done
/*abstract
You are given a string s. An awesome substring is a non-empty substring of s such that we can make any number of swaps in order to make it a palindrome.

Return the length of the maximum length awesome substring of s.

 

Example 1:

Input: s = "3242415"
Output: 5
Explanation: "24241" is the longest awesome substring, we can form the palindrome "24142" with some swaps.
Example 2:

Input: s = "12345678"
Output: 1
Example 3:

Input: s = "213123"
Output: 6
Explanation: "213123" is the longest awesome substring, we can form the palindrome "231132" with some swaps.
 

Constraints:

1 <= s.length <= 105
s consists only of digits.
*/

class longest_awesome_substring{
    public static void main(String[] args) {
        System.out.println(new Solution().longestAwesome("213123"));
    }
    
    static class Solution {
        public int longestAwesome(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }

            int max = 1;
            int i = 0;
            int [] visited = new int[10];
            while(i<s.length()){
                int cnt = 0;
                while(i < s.length() && visited[s.charAt(i)-'0'] > 0){
                    visited[s.charAt(i)-'0']--;
                    cnt++;
                    i++;
                }

                if(i < s.length()){
                    cnt = (2*cnt)+1;
                    visited[s.charAt(i)-'0']++;
                }else{
                    cnt = 2*cnt;
                }

                max = Math.max(cnt, max);
                i++;
            }

            return max;
        }
    }

}
