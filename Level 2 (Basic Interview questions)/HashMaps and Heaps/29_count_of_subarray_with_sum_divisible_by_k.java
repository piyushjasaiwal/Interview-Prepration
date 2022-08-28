/*
 * 1. You are given an array of integers(arr) and a number K.
2. You have to find the count of subarrays whose sum is divisible by K.
Input Format
A number N
arr1
arr2.. N numbers
A number K
Output Format
A number representing the count of subarrays whose sum is divisible by K.
Question Video

  COMMENTConstraints
1 <= N,K <= 10^5
-1000 <= arr[i] <= 1000
Sample Input
6
2 7 6 1 4 5
3
Sample Output
5
 */

import java.util.*;

class count_of_subarray_with_sum_divisible_by_k {

    public static int solution(int[] arr, int k) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int cnt = 0;
        map.put(0, 1);
        for(int i = 0;i<arr.length;i++){
            sum=(sum+arr[i])%k;
            if(sum<0){
                sum+=k;
            }

            cnt+=map.getOrDefault(sum, 0);
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
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }

}
