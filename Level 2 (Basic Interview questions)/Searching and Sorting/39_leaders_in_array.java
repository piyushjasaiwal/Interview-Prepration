/*abstract
Given an array A of positive integers. Your task is to find the leaders in the array. An element of array is leader if it is greater than or equal to all the elements to its right side. The rightmost element is always a leader. 
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1 <= n <= 10^7
0 <= Ai <= 10^7
Sample Input
6
16 17 4 3 5 2
Sample Output
17 5 2
*/

import java.util.*;
import java.io.*;

class leaders_in_array {

    public static ArrayList<Integer> leaders(int[]arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i = arr.length-1;i>=0;i--){
            if(arr[i] >= max){
                ans.add(0, arr[i]);
                max = arr[i];
            }
        }
        return ans;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]arr = new int[n];

        for (int i = 0; i < n; i++) {
        arr[i] = scn.nextInt();
        }

        ArrayList<Integer>ans = leaders(arr);

        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
}