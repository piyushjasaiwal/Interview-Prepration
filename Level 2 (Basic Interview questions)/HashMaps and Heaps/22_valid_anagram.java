/*abstract
1. You are given two strings s1 and s2.
2. You have to determine if s2 is an anagram of s1.
Input Format
Two strings s1 and s2
Output Format
true/false
Question Video

  COMMENTConstraints
1 <= length of string <= 10^5
Sample Input
pepcoding
codingpep
Sample Output
true
*/

import java.util.*;

class valid_anagram {
	
	public static boolean solution(String s1, String s2){
		// write your code here

        int [] m1 = make_map(s1);
        int [] m2 = make_map(s2);

        for(int i = 0;i<m1.length;i++){
            if(m1[i] != m2[i]){
                return false;
            }
        }
		return true;
	}

    public static int [] make_map(String str){
        int [] map = new int[26];
        for(int i = 0;i<str.length();i++){
            map[str.charAt(i)-'a']++;
        }
        return map;
    }


	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}
