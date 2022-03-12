/*abstract
1. You are given two strings S1 and S2.
2. You have to make these two strings equal by deleting characters. You can delete characters from any of the two strings.
3. The cost of deleting a character from any string is the ASCII value of that character.
4. You have to find the minimum ASCII sum of deleted characters.
Input Format
Two Strings S1 and S2
Output Format
A number representing the minimum ASCII sum of deleted characters.
Question Video

  COMMENTConstraints
1 <= length of strings S1 and S2 <= 1000
Sample Input
sea
eat
Sample Output
231
*/

import java.io.*;
import java.util.*;

class minimum_ascii_delete_sum_of_two_strings {

	public static int solution(String s1, String s2) {
		//write your code here

		return 0;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1, s2));
	}

}