/*
1. You are given an n x n 2D matrix representing an image.
2. rotate the image by 90 degrees (clockwise).
3. You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
4. DO NOT allocate another 2D matrix and do the rotation.
Input Format
matrix = {
    {11, 12, 13, 14},
    {21, 22, 23, 24},
    {31, 32, 33, 34},
    {41, 42, 43, 44}
}
Output Format
matrix = {
    {41, 31, 21, 11},
    {42, 32, 22, 12},
    {43, 33, 23, 13},
    {44, 34, 24, 14}
}
Question Video

  COMMENTConstraints
1. matrix.length == n
2. matrix[i].length == n
3. 1 <= n <= 20
4. -1000 <= matrix[i][j] <= 1000
Sample Input
3
11 12 13
21 22 23
31 32 33
Sample Output
31 21 11 
32 22 12 
33 23 13 
*/

import java.util.*;

class rotate_image {

  // ~~~~~~~~~~~~~User Section~~~~~~~~~~~~~
  public static void rotate(int[][] matrix) {
    // write your code here
    transpose(matrix);
    row_reverse(matrix);
  }

  public static void transpose(int[][] matrix) {
    // write your code here
    for(int i = 0;i<matrix.length;i++){
        for(int j = 0;j<i;j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
  }

  public static void row_reverse(int [][] matrix){
      for(int k = 0;k<matrix.length;k++){
          int i = 0;
          int j = matrix[0].length-1;
          while(i<j){
            int temp = matrix[k][i];
            matrix[k][i] = matrix[k][j];
            matrix[k][j] = temp;

            i++;
            j--;
          }
      }
  }

  // ~~~~~~~~~~~Input Management~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[][] matrix = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = scn.nextInt();
      }
    }
    rotate(matrix);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}