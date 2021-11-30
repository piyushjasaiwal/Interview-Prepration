/*abstract
1. Given an integer array nums.
2. return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

  COMMENTConstraints
1. 1 <= nums.length <= 2 * 10^5
2. 0 <= nums[i] <= 2^31 - 1
Sample Input
6
3 
10 
5 
25 
2 
8
Sample Output
28
*/

import java.io.*;
import java.util.*;

class Main {
  public static int findMaximumXOR(int[] nums) {
    // write your code here


    return 0;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine().trim());
    int arr[] = new int[n];
    for (int i = 0; i < n; i++)arr[i] = Integer.parseInt(read.readLine().trim());

    int result = findMaximumXOR(arr);
    System.out.println(result);

  }
}
