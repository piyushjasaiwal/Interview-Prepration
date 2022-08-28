/*
 * 1. You are given two strings s1 and s2.
2. You have to determine if they are isomorphic or not.
3. Two strings are called isomorphic if -
   -> Every character of s1 can be mapped with characters of s2.
   -> A character of s1 can be mapped to only one character.
   -> All occurrences of a character must be replaced with another character while preserving the order of characters.

Note -> Length of s1 is equal to the length of s2.
Input Format
Two strings s1 and s2
Output Format
true/false
Question Video

  COMMENTConstraints
1 <= length of strings <= 1000
Sample Input
pepcoding
sosherlok
Sample Output
false
 */

import java.util.*;

class isomorphic_strings {

	public static boolean isIsomorphic(String s, String t) {
		// write your code here
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

		if(s.length() != t.length()){
			return false;
		}

		for(int i = 0;i<s.length();i++){
			char ch1 = s.charAt(i);
			char ch2 = t.charAt(i);

			if(map1.containsKey(ch1)){
				if(map1.get(ch1) != ch2){
					return false;
				}
			}

			if(map2.containsKey(ch2)){
				if(map2.get(ch2) != ch1){
					return false;
				}
			}

			map1.put(ch1, ch2);
			map2.put(ch2, ch1);
		}

		return true;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String A = scn.next();
		String B = scn.next();
		System.out.print(isIsomorphic(A, B));
	}

}
