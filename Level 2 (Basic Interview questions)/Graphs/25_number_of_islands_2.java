/*abstract
Given an m*n matrix mat, Originally, the 2D matrix is all 0 which means there is only sea in the matrix. The list pair has k operator and each operator has two integer A[i].x, A[i].y means that you can change the grid mat[A[i].x][A[i].y] from sea to island. Return how many island are there in the matrix after each operator.You need to return an array of size K.
Input Format
First line contains three integers m and n and k.
Each of next k lines contain 2 numbers denoting row and col to change into 1.
Output Format
print number of island after each operation.
Question Video

  COMMENTConstraints
1<= m,n <= 10000
1<= k <= 10^6
Sample Input
3 3 4
0 0
0 1
1 2
2 1
Sample Output
[1, 1, 2, 3]
*/

import java.util.*;
import java.io.*;

class number_of_islands_2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          String[] st = br.readLine().split(" ");
          int m = Integer.parseInt(st[0]);
          int n = Integer.parseInt(st[1]);
          int q = Integer.parseInt(st[2]);

          int[][] pos = new int[q][2];
          for (int i = 0; i < q; i++) {
              st = br.readLine().split(" ");
              pos[i][0] = Integer.parseInt(st[0]);
              pos[i][1] = Integer.parseInt(st[1]);
          }

          System.out.println(numIslands2(m, n, pos));
      }

      public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        int [][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int [] parent = new int[m*n];
        int [] rank = new int[m*n];
        Arrays.fill(parent, -1);
        int count = 0;

        for(int [] pos:positions){
          int row = pos[0];
          int col = pos[1];

          int cellNo = row*n + col;
          if(parent[cellNo] != -1){
            ans.add(count);
            continue;
          }

          parent[cellNo] = cellNo;
          count+=1;
          rank[cellNo] = 1;

          for(int [] dir:dirs){
            int rowdash = row+dir[0];
            int coldash = col+dir[1];
            int cellDashNo = rowdash*n+coldash;

            if(rowdash < 0 || coldash < 0 || rowdash >= m || coldash >= n || parent[cellDashNo] == -1){
              continue;
            }

            int lx = find(cellNo, parent);
            int ly = find(cellDashNo, parent);

            if(lx != ly){
              if(rank[lx] < rank[ly]){
                parent[lx] = ly;
              }else if(rank[lx] > rank[ly]){
                parent[ly] = lx;
              }else{
                parent[lx] = ly;
                rank[ly]+=1;
              }

              count--;
            }
          }

          ans.add(count);
        }

        return ans;
      }

      public static int find(int x, int [] parent){
        if(parent[x] == x){
          return x;
        }

        int temp = find(parent[x], parent);
        parent[x] = temp;
        return temp;
      }
}