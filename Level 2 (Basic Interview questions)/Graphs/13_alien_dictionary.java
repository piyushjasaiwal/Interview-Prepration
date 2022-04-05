/*abstract
You are given a list of strings from the alien language's dictionary, where the strings in words are sorted lexicographically by the rules of this new language.
Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.
Input Format
First line contains one integer N. 
Next line contains n Strings.
Output Format
Return a string of the unique letters in the new alien language sorted in lexicographically increasing order.
Question Video

  COMMENTConstraints
1 <= number of words <= 100
1 <= length of each word <= 100
word consists of only lowercase English letters
Sample Input
5
wrt wrf er ett rftt
Sample Output
wertf
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class alien_dictionary {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        n=n+1;
        String[] words = br.readLine().split(" ");

        System.out.println(alienOrder(words));
    }

    public static String alienOrder(String[] words) {
        ArrayList<ArrayList<Character>> graph = new ArrayList<>();
        Set<Character> all_letters = new HashSet<>();

        for(int i = 0;i<26;i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0;i<words.length;i++){
            for(int j = i+1;j<words.length;j++){
                addWords(words[i], words[j], graph, all_letters);
            }
        }

        System.out.println(graph);

        ArrayList<Character> order = new ArrayList<>();
        boolean flag = false;

        if(is_cyclic(graph, all_letters)){
            return "";
        }else{
            for(int i = 0;i<26;i++){
                order = new ArrayList<>();
                DFS(i, new HashSet<>(), order, graph);
                if(all_letters.size() == order.size()){
                    flag = true;
                    break;
                }
            }
        }

        if(flag){
            StringBuilder sb = new StringBuilder();
            for(char ch:order){
                sb.append(ch);
            }
            return new String(sb);
        }
        return "";
    }

    private static void DFS(int src, HashSet<Integer> hashSet, ArrayList<Character> order, ArrayList<ArrayList<Character>> graph) {
        for(char ch:graph.get(src)){
            if(!hashSet.contains(ch-'a')){
                DFS(ch-'a', hashSet, order, graph);
            }
        }
        order.add((char)(src+'a'));
    }

    private static boolean is_cyclic(ArrayList<ArrayList<Character>> graph, Set<Character> all_letters) {
        Set<Integer> visited = new HashSet<>();
        int [] dfs_vis = new int[26];

        for(char ch:all_letters){
            if(isCyclic(ch-'a', graph, visited, dfs_vis)){
                return true;
            }
        }
        return false;
    }

    private static boolean isCyclic(int ch, ArrayList<ArrayList<Character>> graph, Set<Integer> visited,int[] dfs_vis) {
        if(visited.contains(ch)){
            return dfs_vis[ch] == 1;
        }

        visited.add(ch);
        dfs_vis[ch] = 1;
        for(char next:graph.get(ch)){
            if(isCyclic(next, graph, visited, dfs_vis)){
                return true;
            }
        }

        dfs_vis[ch] = 0;
        return false;
    }

    private static void addWords(String s1, String s2, ArrayList<ArrayList<Character>> graph, Set<Character> all_letters) {
        int i = 0;
        int j = 0;

        while(i < s1.length() && j < s2.length()){
            all_letters.add(s1.charAt(i));
            all_letters.add(s2.charAt(j));
            if(s1.charAt(i) != s2.charAt(j)){
                graph.get((char)(s1.charAt(i)-'a')).add((char)(s2.charAt(j)));
                break;
            }
            i++;
            j++;
        }

        while(i<s1.length()){
            all_letters.add(s1.charAt(i));
            i++;
        }

        while(j<s2.length()){
            all_letters.add(s2.charAt(j));
            j++;
        }
    }
}
