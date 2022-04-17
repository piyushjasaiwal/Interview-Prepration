/*abstract
Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
 1 <= n, m <= 40
0 <= mat[][] <= 1
Sample Input
4 3
0 1 1
0 0 1
1 1 1
0 0 1
Sample Output
2
*/

import java.util.*;
import java.io.*;

class maximum_number_of_1s_rows {

    public static int findRow(int[][]mat) {
        //write your code here
        int max = 0;
        int row_idx = 0;
        for(int i = 0;i<mat.length;i++){
            int cnt = 0;
            for(int j = 0;j<mat[0].length;j++){
                if(mat[i][j] == 1){
                    cnt++;
                }
            }
            if(cnt > max){
                max = cnt;
                row_idx=i;
            }
        }
        return row_idx;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][]mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scn.nextInt();
            }
        }

        System.out.println(findRow(mat));
    }
}