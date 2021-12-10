/*abstract
1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all k length words (of distinct chars) by using chars of the word.

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't force you but the intention is to teach a concept. Play in spirit of the question.
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
acb
adb
aeb
acd
ace
adc
aec
ade
aed
bac
bad
bae
cab
dab
eab
cad
cae
dac
eac
dae
ead
bca
bda
bea
cba
dba
eba
cda
cea
dca
eca
dea
eda
bcd
bce
bdc
bec
bde
bed
cbd
cbe
dbc
ebc
dbe
ebd
cdb
ceb
dcb
ecb
deb
edb
cde
ced
dce
ecd
dec
edc
*/

import java.io.*;
import java.util.*;

class words_K_length_words_one {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.contains(ch) == false) {
                unique.add(ch);
                ustr += ch;
            }
        }

        generateWords(ustr, 0, k, "", new HashSet<>());
    }

    public static void generateWords(String ustr, int cs, int ts, String asf, HashSet<Character> occupied){
        if(cs == ts){
            System.out.println(asf);
            return ;
        }

        if(cs > ts){
            return ;
        }

        for(int i = 0; i<ustr.length();i++){
            char ch = ustr.charAt(i);
            if(!occupied.contains(ch)){
                occupied.add(ch);
                generateWords(ustr, cs+1, ts, asf+ustr.charAt(i), occupied);
                occupied.remove(ch);
            }
        }

        // generateWords(lcu+1, ustr, cs, ts, asf);
    }

}