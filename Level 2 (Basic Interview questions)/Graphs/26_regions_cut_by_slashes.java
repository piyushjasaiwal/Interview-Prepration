/*abstract
An n x n grid is composed of 1 x 1 squares where each 1 x 1 square consists of a '/', '\', or blank space ' '. These characters divide the square into contiguous regions.

Given the grid grid represented as a string array, return the number of regions.

Note that backslash characters are escaped, so a '\' is represented as '\\'.

 

Example 1:


Input: grid = [" /","/ "]
Output: 2
Example 2:


Input: grid = [" /","  "]
Output: 1
Example 3:


Input: grid = ["/\\","\\/"]
Output: 5
Explanation: Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.
 

Constraints:

n == grid.length == grid[i].length
1 <= n <= 30
grid[i][j] is either '/', '\', or ' '.
*/

import java.io.*;
import java.util.*;

class regions_cut_by_slashes{
    public static void main(String[] args) throws NumberFormatException, IOException {
        // Scanner s= new Scanner(System.in);
        String [] grid = {"/\\","\\/"};
        int n= grid.length;
        int dots = n+1;
        dsu dsu = new dsu(dots*dots);
        int cnt = 1;
        for(int i = 0;i<dots;i++){
            for(int j = 0;j<dots;j++){
                if(i == 0 || j == 0 || i == dots-1 || j == dots-1){
                    int cellNo = i*dots+j;
                    dsu.merge(0, cellNo);
                }
            }
        }

        for(int i= 0;i<n;i++){
            String str = grid[i];
            for(int j = 0;j<str.length();j++){
                if(str.charAt(j) == '/'){
                    int cell1 = ((i+1)*dots)+j;
                    int cell2 = (i*dots)+(j+1);
                    if(dsu.merge(cell1, cell2)){
                        cnt++;
                    }
                }else if(str.charAt(j) == '\\'){
                    int cell1 = ((i)*dots)+j;
                    int cell2 = ((i+1)*dots)+(j+1);
                    if(dsu.merge(cell1, cell2)){
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    static class dsu{
        int [] parent;
        int [] rank;

        public dsu(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0;i<n;i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int a){
            if(parent[a] == a){
                return a;
            }

            int x = find(parent[a]);
            parent[a] = x;
            return x;
        }

        public boolean merge(int a, int b){
            int pa = find(a);
            int pb = find(b);
            if(pa == pb){
                return true;
            }else{
                if(rank[pa] > rank[pb]){
                    parent[pb] = pa;
                }else if(rank[pa] < rank[pb]){
                    parent[pa] = pb;
                }else{
                    parent[pa] = pb;
                    rank[pb]++;
                }
                return false;
            }
        }
    }
}
