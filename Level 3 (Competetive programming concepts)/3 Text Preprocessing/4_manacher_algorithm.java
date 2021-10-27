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

    public static String updatedString(String str){
        StringBuilder sb = new StringBuilder("@");
        for(int i = 0;i<str.length();i++){
            sb.append("#");
            sb.append(str.charAt(i));
        }
        sb.append("#");
        sb.append("$");

        return sb.toString();
    }

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

    private static void solution_O_N(String s1) {
        String update = updatedString(s1);
        int []manacher = new int[update.length()];

        int c = 0;
        int r = 0;

        for(int i = 1;i<update.length()-1;i++){
            int mirror = c - (i-c);
            if(i<r){
                manacher[i] = Math.min(manacher[mirror], r-i);
            } 

            while(update.charAt(i+manacher[i]+1) == update.charAt(i-manacher[i]-1)){
                manacher[i]++;
            }

            if(i+manacher[i] > r){
                c = i;
                r = i+manacher[i];
            }
        }

        int max_len = 0;
        int max_idx = 0;
        for(int i = 1;i<manacher.length-1;i++){
            if(manacher[i] > max_len){
                max_len = manacher[i];
                max_idx = i;
            }
        }

        int first_idx = max_idx - max_len + 1;
        int actual_idx = (first_idx - 2)/2;

        System.out.println(max_len);
        System.out.println(s1.substring(actual_idx, actual_idx+max_len));
    }
  
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        // solution_O_nSquared(s1);
        solution_O_N(s1);
        System.out.println();
    }

}