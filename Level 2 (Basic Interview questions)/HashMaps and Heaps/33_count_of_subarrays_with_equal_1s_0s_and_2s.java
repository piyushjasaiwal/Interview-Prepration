/*
 * 1. You are given an array that contains only 0s, 1s, and 2s.
2. You have to find the count of subarrays with equal number of 0s, 1s, and 2s.
Input Format
A number N
arr1
arr2.. N numbers
Output Format
A number representing count of subarrays with an equal number of 0s, 1s, and 2s.
Question Video

  COMMENTConstraints
A number representing the count of subarrays with equal number of 0s, 1s, and 2s.
Sample Input
7
0 1 0 2 0 1 0
Sample Output
2
 */

import java.util.*;

class count_of_subarrays_with_equal_1s_0s_and_2s {

    public static int solution(int[] arr) {
        // write your code here
        int ans = 0;
        HashMap<String, Integer> map = new HashMap<>();
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        int delta01 = count0 - count1;
        int delta12 = count1 - count2;

        String str = delta01+"#"+delta12;

        map.put(str, 1);
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 0){
                count0++;
            }else if(arr[i] == 1){
                count1++;
            }else{
                count2++;
            }

            delta01 = count0 - count1;
            delta12 = count1 - count2;

            str = delta01+"#"+delta12;

            ans += map.getOrDefault(str, 0);
            map.put(str, map.getOrDefault(str, 0)+1);
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
        System.out.println(solution(arr));
    }

}
