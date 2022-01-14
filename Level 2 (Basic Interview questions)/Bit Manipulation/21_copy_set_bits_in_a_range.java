/*abstract
1. You are given two numbers A and B.
2. You are given two more numbers left and right, representing a range [left,right].
3. You have to set bits in B which are set in A lying in the above mentioned range.
4. Print the updated number B.
Input Format
4 numbers representing A,B,left and right.
Output Format
A number
Question Video

  COMMENTConstraints
-10^9 <= A,B <= 10^9
1 < left < right < 32
Sample Input
10
13
2
3
Sample Output
15*/

import java.io.*;
import java.util.*;

class copy_set_bits_in_a_range {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        int left = scn.nextInt();
        int right = scn.nextInt();

        //write your code here
        
        int MAX_N = 32;
        
        for(int i = 1;i<=MAX_N;i++){
            if(i >= left && i <= right){
                int mask = (1<<(i-1));
                int bitA = (mask&a);
                b = (b|bitA);
            }
        }

        System.out.println(b);
    }

}