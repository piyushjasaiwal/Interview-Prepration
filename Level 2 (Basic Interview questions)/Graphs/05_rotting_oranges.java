/*abstract
You are given an m * n matrix containing 0, 1 or 2 , where 0 represents an empty cell, 1 represents a fresh orange, 2 represents rotten orange. Every hour, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Print the minimum number of hours that must elapse until no cell has a fresh orange.

In case if all the oranges can't become rotten print -1
Input Format
First line contains two integers m and n.
Each of next m line contains n integers 0,1 or 2.
Output Format
Print minimum hours.
Question Video

  COMMENTConstraints
1 <= m,n <= 1000
Sample Input
3 3
2 1 1
1 1 0
0 1 1
Sample Output
4
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(orangesRotting(arr));

  }

  public static class Pair {
    int row;
    int col;

    Pair(int row, int col) {
      this.row = row;
      this.col = col;
    }

  }

  public static int orangesRotting(int[][] grid) {

  }
}