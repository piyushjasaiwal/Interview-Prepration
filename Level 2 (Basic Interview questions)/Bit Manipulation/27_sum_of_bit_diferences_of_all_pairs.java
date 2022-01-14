/*
1. You are given an array of n numbers.
2. You have to find the sum of bit differences in all pairs that can be formed from n numbers.
3. Bit difference of two numbers is defined as the count of different bits at same positions in binary representations of two numbers.
Input Format
A number n
a1
a2..
n numbers
Output Format
Check the sample ouput and question video.
Question Video

  COMMENTConstraints
1 <= n <= 10^9
1 <= arr[i] <= 10^9
Sample Input
3
1 2 3
Sample Output
8
*/

import java.util.*;

class sum_of_bit_diferences_of_all_pairs {
    public static long solution(int[] arr){
        //write your code here
        int Max_N = 32;

        long ans = 0;

        for(int i = 0;i<Max_N;i++){
            int bit1 = 0;
            int bit0 = 0;

            for(int val:arr){
                if((val & (1<<i)) > 0){
                    bit1++;
                }else{
                    bit0++;
                }
            }

            ans += (1L*bit0*bit1);
        }
        return ans*2;
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
}
