/*
1. You are given a number n, the size of a chess board.
2. You are required to place n number of queens in the n * n cells of board such that no queen can kill another.
Note - Queens kill at distance in all 8 directions
3. Complete the body of printNQueens function - without changing signature - to calculate and print all safe configurations of n-queens. Use sample input and output to get more idea.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
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

class n_queens {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        printNQueens(new int[n][n], "", 0);
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
        if(row >= chess.length){
            print_board(chess);
            System.out.println(qsf+".");
            return ;
        }

        for(int col = 0;col<chess.length;col++){
            if(is_safe(chess, row, col)){
                chess[row][row] = 1;
                printNQueens(chess, qsf+row+"-"+col+", ", row+1);
                chess[row][col] = 0;
            }
        }
    }

    private static void print_board(int[][] chess) {
        for(int [] ch:chess){
            for(int c:ch){
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }

    private static boolean is_safe(int[][] chess, int row, int col) {
        int r = row;
        int c = col;

        r-=1;
        while(r >= 0){
            if(chess[r][c] == 1){
                return false;
            }
            r--;
        }

        r = row;
        c = col;

        c-=1;
        while(c >= 0){
            if(chess[r][c] == 1){
                return false;
            }
            c--;
        }

        r = row;
        c = col;

        r-=1;
        c-=1;
        while(r >= 0 && c >= 0){
            if(chess[r][c] == 1){
                return false;
            }
            r--;
            c--;
        }

        r = row;
        c = col;

        r-=1;
        c+=1;
        while(r >= 0 && c < chess.length){
            if(chess[r][c] == 1){
                return false;
            }
            r--;
            c++;
        }

        return true;        
    }
}