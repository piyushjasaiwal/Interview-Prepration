/*abstract
1. You are given four integers row, cols, rCenter, and cCenter. There is a rows x cols matrix and you are on the cell with the coordinates (rCenter, cCenter).
2. Return the coordinates of all cells in the matrix, sorted by their distance from (rCenter, cCenter) from the smallest distance to the largest distance.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1 <= rows, cols <= 100
0 < rCenter < rows
0 < cCenter < cols
Sample Input
2 3 1 2
Sample Output
(1, 2), (0, 2), (1, 1), (0, 1), (1, 0), (0, 0),
*/

import java.util.*;
import java.io.*;

class matrix_cells_in_distance_order {

    static class comp implements Comparator<int[]>{

        @Override
        public int compare(int[] o1, int[] o2) {
            // TODO Auto-generated method stub
            int d1 = Math.abs(o1[0]-r)+Math.abs(o1[1]-c);
            int d2 = Math.abs(o2[0]-r)+Math.abs(o2[1]-c);

            return d1-d2;
        }

    }

    static int r = -1;
    static int c = -1;

    public static int[][] solve(int rows, int cols, int rCenter, int cCenter) {
        //write your code here
        r = rCenter;
        c = cCenter;

        int [][] mat = new int[rows*cols][2];
        int idx = 0;
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                mat[idx][0] = i;
                mat[idx][1] = j;
                idx++;
            }
        }

        Arrays.sort(mat, new comp());
        return mat;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        int rows = scn.nextInt();
        int cols = scn.nextInt();
        int rCenter = scn.nextInt();
        int cCenter = scn.nextInt();

        int[][]ans = solve(rows, cols, rCenter, cCenter);

        for (int i = 0; i < ans.length; i++) {
            System.out.print("(" + ans[i][0] + ", " + ans[i][1] + "), ");
        }
        System.out.println();
    }
}