// /*abstract
// Given an n*n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.

// The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
// Input Format
// First line contains an integer n.
// Each of next n lines contain n numbers containing either 0 or 1.
// Output Format
// Print a 2d matrix where each box contains distance to its nearest 0.
// Question Video

//   COMMENTConstraints
// 1<= n <= 1000
// Sample Input
// 3
// 0 0 0
// 0 1 1
// 1 1 1
// Sample Output
// 2
// */

// =import java.io.*;
// import java.util.*;

// class As_far_from_land_As_possible {

//     public static void main(String[] args) throws NumberFormatException, IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         int n = Integer.parseInt(br.readLine());
//         int[][] arr = new int[n][n];

//         for (int i = 0; i < n; i++) {
//         String[] st = br.readLine().split(" ");
//         for (int j = 0; j < n; j++) {
//             arr[i][j] = Integer.parseInt(st[j]);
//         }
//         }

//         System.out.println(maxDistance(arr));

//     }

//     public static int maxDistance(int[][] grid) {
//         int [] x = {-1, 1, 0, 0};
//         int [] y = {0, 0, -1, 1};
//         LinkedList<Pair> q = new LinkedList<>();

//         for(int i = 0;i<grid.length;i++){
//             for(int j = 0;j<grid[0].length;j++){
//                 if(grid[i][j] == 1){
//                     q.add(new Pair(i, j));
//                 }
//             }
//         }

//         if(q.size() == 0 || q.size() == grid.length * grid[0].length){
//             return -1;
//         }

//         int max = -1;
//         // boolean [][] visited = new boolean[grid.length][grid[0].length];

//         while(!q.isEmpty()){
//             // max = Math.max(max, curr.dis);
//             max++;
//             int size = q.size();
//             while(size-->0){
//                 Pair curr = q.removeFirst();
//                 for(int i = 0;i<4;i++){
//                     int new_x = curr.x+x[i];
//                     int new_y = curr.y+y[i];
    
//                     if(is_valid(new_x, new_y, grid)){
//                         q.add(new Pair(new_x, new_y));
//                         grid[new_x][new_y] = 1;
//                     }
//                 }
//             }

//         }

//         return max;
//     }

//     private static boolean is_valid(int x, int y, int[][] grid) {
//         if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y] == 1){
//             return false;
//         }
//         return true;
//     }
// }

// class Pair{
//     int x, y;
//     public Pair(int x, int y){
//         this.x = x;
//         this.y = y;
//     }
// }
