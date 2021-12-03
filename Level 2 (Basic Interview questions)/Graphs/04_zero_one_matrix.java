/*abstract
Given an m*n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
Input Format
First line contains two integers n and m.
Each of next n lines contain m numbers containing either 0 or 1.
Output Format
print a 2d matrix where each box contains distance to its nearest 0.
Question Video

  COMMENTConstraints
1<= n <= 1000
1<= e <= n*(n-1)/2
Sample Input
3 3
0 0 0
0 1 1
1 1 1
Sample Output
0 0 0 
0 1 1 
1 2 2 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class zero_one_matrix {
    private static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
        this.x = x;
        this.y = y;
        }
    }

    private static int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

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

        int[][] ans = updateMatrix(arr);

        for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            System.out.print(ans[i][j] + " ");
        }
        System.out.println();
        }

    }

    public static int[][] updateMatrix(int[][] matrix) {
        int [][] ans = new int[matrix.length][matrix[0].length];
        for(int i = 0;i<ans.length;i++){
            for(int j = 0;j<ans[0].length;j++){
                if(matrix[i][j] == 1){
                    BFS(i, j, matrix, ans);
                }
            }
        }
        return ans;
    }

    private static void BFS(int i, int j, int[][] matrix, int[][] ans) {
        int cnt = 0;

        LinkedList<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));


        while(!q.isEmpty()){
            LinkedList<Pair> q2 = new LinkedList<>();
            boolean flag = false;
            while(!q.isEmpty()){
                Pair curr = q.removeFirst();
                if(matrix[curr.x][curr.y] == 0){
                    flag = true;
                    break;
                }

                for(int [] dir:dirs){
                    int new_x = curr.x + dir[0];
                    int new_y = curr.y + dir[1];

                    if(is_valid(new_x, new_y, matrix)){
                        q2.add(new Pair(new_x, new_y));
                    }
                }
            }
            if(flag){
                break;
            }
            q = q2;
            cnt+=1;
        }

        ans[i][j] = cnt;
    }

    private static boolean is_valid(int new_x, int new_y, int[][] matrix) {
        if(new_x < 0 || new_y < 0 || new_x >= matrix.length || new_y >= matrix[0].length){
            return false;
        }
        return true;
    }

}