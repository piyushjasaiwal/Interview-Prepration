/*
 * 1. You are given an array(arr) of integers with even length N.
2. You have to tell if it is possible to re-order the given array such that for every i in range [0,N/2)
   arr[2*i + 1] = 2 * arr[2*i], this condition holds true.
Input Format
A number N
arr1
arr2.. N numbers
Output Format
true/false
Question Video

  COMMENTConstraints
1 <= N <= 10^4
-10^5 <= arr[i] <= 10^5
Sample Input
4
3 1 3 6
Sample Output
false
 */

import java.util.*;

class double_pair_array {

    public static boolean solution(int[] arr) {
        // write your code here
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int val:arr){
            min = Math.min(min, val);
            max = Math.max(max, val);
        }

        int [] map = new int[max-min+1];
        Arrays.fill(map, 0);
        for(int val:arr){
            int idx = val-min;
            map[idx]++;
        }

        //checking for zero
        int zero_idx = 0-min;
        if(map[zero_idx]%2 == 1){
            return false;
        }

        for(int i = 0;i<map.length;i++){
            if(map[i] == 0){
                continue;
            }
            int val = i-min;
            if(val < 0){
                
            }
        }
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
