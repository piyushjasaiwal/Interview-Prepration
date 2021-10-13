/*
1. You are given a string str.
2. You are required to find the character with maximum frequency.
Input Format
A string str
Output Format
The character with highest frequency
Question Video

  COMMENTConstraints
0 < str.length() <= 100
There will be a single character with highest frequency
Sample Input
zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc
Sample Output
q
*/

import java.io.*;
import java.util.*;

class highest_frequency_character {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        String str = s.next();
        char ans = '/';
        int hi = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            int freq = map.get(ch);
            if(freq>hi){
                hi = freq;
                ans = ch;
            }
        }
        System.out.println(ans);
    }

}