/*abstract
1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
2. You are required to generate and print all ways you can select k characters out of the word.

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
Input is managed for you
Output Format
Check the sample ouput and question video. 
Question Video

Constraints
0 < str.length() < 15
0 < k <= str.length()
Sample Input
aabbbccdde
3
Sample Output
aab
aac
aad
aae
abb
abc
abd
abe
acc
acd
ace
add
ade
bbb
bbc
bbd
bbe
bcc
bcd
bce
bdd
bde
ccd
cce
cdd
cde
dde
*/

import java.io.*;
import java.util.*;

class word_k_selections_three {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> unique = new HashMap<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.containsKey(ch) == false) {
                unique.put(ch, 1);
                ustr += ch;
            } else {
                unique.put(ch, unique.get(ch) + 1);
            }
        }

        generateWords(0, ustr, 0, k, unique, "");
    }

    public static void generateWords(int idx, String ustr, int cs, int ts, HashMap<Character, Integer> unique, String asf){

        if(cs > ts){
            return ;
        }

        if(cs == ts){
            System.out.println(asf);
            return ;
        }

        if(idx >= ustr.length()){
            return ;
        }

        int cnt = unique.get(ustr.charAt(idx));
        String curr = new String(asf);
        for(int i = 0;i<cnt;i++){
            curr = curr+ustr.charAt(idx);
        }

        for(int j = 1;j<=cnt;j++){
            generateWords(idx+1, ustr, cs+cnt-j+1, ts, unique, curr);
            curr = curr.substring(0, curr.length()-1);
        }
        generateWords(idx+1, ustr, cs, ts, unique, asf);                
    }
}