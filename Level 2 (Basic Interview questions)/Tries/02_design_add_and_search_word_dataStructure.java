/*
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:
1. WordDictionary() Initializes the object.
2. void addWord(word) Adds word to the data structure, it can be matched later.
3. boolean search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1. 1 <= word.length <= 500
2. word in addWord consists lower-case English letters.
3. word in search consist of  '.' or lower-case English letters.
Sample Input
addWord bad
addWord dad
addWord mad
search pad
search bad
search .ad
search b..
Sample Output
false
true
true
true

*/

import java.io.*;
import java.util.*;

class Main {
    public static class WordDictionary {

        Trie trie;

        public WordDictionary() {
            trie = new Trie();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            trie.insert(word);
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot
         * character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return trie.find(word);
        }
    }


    static class Trie{

        static class Node{
            Node [] children;
            boolean isEnd;

            Node(){
                children = new Node[26];
                isEnd = false;
            }
        }

        private Node root;

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

        public boolean find(String word){
            return find(word, 0, root);
        }

        private boolean find(String word, int idx, Node curr){
            if(curr == null){
                return false;
            }
            if(idx>=word.length()){
                return curr.isEnd;
            }

            char ch = word.charAt(idx);

            if(ch == '.'){
                boolean ans = false;

                for(int i = 0;i<26;i++){
                    if(curr.children[i] != null){
                        ans = ans||find(word, idx+1, curr.children[i]);
                    }   
                }
                return ans;
            }else{
                if(curr.children[ch-'a'] == null){
                    return false;
                }

                return find(word, idx+1, curr.children[ch-'a']);
            }
        }
    }    


    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        WordDictionary obj = new WordDictionary();

        while (true) {
        String inp[] = read.readLine().split(" ");

            if (inp[0].equals("addWord")) {
                obj.addWord(inp[1]);
            } else if (inp[0].equals("search")) {
                System.out.println(obj.search(inp[1]));
            }
        }

    }
}
