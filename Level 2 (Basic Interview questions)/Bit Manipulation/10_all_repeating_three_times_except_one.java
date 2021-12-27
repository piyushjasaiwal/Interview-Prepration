/*abstract
1. You are given an array of numbers.
2. All numbers occur thrice in the array except one.
3. You have to find the element that occurs once.
Input Format
A number n
a1
a2..
n numbers
Output Format
A number
Question Video

  COMMENTConstraints
1 <= n <= 10^9
1 <= a1,a2.. <= 10^9
Sample Input
4
1 1 1 2 
Sample Output
2
*/

import java.io.*;
import java.util.*;

class all_repeating_three_times_except_one {

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
        int MAX_BIT= 30;

        int ans = 0;

        for(int i = MAX_BIT;i>=0;i--){
            int mask = (1<<i);
            int cnt = 0;
            for(int val:arr){
                int bit = (val&mask);
                cnt = cnt + (bit > 0 ? 1 : 0);
            }

            if(cnt%3 == 1){
                ans = ans | mask;
            }
        }

        System.out.println(ans);
    }

}