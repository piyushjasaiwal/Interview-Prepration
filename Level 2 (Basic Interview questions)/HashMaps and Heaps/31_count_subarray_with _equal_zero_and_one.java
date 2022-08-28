/*
 * 1. You are given an array that contains only 0s and 1s.
2. You have to find the count of subarrays with equal number of 0s and 1s.
Input Format
A number N
arr1
arr2.. N numbers
Output Format
A number representing count of subarrays with equal number of 0s and 1s.
Question Video

  COMMENTConstraints
1 <= N <= 10^5
0 <= arr[i] <= 1
Sample Input
6
0 1 1 0 1 1
Sample Output
4
 */

import java.util.*;

class count_subarray_with_equal_zero_and_one {

    public static int solution(int[] arr) {
        // write your code here
        int cnt = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 1);
        for(int i = 0;i<arr.length;i++){
            sum+=arr[i] == 1 ? 1 : -1;
            cnt += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
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
