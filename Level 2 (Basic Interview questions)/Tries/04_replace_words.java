/*abstract
1. You r given an array of string's say dictionary and a long string say sentence.
2. You have to replace all words in sentence which contains a prefix in dictionary with the prefix itself in dictionary.

Example 
dictionary = ["cat","bat","rat"]
sentence = "the cattle was rattled by the battery"

In this sentence cattle, rattled and battery are the words containing prefix in dictionary they are cat, rat and bat.
sentence after replace words is "the cat was rat by the bat".

3. If there are multiple prefix for a word in dictionary replace it with the shortest prefix word.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1. 1 <= dictionary.length <= 1000
2. 1 <= dictionary[i].length <= 100
3. 1 <= sentence.length <= 10^6
4. dictionary[i] an sentence consists of only lower-case letters.
Sample Input
4
catt
cat
bat
rat
the cattle was rattled by the battery
Sample Output
the cat was rat by the bat
*/

import java.io.*;
import java.util.*;

class Main {

    static class Trie{
        class Node{
            Node [] children;
            boolean isEnd;

            Node(){
                children = new Node[26];
                isEnd = false;
            }
        }

        private Node root ;

        Trie(){
            root = new Node();
        }

        public void insert(String word){
            Node curr = root;

            for(int i = 0;i<word.length();i++){
                char ch = word.charAt(i);
                if(curr.children[ch-'a'] == null){
                    curr.children[ch-'a'] = new Node();
                }

                curr = curr.children[ch-'a'];
            }

            curr.isEnd = true;
        }

        public int find(String word){
            Node curr = root;
            // int idx = 0;
            for(int i = 0;i<word.length();i++){
                char ch = word.charAt(i);
                if(curr.children[ch-'a'] == null){
                    break;
                }

                if(curr.children[ch-'a'].isEnd){
                    return i;
                }

                curr = curr.children[ch-'a'];
                // idx+=1;
            }
            return -1;
        }
    }

    public static String replaceWords(String dictionary[], String sentence) {
        Trie trie = new Trie();
        for(String word:dictionary){
            trie.insert(word);
        }

        String [] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder("");
        for(int i = 0;i<words.length;i++){
            String word = words[i];
            int idx = trie.find(word);
            if(idx != -1){
                word = word.substring(0, idx+1);
            }
            sb.append(word);
            sb.append(" ");
        }

        return new String(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());

        String[]dictionary = new String[n];

        for (int i = 0; i < n; i++) {
        dictionary[i] = read.readLine();
        }

        String sentence = read.readLine();

        String result = replaceWords(dictionary, sentence);
        System.out.println(result);
    }
}
