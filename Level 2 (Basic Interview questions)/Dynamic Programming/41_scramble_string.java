/*abstract
1. You are given two strings s1 and s2.
2. A string can be represented as a binary tree by partitioning it to two non-empty substrings recursively.
3. If you choose any non-leaf node and swap its two children, then the string formed is the scramble of the original string.
4. You have to determine if s2 is a scrambled string of s1.

Input Format
2 strings s1 and s2
Output Format
Check the sample output and question video.
Question Video

  COMMENTConstraints
1 < length of strings <= 100
Sample Input
great
rgeat
Sample Output
true
*/

import java.io.*;
import java.util.*;

class scramble_string {

	public static boolean isScrambleTab(String s1, String s2) {
		//write your code here
		
		return false;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(isScrambleTab(s1,s2));
	}

}