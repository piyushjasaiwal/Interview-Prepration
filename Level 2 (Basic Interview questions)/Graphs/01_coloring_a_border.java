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

        int original = grid[row][col];

        DFS(row, col, grid, color, grid[row][col]);

        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid.length;j++){
                if(grid[i][j] == -original){
                    grid[i][j] = color;
                }
            }
        }

        return grid;
    }

    public void DFS(int r, int c, int [][] grid, int color, int original){

        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == -original || grid[r][c] != original){
            return ;
        }

        int count = 0;
        int [] x_val = {1, -1, 0, 0};
        int [] y_val = {0, 0, -1, 1};

        grid[r][c] = -grid[r][c];

        for(int x:x_val){
            for(int y:y_val){
                int new_r = r+x;
                int new_c = c+y;

                if(is_same(new_r, new_c, grid, grid[r][c])){
                    count++;
                }

                DFS(new_r, new_c, grid, color, original);
            }
        }

        if(count == 4){
            grid[r][c] = Math.abs(grid[r][c]);
        }
    }

    private boolean is_same(int new_r, int new_c, int[][] grid, int original) {
        if(new_r < 0 || new_c < 0 || new_r >= grid.length || new_c >= grid[0].length || Math.abs(grid[new_r][new_c]) != Math.abs(original)){
            return false;
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