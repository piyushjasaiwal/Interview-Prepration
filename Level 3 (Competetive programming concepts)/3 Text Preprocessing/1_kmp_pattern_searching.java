/*
1. You are given two strings s1 and s2.
2. s1 represents a text and s2 represents a pattern. 
3. You have to print the starting index for all occurrences of the pattern in the given text string.
Input Format
Two strings s1 and s2 in two different lines.
Output Format
Starting index for all occurrences of the pattern in the given text string.
Question Video

  COMMENTConstraints
1 <= length of the strings <= 10^4
Sample Input
abab
ab
Sample Output
0
2
*/

import java.io.*;
import java.util.*;

class kmp_pattern_searching {

  public static void solution(String txt, String pat) {
    // write your code here
    int [] lps = make_lps_array(pat);
    int i = 0, j = 0;
    while(i<txt.length()){
        if(pat.charAt(j) == txt.charAt(i)){
            j++;
            i++;
        }
        if(j == pat.length()){
            System.out.println(i-pat.length());
            j = lps[j-1];
        }else if(i < txt.length() && pat.charAt(j) != txt.charAt(i)){
            if(j != 0){
                j = lps[j-1];
            }else{
                i+=1;
            }
        }
    }
    System.out.println();
  }
  
  private static int[] make_lps_array(String pat) {
    int [] lps = new int[pat.length()];
    lps[0] = 0;
    for(int i = 1;i<pat.length();i++){
        int j = lps[i-1];
        while(j > 0 && pat.charAt(j) != pat.charAt(i)){
            j = lps[j-1];
        }

        if(pat.charAt(j) == pat.charAt(i)){
            j+=1;
        }

        lps[i] = j;
    }

    return lps;
}

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.nextLine();
    String s2 = scn.nextLine();
		solution(s1, s2);
	}

}