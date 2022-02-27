/*abstract
rows = 2
cols = 3

Format
Input
Each of next 2 lines contain 3 integer.

Output
Min number of moves required to achieve solved state.

Example
Sample Input

1 2 3
4 0 5

Sample Output
1
*/

// Note : Use Bfs with String and make the array linearize

import java.io.*;
import java.util.*;

class Sliding_Puzzle {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[2][3];

        for (int i = 0; i < 2; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        int ans = slidingPuzzle(arr);
        System.out.println(ans != Integer.MAX_VALUE ? ans : -1);
    }

    public static int slidingPuzzle(int[][] board) {
        int [][] win = {{1,2,3},{4,5,0}};
        // int [][] temp = {{1,2,3},{4,5,0}};;
        // System.out.println(equals(win, temp));
        int r = 0;
        int c = 0;
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == 0){
                    r = i;
                    c = j;
                    break;
                }
            }
        }

        // boolean [][] visited = new boolean[board.length][board[0].length];
        HashSet<String> visited = new HashSet<>();
        
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, slidingPuzzleHelper(board,r, c, visited, 0, win));
        return ans;
    }

    private static int slidingPuzzleHelper(int[][] board, int r, int c, HashSet<String> visited, int moves, int [][] win) {
        if(r < 0 || c < 0 || r >= 2 || c >= 3){
            return Integer.MAX_VALUE;
        }

        if(equals(board, win)){
            return moves;
        }

        StringBuilder sb = new StringBuilder("");
        for(int [] ar:board){
            for(int val:ar){
                sb.append(val);
            }
        }

        String str = new String(sb);
        if(visited.contains(str)){
            return Integer.MAX_VALUE;
        }

        visited.add(str);

        // for(int [] a:board){
        //     for(int v:a){
        //         System.out.print(v+" ");
        //     }
        //     System.out.println();
        // }

        // System.out.println("------------------------------------------------------------------");

        // System.out.println(r+" "+c);

        // visited[r][c] = true;

        int ans = Integer.MAX_VALUE;
        
        if(isValid(r+1, c)){
            swap(board, r, c, r+1, c);
            ans = Math.min(ans, slidingPuzzleHelper(board, r+1, c, visited, moves+1, win));
            swap(board, r, c, r+1, c);
        }

        if(isValid(r-1, c)){
            swap(board, r, c, r-1, c);
            ans = Math.min(ans, slidingPuzzleHelper(board, r-1, c, visited, moves+1, win));
            swap(board, r, c, r-1, c);
        }

        if(isValid(r, c+1)){
            swap(board, r, c, r, c+1);
            ans = Math.min(ans, slidingPuzzleHelper(board, r, c+1, visited, moves+1, win));
            swap(board, r, c, r, c+1);
        }

        if(isValid(r, c-1)){
            swap(board, r, c, r, c-1);
            ans = Math.min(ans, slidingPuzzleHelper(board, r, c-1, visited, moves+1, win));
            swap(board, r, c, r, c-1);
        }
        
        return ans;
    }

    private static boolean isValid(int r, int c) {
        if(r < 0 || c < 0 || r >= 2 || c >= 3){
            return false;
        }
        return true;
    }

    public static void swap(int [][] board, int r, int c, int nr, int nc){
        int temp = board[r][c];
        board[r][c] = board[nr][nc];
        board[nr][nc] = temp;
    }

    public static boolean equals(int [][] a, int [][] b){
        for(int i = 0;i<2;i++){
            for(int j = 0;j<3;j++){
                if(a[i][j] != b[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}