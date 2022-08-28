/*
 * 
 * 1. You are given an array of integers(arr) and a number K.
2. You have to find the count of subarrays whose sum equals k.
Input Format
A number N
arr1
arr2.. N numbers
A number K
Output Format
A number representing the count of subarrays having sum equal to K.
Question Video

  COMMENTConstraints
1 <= N <= 10^5
-1000 <= arr[i] <= 1000
-10^9 <= K <= 10^9
Sample Input
3
1 1 1
2
Sample Output
2
 */

import java.util.*;

class count_of_subarray_having_sum_equal_k {

	public static int solution(int[] arr, int target){
		// write your code here
		HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int cnt = 0;
        for(int val:arr){
            sum += val;
            if(map.containsKey(sum-target)){
                cnt += map.get(sum-target);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        // System.out.println(map);
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        System.out.println(solution(arr,target));
	}

}
