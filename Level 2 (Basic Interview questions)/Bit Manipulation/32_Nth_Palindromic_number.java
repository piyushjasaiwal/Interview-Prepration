/*abstract
1. You are given an integer N.
2. You have to find the N-th number whose binary representation is a palindrome.

Note -> First binary number whose representation is a palindrome is 1.
Input Format
A number N
Output Format
Check the sample output and question video.
Question Video

  COMMENTConstraints
1 <= n <= 2*10^4
Sample Input
17
Sample Output
85
*/

import java.util.*;

class Nth_Palindromic_number {

    public static int NthPalindromicBinary(int n) {
        //write your code here
        int len = 1;
        int count = 1;

        while(count < n){
            len++;
            count += (1<<(len-1)/2);
        }

        count -= (1<<(len-1)/2);

        int offSet = n-count-1;

        int ans = (1<<len-1);
        ans |= (offSet<<len/2);

        int valForRev = ans >> (len/2);

        ans = ans | reverse(valForRev);
        return ans;
    }

    private static int reverse(int n) {
        int ans = 0;
        int mask = 1;
        while(mask <= n){
            int cBit = (mask&n) > 0 ? 1: 0;
            ans = (ans<<1)|cBit;
            mask = mask<<1;
        }
        return ans;
    }



    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(NthPalindromicBinary(n));
    }

}