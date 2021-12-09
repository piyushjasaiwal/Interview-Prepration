/*
1. You are given a word (may have one character repeat more than once).
2. You are required to generate and print all arrangements of these characters. 

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
Input is managed for you
Output Format
Check the sample ouput and question video. 
Question Video

  COMMENTConstraints
0 < str.length() <= 4
Sample Input
aabb
Sample Output
aabb
abab
abba
baab
baba
bbaa
*/

import java.io.*;
import java.util.*;

class permutations_words {

    public static void generateWords(int cs, int ts, HashMap<Character, Integer> fmap, String asf) {
      // write your code here

      if(cs > ts){
        System.out.println(asf);
        return ;
      }
      for(Character ch:fmap.keySet()){
        int val = fmap.get(ch);
        if(val > 0){
          fmap.put(ch, val-1);
          generateWords(cs+1, ts, fmap, asf+ch);
          fmap.put(ch, val);
        }
      }
    }

    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String str = br.readLine();

      HashMap<Character, Integer> fmap = new HashMap<>();
      for(char ch: str.toCharArray()){
        if(fmap.containsKey(ch)){
          fmap.put(ch, fmap.get(ch) + 1);
        } else {
          fmap.put(ch, 1);
        }
      }

      generateWords(1, str.length(), fmap, "");
    }

}