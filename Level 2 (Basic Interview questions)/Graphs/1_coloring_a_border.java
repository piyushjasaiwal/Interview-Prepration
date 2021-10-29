/*
You are given an m x n integer matrix grid, and three integers row, col, and color. Each value in the grid represents the color of the grid square at that location.

Two squares belong to the same connected component if they have the same color and are next to each other in any of the 4 directions.

The border of a connected component is all the squares in the connected component that are either 4-directionally adjacent to a square not in the component, or on the boundary of the grid (the first or last row or column).

You should color the border of the connected component that contains the square grid[row][col] with color.

Return the final grid.

 

Example 1:

Input: grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
Output: [[3,3],[3,2]]
Example 2:

Input: grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
Output: [[1,3,3],[2,3,3]]
Example 3:

Input: grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
Output: [[2,2,2],[2,1,2],[2,2,2]]
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
1 <= grid[i][j], color <= 1000
0 <= row < m
0 <= col < n
*/

class Solution_color_border {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int [][] colored_grid = new int [grid.length][grid[0].length];

        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                colored_grid[i][j] = grid[i][j];
            }
        }

        DFS(row, col,grid, color, colored_grid, grid[row][col], new boolean[grid.length][grid[0].length]);
        return colored_grid;
    }

    public boolean DFS(int i, int j, int [][] grid, int color ,int [][] colored_grid, int curr, boolean [][] visited){
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] != curr){
            return false;
        }

        if(visited[i][j]){
            return true;
        }
        visited[i][j] = true;

        boolean ans = true;
        ans = ans && DFS(i+1, j, grid, color, colored_grid, curr, visited);
        ans = ans && DFS(i, j+1, grid, color, colored_grid, curr, visited);
        ans = ans && DFS(i-1, j, grid, color, colored_grid, curr, visited);
        ans = ans && DFS(i, j-1, grid, color, colored_grid, curr, visited);

        if(!ans){
            colored_grid[i][j] = color;
        }

        return true;
    }
}

class color_border{
    public static void main(String[] args) {
        // int [][] grid = {{1,2,2},{2,3,2}};
        // int row = 0;
        // int col = 1;
        // int color = 3;
        int [][] grid = {{0,0}};
        int row = 0;
        int col = 0;
        int color = 3;
        Solution_color_border solution = new Solution_color_border();
        int [][] ans = solution.colorBorder(grid, row, col, color);
        display(grid);
        display(ans);
    }
    public static void display(int [][] arr){
        for(int [] ar:arr){
            for(int a:ar){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
}