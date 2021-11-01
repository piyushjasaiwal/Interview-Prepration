/*
A trie or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings

Implement the Trie class:
1. Trie(): Initializes the trie object.
2. void insert(String word): Inserts the string word into the trie.
3. boolean search(String word): Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
4. boolean startsWith(String prefix): Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1. 1 <= word.length, prefix.length <= 2000
2. word and prefix consist only of lowercase English letters.
Sample Input
insert apple
search apple
search app
startsWith app
insert app
search app
Sample Output
true
false
true
true
*/

import java.io.*;
import java.util.*;

class Main {
  public static class Trie {

    /** Initialize your data structure here. */

    private class Node{
    	Node [] children;
    	boolean isEnd;

    	Node(){
    		children = new Node[26];
    	}
    }

    final private Node root;

    public Trie() {
    	root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
    	Node curr = root;
    	for(int i = 0 ;i<word.length();i++){
    		char ch = word.charAt(i);
    		if(curr.children[ch-'a'] == null){
    			curr.children[ch-'a'] = new Node();
    		}
    		curr = curr.children[ch-'a'];
    	}

    	curr.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	Node curr= root;
    	for(int i = 0;i<word.length();i++){
    		char ch = word.charAt(i);
    		if(curr.children[ch-'a'] == null){
    			return false;
    		}
    		curr = curr.children[ch-'a'];
    	}
    	return curr.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
    	Node curr= root;
    	for(int i = 0;i<word.length();i++){
    		char ch = word.charAt(i);
    		if(curr.children[ch-'a'] == null){
    			return false;
    		}
    		curr = curr.children[ch-'a'];
    	}
    	return true;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    Trie obj = new Trie();

    while (read.ready()) {
      String inp[] = read.readLine().split(" ");

      if (inp[0].equals("insert")) {
        obj.insert(inp[1]);
      } else if (inp[0].equals("search")) {
        System.out.println(obj.search(inp[1]));
      } else if (inp[0].equals("startsWith")) {
        System.out.println(obj.startsWith(inp[1]));
      }
    }

  }
}
