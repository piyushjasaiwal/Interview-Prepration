/*abstract
1. You are given a string.
2. You have to find the count of valid substrings of the given string.
3. Valid substring is defined as a substring that has all unique characters.
Input Format
A string
Output Format
A number representing the count of substrings having all unique characters.
Question Video

  COMMENTConstraints
1 <= length of string <= 10^5
Sample Input
aabcbcdbca
Sample Output
24
*/

import java.util.*;

class count_of_substring_having_all_unique_characters {

	public static int solution(String str) {
		// write your code here

		int i = 0;
		int j = 0;

		int ans = 0;

		int [] freqMap = new int[26];

		while(j<str.length()){
			while(j<str.length()){
				freqMap[str.charAt(j) - 'a']++;
				if(!isValid(freqMap)){
					j++;
					break;
				}else{
					int len = (j-i+1);
					ans += len;
					j++;
				}
			}

			while(i<j){
				freqMap[str.charAt(i)-'a']--;
				if(isValid(freqMap)){
					int len = (j-i-1);
					ans += len;
					i++;
					break;
				}else{
					i++;
				}
			}
		}
        
		return ans;
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