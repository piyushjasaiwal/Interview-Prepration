/*abstract
1. You are given an array of distinct integers.
2. You have to print all pairs of integers in the array whose XOR value is minimum.
Input Format
A number N
arr1
arr2..
N numbers
Output Format
Check the sample output and question video.
Question Video

  COMMENTConstraints
1 <= n <= 10^5
-10^9 <= arr[i] <= 10^9
Sample Input
4
2
0
5
7
Sample Output
0, 2
5, 7
*/

/*concept used here is

if a <= b <= c

then (a^b < a^c) or (b^c < a^c)

a^c can never be smaller than the above given pairs
*/

import java.io.*;
import java.util.*;

class min_xor_array {

    public static void solution(int[] arr) {
        //write your code here
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<arr.length-1;i++){
            int res = (arr[i]^arr[i+1]);
            min = Math.min(min, res);
        }

        for(int i = 0;i<arr.length-1;i++){
            int res = (arr[i]^arr[i+1]);
            if(res == min){
                System.out.println(arr[i] + ", " + arr[i+1]);
            }
        }
    }
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        solution(arr);
    }
    
    
}