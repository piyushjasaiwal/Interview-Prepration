/*abstract
1. You are given an array of numbers.
2. All numbers occur twice in the array except one.
3. You have to find that number by traversing only once in the array and without using any extra 
     space.
Input Format
A number n
a1
a2..
n numbers
Output Format
Non-repeating number
Question Video

  COMMENTConstraints
1 <= n <= 10^9
1 <= a1,a2.. <= 10^9 
Sample Input
5
23 27 23 17 17
Sample Output
27
*/

import java.io.*;
import java.util.*;

class All_repeating_except_one {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        //write your code here
        
        int unique = 0;
        for(int val : arr){
            unique = (val^unique);
        }

        System.out.println(unique);
    }

}