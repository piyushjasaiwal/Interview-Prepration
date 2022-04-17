/*abstract
1. You are given an array of integers, which represents the vertices of an N-sided convex polygon in clockwise order.
2. You have to triangulate the given polygon into N-2 triangles.
3. The value of a triangle is the product of the labels of vertices of that triangle.
4. The total score of the triangulation is the sum of the value of all the triangles.
5. You have to find the minimum score of the triangulation of the given polygon.
Input Format
A number N
a1
a2.. N integers
Output Format
Check the sample output and question video.
Question Video

  COMMENTConstraints
1 <= N <= 1000
1 <= arr[i] <= 100
Sample Input
3
1
2
3
Sample Output
6
*/

import java.io.*;
import java.util.*;

class minimum_score_of_triangulation {

	public static int minScoreTriangulation(int[] arr) {
		//write your code here
        int n = arr.length;
		int [][] dp = new int[n][n];
        for(int gap = 0;gap<n;gap++){
            int i = 0;
            int j = gap;
            while(j < n){
                if(gap == 0){
                    dp[i][j] = 0;
                }else if(gap == 1){
                    dp[i][j] = 0;
                }else if(gap == 2){
                    dp[i][j] = 1;
                    for(int k = i;k<=j;k++){
                        dp[i][j]*=arr[k];
                    }
                }else{
                    int min = Integer.MAX_VALUE;
                    int point1 = i;
                    int point3 = j;

                    int point2 = i+1;
                    while(point2 < point3){
                        min = Math.min(min, (arr[point1]*arr[point2]*arr[point3])+dp[i][point2]+dp[point2][j]);
                        point2++;
                    }
                    dp[i][j] = min;
                }
                i++;
                j++;
            }
        }

        // for(int []d:dp){
        //     for(int a:d){
        //         System.out.print(a+" ");
        //     }
        //     System.out.println();
        // }
		return dp[0][n-1];
    }
  public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
		for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(minScoreTriangulation(arr));
	}
}