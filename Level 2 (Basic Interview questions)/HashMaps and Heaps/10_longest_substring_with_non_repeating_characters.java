/*abstract
1. You are given a string.
2. You have to find the length of the longest substring of the given string that contains all non-repeating characters.
Input Format
A string
Output Format
A number representing the length of longest substring with unique characters.
Question Video

  COMMENTConstraints
1 <= length of string <= 10^5
Sample Input
aabcbcdbca
Sample Output
4
*/

import java.util.*;

class longest_substring_with_non_repeating_characters {

	public static int solution(String str) {
		// write your code here
		int i = 0;
        int j = 0;

		int [] freqMap = new int[26];
		int max = 0;

        while(j<str.length()){
            while(j < str.length() && isValid(freqMap)){
				freqMap[str.charAt(j)-'a']++;
				if(!isValid(freqMap)){
					j++;
					break;
				}else{
					max = Math.max(max, j-i+1);
					j++;
				}
			}

			while(i<j && !isValid(freqMap)){
				freqMap[str.charAt(i)-'a']--;
				i++;
			}

        }

		return max;
	}
	
	private static boolean isValid(int[] freqMap) {
		for(int val:freqMap){
			if(val > 1){
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
