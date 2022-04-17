/*abstract
Given a sorted array arr[] of size N. Find the element that appears only once in the array. All other elements appear exactly twice. 
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
10^5 <= N <= 10^5
Sample Input
11
1 1 2 2 4 4 7 7 8 10 10
Sample Output
8
*/

import java.util.*;
import java.io.*;

class find_the_element_that_appear_once_in_sorted_array {

    public static int findSingleElement(int[]arr) {
        //write your code here
        int i = 0;
        for(i = 0;i<arr.length-1;i+=2){
            if(arr[i] != arr[i+1]){
                return arr[i];
            }
        }
        return arr[arr.length-1];
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = findSingleElement(arr);
        System.out.println(ans);
    }
}