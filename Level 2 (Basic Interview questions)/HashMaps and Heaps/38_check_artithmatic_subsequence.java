/*
 * 1. You are given an array(arr) of integers.
2. You have to find if the elements of the given array can be arranged to form an arithmetic progression.
3. Arithmetic progression is defined as a sequence of numbers where the difference between any two consecutive numbers is the same. 

Note -> Try to solve this in linear time complexity.
Input Format
A number N
arr1
arr2.. N numbers
Output Format
true/false
Question Video

  COMMENTConstraints
1 <= N <= 10^6
1 <= arr[i] <= 10^3
Sample Input
3
3 5 1
Sample Output
true
 */

import java.util.*;

class check_artithmatic_subsequence {

    public static boolean solution(int[] arr) {
        // write your code here
        
        return true;
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
