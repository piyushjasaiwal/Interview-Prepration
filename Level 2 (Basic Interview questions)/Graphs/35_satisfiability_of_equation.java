/*abstract
You are given an array of strings equations that represent relationships between variables where each string equations[i] is of length 4 and takes one of two different forms: x==y or x!=y. Here x and y represents lowercase letters.
Input Format
First line contains an integer denoting the number of equation
Each of next n line contains an equation of form "x==y" or "x!=y"
Output Format
print true if all equations can be satisfied else print false.
Question Video

  COMMENTConstraints
1 <= equations.length <= 100000
equations[i].length == 4
Sample Input
2
b==c
c!=b
Sample Output
false
*/

import java.io.*;
import java.util.*;

class satisfiability_of_equation {

  public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        System.out.println(equationsPossible(arr));
    }

    public static boolean equationsPossible(String[] equations) {

        DSU dsu = new DSU();

        for(String equation : equations){
            if(equation.charAt(1) == '='){
                dsu.merge(equation.charAt(0), equation.charAt(3));
            }
        }

        boolean ans = true;

        for(String equation : equations){
            if(equation.charAt(1) == '!'){
                ans = ans && (!dsu.isSame(equation.charAt(0), equation.charAt(3)));
            }
        }

        return ans;
    }

    static class DSU{
        char [] par ;
        int [] rank;

        DSU(){
            par = new char[128];
            rank = new int[128];
            for(int i = 0;i<par.length;i++){
                par[i] = (char)(i);
                rank[i] = 1;
            }
        }

        public char find(char ch){
            if(ch == par[ch]){
                return ch;
            }

            char c = find(par[ch]);
            par[ch] = c;
            return c;
        }

        public void merge(char a, char b){
            char par_a = find(a);
            char par_b = find(b);

            if(par_a != par_b){
                if(rank[par_a] < rank[par_b]){
                    par[par_a] = par_b;
                }else if(rank[par_a] > rank[par_b]){
                    par[par_b] = par_a;
                }else{
                    par[par_a] = par_b;
                    rank[par_b]++;
                }
            }
        }

        public boolean isSame(char a, char b){
            return find(a) == find(b);
        }
    }
}
