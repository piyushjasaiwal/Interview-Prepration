/*
1. Given an m x n board of characters and a list of strings words, return all words present on the board.
2. Word must be made from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

You can return word's in any order.
Input Format
n
m
str1
str2
... n string's each of length m
len count of words
str1
str2
... len number of string's.
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1. 1 <= m, n <= 12
2. 1 <= words.length <= 3 * 10^4
3. 1 <= words[i].length <= 10
4. words[i] consists of lowercase English letters.
5. All the strings of words are unique.
Sample Input
4
4
oaan
etae
ihkr
iflv
5
oath
pea
eat
eatat
rain
Sample Output
[eat, oath]
*/

import java.io.*;
import java.net.Inet4Address;
import java.util.*;

class Main {

    static class Trie{
        class Node{
            Node[] children;
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
                char ch=word.charAt(i);

                if(curr.children[ch-'a'] == null){
                    curr.children[ch-'a'] = new Node();
                }

                curr = curr.children[ch-'a'];
            }

            curr.isEnd = true;
        }

        public boolean find(String word){
            Node curr = root;

            for(int i = 0;i<word.length();i++){
                char ch=word.charAt(i);

                if(curr.children[ch-'a'] == null){
                    return false;
                }

                curr = curr.children[ch-'a'];
            }

            return curr.isEnd;
        }
        
    }

    public static ArrayList<String> findWords(char[][] board, String[] words) {
        ArrayList<String> list= new ArrayList<>();
        Trie trie = new Trie();

        for(String word : words){
            trie.insert(word);
        }

        HashSet<String> set = new HashSet<>();

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                findWords(i, j, board, new boolean[board.length][board[0].length], list, trie, "", set);
            }
        }
        return list;
    }

    public static void findWords(int i, int j, char [][] board, boolean [][] visited, ArrayList<String> list, Trie trie, String wsf, HashSet<String> set){
        
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || visited[i][j]){
            return ;
        }

        String word = wsf+board[i][j];
        if(trie.find(word)){
            if(!set.contains(word)){
                list.add(word);
                set.add(word);
            }
        }
        visited[i][j] = true;
        findWords(i+1, j, board, visited, list, trie, wsf+board[i][j], set);
        findWords(i-1, j, board, visited, list, trie, wsf+board[i][j], set);
        findWords(i, j+1, board, visited, list, trie, wsf+board[i][j], set);
        findWords(i, j-1, board, visited, list, trie, wsf+board[i][j], set);
        visited[i][j] = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int m = Integer.parseInt(read.readLine());
        char[][]board = new char[n][];
        for (int i = 0; i < n; i++) {
        board[i] = read.readLine().trim().toCharArray();
        }
        int count = Integer.parseInt(read.readLine());
        String words[] = new String[count];
        for (int i = 0; i < count; i++) {
        words[i] = read.readLine();
        }

        ArrayList<String> result = findWords(board, words);
        Collections.sort(result);
        System.out.println(result);

        // Scanner s = new Scanner(System.in);
        // int n = s.nextInt();
        // Trie trie = new Trie();
        // while(n-->0){
        //     String str=s.next();
        //     trie.insert(str);
        // }

        // int q = s.nextInt();
        // while(q-->0){
        //     String str=s.next();
        //     System.out.println(trie.find(str));
        // }
    }
}
