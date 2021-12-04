/*abstract
In a given 2D binary array grid, there are two islands. Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
Return the smallest number of 0s that must be flipped. (It is guaranteed that the answer is at least 1.)
Input Format
First line contains an integer n.
Each of next n lines contain n numbers containing either 0 or 1.
Output Format
Return the smallest number of 0s that must be flipped.
Question Video

  COMMENTConstraints
1<= n <= 1000
Sample Input
3
0 1 0
0 0 0
1 1 1
Sample Output
1
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class shortest_bridge {

    private static int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(shortestBridge(arr));
        // for(int i = 0;i<arr.length;i++){
        //     for(int j = 0;j<arr[0].length;j++){
        //         System.out.print(arr[i][j]+" ");
        //     }
        //     System.out.println();
        // }

    }

    public static int shortestBridge(int[][] A) {
        LinkedList<Pair> q = new LinkedList<>();
        for(int i = 0;i<A.length;i++){
            boolean flag =false;
            for(int j = 0;j<A[0].length;j++){
                if(A[i][j] == 1){
                    DFS(i, j, A, q);
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }

        int cnt = 0;
        boolean flag = false;
        while(!q.isEmpty()){
            LinkedList<Pair> q2 = new LinkedList<>();
            while(!q.isEmpty()){
                Pair curr = q.removeFirst();
                if(A[curr.row][curr.col] == 1){
                    flag = true;
                    break;
                }
                for(int [] dir : dirs){
                    int new_x = curr.row + dir[0];
                    int new_y = curr.col + dir[1];

                    if(is_valid(new_x, new_y, A)){
                        if(A[new_x][new_y] == 1){
                            flag = true;
                            break;
                        }
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

        return cnt;
    }

    private static boolean is_valid(int new_x, int new_y, int[][] grid) {
        if(new_x < 0 || new_y < 0 || new_x >= grid.length || new_y >= grid[0].length){
            return false;
        }
        return true;
    }

    private static void DFS(int i, int j, int[][] a, LinkedList<Pair> q) {
        if(i < 0 || j < 0 || i >= a.length || j >= a[0].length || a[i][j] == 0 || a[i][j] == 2){
            return ;
        }

        a[i][j] = 2;

        q.add(new Pair(i, j));
        DFS(i+1, j, a, q);
        DFS(i-1, j, a, q);
        DFS(i, j+1, a, q);
        DFS(i, j-1, a, q);
    }

    public static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
        this.row = row;
        this.col = col;
        }

    }
}
