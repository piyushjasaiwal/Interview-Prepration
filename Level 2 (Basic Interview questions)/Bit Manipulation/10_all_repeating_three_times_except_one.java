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
        int [] ar = new int[32];
        for(int i = 0;i<arr.length;i++){
            int num = arr[i];
            int mask = 1;
            int j = 0;
            while(mask <= num){
                if((mask & num) > 0){
                    arr[j]+=1;
                }
                j++;
                mask = (mask << 1);
            }
        }

        int ans = 0;

        for(int val : ar){
            System.out.println(val+" ");
        }

        for(int i = 0;i<32;i++){
            if(ar[i]%3 != 0){
                ans = (ans + (1<<i));
            }
        }

        System.out.println(ans);
    }

}