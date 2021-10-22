/*
1. You are given a number n, the size of a chess board.
2. You are required to place n number of queens in the n * n cells of board such that no queen can 
     kill another.
Note - Queens kill at distance in all 8 directions
3. Complete the body of printNQueens function - without changing signature - to calculate and 
     print all safe configurations of n-queens

Use sample input and output to get more idea.

Note -> The online judge can't force you to write the function recursively but that is what the spirit 
               of question is.

Write recursive and not iterative logic. The purpose of the question is to aid learning recursion, branch and bound technique and not test you.
Input Format
A number n
Output Format
Safe configurations of queens as suggested in sample output
Question Video

  COMMENTConstraints
1 <= n <= 10
Sample Input
4
Sample Output
0-1, 1-3, 2-0, 3-2, .
0-2, 1-0, 2-3, 3-1, .
*/

import java.io.*;
import java.util.*;

class N_queens_branch_and_bound {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    //write your code here
    n_queens(0, 0, board, 0, n);
  }

  public static boolean IsQueenSafe(boolean[][] chess, int row, int col) {
    // write your code here
        int r = row;
        int c = col;

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

  public static void n_queens(int r, int c, boolean [][] chess, int qpsf, int tq){
    if(qpsf == tq){
        for (int row = 0; row < chess.length; row++) {
            for (int col = 0; col < chess[0].length; col++) {
                if(chess[row][col]){
                    System.out.print(row+"-"+col+", ");
                }
            }
        }
        System.out.println(".");
        return;
    }

    if(c >= chess[0].length){
        c = 0;
        r = r+1;
    }

    if(r >= chess.length){
        return ;
    }

    if(IsQueenSafe(chess, r, c)){
        chess[r][c] = true;
        n_queens(r+1, 0, chess, qpsf+1, tq);
        chess[r][c] = false;
    }
    n_queens(r, c+1, chess, qpsf, tq);
    
  }

}