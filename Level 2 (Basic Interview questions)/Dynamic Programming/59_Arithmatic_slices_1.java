/*abstract
1. You are given an array(arr) of integers.
2. You have to find the count of arithmetic slices in the given array.
3. Arithmetic slice is defined as the sub-array having all its elements in A.P and the length of sub-array should be greater than or equal to 3.
Input Format
A number N
arr1
arr2.. N numbers
Output Format
Check the sample output and question video.
Question Video

  COMMENTConstraints
1 <= N <= 10^8
-10^8 <= arr[i] <= 10^8
Sample Input
4
1
2
3
4
Sample Output
3
*/

import java.io.*;
import java.util.*;

class Arithmatic_slices_1 {

	public static int solution(int[] arr) {
		//write your code here
		
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}