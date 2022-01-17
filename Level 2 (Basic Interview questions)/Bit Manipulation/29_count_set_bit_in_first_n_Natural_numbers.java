/*abstract
1. You are given a number n.
2. You have to print the count of set bits of first n natural numbers.
Input Format
A number n
Output Format
A number
Question Video

  COMMENTConstraints
1 <= n <= 10^9
Sample Input
17
Sample Output
35
*/

import java.io.*;
import java.util.*;

class count_set_bit_in_first_n_Natural_numbers {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(solution(n));
    }

    public static int solution(int n){
        //write your code here

        if(n == 0){
            return 0;
        }
        int x = largestPowerOf2InRange(n);
        
        int b2x = x*(1 << (x-1));

        int msb2rxton = n - (1<<x) + 1;
        int rest = n - (1<<x);
        int ans = b2x + msb2rxton + solution(rest);
        return ans;
    }

    private static int largestPowerOf2InRange(int n) {
        int x = 0;
        while((1<<x) <= n){
            x++;
        }

        return x-1;
    }

}