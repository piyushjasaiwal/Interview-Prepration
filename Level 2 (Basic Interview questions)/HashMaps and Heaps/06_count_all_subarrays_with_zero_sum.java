/*abstract
1. You are given an array(arr) of integers.
2. You have to find the count of all subarrays with sum 0.
Input Format
A number N
arr1
arr2.. N numbers
Output Format
A number representing the count of all subarrays with sum 0. 
Question Video

  COMMENTConstraints
1 <= N <= 10^6
1 <= arr[i] <= 10^4
Sample Input
8
15 -2 2 -8 1 7 10 23
Sample Output
3
*/

import java.util.*;

class count_all_subarrays_with_zero_sum {

	public static int solution(int[] arr) {
		// write your code here
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
            if(map.containsKey(sum)){
                cnt+=map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));

	}

}
