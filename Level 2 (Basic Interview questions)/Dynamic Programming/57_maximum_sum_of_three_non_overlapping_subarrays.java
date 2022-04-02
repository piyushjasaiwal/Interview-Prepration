/*abstract
1. You are given an array(arr) of positive numbers and a number K.
2. You have to find the maximum sum of elements in three non-overlapping subarrays.
3. Also, you have to print indices representing the starting position of every subarray.
4. If there are multiple answers, print the lexicographically smallest one.
Input Format
A number N
arr1
arr2.. N numbers
A number K
Output Format
4 space-separated numbers, where first number represents the maximum sum of three non-overlapping subarrays and rest three represents the starting position of every subarray.
Question Video

  COMMENTConstraints
1 <= N <= 20000
1 <= arr[i] <= 10^5
1 <= K <= N/3
Sample Input
8
1 2 1 2 6 7 5 1 
2
Sample Output
23 0 3 5 
*/

import java.io.*;
import java.util.*;

class maximum_sum_of_three_non_overlapping_subarrays {

	public static void solution(int[] arr, int k){
		// write your code here
        int n = arr.length;

        int ans = Integer.MIN_VALUE;
        
		int [] dp1 = new int[n];
		int [] dp2 = new int[n];
        int [] pre = new int[n];
        int val = 0;
        for(int i = 0;i<n;i++){
            val += arr[i];
            pre[i] = val;
        }

        int sum = 0;
        for(int i = 0;i<n;i++){
            if(i < k){
                sum += arr[i];
                dp1[i] = sum;
            }else{
                sum += arr[i]-arr[i-k];
                dp1[i] = Math.max(sum, dp1[i-1]);
            }
        }

        sum = 0;
        for(int i = n-1;i>=0;i--){
            if(i+k>=n){
                sum += arr[i];
                dp2[i] = sum;
            }else{
                sum += arr[i]-arr[i+k];
                dp2[i] = Math.max(sum, dp2[i+1]);
            }
        }

        int lidx = -1;
        int ridx = -1;
        int midx = -1;
        int lsum = 0;
        int rsum = 0;

        for(int i = k;i<=n-(2*k);i++){
            int temp = pre_sum(pre, i, i+k-1)+dp1[i-1]+dp2[i+k];
            if(temp > ans){
                ans = temp;
                lsum = dp1[i-1];
                rsum = dp2[i+k];
                midx = i;
            }
        }

        for(int i = k-1;i<midx;i++){
            if(pre_sum(pre, i-k, i)  == lsum){
                lidx = i;
                break;
            }
        }

        for(int i = midx+k-1;i<n;i++){
            if(pre_sum(pre, i-k, i) == rsum){
                ridx = i;
                break;
            }
        }

        String str= ans+" "+lidx+" "+midx+" "+ridx;
        System.out.println(str);
	}
	
	private static int pre_sum(int[] pre, int s, int e) {
        // if(s < 0){
        //     return 0;
        // }
        if(s <= 0){
            return pre[e];
        }
        return pre[e]-pre[s];
    }

    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		solution(arr,k);
	}

}