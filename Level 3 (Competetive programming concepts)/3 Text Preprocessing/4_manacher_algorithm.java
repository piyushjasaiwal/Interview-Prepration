/*
1. You are given one string s1.
2. You have to find the longest palindromic substring in s1.
3. Expected Complexity : O(n)
Input Format
one string s1
Output Format
Print the length of the longest palindrome substring in the first line. In the second line print the longest palindromic substring in s1. If there is more than one palindromic substring with the maximum length, output the first one.
Question Video

  COMMENTConstraints
1 <= length of the string <= 10^5
Sample Input
abadxd
Sample Output
3
aba
*/

import java.util.*;

class manacher_algorithm {

    public static void solution_O_nSquared(String s1) {
    // write your code here
        int ans = 0;
        String str = "";
        for(int i = 0;i<s1.length();i++){
            int l = i-1;
            int r = i+1;
            while(l >= 0 && r < s1.length() && s1.charAt(l) == s1.charAt(r)){
                l--;
                r++;
            }
            int temp = r-l-1;
            if(temp > ans){
                ans = temp;
                str = s1.substring(l+1, r);
            }
        }
        System.out.println(ans);
        System.out.println(str);
    }

    // private static void solution_O_N(String s1) {

    // }
  
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        if(s1.length()%2 == 0){
            s1 = s1+'$';
        }
        solution_O_nSquared(s1);
        System.out.println();
    }

}