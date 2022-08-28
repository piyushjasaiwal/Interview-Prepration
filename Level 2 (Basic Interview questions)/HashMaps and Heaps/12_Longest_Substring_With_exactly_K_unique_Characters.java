/*
1. You are given a string(str) and a number K.
2. You have to find length of the longest substring that has exactly k unique characters.
3. If no such substring exists, print "-1".
Input Format
A string
Output Format
A number representing length of the longest K unique characters substring.
Question Video

  COMMENTConstraints
1 <= length of string <= 10^5
1 <= k <= 26
Sample Input
aabcbcdbca
2
Sample Output
4
*/

import java.util.*;

class Longest_Substring_With_exactly_K_unique_Characters {

	public static int solution(String str, int k){
		// write your code here
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        int ans = -1;
        while(true){
            boolean f1 = false;
            boolean f2 = false;

            while(i < str.length()-1){
                f1 = true;
                i++;
                map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
                if(map.size() < k){
                    continue;
                }else if(map.size() == k){
                    ans = Math.max(ans, i-j);
                }else{
                    break;
                }
            }

            while(j < i){
                f2 = true;
                j++;
                map.put(str.charAt(j), map.get(str.charAt(j))-1);
                if(map.get(str.charAt(j)) == 0){
                    map.remove(str.charAt(j));
                }

                if(map.size() > k){
                    continue;
                }else if(map.size() == k){
                    ans = Math.max(ans, i-j);
                    break;
                }else{
                    break;
                }
            }

            if(!f1 && !f2){
                break;
            }
        }
        
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}
