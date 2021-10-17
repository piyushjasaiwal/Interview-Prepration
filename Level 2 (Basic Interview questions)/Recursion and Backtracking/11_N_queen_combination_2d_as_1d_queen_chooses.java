/*
1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the combinations in which n queens can be placed on the 
     n * n chess-board. 
3. No queen shall be able to kill another.

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
A number n
Output Format
Check the sample output and question video
Question Video

  COMMENTConstraints
1 <= n <= 5
Sample Input
4
Sample Output
-	q	-	-	
-	-	-	q	
q	-	-	-	
-	-	q	-	

-	-	q	-	
q	-	-	-	
-	-	-	q	
-	q	-	-	
*/

import java.io.*;
import java.util.*;

class N_queen_combination_2d_as_1d_queen_chooses {

    public static boolean IsQueenSafe(boolean[][] chess, int row, int col) {
        // write your code here
        int r = row;
        int c = col;

        if(chess[r][c]){
            return false;
        }

        while(r >= 0){
            if(chess[r][col]){
                return false;
            }
            r--;
        }
        
        r = row;
        c = col;

        while(c >= 0){
            if(chess[row][c]){
                return false;
            }
            c--;
        }
        
        r = row;
        c = col;

        while(c >= 0 && r >= 0){
            if(chess[r][c]){
                return false;
            }
            r--;
            c--;
        }

        r = row;
        c = col;

        while(c < chess[0].length && r >= 0){
            if(chess[r][c]){
                return false;
            }
            r--;
            c++;
        }

        return true;
    }

    public static void nqueens(int qpsf, int tq, boolean[][] chess, int lcno) {
        if (qpsf == tq) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] ? "q\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (chess[row][col] == false && IsQueenSafe(chess, row, col)) {
                chess[row][col] = true;
                nqueens(qpsf + 1, tq, chess, row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        nqueens(0, n, chess, -1);
    }
}