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

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
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
//         LinkedList<Pair> prev = new LinkedList<>();
//         int max = -1;
//         q.add(new Pair(0, 0));

//         while(!q.isEmpty()){
//             Pair curr = q.removeFirst();
            
//             if(grid[curr.x][curr.y] == 1){
//                 while(!prev.isEmpty()){
//                     Pair prev_pair = prev.removeFirst();
//                     int dis = Math.abs(prev_pair.x - curr.x) + Math.abs(prev_pair.y - curr.y);
//                     max = Math.max(max, dis);
//                 }
//                 grid[curr.x][curr.y] = -1;
//             }else{
//                 prev.add(curr);
//                 grid[curr.x]
//             }
//         }
//     }
// }

// class Pair{
//     int x, y;
//     public Pair(int x, int y){
//         this.x = x;
//         this.y = y;
//     }
// }
