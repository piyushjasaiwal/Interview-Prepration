/*
1. You are given two strings s1 and s2.
2. You have to find the count of s2's anagrams that are present in s1.
3. Also, you have to print the start indices of such anagrams in s1.

Note -> Both s1 ad s2 consist of lowercase English letters only.
Input Format
Two strings s1 and s2
Output Format
A number(x) representing count of s2's anagrams which are present in s1.
X space separated numbers representing start indices of anagrams.
Question Video

  COMMENTConstraints
1 <= length of string <= 20,000
Sample Input
cbaebabacd
abc
Sample Output
2
0 6 
*/

import java.util.*;

class find_all_anagram_in_string {
	public static void findAnagrams(String s, String p) {
        // write your code here
        
        int [] map1 = make_map(p, 0, p.length());
        StringBuilder sb = new StringBuilder();

        int cnt = 0;

        for(int i =0;i<=s.length()-p.length();i++){
            int [] map2 = make_map(s, i, i+p.length());
            if(compare(map1, map2)){
                sb.append(i+" ");
                cnt++;
            }
        }

        System.out.println(cnt);
        System.out.println(sb);
	}

    private static boolean compare(int[] map1, int[] map2) {
        for(int i = 0;i<map1.length;i++){
            if(map1[i] != map2[i]){
                return false;
            }
        }
        return true;
    }

    public static int [] make_map(String str, int start, int end){
        int [] map = new int[26];
        for(int i = start;i<end;i++){
            map[str.charAt(i)-'a']++;
        }
        return map;
    }

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String p = scn.next();
		findAnagrams(s, p);
	}

}

