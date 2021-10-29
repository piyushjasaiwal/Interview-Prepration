/*
Given a string S, print the hash code of that string using Polynomial Hashing.
Note: Use prime number = 31 and print the answer mod 1000000007.
Input Format
The first line contains an integer T denoting the number of test cases.
T lines follow each containing a string S.
Output Format
Print an integer (the hashcode of the string) mod 1000000007 and take prime number 31 for hashing.
Question Video

  COMMENTConstraints
String s consists of only lowercase English alphabets
|S| <= 10^5
Sample Input
6
ab
abc
abcd
abc
xyz
pqr
Sample Output
63
2946
122110
2946
25785
17841
*/

import java.util.*;

class string_polynomial_hashing {
    public static long hashCode(String s) {
        //Write your code here
        // NOTE: use prime number = 31 and mod = 1000000007
        long sum = 0;
        long prod = 1;
        long mod = 1000000007;
        for(int i = 0;i<s.length();i++){
            sum = (sum + (prod *(s.charAt(i)-'a' + 1))%mod)%mod;
            prod = (prod*31)%mod;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        while (T-- > 0) {
            String s = scn.next();
            System.out.println(hashCode(s));
        }
        scn.close();
    }
}
