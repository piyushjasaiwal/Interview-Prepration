/*
 * 1. You are given an array of integers(arr).
2. You have to find the count of equivalent subarrays.
3. A subarray is equivalent if,
   count of unique integers in the subarray = count of unique integers in the given array.
Input Format
A number N
arr1
arr2... N numbers
Output Format
A number representing count of equivalent subarrays. 
Question Video

  COMMENTConstraints
1 <= N <= 10^5
-2^31 <= arr[i] <= 2^31-1
Sample Input
5
2 1 3 2 3
Sample Output
5
*/

import java.util.*;

class equivalent_subarrays {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
		//write your code here
		

	}


}
