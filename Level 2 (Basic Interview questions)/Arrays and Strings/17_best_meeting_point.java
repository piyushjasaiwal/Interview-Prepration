/*
1. A group of two or more people wants to meet and minimize the total travel distance.
2. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. 
3. Return min distance where distance is calculated using 'Manhattan Distance', where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
Input Format
[
    [1,0,0,0,1],
    [0,0,0,0,0],
    [0,0,1,0,0]
]
Output Format
6

Explanation:
The point (0,2) is an ideal meeting point, as the total travel distance of 2 + 2 + 2 = 6 is minimal. So return 6.
Question Video

  COMMENTConstraints
1. Distance should me minimum
Sample Input
3 5
1 0 0 0 1
0 0 0 0 0
0 0 1 0 0
Sample Output
6
*/

/*Approach 
first find out the median values for both the x coordinate and y coordinate and this point will be your best meeting point
*/

import java.util.*;

class best_meeting_point {

    // ~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static int minTotalDistance(int[][] grid, int n) {
        // Write your code here
        ArrayList<Integer> xCoordinate = new ArrayList<>();
        ArrayList<Integer> yCoordinate = new ArrayList<>();
        
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    xCoordinate.add(i);
                }
            }
        }

        for(int j = 0;j<grid[0].length;j++){
            for(int i = 0;i<grid.length;i++){
                if(grid[i][j] == 1){
                    yCoordinate.add(j);
                }
            }
        }

        int x = xCoordinate.get(xCoordinate.size()/2);
        int y = yCoordinate.get(yCoordinate.size()/2);

        int dis = 0;
        for(int val:xCoordinate){
            dis += Math.abs(val-x);
        }

        for(int val:yCoordinate){
            dis += Math.abs(val-y);
        }

        return dis;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();


        int[][] grid = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = scn.nextInt();
            }
        }

        int dist = minTotalDistance(grid, n);
        System.out.println(dist);
    }
}
