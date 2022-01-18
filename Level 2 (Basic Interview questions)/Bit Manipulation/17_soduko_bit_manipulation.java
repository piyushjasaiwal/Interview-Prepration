/*abstract
1. You are give a partially filled 9*9 2-D array(arr) which represents an incomplete sudoku state.
2. You are required to assign the digits from 1 to 9 to the empty cells following some rules.
Rule 1 -> Digits from 1-9 must occur exactly once in each row.
Rule 2 -> Digits from 1-9 must occur exactly once in each column.
Rule 3 -> Digits from 1-9 must occur exactly once in each 3x3 sub-array of the given 2D array.

Assumption -> The given Sudoku puzzle will have a single unique solution.
Note -> You have to Solve this problem using bits.
Input Format
9*9 integers ranging from 1 to 9.
0 represents an empty cell.
Output Format
You have to print the solved sudoku. 
Question Video

  COMMENTConstraints
0 <= arr[i][j] <= 9
Sample Input
3 0 6 5 0 8 4 0 0
5 2 0 0 0 0 0 0 0
0 8 7 0 0 0 0 3 1
0 0 3 0 1 0 0 8 0
9 0 0 8 6 3 0 0 5
0 5 0 0 9 0 6 0 0
1 3 0 0 0 0 2 5 0
0 0 0 0 0 0 0 7 4
0 0 5 2 0 6 3 0 0
Sample Output
3 1 6 5 7 8 4 9 2 
5 2 9 1 3 4 7 6 8 
4 8 7 6 2 9 5 3 1 
2 6 3 4 1 5 9 8 7 
9 7 4 8 6 3 1 2 5 
8 5 1 7 9 2 6 4 3 
1 3 8 9 4 7 2 5 6 
6 9 2 3 5 1 8 7 4 
7 4 5 2 8 6 3 1 9 
*/

import java.util.*;

class soduko_bit_manipulation {

  public static void display(int[][] arr){
    for (int ii = 0; ii < arr.length; ii++) {
      for (int jj = 0; jj < arr.length; jj++) {
        System.out.print(arr[ii][jj] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void solveSudoku(int[][] arr, int[] rows, int[] cols, int[][] grid, int i, int j) {
    // write your code here. Use display function to display arr

    if(i >= 9){
      display(arr);
      return ;
    }

    if(arr[i][j] > 0){
      solveSudoku(arr, rows, cols, grid, j == arr.length-1 ? i+1 : i, j == arr.length-1 ? 0 : j+1);
    }else{
      for(int num = 1;num<=9;num++){
        if(
          ((rows[i] & 1<<num) == 0) &&
          ((cols[j] & 1<<num) == 0) &&
          ((grid[i/3][j/3] & 1<<num) == 0)
        ){
          arr[i][j] = num;
          rows[i] ^= (1<<num);
          cols[j] ^= (1<<num);
          grid[i/3][j/3] ^= (1<<num);
          solveSudoku(arr, rows, cols, grid, j == arr.length-1 ? i+1 : i, j == arr.length-1 ? 0 : j+1);
          rows[i] ^= (1<<num);
          cols[j] ^= (1<<num);
          grid[i/3][j/3] ^= (1<<num);
          arr[i][j] = 0;
        }
      }
    }
  }

  public static boolean is_valid(int[] rows, int[] cols, int[][] grid, int i, int j, int k) {
    int mask = 1<<k;
    if((mask^rows[i]) == 0 || (mask^cols[j]) == 0 || (mask^grid[i/3][j/3]) == 0){
      return false;
    }
    return true;
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    int[] rows = new int[9];
    int[] cols = new int[9];
    int[][] grid = new int[3][3];

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        int digit = scn.nextInt();
        arr[i][j] = digit;
        rows[i] |= (1 << digit);
        cols[j] |= (1 << digit);
        grid[i / 3][j / 3] |= (1 << digit);
      }
    }

    solveSudoku(arr, rows, cols, grid, 0, 0);
  }

}