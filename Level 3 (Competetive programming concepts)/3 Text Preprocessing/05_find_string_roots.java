/*
In mathematics, the N-th root of a number M, is a number K such that K^N=M, i.e. KKK...K=M where k is multiplied N times.
Given a string S you have to find the maximum N such that the N-th root of S exists.
For ex :
If S= "sumsumsumsum",  for N=2 the string T="sumsum" is the N-th root of S, While for N=4 its N-th root is T= "sum".  
The actual answer would be 4, because there is no N-th root of S="sumsumsumsum" for N>4.

Note that for N=1 any string S is the N-th root of itself.
Input Format
One line containing a non empty string S.
Output Format
Output a single line with the greatest integer N such that there exists a string T that concatenated N times is equal to S.
Question Video

  COMMENTConstraints
1<= length of string <= 10^5
Sample Input
sumsumsumsum
Sample Output
4
*/

import java.io.*;
import java.util.*;

class find_string_roots{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String st = br.readLine();
        solution(st);
        br.readLine();
	}


    public static void solution(String st) {
        // write your code here
        int []lps = lps_array(st);
        if((st.length()%(st.length() - lps[lps.length-1])) == 0){
            int ans = (st.length()/(st.length() - lps[lps.length-1]));
            System.out.println(ans);
        }       
    }

    public static int[] lps_array(String str){
        int [] lps = new int[str.length()];

        for(int i = 1;i<str.length();i++){
            int j = lps[i-1];
            while(j > 0 && str.charAt(j) != str.charAt(i)){
                j = lps[j-1];
            }
            if(str.charAt(j) == str.charAt(i)){
                j++;
            }
            lps[i] = j;
        }
        return lps;
    }

}