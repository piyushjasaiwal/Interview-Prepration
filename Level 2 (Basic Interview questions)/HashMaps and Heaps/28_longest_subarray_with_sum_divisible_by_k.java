/*
1. You are given an array of integers(arr) and a number K.
2. You have to find length of the longest subarray whose sum is divisible by K.
Input Format
A number N
arr1
arr2.. N numbers
A number K
Output Format
A number representing length of the longest subarray whose sum is divisible by K.
Question Video

  COMMENTConstraints
1 <= N,K <= 10^5
-1000 <= arr[i] <= 1000
Sample Input
6
2 7 6 1 4 5
3
Sample Output
4
*/

import java.util.*;

class longest_subarray_with_sum_divisible_by_k {
    public static int solution(int[] arr, int k) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int i = 0;
        map.put(0, -1);
        int ans = 0;
        for(int val:arr){
            sum = (sum+val)%k;
            if(sum<0){
                sum+=k;
            }
            if(map.containsKey(sum)){
                ans = Math.max(ans, i-map.get(sum));
            }else{
                map.put(sum, i);
            }
            i++;
        }
        return ans;
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
