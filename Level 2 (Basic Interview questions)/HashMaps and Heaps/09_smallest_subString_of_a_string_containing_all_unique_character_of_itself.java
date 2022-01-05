/*abstract
1. You are given a string str.
2. You have to find the smallest window length that contains all the unique characters of the given string.
Input Format
A string
Output Format
A number representing smallest window length that contains all unique characters of the given string.
Question Video

  COMMENTConstraints
1 <= length of string <= 10^6
Sample Input
aabcbcdbca
Sample Output
4
*/

import java.util.*;

class smallest_subString_of_a_string_containing_all_unique_character_of_itselfimport {

	public static int solution(String str){
		// write your code here
		Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<str.length();i++){
            if(!set.contains(str.charAt(i))){
                sb.append(str.charAt(i));
                set.add(str.charAt(i));
            }
        }

		return solution(str, new String(sb)).length();
	}

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

            // System.out.println("----------------------------------");
            // System.out.println(smallest_cnt);
            // System.out.println(smallest_string);
            // System.out.println("----------------------------------");

            while(i<j && compare(m1, m2)){
                m1[s1.charAt(i)-'a']--;
                if(!compare(m1, m2)){
                    if(j-i<smallest_cnt){
                        smallest_cnt = Math.min(smallest_cnt, j-i);
                        smallest_string = s1.substring(i, j);
                    }
                    i++;
                    break;
                }
                i++;
            }

            // if(compare(m1, m2)){
            //     if(j-i+1<smallest_cnt){
            //         smallest_cnt = Math.min(smallest_cnt, j-i+1);
            //         smallest_string = s1.substring(i-1, j);
            //     }
            // }

            // System.out.println("----------------------------------");
            // System.out.println(smallest_cnt);
            // System.out.println(smallest_string);
            // System.out.println("----------------------------------");
        }
        // System.out.println(smallest_cnt);
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
		String str = scn.next();
		System.out.println(solution(str));
	}

}
