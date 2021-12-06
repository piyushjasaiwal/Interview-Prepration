/*abstract
Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1 <= N <= 10^3
1 <= arr[i] <= 10^5
Sample Input
4
1 5 3 2
Sample Output
2
*/

import java.util.*;
import java.io.*;

class count_the_triplets {

    public static int countTriplets(int[]arr) {
        //write your code here
        Arrays.sort(arr);
        int cnt = 0;
        for(int i = 0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                if(b_search(arr, j+1, arr.length-1, arr[i]+arr[j])){
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    private static boolean b_search(int[] arr, int lo, int hi, int target) {
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(arr[mid] == target){
                return true;
            }else if(arr[mid] < target){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return false;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for (int i = 0; i < n; i++) {
        arr[i] = scn.nextInt();
        }

        System.out.println(countTriplets(arr));
    }
}