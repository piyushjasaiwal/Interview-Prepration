/*
1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
2. You are required to generate and print all ways you can select k distinct characters out of the 
     word.

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
acd
ace
ade
bcd
bce
bde
cde
*/

import java.util.*;

class words_k_selection_one {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int k = scn.nextInt();

        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.contains(ch) == false) {
                unique.add(ch);
                ustr += ch;
            }
        }

        combination(0, ustr, 0, k, "");
        scn.close();
    }


    public static void combination(int i, String ustr, int ssf, int ts, String asf ) {

        if(i>=ustr.length()){
            if(ssf == ts){
                System.out.println(asf);
            }
            return ;
        }

        if(ts > ssf){
            combination(i+1, ustr, ssf+1, ts, asf+ustr.charAt(i));
        }
        combination(i+1, ustr, ssf, ts, asf);
    }
}