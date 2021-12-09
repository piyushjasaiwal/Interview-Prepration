/*abstract
1. You are given a word (may have one character repeat more than once).
2. You are required to generate and print all arrangements of these characters. 

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't force you but the intention is to teach a concept. Play in spirit of the question.
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

class permutation_words_two {

    public static void generateWords(int cc, String str, char[] spots, HashMap<Character, Integer> lastOccurence) {
        // write your code here

        if(cc >= str.length()){
            System.out.println(new String(spots));
            return ;
        }

        char ch = str.charAt(cc);
        int last_occur = lastOccurence.get(ch);
        for(int pos = last_occur+1; pos<str.length();pos++){
            if(spots[pos] == '/'){
                spots[pos] = ch;
                lastOccurence.put(ch, pos);
                generateWords(cc+1, str, spots, lastOccurence);
                lastOccurence.put(ch, -1);
                spots[pos] = '/';
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char[] spots = new char[str.length()];
        Arrays.fill(spots, '/');
        HashMap<Character, Integer> lastOccurence = new HashMap<>();
        for(char ch: str.toCharArray()){
            lastOccurence.put(ch, -1);
        }

        generateWords(0, str, spots, lastOccurence);
    }

}