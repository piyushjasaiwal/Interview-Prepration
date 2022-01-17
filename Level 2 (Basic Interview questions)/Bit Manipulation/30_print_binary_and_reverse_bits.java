/*abstract
1. You are given a number.
2. You have to print its binary representation.
3. You also have to reverse the bits of n and print the number obtained after reversing the bits.
Input Format
A number n
Output Format
Check the sample ouput and question video.
Question Video

  COMMENTConstraints
1 <= n <= 10^9
Sample Input
11
Sample Output
1011
13
*/

import java.io.*;
import java.util.*;

class print_binary_and_reverse_bits {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        //write your code here
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int ans = 0;
        while((1<<i) <= n){
            int mask = (1<<i);
            int bit = (mask&n);
            sb.insert(0, bit > 0 ? '1' : '0');
            ans = ans<<1;
            if(bit > 0){
                ans = ans|1;
            }
            i+=1;
        }
        System.out.println(sb);
        System.out.println(ans);
    }

}