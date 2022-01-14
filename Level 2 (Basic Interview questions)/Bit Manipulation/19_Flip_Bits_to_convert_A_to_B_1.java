/*
1. You are given two numbers A and B.
2. You have to print the count of bits needed to be flipped to convert 'A' to 'B'.
Input Format
2 numbers A and B
Output Format
A number
Question Video

  COMMENTConstraints
-10^9 <= A,B <= 10^9
Sample Input
57
76
Sample Output
5
*/

import java.util.*;

class Flip_Bits_to_convert_A_to_B_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long a = s.nextLong();
        long b = s.nextLong();

        int MAX_BIT = 32;
        int count = 0;
        for(int i = 0;i<MAX_BIT;i++){
            long mask = (1<<i);
            int bitA = ((mask&a) > 0 ? 1 : 0);
            int bitB = ((mask&b) > 0 ? 1 : 0);
            
            if(bitA != bitB){
                count++;
            }
        }

        System.out.println(count);
    }
}
