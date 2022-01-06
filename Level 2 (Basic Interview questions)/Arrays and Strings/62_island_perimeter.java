/*abstract
1. You will be given a matrix, 2d Array and number of its columns and rows.
 2. Matrix represents a grid, where 1 is land and 0 is water. 
 3. Each tile/element has 1 as width and height.
 4. You need to find perimeter of the island formed by land.
 5. Input and output is handled for you
 6. It is a functional problem, please do not modify main()
Input Format
Input is handled for you.
Output Format
Output is handled for you.
Question Video

  COMMENTConstraints
Grid only contains 1 and 0, 0 is water and 1 is land
Sample Input
4 3
1 0 0 
1 1 1 
0 1 0 
0 1 0
Sample Output
14
*/

import java.io.*;
import java.util.*;

class island_perimeter {

    public static int islandPerimeter(int[][] grid) {
        boolean [][] visited = new boolean[grid.length][grid[0].length];

        int ans = 0;

        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    ans += DFS(i, j, grid, visited);
                }
            }
        }

        return ans;
    }

    private static int DFS(int i, int j, int[][] grid, boolean[][] visited) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 1;
        }

        if(visited[i][j]){
            return 0;
        }
        visited[i][j] = true;

        int ans = 0;

        ans += DFS(i-1, j, grid, visited);
        ans += DFS(i+1, j, grid, visited);
        ans += DFS(i, j-1, grid, visited);
        ans += DFS(i, j+1, grid, visited);

        // System.out.println(ans);

        return ans;
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] grid = new int[row][col];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(islandPerimeter(grid));
    }
}