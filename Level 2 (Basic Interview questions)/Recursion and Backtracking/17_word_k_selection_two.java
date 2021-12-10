/*abstract
1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
2. You are required to generate and print all ways you can select k distinct characters out of the 
     word.
 
Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.

Input Format
Input is managed for you
Output Format
Check the sample ouput and question video. 
Question Video

  COMMENTConstraints
0 < str.length() < 15
0 < k <= str.length()
Sample Input
aabbbccdde
3
Sample Output
abc
abd
abe
acd
ace
ade
bcd
bce
bde
cde
*/

import java.io.*;
import java.util.*;

class word_k_selection_two {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
        String ustr = "";
        Set<Character> set = new HashSet<>();

        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!set.contains(ch)){
                ustr = ustr + ch;
                set.add(ch);
            }
        }
        

        generateWords(ustr, 0, k, -1, "");
    }

    public static void generateWords(String ustr, int cs, int ts, int lc, String asf){
        if(cs >= ts){
            System.out.println(asf);
            return ;
        }

        for(int i = lc+1;i<ustr.length();i++){
            generateWords(ustr, cs+1, ts, i, asf+ustr.charAt(i));
        }
    }

}