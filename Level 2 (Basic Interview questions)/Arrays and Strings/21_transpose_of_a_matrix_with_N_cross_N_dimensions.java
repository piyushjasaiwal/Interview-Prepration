/*
1. You have a matrix of N*N Dimension.
2. You have to convert matrix into transpose.
3. Transpose matrix is defined as, matrix flipped over its main diagonal.
Input Format
matrix = {
    {11, 12, 13},
    {21, 22, 23},
    {31, 32, 33}
}
Output Format
res = {
    {11, 21, 31},
    {12, 22, 32},
    {13, 23, 33}
}
Question Video

  COMMENTConstraints
1. n == matrix.length
2. 1 <= n <= 1000
3. 1 <= n * n <= 10^5
4. -10^9 <= matrix[i][j] <= 10^9
Sample Input
3
11 12 13
21 22 23
31 32 33
Sample Output
11 21 31 
12 22 32 
13 23 33 
*/

import java.util.*;

class transpose_of_a_matrix_with_N_cross_N_dimensions {

  // ~~~~~~~~~~~~~User Section~~~~~~~~~~~~~
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
    transpose(matrix);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}