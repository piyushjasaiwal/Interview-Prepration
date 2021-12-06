/*abstract
Given an unsorted array arr[] of n positive integers. Find the number of triangles that can be formed with three different array elements as lengths of three sides of triangles. 
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
3 <= n <= 10^3
1 <= arr[i] <= 10^3
Sample Input
5
6 4 9 7 8
Sample Output
10
*/

import java.util.*;
import java.io.*;

class count_number_of_triangles {

    public static int countTriangles(int[]arr) {
        //write your code here
        Arrays.sort(arr);
        int ans = 0;
        for(int i = arr.length-1;i>=0;i--){
            int left = 0;
            int right = i-1;
            while(left<right){
                if(arr[left]+arr[right] > arr[i]){
                    ans += (right-left);
                    right--;
                }else{
                    left++;
                }
            }
        }
        return ans;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for (int i = 0; i < n; i++) {
        arr[i] = scn.nextInt();
        }

        System.out.println(countTriangles(arr));
    }
}