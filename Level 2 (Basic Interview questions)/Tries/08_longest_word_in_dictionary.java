/*abstract
1. Given an array of strings words.
2. Find the word of longest length, where all of its substrings starting from 0th index exists as different word in array.
3. If there are multiple answers with same length return one which is smallest in lexicographical order. If there is no valid string return empty string.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1. 1 <= words.length <= 1000
2. 1 <= words[i].length <= 30
3. words[i] consists of lowercase English letters.
Sample Input
7
a
banana
app
appl
ap
apply
apple
Sample Output
apple
*/

import java.io.*;
import java.util.*;

class Main {

    static class Node{
        Node children[];
        boolean isEnd;
        
        Node(){
            children = new Node[26];
            isEnd = false;
        }
    }

    static Node root = new Node();
   
    public static void insert(String key) {
        Node curr = root;
        for(int i = 0;i<key.length();i++){
          char ch = key.charAt(i);
          if(curr.children[ch - 'a'] == null){
            curr.children[ch-'a'] = new Node();
          }
  
          curr = curr.children[ch-'a'];
        }
        curr.isEnd = true;
    }


    static String Longest = "";
    public static String longestWord(String[] words) {
        for(String word:words){
            insert(word);
        }
        findLongest(root, "");
        return Longest;
    }

    public static void findLongest(Node curr, String str){
        if(curr == null){
            return ;
        }

        if(curr.isEnd && str.length() > Longest.length()){
            Longest = str;
        }

        for(int i= 0;i<curr.children.length;i++){
            if(curr.children[i] != null){
                findLongest(curr.children[i], str+(char)(i+'a'));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());

        String[]words = new String[n];

        for (int i = 0; i < n; i++) {
        words[i] = read.readLine();
        }

        String result = longestWord(words);
        System.out.println(result);

    }
}
