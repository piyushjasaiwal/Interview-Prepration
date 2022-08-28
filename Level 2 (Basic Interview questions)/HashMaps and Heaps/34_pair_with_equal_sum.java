/*
 * 1. You are given an array(arr) of distinct integers.
2. You have to find if there are two pairs(A, B) and (C, D) present in the given array which satisfies the condition A+B = C+D.
Input Format
A number N
arr1
arr2.. N numbers
Output Format
true/false
Question Video

  COMMENTConstraints
1 <= N <= 10^3
-10^9 <= arr[i] <= 10^9 
Sample Input
8
1 2 998 72 87576 21 45 -1
Sample Output
false
 */

import java.util.*;

class pair_with_equal_sum {

    public static boolean solution(int[] arr) {
        // write your code here
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                int sum = arr[i]+arr[j];
                if(set.contains(sum)){
                    return true;
                }
                set.add(sum);
            }
        }
        return false;
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
