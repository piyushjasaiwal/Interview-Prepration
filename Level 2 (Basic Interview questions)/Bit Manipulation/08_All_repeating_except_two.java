/*abstract
1. You are given an array of numbers.
2. You have to find 2 non-repeating numbers in an array.
3. All repeating numbers are repeating even number of times.
Input Format
A number n
a1
a2..
n numbers
Output Format
2 Non-repeating number
Question Video

  COMMENTConstraints
1 <= n <= 10^9
1 <= a1,a2.. <= 10^9 
Sample Input
6
23 27 23 17 17 37
Sample Output
27
37
*/

import java.io.*;
import java.util.*;

class All_repeating_except_two {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        solution(arr);
    }

    public static void solution(int[] arr){
        //write your code here
        int mask = 0;
        for(int val : arr){
            mask = (mask^val);
        }   

        int twos_complement_mask = -mask;

        int val1 = 0;
        int val2 = 0;

        int new_mask = (twos_complement_mask&mask);

        for(int val:arr){
            if((val&new_mask) != 0){
                val1 = (val^val1);
            }else{
                val2 = (val^val2);
            }
        }

        System.out.println(Math.min(val1,val2));
        System.out.println(Math.max(val1, val2));
    }
}