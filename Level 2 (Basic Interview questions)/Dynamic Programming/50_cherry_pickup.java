/*abstract
1. You are given a number N, which represents the rows and columns of a 2-D matrix.
2. Matrix contains only three values - 
   a. Cell is empty.
   b. Cell contains a cherry.
   c. Cell contains a thorn and you can not pass through this cell.
3. You have to find the maximum number of cherries that you can collect following these rules :
   a. You have to start from (0,0) and travel till (N-1,N-1) by moving right or down, 
    one step at a time.
   b. After reaching (N-1,N-1), you have to come back to (0,0) by moving left or up, 
    one step at a time.   

Note -> If there is no valid path between the top-left cell and bottom-right cell, then no cherries can be collected.
Input Format
A number N
arr1
arr2... (N*N numbers).
Output Format
Check the sample output and question video.
Question Video

  COMMENTConstraints
1 <= N <= 50
Cells can have only three values 0,1 and -1.
Sample Input
3
0 1 -1 
1 0 -1
1 1 1

Sample Output
5
*/

import java.io.*;
import java.util.*;

class cherry_pickup {

	public static int Solution(int r1, int c1, int r2, int[][] arr, int[][][] dp) {
		//write your code here

        

		return 0;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0 ; j < n; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		int ans = Math.max(0,Solution(0, 0, 0, arr, new int[n][n][n]));
		System.out.println(ans);
	}

}