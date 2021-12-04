/*abstract
1. You are given two strings s1 and s2 containing lowercase english alphabets.
2. You have to find the smallest substring of s1 that contains all the characters of s2.
3. If no such substring exists, print blank string("").
Input Format
Two strings s1 and s2
Output Format
A string
Question Video

  COMMENTConstraints
1 <= length of string s1 and s2 <= 10000
Sample Input
timetopractice
toc
Sample Output
toprac
*/

import java.util.*;

class smallest_substring_of_a_string_containing_all_characters_of_another_string {

	public static String solution(String s1, String s2){
		// write your code here
		int smallest_cnt = Integer.MAX_VALUE;
        String smallest_string = "";

        int [] m2 = make_map(s2);
        int [] m1 = new int[26];
        int i = 0;
        int j = 0;
        while(j<s1.length()){
            while(j<s1.length() && !compare(m1, m2)){
                m1[s1.charAt(j)-'a']++;
                j++;
            }

            if(compare(m1, m2)){
                if(j-i<smallest_cnt){
                    smallest_cnt = Math.min(smallest_cnt, j-i);
                    smallest_string = s1.substring(i, j);
                }
            }

            System.out.println("----------------------------------");
            System.out.println(smallest_cnt);
            System.out.println(smallest_string);
            System.out.println("----------------------------------");

            while(i<=j && compare(m1, m2)){
                m1[s1.charAt(i)-'a']--;
                i++;
            }

            if(compare(m1, m2)){
                if(j-i+1<smallest_cnt){
                    smallest_cnt = Math.min(smallest_cnt, j-i+1);
                    smallest_string = s1.substring(i-1, j);
                }
            }

            System.out.println("----------------------------------");
            System.out.println(smallest_cnt);
            System.out.println(smallest_string);
            System.out.println("----------------------------------");
        }
        System.out.println(smallest_cnt);
        return smallest_string;
	}

    public static int [] make_map(String str){
        int [] ar = new int[26];
        for(int i = 0;i<str.length();i++){
            ar[str.charAt(i)-'a']++;
        }
        return ar;
    }

    public static boolean compare(int [] m1, int [] m2){
        for(int i = 0;i<26;i++){
            if(m1[i] < m2[i]){
                return false;
            }
        }
        return true;
    }

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}
