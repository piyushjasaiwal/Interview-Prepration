/*abstract
1. You are given two strings s1, s2, and a number K.
2. You have to find if two strings are K-anagrams of each other or not.
3. Two strings are called K-anagrams if 
   -> Both s1 and s2 have the same number of characters.
   -> After changing K characters in any string, s1 and s2 become anagram of each other. 

Note -> Both s1 ad s2 consist of lowercase English letters only.
Input Format
Two strings s1 and s2
A number K
Output Format
true/false
Question Video

  COMMENTConstraints
1 <= length of string s1 and s2 <= 20,000
1 <= K <= length of strings
Sample Input
fodr 
gork
2
Sample Output
true
*/

import java.util.*;

class K_anagrams {
	public static boolean areKAnagrams(String str1, String str2, int k) {
		// write your code here

        if(str1.length() != str2.length()){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0;i<str1.length();i++){
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0)+1);
        }

        int cnt = 0;
        for(int i = 0;i<str2.length();i++){
            if(!map.containsKey(str2.charAt(i)) || map.get(str2.charAt(i)) == 0){
                cnt+=1;
            }else{
                map.put(str2.charAt(i), map.get(str2.charAt(i))-1);
            }
        }

        return cnt<=k;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String str1 = s.next();
		String str2 = s.next();
		int k = s.nextInt();
		System.out.println(areKAnagrams(str1, str2, k));

	}

}
