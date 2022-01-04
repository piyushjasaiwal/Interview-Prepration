/*abstract
Given a string s, Your task is, for any prefix of string s which matches a suffix of string s, print the number of times it occurs in string s as a substring.
Expected Complexity: O(n)
Input Format
The first line contains string s.
Output Format
In the first line, print integer k (0<=k<=|s|) - the number of prefixes that match a suffix of string s. Next print k lines, in each line print two integers li ci. Numbers li ci mean that the prefix of the length li matches the suffix of length li and occurs in string s as a substring ci times. Print pairs li ci in the order of increasing li.
Question Video

  COMMENTConstraints
1<= s.length() <= 10^5
Sample Input
ABABABAB
Sample Output
4
2 4
4 3
6 2
8 1
*/

import java.io.*;

class prefix_and_suffix_count {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int [] lps = new int[str.length()];

        lps[0] = 0;
        int i = 1;

        int cnt = 0;

        while(i<str.length()){
            int j = lps[i-1];
            while(j>0 && str.charAt(i) != str.charAt(j)){
                j = lps[j-1];
            }

            if(str.charAt(i) == str.charAt(j)){
                j++;
            }

            lps[i] = j;
            i++;
        }

        for(int val:lps){
            System.out.print(val+" ");
        }
	}
}
