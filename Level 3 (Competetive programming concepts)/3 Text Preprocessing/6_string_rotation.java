/*
Three Programmers at Pepcoding invented an amusing game. First Pepcoder thought out a string S and passed it to the Second Pepcoder. The Second Pepcoder executed X (0< X < string length) cyclic shifts ( a cyclic shift is a transfer of the last character of the string to the beginning of this string) with this string. As a result of these operations, a string T was produced, and the Second Pepcoder passed it to the Third Pepcoder. The task of the Third Pepcoder was to find the number X or make sure that the Second Pepcoder was mistaken because the string T could not be produced from the string S via cyclic shifts.

Expected complexity: O(n)
Input Format
The first line contains string S. The second line contains the string T.
Output Format
If the string T can be produced from the string S via cycle shifts you should output the desired number X, otherwise, you should output "-1". If multiple answers exist, output maximum X among them.
Question Video

  COMMENTConstraints
1 <= S.length() <= 100000
Sample Input
pepcodingforlife
forlifepepcoding
Sample Output
7
*/

import java.io.*;

class string_rotation {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		String T = br.readLine();

		Solution(S, T);
	}

	private static void Solution(String s, String t) {
        String str = t+s;
        int [] lps = new int[str.length()];
        for(int i = 1;i<str.length();i++){
            int j = lps[i-1];
            while(j>0 && str.charAt(i) != str.charAt(j)){
                j = lps[j-1];
            }

            if(str.charAt(i) == str.charAt(j)){
                j++;
            }

            lps[i] = j;
        }
        System.out.println(lps[lps.length-1]);
	}
}