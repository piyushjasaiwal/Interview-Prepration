/*abstract
Ram is visiting a public park composed of 1 x 1 squares. These squares may or may not contain diagonal brick walls dividing the park into contiguos regions.
Help Ram count the number of regions.

You'll be given a string array of length n (length of a side of park) where every string will be of length n
consisting of "/", "" or blank space ' '. 


Example 1:
    park = [" /","/ "]
    Output: 2

Example 2:
    park = [" /","  "]
    Output: 1

Example 3:
    park = ["/","/"]
    Output: 2

Example 4 : 
    park = ["//","/ "]
    Output: 3
Input Format
A number n.
String array consisting of n strings, each of size n.  
Input is handled for you. You just need to complete the function.
Output Format
"Find out the number of regions of park"
(Output Format is handled for you.)
Question Video

Constraints
1. n == park.length
2. n == park[i].length
3. 1 <= n <= 30
4. park[i][j] is either "/", "", or blank space ' '. 
Sample Input
2
 /
/ 
Sample Output
2
*/

import java.util.*;
import java.io.*;

class park_regions {
    public static int parkRegions(String[] park) {
        // Write your code here
        int dots = park.length+1;
        DSU dsu = new DSU(dots*dots);

        for(int i = 0;i<dots;i++){
            for(int j = 0;j<dots;j++){
                if(i == 0 || j == 0 || i == dots-1 || j == dots-1){
                    int cell = (dots*i)+j;
                    dsu.merge(0, cell);
                }
            }
        }

        int cnt = 1;

        for(int i = 0;i<park.length;i++){
            String str = park[i];

            for(int j = 0;j<str.length();j++){
                if(str.charAt(j) == '/'){
                    // System.out.println("{"+i+", "+j+"}");
                    int cell1 = (dots*(i+1))+j;
                    int cell2 = (dots*i)+(j+1);

                    if(dsu.merge(cell1, cell2)){
                        cnt++;
                    }
                }else if(str.charAt(j) == '\\'){
                    int cell1 = (dots*i)+j;
                    int cell2 = (dots*(i+1))+(j+1);

                    if(dsu.merge(cell1, cell2)){
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    static class DSU{
        int [] par;
        int [] rank;
        DSU(int n){
            par = new int[n+1];
            rank = new int[n+1];
            for(int i = 0;i<par.length;i++){
                par[i] = i;
            }
            Arrays.fill(rank, 0);
        }

        public int find(int a){
            if(par[a] == a){
                return a;
            }

            int x = find(par[a]);
            par[a] = x;
            return x;
        }

        public boolean merge(int a, int b){
            int par_a = find(a);
            int par_b = find(b);

            // System.out.println("{"+a+"=>"+par_a+", "+b+"=>"+par_b+"}");

            if(par_a == par_b){
                return true;
            }else{
                if(rank[par_a] < rank[par_b]){
                    par[par_a] = par_b;
                }else if(rank[par_a] > rank[par_b]){
                    par[par_b] = par_a;
                }else{
                    par[par_b] = par_a;
                    rank[par_a]++;
                }
                return false;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        int n = Integer.parseInt(br.readLine());

        String[] park = new String[n];
        for (int i = 0; i < n; i++) {
            park[i] = br.readLine();
        }

        int ans = parkRegions(park);
        System.out.println(ans);
    }
}
