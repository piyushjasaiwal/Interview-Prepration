/*abstract
Given a Binary Square Matrix where each row and column of the matrix is sorted in ascending order. Find the total number of Zeros present in the matrix.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1 <= T <= 50
1 <= M,N <= 1000
0 <= A[i][j] <= 1
Sample Input
3 
0 0 1
0 1 1
0 1 1
Sample Output
4
*/

import java.util.*;
import java.io.*;

class count_number_of_zeroes_in_sorted_matrix {

    public static int countZeros(int[][]mat) {
        //write your code here
        int i = 0;
        int j = mat[0].length-1;
        int count = 0;

        while(i<mat.length && j >= 0){
            if(mat[i][j] == 0){
                count += (j+1);
                i++;
            }else{
                j--;
            }
        }

        return count;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][]mat = new int[n][n];

        for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            mat[i][j] = scn.nextInt();
        }
        }

        System.out.println(countZeros(mat));
    }
}