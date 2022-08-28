// /*1. You are given a string(str) and a number K.
// 2. You have to find the count of valid substrings of the given string.
// 3. Valid substring is defined as a substring that has exactly K unique characters.
// Input Format
// A string
// Output Format
// A number representing count of substrings with exactly K unique characters.
// Question Video

//   COMMENTConstraints
// 1 <= length of string <= 10^5
// 1 <= k <= 26
// Sample Input
// aabcbcdbca
// 2
// Sample Output
// 12 */

// import java.util.*;

// class count_of_substring_with_exactly_k_unique_characters {

// 	public static int solution(String str, int k){
// 		// write your code here
        
//         int is = -1;
//         int ib = -1;
//         int j = -1;
//         HashMap<Character, Integer> maps = new HashMap<>();
//         HashMap<Character, Integer> mapb = new HashMap<>();

//         while(true){
//             while(ib < str.length()-1){
//                 ib++;
//                 char ch = str.charAt(ib);
//                 mapb.put(ch, mapb.get(ch)+1);

//                 if(mapb.size() == k+1){
//                     map.put
//                 }
//             }
//         }
// 	}
	
// 	public static void main(String[] args) {
// 		Scanner scn = new Scanner(System.in);
//         String str = scn.next();
//         int k = scn.nextInt();
// 		System.out.println(solution(str,k));
// 	}

// }
