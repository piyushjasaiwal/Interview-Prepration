/*abstract
1. You are given an array(arr) of positive numbers and two numbers M and K.
2. You have to find the maximum sum of M non-overlapping subarrays of size K.
3. The size of the given array(arr) is greater than M*K.
Input Format
A number N
arr1
arr2.. N numbers
Two numbers M and K
Output Format
A number representing maximum sum of M non-overlapping subarrays of size K.
Question Video

  COMMENTConstraints
1 <= N <= 10^3
1 <= arr[i] <= 10^3
M >= 1
K >= 1
N >= M*K
Sample Input
7
2 10 7 18 5 33 0
3
1
Sample Output
61
*/

import java.io.*;
import java.util.*;

class maximum_sum_of_M_overlapping_sum_subarrays {

	public static int solution(int[] arr, int m, int k){
		// write your code here
		
        int n = arr.length;
        int [] pre = new int[n];
        int sum = 0;
        int i = 0;
        for(i=0;i<n;i++){
            if(i<k){
                sum+=arr[i];
            }else{
                pre[i-k] = sum;
                sum += arr[i]-arr[i-k];
            }
        }

        // for(int val : pre){
        //     System.out.print(val+" ");
        // }
        // System.out.println();

        pre[i-k] = sum;
        int [][] dp = new int[m+1][n];
		return give_answer(arr, 0, m, k, pre, dp);
	}
	
	private static int give_answer(int[] arr, int idx, int m, int k, int[] pre, int[][] dp) {
        if(m == 0){
            return 0;
        }

        if(idx >= arr.length){
            return 0;
        }

        if(dp[m][idx] != 0){
            return dp[m][idx];
        }
        int include = pre[idx]+give_answer(arr, idx+k, m-1, k, pre, dp);
        int exlude = give_answer(arr, idx+1, m, k, pre, dp);
        int ans = Math.max(include, exlude);
        dp[m][idx] = ans;
        return ans;
    }

    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
        int m = scn.nextInt();
        int k = scn.nextInt();
        System.out.println(solution(arr, m , k));
	}

}