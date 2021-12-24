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

import java.util.*;

class regions_cut_by_slashes{
    public static void main(String[] args) {
        System.out.println(new regions_cut_by_slashes().regionsBySlashes(new String[]{" /","/ "}));
    }

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        ArrayList<ArrayList<ArrayList<Pair>>>  map = new ArrayList<>();
        for(int i = 0;i<n;i++){
            map.add(new ArrayList<>());
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                map.get(i).add(new ArrayList<>());
            }
        }

        for(int i = 0;i<grid.length;i++){
            int j = 0;
            while(j<grid[i].length()){
                char ch = grid[i].charAt(j);
                if(ch == ' '){
                    ArrayList<Pair> cell_list = map.get(i).get(j);
                    cell_list.add(new Pair(true, true, true, true));
                    j++;
                }else if(ch == '/'){
                    ArrayList<Pair> cell_list = map.get(i).get(j);
                    cell_list.add(new Pair(true, false, true, false));
                    cell_list.add(new Pair(false, true, false, true));
                    j++;
                }else{
                    ArrayList<Pair> cell_list = map.get(i).get(j);
                    cell_list.add(new Pair(true, false, false, true));
                    cell_list.add(new Pair(false, true, true, false));
                    j+=2;
                }
            }
        }

        int cnt = 0;
        int [][] visited = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j=0;j<n;j++){
                for(Pair pair:map.get(i).get(j)){
                    if(visited[i][j] < map.get(i).get(j).size()){
                        DFS(i, j, map, visited);
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    private void DFS(int i, int j, ArrayList<ArrayList<ArrayList<Pair>>> map, int[][] visited) {
        if(i<0 || j<0 || i >= visited.length || j >= visited[0].length || visited[i][j] >= map.get(i).get(j).size()){
            return ;
        }

        visited[i][j]+=1;

        ArrayList<Pair> pairs = map.get(i).get(j);
        for(Pair pair : pairs){
            if(pair.left && pair.right && pair.down && pair.up){
                DFS(i-1, j, map, visited);
                DFS(i+1, j, map, visited);
                DFS(i, j-1, map, visited);
                DFS(i, j+1, map, visited);
            }else if(pair.left && pair.right && pair.down && pair.up){

            }
        }
    }
}

class Pair{
    boolean up, down, left, right;
    public Pair(boolean up, boolean down, boolean left, boolean right){
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }
}