/*abstract
1. You are given an array(arr) of integers.
2. You have to find the length of the largest subarray with sum 0.
Input Format
A number N
arr1
arr2.. N numbers
Output Format
A number representing the length of largest subarray with zero sum.
Question Video

  COMMENTConstraints
1 <= N <= 10^6
1 <= arr[i] <= 10^4
Sample Input
8
15 -2 2 -8 1 7 10 23
Sample Output
5
*/

import java.util.*;

class largest_subarray_with_ero_sum {
	
	public static int solution(int[] arr) {
		// write your code here
        int max = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum+=arr[i];
            if(sum == 0){
                max = Math.max(max, i+1);
            }else if(map.containsKey(sum)){
                int prev = map.get(sum);
                max = Math.max(max, i-prev);
            }else{
                map.put(sum, i);
            }
        }

		return max;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
