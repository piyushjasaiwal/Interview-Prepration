/*abstract
1. Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:
a). Integers in each row are sorted in ascending from left to right.
b). Integers in each column are sorted in ascending from top to bottom.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-10^9 <= matix[i][j] <= 10^9
-10^9 <= target <= 10^9
Sample Input
5 5
1 4 7 11 15
2 5 8 12 20
4 6 9 16 22
10 13 14 17 24
18 21 23 26 30
12
Sample Output
true
*/

import java.util.*;
import java.io.*;

class search_a_2D_matrix_2 {

    /*your task is to complete this function which returns true if target exists in the matrix
    else return false*/
    public static boolean search_complexity_nlogn(int[][]matrix,int target) {
        //write your code here
        for(int [] ar : matrix){
            if(B_search(ar, target)){
                return true;
            }
        }
        return false;
    }

    public static boolean B_search(int [] arr, int tar){
        int l = 0;
        int h = arr.length-1;
        while(l <= h){
            int mid = l + (h-l)/2;
            if(arr[mid] == tar){
                return true;
            }else if(arr[mid] < tar){
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        return false;
    }

    //more optimized solution

    public static boolean search(int [][] matrix, int target){
        //take the top right corner as the reference point
        int r = 0, c = matrix[0].length-1;

        while(r < matrix.length && c >= 0){
            if(matrix[r][c] == target){
                return true;
            }else if(matrix[r][c] > target){
                c--;
            }else{
                r++;
            }
        }
        return false;
    }
    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        int[][]matrix = new int[m][n];

        for(int i=0; i < m;i++) {
            for(int j=0; j < n;j++) {
                matrix[i][j] = scn.nextInt();
            }
        }

        int target = scn.nextInt();

        boolean isFound = search(matrix,target);
        System.out.println(isFound);

    }
}