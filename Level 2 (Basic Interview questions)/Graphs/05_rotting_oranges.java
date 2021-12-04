/*abstract
You are given an m * n matrix containing 0, 1 or 2 , where 0 represents an empty cell, 1 represents a fresh orange, 2 represents rotten orange. Every hour, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Print the minimum number of hours that must elapse until no cell has a fresh orange.

In case if all the oranges can't become rotten print -1
Input Format
First line contains two integers m and n.
Each of next m line contains n integers 0,1 or 2.
Output Format
Print minimum hours.
Question Video

  COMMENTConstraints
1 <= m,n <= 1000
Sample Input
3 3
2 1 1
1 1 0
0 1 1
Sample Output
4
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class rotting_oranges {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(orangesRotting(arr));
        // for(int i = 0;i<arr.length;i++){
        //     for(int j = 0;j<arr[0].length;j++){
        //         System.out.print(arr[i][j]+" ");
        //     }
        //     System.out.println();
        // }

    }

    public static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
        this.row = row;
        this.col = col;
        }

    }

    private static int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static int orangesRotting(int[][] grid) {
        int cnt = 0;
        LinkedList<Pair> q = new LinkedList<>();
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 2 && should_add(i, j, grid)){
                    q.add(new Pair(i, j));
                }
            }
        }

        while(!q.isEmpty()){
            LinkedList<Pair> q2 = new LinkedList<>();
            while(!q.isEmpty()){
                Pair curr = q.removeFirst();
                for(int [] dir:dirs){
                    int new_x = curr.row + dir[0];
                    int new_y = curr.col + dir[1];

                    if(is_valid(new_x, new_y, grid)){
                        grid[new_x][new_y] = 2;
                        if(should_add(new_x, new_y, grid)){
                            q2.add(new Pair(new_x, new_y));
                        }
                    }
                }
            }
            q = q2;
            cnt+=1;

            // for(int i = 0;i<grid.length;i++){
            //     for(int j = 0;j<grid[0].length;j++){
            //         System.out.print(grid[i][j]+" ");
            //     }
            //     System.out.println();
            // }
        }

        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return cnt;
    }

    private static boolean should_add(int row, int col, int[][] grid) {
        for(int [] dir:dirs){
            int new_x = row+dir[0];
            int new_y = col+dir[1];
            if(new_x >= 0 && new_y >= 0 && new_x < grid.length && new_y < grid[0].length && grid[new_x][new_y] == 1){
                return true;
            }
        }
        return false;
    }

    private static boolean is_valid(int new_x, int new_y, int[][] grid) {
        if(new_x < 0 || new_y < 0 || new_x >= grid.length || new_y >= grid[0].length || grid[new_x][new_y] == 2 || grid[new_x][new_y] == 0){
            return false;
        }
        return true;
    }
}