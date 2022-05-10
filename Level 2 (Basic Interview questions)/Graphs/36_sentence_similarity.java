/*abstract
Given two sentences sentence1 and sentence2 each represented as a string array and given a 2d array of string pairs where each row contains two words {x,y} indicating that the word x and y are similar.
Return true if sentence1 and sentence2 are similar, or false if they are not similar. Two sentences are similar if they have the same length and sentence1[i] and sentences2[i] are similar.

Note: Similarity relation is transitive.
Input Format
First line contains an integer denoting the sentence length.
Second line contaions the words of sentence1 separated by space.
Third line contains the words of sentence2 separated by space.
Fourth line contains an integer m denoting number of pairs.
Each of next m lines contains 2 words separated by space which are similar.
Output Format
Print true if Sentence1 and Sentence2 are similar else print false.
Question Video

  COMMENTConstraints
1 <= sentence1.length, Sentence2.length <= 100000
1 <= sentence1[i].length, sentence2[i].length <= 20
sentence1[i] and sentence2[i] consist of lower-case and upper-case English letters.
Sample Input
3
treat fight miss
like train lost
4
treat catch
train fight
like catch
miss lost
Sample Output
true
*/

import java.io.*;
import java.util.*;

class sentence_similarity {

  public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] sentence1 = br.readLine().split(" ");
        String[] sentence2 = br.readLine().split(" ");

        int m = Integer.parseInt(br.readLine());

        String[][] pairs = new String[m][2];
        for (int i = 0; i < m; i++) {
            pairs[i] = br.readLine().split(" ");
        }

        System.out.println(areSentencesSimilarTwo(sentence1, sentence2, pairs));

    }


    public static boolean areSentencesSimilarTwo(String[] Sentence1, String[] Sentence2, String[][] pairs) {
        HashMap<String, Integer> map = new HashMap<>();
        int i = 0;
        
        for(String [] pair:pairs){
            for(String word : pair){
                if(!map.containsKey(word)){
                    map.put(word, i);
                    i++;
                }
            }
        }

        // System.out.println(map);

        int count = i;

        DSU dsu = new DSU(count);
        for(String [] pair:pairs){
            dsu.merge(map.get(pair[0]), map.get(pair[1]));
            // dsu.merge(map.get(pair[1]), map.get(pair[0]));
        }

        if(Sentence1.length != Sentence2.length){
            return false;
        }

        for(i = 0;i<Sentence1.length;i++){
            if(map.containsKey(Sentence1[i]) && map.containsKey(Sentence2[i])){
                // System.out.println("{"+Sentence1[i]+", "+Sentence2[i]+"}");
                if(!dsu.is_same(map.get(Sentence1[i]), map.get(Sentence2[i]))){
                    return false;
                }
            }else{
                // System.out.println("{"+Sentence1[i]+", "+Sentence2[i]+"}");
                if(!Sentence1[i].equals(Sentence2[i])){
                    return false;
                }
            }
        }

        return true;
    }
    

    static class DSU{
        int [] par;
        int [] rank;

        DSU(int n){
            par = new int[n];
            rank = new int[n];
            for(int i = 0;i<n;i++){
                par[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int a){
            if(par[a] == a){
                return a;
            }

            int x = find(par[a]);
            par[a] = x;
            return x;
        }

        public void merge(int a, int b){
            int par_a = find(a);
            int par_b = find(b);

            // System.out.println("{"+a+"=>"+par_a+", "+b+"=>"+par_b+"}");

            if(par_a == par_b){
                return ;
            }else{
                if(rank[par_a] < rank[par_b]){
                    par[par_a] = par_b;
                }else if(rank[par_a] > rank[par_b]){
                    par[par_b] = par_a;
                }else{
                    par[par_b] = par_a;
                    rank[par_a]++;
                }
                return ;
            }
        }
        public boolean is_same(int a, int b){
            return find(a) == find(b);
        }
    }
}
