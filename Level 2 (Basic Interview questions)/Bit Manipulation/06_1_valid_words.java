/*
1. You are given N number of words.
2. You are given M puzzles in the form of M strings.
3. For a given puzzle, a word is valid if both the following conditions are confirmed - 
    Condition 1 -> Word contains the first letter of puzzle.
    Condition 2 -> For each letter in word, that letter should be present in puzzle.
4. You have to print the number of valid words corresponding to a puzzle.
Input Format
A number N
N space separated strings
A number M
M space separated strings
Output Format
Check the sample ouput and question video.
Question Video

  COMMENTConstraints
1 <= N <= 10^5
4 <= length of word <= 50
1 <= M <= 10^4
length of puzzle string = 7
puzzle string doesn't contain any repeated characters.
Sample Input
7
aaaa asas able ability actt actor access 
6
aboveyz abrodyz abslute absoryz actresz gaswxyz
Sample Output
aboveyz -> 1
abrodyz -> 1
abslute -> 3
absoryz -> 2
actresz -> 4
gaswxyz -> 0
*/

import java.io.*;
import java.util.*;

class valid_words {

  public static ArrayList<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
    //write your code here

    HashMap<Character, ArrayList<Integer>> map = new HashMap<>();

    for(int i = 0;i<26;i++){
        map.put((char)(i+'a'), new ArrayList<>());
    }

    for(String word : words){
        int mask = 0;
        
        for(char ch : word.toCharArray()){
            mask |= (1<<(ch-'a'));
        }
        
        HashSet<Character> unique = new HashSet<>();
        for(char ch : word.toCharArray()){
            if(unique.contains(ch)){
                continue;
            }
            unique.add(ch);
            map.get(ch).add(mask);
        }
    }

    ArrayList<Integer> ans = new ArrayList<>();

    for(String puzzle:puzzles){
        int pmask = 0;
        for(char ch : puzzle.toCharArray()){
            pmask |= (1<<(ch-'a'));
        }

        char fch = puzzle.charAt(0);
        ArrayList<Integer> wordsToCheck = map.get(fch);
        int cnt = 0;

        for(int wmask : wordsToCheck){
            if((wmask & pmask) == wmask){
                cnt++;
            }
        }

        ans.add(cnt);
    }

    return ans;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    String[] words = new String[n];
    for (int i = 0 ; i < words.length; i++) {
      words[i] = scn.next();
    }
    int m = scn.nextInt();
    String[] puzzles = new String[m];
    for (int i = 0 ; i < m ; i++) {
      puzzles[i] = scn.next();
    }
    ArrayList<Integer> ans = findNumOfValidWords(words, puzzles);
    for (int i = 0 ; i < m ; i++) {
      System.out.println(puzzles[i] + " -> " + ans.get(i));
    }
  }

}