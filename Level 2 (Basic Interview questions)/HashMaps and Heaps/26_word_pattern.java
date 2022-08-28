/*
 * 1. You are given two strings S1 and S2. S1 represents a word of length N and S2 represents N space-separated words.
2. You have to find if the words in S2 follow the exact order as characters in S1.

Note -> Every string consists of lower-case English letters only.
Input Format
Two strings S1 and S2
Output Format
true/false
Question Video

  COMMENTConstraints
1 <= length of strings <= 1000
Sample Input
abab
pep coding pep coding
Sample Output
true
 */

 import java.io.*;
 import java.util.*;

class word_pattern {
    public static boolean wordPattern(String pattern, String str) {
		// write your code here
		HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        String [] arr = str.split(" ");
        for(int i = 0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            ArrayList<Integer> list = map.getOrDefault(ch, new ArrayList<>());
            if(list.size() == 0){
                if(set.contains(arr[i])){
                    return false;
                }
                set.add(arr[i]);
            }
            list.add(i);
            map.put(ch, list);
        }

        ArrayList<Character> keys = new ArrayList<>(map.keySet());
        for(char key : keys){
            ArrayList<Integer> list = map.get(key);
            for(int i = 1;i<list.size();i++){
                if(arr[list.get(i)].compareTo(arr[list.get(0)]) != 0){
                    return false;
                }
            }
        }
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String pattern = scn.nextLine();
		String words = scn.nextLine();
		System.out.println(wordPattern(pattern,words));
	}
}
