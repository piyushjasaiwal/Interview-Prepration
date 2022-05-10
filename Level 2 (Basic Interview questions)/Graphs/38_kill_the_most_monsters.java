/*abstract
On a 2D plane, we place n monsters at some integer coordinate points. Each coordinate point may have at most one monster.

A monster can be removed if it shares either the same row or the same column as another monster that has not been removed.

Given an array monsters of length n where monsters[i] = [xi, yi] represents the location of the ith monster, return the largest possible number of monsters that can be removed.

Example 1:

    Input: monsters = [[0,0],[0,2],[1,1],[2,0],[2,2]]
    Output: 3

Explanation: One way to make 3 moves is as follows:
1. Remove monster [2,2] because it shares the same row as [2,0].
2. Remove monster [2,0] because it shares the same column as [0,0].
3. Remove monster [0,2] because it shares the same row as [0,0].
monsters [0,0] and [1,1] cannot be removed since they do not share a row/column with another stone still on the plane.
Input Format
Input/output is handled for you. You just need to complete the function.
Output Format
Input/output is handled for you. You just need to complete the function.
Question Video

Constraints

1. 1 <= monsters.length <= 1000
2. 0 <= monsters[i][0],monsters[i][1] <= 1
Sample Input
6
0
0
0
1
1
0
1
2
2
1
2
2
Sample Output
5
*/

import java.util.*;
import java.io.*;

class kill_the_most_monsters {
    public static int removeMonsters(int[][] monsters) {
        // Write your code here
        int r = 0;
        int c = 0;
        int cnt = 0;

        for(int [] monster:monsters){
            r = Math.max(r, monster[0]);
            c = Math.max(c, monster[1]);
        }

        r++;
        c++;

        int [][] visited = new int[r][c];

        for(int [] monster:monsters){
            visited[monster[0]][monster[1]] = 1;
        }

        for(int i = 0;i<visited.length;i++){
            for(int j = 0;j<visited[0].length;j++){
                if(visited[i][j] == 1){
                    cnt += (DFS(i, j, visited)-1);
                }
            }
        }
        return cnt;
    }

    private static int DFS(int i, int j, int[][] visited) {
        if(i < 0 || j < 0 || i >= visited.length || j >= visited[0].length || visited[i][j] == 0 || visited[i][j] == 2){
            return 0;
        }

        int cnt = 1;
        visited[i][j] = 2;

        int r = i+1;
        int c = j;

        while(r < visited.length){
            if(visited[r][c] == 1){
                cnt += DFS(r, c, visited);
            }
            r++;
        }

        r = i;
        c = j+1;

        while(c < visited[0].length){
            if(visited[r][c] == 1){
                cnt += DFS(r, c, visited);
            }
            c++;
        }

        r = i-1;
        c = j;

        while(r >= 0){
            if(visited[r][c] == 1){
                cnt += DFS(r, c, visited);
            }
            r--;
        }

        r = i;
        c = j-1;

        while(c >= 0){
            if(visited[r][c] == 1){
                cnt += DFS(r, c, visited);
            }
            c--;
        }

        return cnt;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] monsters = new int[n][2];
        for (int i = 0; i < n; i++) {
            monsters[i][0] = scn.nextInt();
            monsters[i][1] = scn.nextInt();
        }

        int ans = removeMonsters(monsters);
        System.out.println(ans);
    }
}
