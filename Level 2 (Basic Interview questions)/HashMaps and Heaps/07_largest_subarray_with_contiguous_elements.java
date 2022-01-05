/*abstract
1. You are given an array(arr) of integers. Values may be duplicated.
2. You have to find the length of the largest subarray with contiguous elements.

Note -> The contiguous elements can be in any order(not necessarily in increasing order).
Input Format
A number N
arr1
arr2.. N numbers
Output Format
A number representing the length of the largest subarray with contiguous elements.
Question Video

  COMMENTConstraints
1 <= N <= 10^4
1 <= arr[i] <= 10^3
Sample Input
3
10 12 11
Sample Output
3
*/

import java.util.*;

class largest_subarray_with_contiguous_elements {

	public static int solution(int[] arr) {
		// write your code here
        int max_len = 0;
        for(int i = 0;i<arr.length;i++){
            int max = arr[i];
            int min = arr[i];
            Set<Integer> set = new HashSet<>();
            set.add(arr[i]);
            for(int j = i+1;j<arr.length;j++){
                if(set.contains(arr[j])){
                    break;
                }

                set.add(arr[j]);
                
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                
                if(max-min == j-i){
                    max_len = Math.max(max_len, j-i+1);
                }
            }
        }
		return max_len;
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
