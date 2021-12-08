/*abstract
1. You are given an array of length n containing numbers from 1 to n.
2. One number is present twice in array and one is missing.
3. You have to find these two numbers.
Input Format
A number n
a1
a2..
n numbers
Output Format
Missing number
Repeating Number
Question Video

  COMMENTConstraints
1 <= n <= 10^9
1 <= a1,a2.. <= 10^9 
Sample Input
7
1 
3 
4 
5 
1 
6 
2
Sample Output
Missing Number -> 7
Repeating Number -> 1
*/

import java.io.*;
import java.util.*;

class one_repeating_one_missing {

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
        int mask = XOR_1_to_N(arr.length);
        for(int val : arr){
            mask = (mask^val);
        }   

        int twos_complement_mask = -mask;

        int val1 = 0;
        int val2 = 0;

        int new_mask = (twos_complement_mask&mask);

        for(int i = 1;i<=arr.length;i++){
            if((i&new_mask) != 0){
                val1 = (i^val1);
            }else{
                val2 = (i^val2);
            }
        }

        for(int val:arr){
            if((val&new_mask) != 0){
                val1 = (val^val1);
            }else{
                val2 = (val^val2);
            }
        }

        for(int val:arr){
            if(val == val1){
                System.out.println("Missing Number -> "+val2);
                System.out.println("Repeating Number -> "+val1);
                break;
            }else if(val == val2){
                System.out.println("Missing Number -> "+val1);
                System.out.println("Repeating Number -> "+val2);
                break;
            }
        }
    }

    private static int XOR_1_to_N(int length) {
        int mask = 0;
        for(int i = 1;i<=length;i++){
            mask = (mask^i);
        }
        return mask;
    }
}