/*abstract
1. You are given an array(arr) of integers.
2. You have to find maximum subarray sum in the given array.
3. The subarray must have at least one element.
Input Format
A number N
a1
a2.. N integers
Output Format
A number representing maximum subarray sum in the given array.
Question Video

  COMMENTConstraints
1 <= N <= 10000
-2^31 <= arr[i] <= 2^31 - 1 
Sample Input
3
1
2
3
Sample Output
6
*/

import java.io.*;
import java.util.*;

class kadanes_algorithm {

    public static int solution(int[] arr) {
        // write your code here
    
        int max = Integer.MIN_VALUE;
        int local_max = 0;
    
        for(int i = 0;i<arr.length;i++){
            local_max =  local_max+arr[i];
            max = Math.max(max, local_max);
    
            if(local_max < 0){
                local_max = 0;
            }
        }
    
        return max;
    }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    System.out.println(solution(arr));
  }
}