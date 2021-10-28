/*
1. Given a string s.
2. Return true if the s can be palindrome after deleting at most one character from it.
Input Format
s = "abca"
Output Format
true
Explanation: You could delete the character 'c'.
Question Video

  COMMENTConstraints
1. 1 <= s.length <= 10^5
2. s consists of lowercase English letters.
Sample Input
abca
Sample Output
true
*/

import java.util.*;

class valid_palindrome_2 {

    // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~
    public static boolean validPalindrome(String s) {
        // write your code here
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return is_palindrome(s, i+1, j) || is_palindrome(s, i, j-1);
            }
            i++;
            j--;
        }

        return true;
    }

    public static boolean is_palindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        boolean res = validPalindrome(str);
        System.out.println(res);
    }
}