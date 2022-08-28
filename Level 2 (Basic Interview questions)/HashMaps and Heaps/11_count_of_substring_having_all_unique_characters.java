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
		int ans = 0;
		int i = -1;
		int j = -1;
		HashMap<Character, Integer> map = new HashMap<>();
		while(true){
			boolean f1 = false;
			boolean f2 = false;

			while(i < str.length()-1){
				i++;
				f1 = true;
				map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
				if(map.get(str.charAt(i)) == 2){
					break;
				}else{
					ans+=(i-j);
				}
			}

			while(j<i){
				j++;
				f2 = true;
				
				map.put(str.charAt(j), map.get(str.charAt(j))-1);
				if(map.get(str.charAt(j)) == 1){
					ans += (i-j);
					break;
				}
			}

			
			if(f1 == false && f2 == false){
				break;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}
}