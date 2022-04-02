/*abstract
1. You are given an array(arr) of positive numbers and two numbers X and Y.
2. You have to find the maximum sum of elements in two non-overlapping subarrays.
3. One subarray must of length X and the other must be of length Y.
Input Format
A number N
arr1
arr2.. N numbers
Two numbers X and Y
Output Format
A number representing maximum sum of elements in two non-overlapping subarrays. 
Question Video

  COMMENTConstraints
1 <= N <= 1000
0 <= arr[i] <= 1000
X >= 1, Y >= 1
X + Y <= N
Sample Input
9
0 6 5 2 2 5 1 9 4
1
2
Sample Output
20
*/

import java.io.*;
import java.util.*;

class maximum_sum_of_two_non_overlapping_subarrays {

	public static int solution(int[] arr, int x, int y){
		// write your code here

        
		return 0;
	}
	
	public static int pre_sum(int [] arr, int[] pre, int s, int e) {
        return pre[e]-pre[s]+arr[s];
    }

    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		int x = scn.nextInt();
		int y = scn.nextInt();
		System.out.println(solution(arr,x,y));
	}

}