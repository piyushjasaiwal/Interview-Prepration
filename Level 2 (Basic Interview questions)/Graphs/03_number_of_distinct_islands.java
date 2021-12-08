/*
Given an m*n binary matrix mat, return the number of distinct island.

An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.
Input Format
First line contains two integers n and m.
Each of next n lines contain n numbers containing either 0 or 1.
Output Format
print number of distinct island.
Question Video

  COMMENTConstraints
1<= n <= 1000
1<= e <= n*(n-1)/2
Sample Input
3 3
1 0 0
0 1 0
1 1 1
Sample Output
2
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class number_of_distinct_islands {

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

        System.out.println(numDistinctIslands(arr));

    }

    public static StringBuilder psf = new StringBuilder("");

    public static int numDistinctIslands(int[][] arr) {
        //write your code here
        Set<String> set = new HashSet<>();
        // HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                if(arr[i][j] == 1){
                    psf.append('x');
                    DFS(i, j, arr);
                    String path = new String(psf);
                    if(!set.contains(path)){
                        System.out.println(psf);
                        set.add(path);
                    }
                    psf = new StringBuilder("");
                }
            }
        }
        return set.size();
    }

    private static void DFS(int i, int j, int[][] arr) {
        if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length){
            return ;
        }

        arr[i][j] = 0;

        if(is_valid(i-1, j, arr)){
            psf.append('u');
            DFS(i-1, j, arr);
        }

        if(is_valid(i+1, j, arr)){
            psf.append('d');
            DFS(i+1, j, arr);
        }

        if(is_valid(i, j-1, arr)){
            psf.append('l');
            DFS(i, j-1, arr);
        }

        if(is_valid(i, j+1, arr)){
            psf.append('r');
            DFS(i, j+1, arr);
        }

        psf.append('b');
    }

    private static boolean is_valid(int i, int j, int[][] arr) {
        if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 0){
            return false;
        }
        return true;
    }
}