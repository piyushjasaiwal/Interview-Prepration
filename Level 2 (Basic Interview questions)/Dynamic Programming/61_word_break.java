/*
1. You are given n space-separated strings, which represents a dictionary of words.
2. You are given another string that represents a sentence.
3. You have to determine if this sentence can be segmented into a space-separated sequence of one or more dictionary words.
Input Format
A number n 
n strings representing words
A string representing a sentence
Output Format
Check the sample ouput and question video.
Question Video

Constraints
1 <= number of words <= 10
1 <= length of each word <= 15
1 <= length of sentence <= 1000
Sample Input
2
pep coding
pepcoding
Sample Output
true
*/

import java.util.*;
import java.io.*;

class word_break {
    public static boolean solution(String sentence, HashSet<String> dictionary) {
		//write your code here

		return false;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashSet<String> dictionary = new HashSet<String>();
		for (int i = 0; i < n; i++) {
			dictionary.add(scn.next());
		}
		String sentence = scn.next();
		System.out.println(solution(sentence, dictionary));
	}
}
