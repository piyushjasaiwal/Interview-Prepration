/*abstract
Given two unsorted arrays arr1[] and arr2[]. They may contain duplicates. For each element in arr1[] count elements less than or equal to it in array arr2[].
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1 <= m,n <= 10^5
1 <= arr1[i],arr2[j] <= 10^5
Sample Input
6
1 2 3 4 7 9
6
0 1 2 1 1 4
Sample Output
4 5 5 6 6 6
*/

import java.util.*;
import java.io.*;

class count_elements_in_two_arrays {

    public static int[] find(int[]arr1, int[]arr2) {
        //write your code here

        Arrays.sort(arr2);
        int [] ans = new int[arr1.length];
        for(int i = 0;i<arr1.length;i++){
            int idx = b_search(arr2, 0, arr2.length-1, arr1[i]);
            ans[i] = idx+1;
        }
        return ans;
    }

    private static int b_search(int[] arr, int lo, int hi, int target) {
        int idx = -1;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(arr[mid] <= target){
                idx = mid;
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return idx;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);

        int n1 = scn.nextInt();
        int[]a = new int[n1];

        for (int i = 0; i < n1; i++) {
        a[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[]b = new int[n2];

        for (int i = 0; i < n2; i++) {
        b[i] = scn.nextInt();
        }

        int[]ans = find(a, b);

        for (int val : ans) {
        System.out.print(val + " ");
        }
    }
}