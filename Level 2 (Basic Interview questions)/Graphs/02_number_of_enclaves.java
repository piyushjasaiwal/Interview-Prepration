/*abstract
You are given an m * n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell. A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
Input Format
First line contains two integers m and n.
Each of next m line contains n integers 0 or 1.
Output Format
Print number of enclaves
Question Video

  COMMENTConstraints
1 <= m,n <= 1000
Sample Input
4 4
0 0 0 0
1 0 1 0
0 1 1 0
0 0 0 0
Sample Output
3
*/

import java.io.*;

class number_of_enclaves {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int m = Integer.parseInt(st[0]);
        int n = Integer.parseInt(st[1]);

        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
        st = br.readLine().split(" ");
        for (int j = 0; j < n; j++) {
            arr[i][j] = Integer.parseInt(st[j]);
        }
        }

        System.out.println(numEnclaves(arr));

    }

    public static int numEnclaves(int[][] arr) {
        int cnt = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i][0] == 1){
                DFS(i, 0, arr);
            }
        }

        for(int i = 0;i<arr[0].length;i++){
            if(arr[0][i] == 1){
                DFS(0, i, arr);
            }
        }

        for(int i = 0;i<arr.length;i++){
            if(arr[i][arr[0].length-1] == 1){
                DFS(i, arr[0].length-1, arr);
            }
        }

        for(int i = 0;i<arr[0].length;i++){
            if(arr[arr.length-1][i] == 1){
                DFS(arr.length-1, i, arr);
            }
        }

        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                if(arr[i][j] == 1){
                    cnt += DFS(i, j, arr);
                }
            }
        }

        return cnt;
    }

    public static int DFS(int r, int c, int [][] arr){
        if(r < 0 || c < 0 || r >= arr.length || c >= arr[0].length || arr[r][c] == 0){
            return 0;
        }

        arr[r][c] = 0;
        int cnt = 1;
        cnt += DFS(r+1, c, arr);
        cnt += DFS(r-1, c, arr);
        cnt += DFS(r, c+1, arr);
        cnt += DFS(r, c-1, arr);

        return cnt;
    }

}